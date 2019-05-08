<template>
  <div>
      <p>
        招投标项目编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        项目名称:
        <span v-text="form.title"></span>
      </p>
      <p>
        项目类型:
        <span v-text="form.projectType"></span>
      </p>
      <p>
        城市:
        <span v-text="form.city"></span>
      </p>
      <p>
        项目详情:
        <span v-html="form.projectDetail"></span>
      </p>
      <p>
        发布状态:
        <span v-text="form.releaseStatus"></span>
      </p>
      <p>
        招标单位名称:
        <span v-text="form.markUnitName"></span>
      </p>
      <p>
        项目投资:
        <span v-text="form.projectInvest"></span>
      </p>
      <p>
        审查方式:
        <span v-text="form.checkPattern"></span>
      </p>
      <p>
        企业资质类型:
        <span v-text="form.compAptitudeType"></span>
      </p>
      <p>
        建造师等级:
        <span v-text="form.builderLevel"></span>
      </p>
      <p>
        资金落实(%):
        <span v-text="form.moneyToImplement"></span>
      </p>
      <p>
        招标代理:
        <span v-text="form.tenderingAgent"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
      </p>
      <p>
        要约价(元):
        <span v-text="form.offerPrice"></span>
      </p>
      <p>
        保证金(万元):
        <span v-text="form.assurePrice"></span>
      </p>
      <p>
        工期(天):
        <span v-text="form.constructionPeriod"></span>
      </p>
      <p>
        下载截止时间:
        <span v-text="form.downloadEndTime"></span>
      </p>
      <p>
        源地址：
        <a :href="form.sourceUrl" target="_blank">{{form.sourceUrl}}</a>
      </p>
      <p>
        其他要求:
        <span v-text="form.otherDemand"></span>
      </p>
      <p>
        开标信息:
        <span v-text="form.openMarkInfo"></span>
      </p>
      <p>
        开标时间:
        <span v-text="form.openMarkTime"></span>
      </p>
      <p>
        开标地点:
        <span v-text="form.openMarkAddr"></span>
      </p>
      <p>
        中标公示:
        <span v-text="form.inMarkPublicity"></span>
      </p>
      <p>
        中标单位:
        <span v-text="form.inMarkComp"></span>
      </p>
      <p>
        公告时间:
        <span v-text="form.noticeTime"></span>
      </p>
      <p>
        点击次数:
        <span v-text="form.clickCount"></span>
      </p>
      <p>
        是否电子标:
        <span v-text="form.isElectronic === 0 ? '非电子' : '电子'"></span>
      </p>
      <p>
        版本号:
        <span v-text="form.version"></span>
      </p>
      <p>
        创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>
        更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>
        是否激活:
        <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span>
      </p>
  </div>
</template>

<script>
export default {
  name: 'ProjectViewModal',
  props: {
    form: Object,
    detail: false
  },
  data() {
    return {}
  },
  computed: {},
  mounted() {},
  methods: {}
}
</script>

<style>
</style>
