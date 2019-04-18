<template>
  <Modal v-model="modal.skuDetailModal" title="商品SKU详情" :mask-closable="true" width="80%"> 
    <Row>
      <i-col :lg="24">
        <div style="margin-bottom: 10px; color: red;">
          当前SKU编号：{{skuId}}
        </div>
        <div style="margin-bottom: 10px;">
          请选择SKU编号加载SKU详情：
          <RadioGroup v-model="chooseSkuId" type="button" @on-change="changeSkuId">
            <Radio v-for="item in allSkuIds" :key="item" :label="item"></Radio>
          </RadioGroup>
        </div>
      </i-col>
    </Row>
        <Form ref="skuForm" :model="form" :label-width="80" :rules="validateRules">
          <Row>
            <i-col :lg="12" :md="12" v-for="item in formElements" :key="item.goodsAttributeAttrCode">
              <FormItem v-if="item.goodsAttributeAttrType === 'String' && item.goodsAttributeAttrRequired === 0" :label="item.goodsAttributeAttrName" :prop="item.goodsAttributeId + '_' + item.goodsAttributeAttrCode"
              :rules="[
                  {type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
                  {type: 'string', min: 1, max: item.goodsAttributeAttrLength, message: '必须1-' + item.goodsAttributeAttrLength + '个字符', trigger: 'blur'}
                ]">
                <Input v-model="form[item.goodsAttributeId + '_' + item.goodsAttributeAttrCode]" :placeholder="'请输入' + item.goodsAttributeAttrName" style="width: 100%;"/>
              </FormItem>
              <FormItem v-else-if="item.goodsAttributeAttrType === 'String'" :label="item.goodsAttributeAttrName" :prop="item.goodsAttributeId + '_' + item.goodsAttributeAttrCode"
              :rules="[
                  {type: 'string', min: 1, max: item.goodsAttributeAttrLength, message: '必须1-' + item.goodsAttributeAttrLength + '个字符', trigger: 'blur'}
                ]">
                <Input v-model="form[item.goodsAttributeId + '_' + item.goodsAttributeAttrCode]" :placeholder="'请输入' + item.goodsAttributeAttrName" style="width: 100%;"/>
              </FormItem>
              <FormItem v-else-if="item.goodsAttributeAttrType === 'Double'" :label="item.goodsAttributeAttrName" :prop="item.goodsAttributeId + '_' + item.goodsAttributeAttrCode"
              :rules="[
                  {type: 'number', required: true, message: '此项为必须项', trigger: 'blur, change'}
                ]">
                <InputNumber v-model="form[item.goodsAttributeId + '_' + item.goodsAttributeAttrCode]" :placeholder="'请输入' + item.goodsAttributeAttrName" style="width: 100%;"/>
              </FormItem>
              <FormItem v-else-if="item.goodsAttributeAttrType === 'Long' || item.goodsAttributeAttrType === 'Integer'" :label="item.goodsAttributeAttrName" :prop="item.goodsAttributeId + '_' + item.goodsAttributeAttrCode"
              :rules="[
                  {type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
                ]">
                <InputNumber v-model="form[item.goodsAttributeId + '_' + item.goodsAttributeAttrCode]" :placeholder="'请输入' + item.goodsAttributeAttrName" style="width: 100%;"/>
              </FormItem>
            </i-col>
          </Row>
        </Form>
    <div slot="footer">
      <Button type="default" size="large" @click="resetFormCancelModal('skuForm', 'skuDetailModal')">关闭</Button>
      <Button type="primary" size="large" @click="saveSkuDetail">保存</Button>
    </div>
  </Modal>
</template>

