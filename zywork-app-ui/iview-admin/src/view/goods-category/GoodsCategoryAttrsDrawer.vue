<template>
  <div>
    <Drawer title="选择商品属性" v-model="goodsCategoryAttrsDrawer" width="900" @on-close="closeDrawer">
      <GoodsAttributeList ref="goodsAttributeList" :selectedData="selectedData" :selectedDataId="selectedDataId" :extraData="extraData" @closeDrawer="closeDrawer"/>
      <div class="demo-drawer-footer">
        <Button style="margin-right: 8px" @click="closeDrawer">取消</Button>
        <Button type="primary" @click="updateAttrs">确认选择</Button>
      </div>
    </Drawer>
  </div>
</template>

<script>
import GoodsAttributeList from '@/view/goods-attribute/GoodsAttributeList.vue'
import { getAttrsByCategory } from '@/api/goods_attribute'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'GoodsCategoryAttrsDrawer',
  components: {
    GoodsAttributeList
  },
  data() {
    return {
      goodsCategoryAttrsDrawer: false,
      selectedData: null,
      selectedDataId: 'goodsAttributeId',
      extraData: {
        categoryId: ''
      }
    }
  },
  computed: {},
  mounted() {},
  methods: {
    initData(id) {
      var params = {
        goodsCategoryId: id
      }
      getAttrsByCategory(params)
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            this.$Message.error(data.message)
            return
          }
          this.goodsCategoryAttrsDrawer = true
          this.selectedData = data.data.rows
          this.extraData.categoryId = id
          this.$refs.goodsAttributeList.initTableData()
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    closeDrawer() {
      // 关闭抽屉清空选择项
      this.goodsCategoryAttrsDrawer = false
      this.$refs.goodsAttributeList.cancelSelect()
    },
    updateAttrs() {
      this.$refs.goodsAttributeList.confirmSelection()
    }
  }
}
</script>

<style>
.demo-drawer-footer {
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
  border-top: 1px solid #e8e8e8;
  padding: 10px 16px;
  text-align: right;
  background: #fff;
}
</style>
