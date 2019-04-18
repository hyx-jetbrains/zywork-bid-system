<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="confirmSelection" type="primary">确认排序</Button>&nbsp;
          <Tooltip content="刷新" placement="right">
            <Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
          </Tooltip>
          <div class="drag-box-card">
            <Spin size="large" fix v-if="spinShow"></Spin>
            <drag-list-single :list.sync="attributes" :dropConClass="dropConClass" @on-change="handleChange">
              <h4 slot="title">鼠标拖动以修改属性顺序</h4>
              <Card class="drag-item" slot="content" slot-scope="content">{{ (content.index + 1) + '. ' + content.item.name }}</Card>
            </drag-list-single>
          </div>
        </Card>
      </i-col>
    </Row>
  </div>
</template>

<script>
  import DragListSingle from '_c/drag-list-single'
  import * as utils from '@/api/utils'
  import {getAttrsByCategory, updateGoodsCategoryAttr} from '@/api/goods_attribute'
  import * as ResponseStatus from '@/api/response-status'

  export default {
    name: 'GoodsAttributeOrder',
    components: {
      DragListSingle
    },
    data() {
      return {
        categoryId: null,
        attributes: [],
        dropConClass: {
          left: ['drop-box', 'left-drop-box'],
          right: ['drop-box', 'right-drop-box']
        },
        spinShow: false,
        modal: {
          search: false,
          detail: false
        },
        loading: {
          search: false
        },
        urls: {
          searchUrl: '/goods-category-attr/admin/pager-cond',
          allUrl: '/goods-category-attr/admin/all',
          detailUrl: '/goods-category-attr/admin/one/'
        },
        page: {
          total: 0
        }
      }
    },
    computed: {},
    mounted() {},
    methods: {
      initData(categoryId) {
        this.spinShow = true
        this.categoryId = categoryId
        this.attributes.splice(0, this.attributes.length)
        let params = {
          goodsCategoryId: categoryId,
          sortColumn: 'goodsCategoryAttributeAttrOrder',
          sortOrder: 'asc'
        }
        getAttrsByCategory(params).then(res => {
          this.spinShow = false
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            this.$Message.error(data.message)
            return
          }
          if (data.data.rows.length > 0) {
            data.data.rows.forEach((row, index) => {
              this.attributes.push(
                {
                  id: row.goodsAttributeId, 
                  name: row.goodsAttributeAttrName
                }
              )
            })
          }
        }).catch(err => {
          this.$Message.error(err)
        })
      },
      search() {
        this.initData(this.categoryId)
      },
      handleChange ({ src, target, oldIndex, newIndex }) {
        // this.handleList.push(`${src} => ${target}, ${oldIndex} => ${newIndex}`)
      },
      confirmSelection() {
        if (this.attributes.length === 0) {
          this.$Message.warning('商品类目没有属性，请先分配商品属性')
          return;
        }
        this.$Spin.show()
        // 保存属性排序
        var params = []
        for (let i = 0, len = this.attributes.length; i < len; i++) {
          params.push({
            goodsCategoryId: this.categoryId,
            goodsAttributeId: this.attributes[i].id,
            goodsCategoryAttributeAttrOrder: i + 1
          })
        }
        updateGoodsCategoryAttr(params).then(response => {
          this.$Spin.hide()
          if (response.data.code === ResponseStatus.OK) {
            this.$Message.success('成功更新商品类目属性排序')
            this.$emit("hideModal")
          } else {
            this.$Message.error(response.data.message)
          }
        }).catch(error => {
          console.log(error)
        })
      }
    }
  }
</script>

<style lang="less">
.drag-box-card{
  display: inline-block;
  width: 100%;
  height: 100%;
  margin-top: 10px;
  .drag-item{
    margin: 5px;
  }
  h3{
    padding: 10px 15px;
  }
  .drop-box{
    height: auto;
    border-radius: 5px;
  }
  .left-drop-box{
    margin-right: 10px;
  }
}
</style>
