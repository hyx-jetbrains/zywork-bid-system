<template>
  <div>
    <Modal v-model="detail" title="模块详情">
      <p>模块编号:
        <span v-text="form.id"></span>
      </p>
      <p>模块标题:
        <span v-text="form.title"></span>
      </p>
      <p>模块描述:
        <span v-text="form.description"></span>
      </p>
      <p>版本号:
        <span v-text="form.version"></span>
      </p>
      <p>创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>是否激活:
        <span v-text="form.isActive"></span>
      </p>
      <div slot="footer">
        <Button type="primary" @click="closeModal">确定</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
export default {
  name: 'ModuleViewModal',
  props: {
    form: Object,
    detail: false
  },
  data() {
    return {}
  },
  computed: {},
  mounted() {
  },
  methods: {
    closeModal() {
      this.$emit('setDetail', false)
    }
  }
}
</script>

<style>
</style>
