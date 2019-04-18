<template>
  <div class="drag-list-wrapper">
    <div class="drag-list-con">
      <slot name="title"></slot>
      <draggable class="drop-box1" :class="dropConClass.left" :options="options" :value="list" @input="handleListChange($event)">
        <div class="drag-list-item" v-for="(item, index) in list" :key="`item_${index}`">
          <slot name="content" :item="item" :index="index">{{ (index + 1) + ': ' + item }}</slot>
        </div>
        <p style="clear: both;"></p>
      </draggable>
    </div>
  </div>
</template>
<script>
import draggable from 'vuedraggable'
export default {
  name: 'DragListSingle',
  components: {
    draggable
  },
  props: {
    list: {
      type: Array,
      required: true
    },
    dropConClass: {
      type: Object,
      default: () => ({})
    }
  },
  data () {
    return {
      options: { group: 'drag_list' }
    }
  },
  methods: {
    handleListChange (value) {
      this.$emit('update:list', value)
    }
  }
}
</script>
<style lang="less">
.drag-list-wrapper{
  height: 100%;
}
.drag-list-item {
  width: 30%;
  float: left;
  margin-right: 3%;
}
</style>
