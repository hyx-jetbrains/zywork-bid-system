(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-164c2024"],{6776:function(e,t,r){"use strict";var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("Row",[r("i-col",{attrs:{span:"24"}},[r("Card",[r("Button",{attrs:{type:"primary"},on:{click:e.confirmSelection}},[e._v("确认选择")]),e._v(" \n        "),r("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n        "),r("Tooltip",{attrs:{content:"刷新",placement:"right"}},[r("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),r("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{"highlight-row":"",stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-current-change":e.changeCurrent,"on-sort-change":e.changeSort}}),r("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[r("div",{staticStyle:{float:"right"}},[r("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),r("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[r("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[r("FormItem",{attrs:{label:"招投标项目编号"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"idMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始招投标项目编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"idMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束招投标项目编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"项目名称",prop:"title"}},[r("Input",{attrs:{placeholder:"请输入项目名称"},model:{value:e.searchForm.title,callback:function(t){e.$set(e.searchForm,"title",t)},expression:"searchForm.title"}})],1),r("FormItem",{attrs:{label:"项目类型",prop:"projectType"}},[r("Input",{attrs:{placeholder:"请输入项目类型"},model:{value:e.searchForm.projectType,callback:function(t){e.$set(e.searchForm,"projectType",t)},expression:"searchForm.projectType"}})],1),r("FormItem",{attrs:{label:"城市",prop:"city"}},[r("Input",{attrs:{placeholder:"请输入城市"},model:{value:e.searchForm.city,callback:function(t){e.$set(e.searchForm,"city",t)},expression:"searchForm.city"}})],1),r("FormItem",{attrs:{label:"项目详情",prop:"projectDetail"}},[r("Input",{attrs:{placeholder:"请输入项目详情"},model:{value:e.searchForm.projectDetail,callback:function(t){e.$set(e.searchForm,"projectDetail",t)},expression:"searchForm.projectDetail"}})],1),r("FormItem",{attrs:{label:"发布状态",prop:"releaseStatus"}},[r("Input",{attrs:{placeholder:"请输入发布状态"},model:{value:e.searchForm.releaseStatus,callback:function(t){e.$set(e.searchForm,"releaseStatus",t)},expression:"searchForm.releaseStatus"}})],1),r("FormItem",{attrs:{label:"招标单位名称",prop:"markUnitName"}},[r("Input",{attrs:{placeholder:"请输入招标单位名称"},model:{value:e.searchForm.markUnitName,callback:function(t){e.$set(e.searchForm,"markUnitName",t)},expression:"searchForm.markUnitName"}})],1),r("FormItem",{attrs:{label:"项目投资",prop:"projectInvest"}},[r("Input",{attrs:{placeholder:"请输入项目投资"},model:{value:e.searchForm.projectInvest,callback:function(t){e.$set(e.searchForm,"projectInvest",t)},expression:"searchForm.projectInvest"}})],1),r("FormItem",{attrs:{label:"审查方式",prop:"checkPattern"}},[r("Input",{attrs:{placeholder:"请输入审查方式"},model:{value:e.searchForm.checkPattern,callback:function(t){e.$set(e.searchForm,"checkPattern",t)},expression:"searchForm.checkPattern"}})],1),r("FormItem",{attrs:{label:"企业资质类型",prop:"compAptitudeType"}},[r("Input",{attrs:{placeholder:"请输入企业资质类型"},model:{value:e.searchForm.compAptitudeType,callback:function(t){e.$set(e.searchForm,"compAptitudeType",t)},expression:"searchForm.compAptitudeType"}})],1),r("FormItem",{attrs:{label:"建造师等级",prop:"builderLevel"}},[r("Input",{attrs:{placeholder:"请输入建造师等级"},model:{value:e.searchForm.builderLevel,callback:function(t){e.$set(e.searchForm,"builderLevel",t)},expression:"searchForm.builderLevel"}})],1),r("FormItem",{attrs:{label:"资金落实(%)"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"moneyToImplementMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始资金落实(%)"},model:{value:e.searchForm.moneyToImplementMin,callback:function(t){e.$set(e.searchForm,"moneyToImplementMin",t)},expression:"searchForm.moneyToImplementMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"moneyToImplementMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束资金落实(%)"},model:{value:e.searchForm.moneyToImplementMax,callback:function(t){e.$set(e.searchForm,"moneyToImplementMax",t)},expression:"searchForm.moneyToImplementMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"招标代理",prop:"tenderingAgent"}},[r("Input",{attrs:{placeholder:"请输入招标代理"},model:{value:e.searchForm.tenderingAgent,callback:function(t){e.$set(e.searchForm,"tenderingAgent",t)},expression:"searchForm.tenderingAgent"}})],1),r("FormItem",{attrs:{label:"联系电话",prop:"phone"}},[r("Input",{attrs:{placeholder:"请输入联系电话"},model:{value:e.searchForm.phone,callback:function(t){e.$set(e.searchForm,"phone",t)},expression:"searchForm.phone"}})],1),r("FormItem",{attrs:{label:"要约价(元)"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"offerPriceMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始要约价(元)"},model:{value:e.searchForm.offerPriceMin,callback:function(t){e.$set(e.searchForm,"offerPriceMin",t)},expression:"searchForm.offerPriceMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"offerPriceMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束要约价(元)"},model:{value:e.searchForm.offerPriceMax,callback:function(t){e.$set(e.searchForm,"offerPriceMax",t)},expression:"searchForm.offerPriceMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"保证金(万元)"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"assurePriceMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始保证金(万元)"},model:{value:e.searchForm.assurePriceMin,callback:function(t){e.$set(e.searchForm,"assurePriceMin",t)},expression:"searchForm.assurePriceMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"assurePriceMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束保证金(万元)"},model:{value:e.searchForm.assurePriceMax,callback:function(t){e.$set(e.searchForm,"assurePriceMax",t)},expression:"searchForm.assurePriceMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"工期(天)"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"constructionPeriodMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始工期(天)"},model:{value:e.searchForm.constructionPeriodMin,callback:function(t){e.$set(e.searchForm,"constructionPeriodMin",t)},expression:"searchForm.constructionPeriodMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"constructionPeriodMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束工期(天)"},model:{value:e.searchForm.constructionPeriodMax,callback:function(t){e.$set(e.searchForm,"constructionPeriodMax",t)},expression:"searchForm.constructionPeriodMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"下载截止时间"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"downloadEndTimeMin"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.downloadEndTimeMin,placeholder:"请输入开始下载截止时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.downloadEndTimeMin=t}}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"downloadEndTimeMax"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.downloadEndTimeMax,placeholder:"请输入结束下载截止时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.downloadEndTimeMax=t}}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"其他要求",prop:"otherDemand"}},[r("Input",{attrs:{placeholder:"请输入其他要求"},model:{value:e.searchForm.otherDemand,callback:function(t){e.$set(e.searchForm,"otherDemand",t)},expression:"searchForm.otherDemand"}})],1),r("FormItem",{attrs:{label:"开标信息",prop:"openMarkInfo"}},[r("Input",{attrs:{placeholder:"请输入开标信息"},model:{value:e.searchForm.openMarkInfo,callback:function(t){e.$set(e.searchForm,"openMarkInfo",t)},expression:"searchForm.openMarkInfo"}})],1),r("FormItem",{attrs:{label:"开标时间"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"openMarkTimeMin"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.openMarkTimeMin,placeholder:"请输入开始开标时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.openMarkTimeMin=t}}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"openMarkTimeMax"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.openMarkTimeMax,placeholder:"请输入结束开标时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.openMarkTimeMax=t}}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"开标地点",prop:"openMarkAddr"}},[r("Input",{attrs:{placeholder:"请输入开标地点"},model:{value:e.searchForm.openMarkAddr,callback:function(t){e.$set(e.searchForm,"openMarkAddr",t)},expression:"searchForm.openMarkAddr"}})],1),r("FormItem",{attrs:{label:"中标公示",prop:"markStatus"}},[r("Input",{attrs:{placeholder:"请输入中标公示"},model:{value:e.searchForm.markStatus,callback:function(t){e.$set(e.searchForm,"markStatus",t)},expression:"searchForm.markStatus"}})],1),r("FormItem",{attrs:{label:"中标单位",prop:"inMarkComp"}},[r("Input",{attrs:{placeholder:"请输入中标单位"},model:{value:e.searchForm.inMarkComp,callback:function(t){e.$set(e.searchForm,"inMarkComp",t)},expression:"searchForm.inMarkComp"}})],1),r("FormItem",{attrs:{label:"公告时间"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"noticeTimeMin"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.noticeTimeMin,placeholder:"请输入开始公告时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.noticeTimeMin=t}}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"noticeTimeMax"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.noticeTimeMax,placeholder:"请输入结束公告时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.noticeTimeMax=t}}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"点击次数"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"clickCountMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始点击次数"},model:{value:e.searchForm.clickCountMin,callback:function(t){e.$set(e.searchForm,"clickCountMin",t)},expression:"searchForm.clickCountMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"clickCountMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束点击次数"},model:{value:e.searchForm.clickCountMax,callback:function(t){e.$set(e.searchForm,"clickCountMax",t)},expression:"searchForm.clickCountMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"是否电子标"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"isElectronicMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否电子标"},model:{value:e.searchForm.isElectronicMin,callback:function(t){e.$set(e.searchForm,"isElectronicMin",t)},expression:"searchForm.isElectronicMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"isElectronicMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否电子标"},model:{value:e.searchForm.isElectronicMax,callback:function(t){e.$set(e.searchForm,"isElectronicMax",t)},expression:"searchForm.isElectronicMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"版本号"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"versionMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"versionMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"创建时间"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"createTimeMin"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"createTimeMax"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"更新时间"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"updateTimeMin"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"updateTimeMax"}},[r("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1),r("FormItem",{attrs:{label:"是否激活"}},[r("Row",[r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"isActiveMin"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:e.searchForm.isActiveMin,callback:function(t){e.$set(e.searchForm,"isActiveMin",t)},expression:"searchForm.isActiveMin"}})],1)],1),r("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),r("i-col",{attrs:{span:"11"}},[r("FormItem",{attrs:{prop:"isActiveMax"}},[r("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:e.searchForm.isActiveMax,callback:function(t){e.$set(e.searchForm,"isActiveMax",t)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),r("div",{attrs:{slot:"footer"},slot:"footer"},[r("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),r("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),r("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("确定")])],1)],1),r("Modal",{attrs:{title:"详情"},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[r("p",[e._v("\n      招投标项目编号:\n      "),r("span",{domProps:{textContent:e._s(e.form.id)}})]),r("p",[e._v("\n      项目名称:\n      "),r("span",{domProps:{textContent:e._s(e.form.title)}})]),r("p",[e._v("\n      项目类型:\n      "),r("span",{domProps:{textContent:e._s(e.form.projectType)}})]),r("p",[e._v("\n      城市:\n      "),r("span",{domProps:{textContent:e._s(e.form.city)}})]),r("p",[e._v("\n      项目详情:\n      "),r("span",{domProps:{innerHTML:e._s(e.form.projectDetail)}})]),r("p",[e._v("\n      发布状态:\n      "),r("span",{domProps:{textContent:e._s(e.form.releaseStatus)}})]),r("p",[e._v("\n      招标单位名称:\n      "),r("span",{domProps:{textContent:e._s(e.form.markUnitName)}})]),r("p",[e._v("\n      项目投资:\n      "),r("span",{domProps:{textContent:e._s(e.form.projectInvest)}})]),r("p",[e._v("\n      审查方式:\n      "),r("span",{domProps:{textContent:e._s(e.form.checkPattern)}})]),r("p",[e._v("\n      企业资质类型:\n      "),r("span",{domProps:{textContent:e._s(e.form.compAptitudeType)}})]),r("p",[e._v("\n      建造师等级:\n      "),r("span",{domProps:{textContent:e._s(e.form.builderLevel)}})]),r("p",[e._v("\n      资金落实(%):\n      "),r("span",{domProps:{textContent:e._s(e.form.moneyToImplement)}})]),r("p",[e._v("\n      招标代理:\n      "),r("span",{domProps:{textContent:e._s(e.form.tenderingAgent)}})]),r("p",[e._v("\n      联系电话:\n      "),r("span",{domProps:{textContent:e._s(e.form.phone)}})]),r("p",[e._v("\n      要约价(元):\n      "),r("span",{domProps:{textContent:e._s(e.form.offerPrice)}})]),r("p",[e._v("\n      保证金(万元):\n      "),r("span",{domProps:{textContent:e._s(e.form.assurePrice)}})]),r("p",[e._v("\n      工期(天):\n      "),r("span",{domProps:{textContent:e._s(e.form.constructionPeriod)}})]),r("p",[e._v("\n      下载截止时间:\n      "),r("span",{domProps:{textContent:e._s(e.form.downloadEndTime)}})]),r("p",[e._v("\n      源地址：\n      "),r("a",{attrs:{href:e.form.sourceUrl,target:"_blank"}},[e._v(e._s(e.form.sourceUrl))])]),r("p",[e._v("\n      其他要求:\n      "),r("span",{domProps:{textContent:e._s(e.form.otherDemand)}})]),r("p",[e._v("\n      开标信息:\n      "),r("span",{domProps:{textContent:e._s(e.form.openMarkInfo)}})]),r("p",[e._v("\n      开标时间:\n      "),r("span",{domProps:{textContent:e._s(e.form.openMarkTime)}})]),r("p",[e._v("\n      开标地点:\n      "),r("span",{domProps:{textContent:e._s(e.form.openMarkAddr)}})]),r("p",[e._v("\n      中标公示:\n      "),r("span",{domProps:{textContent:e._s(e.form.markStatus)}})]),r("p",[e._v("\n      中标单位:\n      "),r("span",{domProps:{textContent:e._s(e.form.inMarkComp)}})]),r("p",[e._v("\n      公告时间:\n      "),r("span",{domProps:{textContent:e._s(e.form.noticeTime)}})]),r("p",[e._v("\n      点击次数:\n      "),r("span",{domProps:{textContent:e._s(e.form.clickCount)}})]),r("p",[e._v("\n      是否电子标:\n      "),r("span",{domProps:{textContent:e._s(0===e.form.isElectronic?"非电子":"电子")}})]),r("p",[e._v("\n      版本号:\n      "),r("span",{domProps:{textContent:e._s(e.form.version)}})]),r("p",[e._v("\n      创建时间:\n      "),r("span",{domProps:{textContent:e._s(e.form.createTime)}})]),r("p",[e._v("\n      更新时间:\n      "),r("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),r("p",[e._v("\n      是否激活:\n      "),r("span",{domProps:{textContent:e._s(0===e.form.isActive?"激活":"冻结")}})])]),r("Modal",{attrs:{title:"招投标项目公示详情",fullscreen:!0},model:{value:e.modal.projectDetail,callback:function(t){e.$set(e.modal,"projectDetail",t)},expression:"modal.projectDetail"}},[r("span",{domProps:{innerHTML:e._s(e.form.projectDetail)}})])],1)},o=[],n=(r("386d"),r("f499")),l=r.n(n),s=r("f62d"),i={name:"ProjectListSingle",data:function(){var e=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1,projectDetail:!1},loading:{search:!1},urls:{searchUrl:"/project/admin/pager-cond",allUrl:"/project/admin/all",detailUrl:"/project/admin/one/"},page:{total:0},form:{id:null,title:null,projectType:null,city:null,projectDetail:null,releaseStatus:null,markUnitName:null,projectInvest:null,checkPattern:null,compAptitudeType:null,builderLevel:null,moneyToImplement:null,tenderingAgent:null,phone:null,offerPrice:null,assurePrice:null,constructionPeriod:null,downloadEndTime:null,otherDemand:null,openMarkInfo:null,openMarkTime:null,openMarkAddr:null,markStatus:null,inMarkComp:null,noticeTime:null,clickCount:null,isElectronic:null,version:null,createTime:null,updateTime:null,isActive:null},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,title:null,projectType:null,city:null,projectDetail:null,releaseStatus:null,markUnitName:null,projectInvest:null,checkPattern:null,compAptitudeType:null,builderLevel:null,moneyToImplement:null,moneyToImplementMin:null,moneyToImplementMax:null,tenderingAgent:null,phone:null,offerPrice:null,offerPriceMin:null,offerPriceMax:null,assurePrice:null,assurePriceMin:null,assurePriceMax:null,constructionPeriod:null,constructionPeriodMin:null,constructionPeriodMax:null,downloadEndTime:null,downloadEndTimeMin:null,downloadEndTimeMax:null,otherDemand:null,openMarkInfo:null,openMarkTime:null,openMarkTimeMin:null,openMarkTimeMax:null,openMarkAddr:null,markStatus:null,inMarkComp:null,noticeTime:null,noticeTimeMin:null,noticeTimeMax:null,clickCount:null,clickCountMin:null,clickCountMax:null,isElectronic:null,isElectronicMin:null,isElectronicMax:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{width:60,align:"center",fixed:"left",render:function(t,r){return t("span",r.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"招投标项目编号",key:"id",minWidth:140,sortable:!0},{title:"项目名称",key:"title",minWidth:120,sortable:!0},{title:"项目类型",key:"projectType",minWidth:120,sortable:!0},{title:"城市",key:"city",minWidth:120,sortable:!0},{title:"项目详情",key:"projectDetail",minWidth:120,render:function(t,r){return t("a",{on:{click:function(){s["B"](e,"projectDetail"),e.form=JSON.parse(l()(r.row))}}},"点击查看")}},{title:"发布状态",key:"releaseStatus",minWidth:120,sortable:!0,render:function(t,r){var a=r.row,o="待审核"===a.releaseStatus?"default":"已发布"===a.releaseStatus?"success":"error";return"待审核"===a.releaseStatus?t("Tooltip",{props:{placement:"top",content:"点击发布"}},[t("Button",{on:{click:function(){e.userOpt("releaseProject",a)}},props:{size:"small",type:o}},a.releaseStatus)]):t("Button",{props:{size:"small",type:o}},a.releaseStatus)}},{title:"招标单位名称",key:"markUnitName",minWidth:130,sortable:!0},{title:"项目投资",key:"projectInvest",minWidth:120,sortable:!0},{title:"审查方式",key:"checkPattern",minWidth:120,sortable:!0},{title:"企业资质类型",key:"compAptitudeType",minWidth:130,sortable:!0},{title:"建造师等级",key:"builderLevel",minWidth:120,sortable:!0},{title:"资金落实(%)",key:"moneyToImplement",minWidth:200,sortable:!0,render:function(e,t){var r=t.row;return e("Progress",{props:{percent:r.moneyToImplement,status:"active"}},r.moneyToImplement+"%")}},{title:"招标代理",key:"tenderingAgent",minWidth:130,sortable:!0},{title:"联系电话",key:"phone",minWidth:120,sortable:!0},{title:"要约价(元)",key:"offerPrice",minWidth:120,sortable:!0},{title:"保证金(万元)",key:"assurePrice",minWidth:130,sortable:!0},{title:"工期(天)",key:"constructionPeriod",minWidth:120,sortable:!0},{title:"下载截止时间",key:"downloadEndTime",minWidth:130,sortable:!0},{title:"源地址",key:"sourceUrl",minWidth:120,sortable:!0,render:function(e,t){var r=t.row;return e("a",{attrs:{href:r.sourceUrl,target:"_blank"}},r.sourceUrl)}},{title:"其他要求",key:"otherDemand",minWidth:120,sortable:!0,render:function(t,r){return t("a",{on:{click:function(){s["B"](e,"detail"),e.form=JSON.parse(l()(r.row))}}},"点击查看")}},{title:"开标信息",key:"openMarkInfo",minWidth:120,sortable:!0},{title:"开标时间",key:"openMarkTime",minWidth:120,sortable:!0},{title:"开标地点",key:"openMarkAddr",minWidth:120,sortable:!0},{title:"中标公示",key:"markStatus",minWidth:120,sortable:!0,render:function(e,t){var r=t.row,a="待开标"===r.markStatus?"default":"公告中"===r.markStatus?"success":"已开标"===r.markStatus?"primary":"error";return e("Button",{props:{size:"small",type:a}},r.markStatus)}},{title:"中标单位",key:"inMarkComp",minWidth:120,sortable:!0},{title:"公告时间",key:"noticeTime",minWidth:120,sortable:!0},{title:"点击次数",key:"clickCount",minWidth:120,sortable:!0},{title:"是否电子标",key:"isElectronic",minWidth:120,sortable:!0,render:function(e,t){var r=t.row,a=0===r.isElectronic?"default":1===r.isElectronic?"success":"error",o=0===r.isElectronic?"非电子":1===r.isElectronic?"电子":"未知";return e("Button",{props:{size:"small",type:a}},o)}},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:120,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:120,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(e,t){var r=t.row,a=0===r.isActive?"激活":"冻结";return e("span",a)}},{title:"操作",key:"action",width:80,align:"center",fixed:"right",render:function(t,r){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.showDetail("detail",r.row)}}},"详情")])}}],tableDetails:[],currentRow:{}}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){s["B"](this,e)},showDetail:function(e,t){s["B"](this,e),this.form=t},changeModalVisibleResetForm:function(e,t){t||s["z"](this,e)},resetForm:function(e){s["z"](this,e)},cancelModal:function(e){s["h"](this,e)},resetFormCancelModal:function(e,t){s["h"](this,t),s["z"](this,e)},searchOkModal:function(e){s["h"](this,e),this.searchForm.pageNo=1,s["A"](this)},search:function(){s["A"](this)},changeCurrent:function(e,t){s["i"](this,e,t)},changeSort:function(e){s["p"](this,e)},changePageNo:function(e){s["j"](this,e)},changePageSize:function(e){s["k"](this,e)},confirmSelection:function(){this.$emit("confirmChoiceProject",this.table.currentRow.id)}}},c=i,m=r("2877"),p=Object(m["a"])(c,a,o,!1,null,null,null);t["a"]=p.exports},"816b":function(e,t,r){"use strict";r.d(t,"a",function(){return o}),r.d(t,"g",function(){return n}),r.d(t,"j",function(){return l}),r.d(t,"h",function(){return s}),r.d(t,"e",function(){return i}),r.d(t,"d",function(){return c}),r.d(t,"c",function(){return m}),r.d(t,"b",function(){return p}),r.d(t,"f",function(){return u}),r.d(t,"k",function(){return d}),r.d(t,"i",function(){return h});var a=r("66df"),o=function(){return a["a"].request({url:"/module/admin/all",method:"GET",data:""})},n=function(e){return a["a"].request({url:"/module/admin/one/"+e,method:"GET",data:""})},l=function(e){return a["a"].request({url:"/user-userdetail/admin/multi/"+e,method:"GET",data:""})},s=function(e){return a["a"].request({url:"/project/admin/one/"+e,method:"GET",data:""})},i=function(e){return a["a"].request({url:"/coupon/admin/one/"+e,method:"GET",data:""})},c=function(e){return a["a"].request({url:"/company/admin/one/"+e,method:"GET",data:""})},m=function(e){return a["a"].request({url:"/builder/admin/one/"+e,method:"GET",data:""})},p=function(e){return a["a"].request({url:"/aptitude-transfer/admin/one/"+e,method:"GET",data:""})},u=function(e){return a["a"].request({url:"/experquestion-type/admin/one/"+e,method:"GET",data:""})},d=function(e){return a["a"].request({url:"/user-expert/admin/one/"+e,method:"GET",data:""})},h=function(e){return a["a"].request({url:"/service/admin/one/"+e,method:"GET",data:""})}}}]);