<script>
import * as utils from '@/api/utils'
import {getAttrsByCategory, skuAttrVals} from '@/api/goods_attribute'
import {allSkusByGoods, batchSaveGoodsAttrVals} from '@/api/goods_sku'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'SkuDetailModal',
  components: {
  },
  data () {
    return {
      modal: {
        skuDetailModal: false
      },
      categoryId: 0,
      skuId: 0,
      goodsId: 0,
      allSkuIds: [],
      chooseSkuId: 0,
      formElements: [],
      form: {},
      validateRules: {}
    }
  },
  methods: {
    resetFormCancelModal(formRef, modal) {
      utils.cancelModal(this, modal)
      utils.resetForm(this, formRef)
    },
    loadSkusByGoodsId() {
      let params = {
        goodsId: this.goodsId,
        sortColumn: 'id',
        sortOrder: 'asc'
      }
      allSkusByGoods(params).then(response => {
        if (response.data.code === ResponseStatus.OK) {
          this.allSkuIds.splice(0, this.allSkuIds.length)
          response.data.data.rows.forEach((row, index) => {
            this.allSkuIds.push(row.id)
          })
        } else {
          console.log(error)
        }
      }).catch(error => {
        console.log(error)
      })
    },
    // 加载sku的所有属性和值
    loadAllAttrVals() {
      // 获取类目所有属性
      this.loadCategoryAttrs().then(response => {
        if (response.data.code === ResponseStatus.OK) {
          this.formElements = response.data.data.rows
          let skuParams = {
            goodsSkuId: this.chooseSkuId,
            sortColumn: 'goodsCategoryAttributeAttrOrder',
            sortOrder: 'asc'
          }
          // 获取已经设置值的属性
          skuAttrVals(skuParams).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              this.formElements.forEach((formItem, index) => {
                this.$set(this.form, formItem.goodsAttributeId + '_' + formItem.goodsAttributeAttrCode, null)
                response.data.data.rows.forEach((attrValue, index) => {
                  if (formItem.goodsAttributeId === attrValue.goodsCategoryAttributeAttrId) {
                    let theAttributeVal = attrValue.goodsAttributeValueAttrValue
                    if (formItem.goodsAttributeAttrType === 'Integer' || formItem.goodsAttributeAttrType === 'Long') { 
                      theAttributeVal = parseInt(theAttributeVal)
                    } else if (formItem.goodsAttributeAttrType === 'Double') {
                      theAttributeVal = parseFloat(theAttributeVal)
                    }
                    this.$set(this.form, formItem.goodsAttributeId + '_' + formItem.goodsAttributeAttrCode, theAttributeVal)
                  }
                })
              })
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
        } else {
          this.$Message.error(response.data.message)
        }
      }).catch(error => {
        console.log(error)
      })
    },
    loadCategoryAttrs() {
      return new Promise((resolve, reject) => {
        let params = {
          goodsCategoryId: this.categoryId,
          sortColumn: 'goodsCategoryAttributeAttrOrder',
          sortOrder: 'asc'
        }
        getAttrsByCategory(params).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    changeSkuId(newVal) {
      this.chooseSkuId = newVal
      this.loadAllAttrVals()
    },
    saveSkuDetail() {
      if (this.form.length <= 0) {
        this.$Message.warning('没有需要保存的属性值')
        return
      }
      this.$refs['skuForm'].validate(valid => {
        if (valid) {
          let params = []
          for (let key in this.form) {
            let attrValue = this.form[key]
            if (attrValue !== null) {
              let attrId = key.split('_')[0]
              params.push({
                goodsSkuId: this.skuId,
                attrId: attrId,
                attrValue: this.form[key]
              })
            }
          }
          if (params.length > 0) {
            batchSaveGoodsAttrVals(params).then(response => {
              if (response.data.code === ResponseStatus.OK) {
                this.$Message.success(response.data.message)
                this.resetFormCancelModal('skuForm', 'skuDetailModal')
              } else {
                this.$Message.error(response.data.message)
              }
            }).catch(error => {
              console.log(error)
            })
          } else {
            this.$Message.warning('没有需要保存的属性值')
          }
        }
      })
    }
  },
  mounted () {}
}
</script>

<style lang="less">
</style>
