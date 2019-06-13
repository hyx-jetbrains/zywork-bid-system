(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b1c48dd4"],{"24d2":function(e,t,o){"use strict";o.d(t,"b",function(){return s}),o.d(t,"a",function(){return c});o("ac6a"),o("386d");var r=o("795b"),a=o.n(r),n=o("66df"),l=o("2e19"),i=o("f62d"),s=(o("4328"),function(e,t){return new a.a(function(o,r){n["a"].request({url:e.urls.releaseStatusUrl,method:"POST",data:{id:t.id,releaseStatus:t.releaseStatus}}).then(function(t){t.data.code!==l["b"]?e.$Message.error(t.data.message):e.$Message.success(t.data.message),i["A"](e),o(t)}).catch(function(t){console.log(t),e.$Message.error("发布失败，稍候再试"),r(t)})})}),c=function(e,t){return new a.a(function(o,r){var a=[];0===e.table.selections.length?e.$Message.warning("请选择需要批量发布的数据"):(e.table.selections.forEach(function(e,o){e.releaseStatus!==t&&a.push({id:e.id,releaseStatus:t})}),a.length>0?n["a"].request({url:e.urls.batchReleaseUrl,method:"POST",data:a}).then(function(t){t.data.code!==l["b"]?e.$Message.error(t.data.message):(e.$Message.success(t.data.message),e.table.selections=[],i["A"](e)),o(t)}).catch(function(t){console.log(t),e.$Message.error("批量发布数据失败，稍候再试"),r(t)}):e.$Message.warning("没有需要批量发布的数据"))})}},"9da9":function(e,t,o){"use strict";o.r(t);var r=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("Row",[o("i-col",{attrs:{span:"24"}},[o("Card",[o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("add")}}},[e._v("添加")]),e._v(" \n        "),o("Dropdown",{on:{"on-click":e.batchOpt}},[o("Button",{attrs:{type:"primary"}},[e._v("\n            批量操作\n            "),o("Icon",{attrs:{type:"ios-arrow-down"}})],1),o("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[o("DropdownItem",{attrs:{name:"batchActive"}},[e._v("批量激活")]),o("DropdownItem",{attrs:{name:"batchInactive"}},[o("span",{staticStyle:{color:"red"}},[e._v("批量冻结")])]),o("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[o("span",{staticStyle:{color:"red"}},[e._v("批量删除")])])],1)],1),e._v(" \n        "),o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n        "),o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("python")}}},[e._v("爬取数据")]),e._v(" \n        "),o("Tooltip",{attrs:{content:"刷新",placement:"right"}},[o("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),o("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-selection-change":e.changeSelection,"on-sort-change":e.changeSort}}),o("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[o("div",{staticStyle:{float:"right"}},[o("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),o("Modal",{attrs:{title:"添加",fullscreen:!0},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("addForm",t)}},model:{value:e.modal.add,callback:function(t){e.$set(e.modal,"add",t)},expression:"modal.add"}},[o("Form",{ref:"addForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[o("FormItem",{attrs:{label:"项目编号",prop:"projectId"}},[o("span",{domProps:{textContent:e._s(e.form.projectId)}}),e._v("\n         \n        "),o("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("projectChoice")}}},[e._v("选择项目")]),e._v(" \n      ")],1),o("FormItem",{attrs:{label:"项目标题",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目标题"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),o("FormItem",{attrs:{label:"项目类型",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目类型"},model:{value:e.form.projectType,callback:function(t){e.$set(e.form,"projectType",t)},expression:"form.projectType"}})],1),o("FormItem",{attrs:{label:"第一候选人",prop:"firstCandidate"}},[o("Input",{attrs:{placeholder:"请输入第一候选人"},model:{value:e.form.firstCandidate,callback:function(t){e.$set(e.form,"firstCandidate",t)},expression:"form.firstCandidate"}})],1),o("FormItem",{attrs:{label:"建造师姓名",prop:"firstBuilderName"}},[o("Input",{attrs:{placeholder:"请输入建造师姓名"},model:{value:e.form.firstBuilderName,callback:function(t){e.$set(e.form,"firstBuilderName",t)},expression:"form.firstBuilderName"}})],1),o("FormItem",{attrs:{label:"中标金额",prop:"firstMarkMoney"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.form.firstMarkMoney,callback:function(t){e.$set(e.form,"firstMarkMoney",t)},expression:"form.firstMarkMoney"}})],1),o("FormItem",{attrs:{label:"源地址",prop:"sourceUrl"}},[o("Input",{attrs:{placeholder:"请输入源地址"},model:{value:e.form.sourceUrl,callback:function(t){e.$set(e.form,"sourceUrl",t)},expression:"form.sourceUrl"}})],1),o("FormItem",{attrs:{label:"公示详情",prop:"announceDesc"}},[o("editor",{ref:"editorAdd",attrs:{value:e.form.announceDesc},on:{"on-change":e.handleChange}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("addForm","add")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.add},on:{click:e.add}},[e._v("添加")])],1)],1),o("Modal",{attrs:{title:"修改",fullscreen:!0},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.edit,callback:function(t){e.$set(e.modal,"edit",t)},expression:"modal.edit"}},[o("Form",{ref:"editForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[o("FormItem",{attrs:{label:"项目编号",prop:"projectId"}},[o("span",{domProps:{textContent:e._s(e.form.projectId)}}),e._v("\n         \n        "),o("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("projectChoice")}}},[e._v("选择项目")]),e._v(" \n      ")],1),o("FormItem",{attrs:{label:"项目标题",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目标题"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),o("FormItem",{attrs:{label:"项目类型",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目类型"},model:{value:e.form.projectType,callback:function(t){e.$set(e.form,"projectType",t)},expression:"form.projectType"}})],1),o("FormItem",{attrs:{label:"第一候选人",prop:"firstCandidate"}},[o("Input",{attrs:{placeholder:"请输入第一候选人"},model:{value:e.form.firstCandidate,callback:function(t){e.$set(e.form,"firstCandidate",t)},expression:"form.firstCandidate"}})],1),o("FormItem",{attrs:{label:"建造师姓名",prop:"firstBuilderName"}},[o("Input",{attrs:{placeholder:"请输入建造师姓名"},model:{value:e.form.firstBuilderName,callback:function(t){e.$set(e.form,"firstBuilderName",t)},expression:"form.firstBuilderName"}})],1),o("FormItem",{attrs:{label:"中标金额",prop:"firstMarkMoney"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.form.firstMarkMoney,callback:function(t){e.$set(e.form,"firstMarkMoney",t)},expression:"form.firstMarkMoney"}})],1),o("FormItem",{attrs:{label:"源地址",prop:"sourceUrl"}},[o("Input",{attrs:{placeholder:"请输入源地址"},model:{value:e.form.sourceUrl,callback:function(t){e.$set(e.form,"sourceUrl",t)},expression:"form.sourceUrl"}})],1),o("FormItem",{attrs:{label:"公示详情",prop:"announceDesc"}},[o("editor",{ref:"editorEdit",attrs:{value:e.form.announceDesc},on:{"on-change":e.handleChange}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("editForm","edit")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.edit},on:{click:e.edit}},[e._v("修改")])],1)],1),o("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[o("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[o("FormItem",{attrs:{label:"公示编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始公示编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束公示编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"项目编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"projectIdMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始项目编号"},model:{value:e.searchForm.projectIdMin,callback:function(t){e.$set(e.searchForm,"projectIdMin",t)},expression:"searchForm.projectIdMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"projectIdMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束项目编号"},model:{value:e.searchForm.projectIdMax,callback:function(t){e.$set(e.searchForm,"projectIdMax",t)},expression:"searchForm.projectIdMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"项目标题",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目标题"},model:{value:e.searchForm.title,callback:function(t){e.$set(e.searchForm,"title",t)},expression:"searchForm.title"}})],1),o("FormItem",{attrs:{label:"项目类型",prop:"title"}},[o("Input",{attrs:{placeholder:"请输入项目类型"},model:{value:e.searchForm.projectType,callback:function(t){e.$set(e.searchForm,"projectType",t)},expression:"searchForm.projectType"}})],1),o("FormItem",{attrs:{label:"第一候选人",prop:"firstCandidate"}},[o("Input",{attrs:{placeholder:"请输入第一候选人"},model:{value:e.searchForm.firstCandidate,callback:function(t){e.$set(e.searchForm,"firstCandidate",t)},expression:"searchForm.firstCandidate"}})],1),o("FormItem",{attrs:{label:"建造师",prop:"firstBuilderName"}},[o("Input",{attrs:{placeholder:"请输入建造师"},model:{value:e.searchForm.firstBuilderName,callback:function(t){e.$set(e.searchForm,"firstBuilderName",t)},expression:"searchForm.firstBuilderName"}})],1),o("FormItem",{attrs:{label:"中标金额",prop:"firstMarkName"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.searchForm.firstMarkName,callback:function(t){e.$set(e.searchForm,"firstMarkName",t)},expression:"searchForm.firstMarkName"}})],1),o("FormItem",{attrs:{label:"是否激活",prop:"isActive"}},[o("Select",{attrs:{placeholder:"请选择是否激活",clearable:"",filterable:""},model:{value:e.searchForm.isActive,callback:function(t){e.$set(e.searchForm,"isActive",t)},expression:"searchForm.isActive"}},e._l(e.isActiveSelect,function(t){return o("i-option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),o("FormItem",{attrs:{label:"版本号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"创建时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"更新时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("搜索")])],1)],1),o("Modal",{attrs:{fullscreen:!0,title:"公示详情"},model:{value:e.modal.detailContent,callback:function(t){e.$set(e.modal,"detailContent",t)},expression:"modal.detailContent"}},[o("span",{domProps:{innerHTML:e._s(e.form.announceDesc)}})]),o("Modal",{attrs:{title:"详情"},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[o("p",[e._v("\n      公示编号:\n      "),o("span",{domProps:{textContent:e._s(e.form.id)}})]),o("p",[e._v("\n      项目编号:\n      "),o("span",{domProps:{textContent:e._s(e.form.projectId)}})]),o("p",[e._v("\n      项目类型:\n      "),o("span",{domProps:{textContent:e._s(e.form.projectType)}})]),o("p",[e._v("\n      项目标题\n      "),o("span",{domProps:{textContent:e._s(e.form.title)}})]),o("p",[e._v("\n      第一候选人:\n      "),o("span",{domProps:{textContent:e._s(e.form.firstCandidate)}})]),o("p",[e._v("\n      建造师:\n      "),o("span",{domProps:{textContent:e._s(e.form.firstBuilderName)}})]),o("p",[e._v("\n      中标金额:\n      "),o("span",{domProps:{textContent:e._s(e.form.firstMarkMoney)}})]),o("p",[e._v("\n      源地址：\n      "),o("a",{attrs:{href:e.form.sourceUrl,target:"_blank"}},[e._v(e._s(e.form.sourceUrl))])]),o("p",[e._v("\n      版本号:\n      "),o("span",{domProps:{textContent:e._s(e.form.version)}})]),o("p",[e._v("\n      创建时间:\n      "),o("span",{domProps:{textContent:e._s(e.form.createTime)}})]),o("p",[e._v("\n      更新时间:\n      "),o("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),o("p",[e._v("\n      是否激活:\n      "),o("span",{domProps:{textContent:e._s(e.form.isActive)}})])]),o("Modal",{attrs:{transfer:!1,title:"招投标项目详情"},model:{value:e.modal.projectDetail,callback:function(t){e.$set(e.modal,"projectDetail",t)},expression:"modal.projectDetail"}},[o("project-detail",{attrs:{form:e.projectDetailForm}})],1),o("Modal",{attrs:{transfer:!1,fullscreen:"",title:"搜索主表信息"},model:{value:e.modal.projectDetailSearch,callback:function(t){e.$set(e.modal,"projectDetailSearch",t)},expression:"modal.projectDetailSearch"}},[o("project-list-single",{ref:"ProjectListSingle",on:{confirmSelectionProject:e.confirmSelectionProject}}),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("projectDetailSearch")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large"},on:{click:e.confirmProject}},[e._v("确认选择")])],1)],1),o("Modal",{attrs:{transfer:!1,fullscreen:"",title:"选择招投标项目"},model:{value:e.modal.projectChoice,callback:function(t){e.$set(e.modal,"projectChoice",t)},expression:"modal.projectChoice"}},[o("project-list-choice",{ref:"ProjectListChoice",on:{confirmChoiceProject:e.confirmChoiceProject}}),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("projectChoice")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large"},on:{click:e.confirmChoice}},[e._v("确认选择")])],1)],1),o("Modal",{attrs:{title:"爬取数据"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("pythonForm",t)}},model:{value:e.modal.python,callback:function(t){e.$set(e.modal,"python",t)},expression:"modal.python"}},[o("Form",{ref:"pythonForm",attrs:{model:e.python,"label-width":80,rules:e.validateRules}},[o("FormItem",{attrs:{label:"数据来源",prop:"sourse"}},[o("a",{attrs:{href:e.sourceDataUrl,target:"_blank"}},[e._v(e._s(e.sourceDataUrl))])]),o("FormItem",{attrs:{label:"爬取说明",prop:"desc"}},[e._v("增量爬取"),o("span",{staticStyle:{color:"red"},domProps:{textContent:e._s(e.typeLabel)}}),e._v("数据，只会爬取最新的数据，如网站未更新数据，则不会爬取")]),o("FormItem",{attrs:{label:"爬取类型",prop:"title"}},[o("Select",{attrs:{placeholder:"请选择爬取类型","label-in-value":!0},on:{"on-change":e.switchSourceDataUrl},model:{value:e.python.title,callback:function(t){e.$set(e.python,"title",t)},expression:"python.title"}},e._l(e.pythonProjectAnnounceTypeSelect,function(t){return o("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("python")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.python},on:{click:e.crawlData}},[e._v("爬取")])],1)],1)],1)},a=[],n=(o("386d"),o("f499")),l=o.n(n),i=o("f62d"),s=(o("24d2"),o("f08a")),c=o("d3e2"),d=o("816b"),p=o("6776"),m=o("a0f0"),u=o("1a21"),h=o("66df"),f=o("2e19"),y={name:"ProjectAnnounce",components:{Editor:m["a"],ProjectDetail:s["a"],ProjectListSingle:c["a"],ProjectListChoice:p["a"]},data:function(){var e=this;return{projectDetailForm:{id:null,title:null,projectType:null,city:null,projectDetail:null,releaseStatus:null,markUnitName:null,projectInvest:null,checkPattern:null,compAptitudeType:null,builderLevel:null,moneyToImplement:100,tenderingAgent:null,phone:null,offerPrice:0,assurePrice:0,constructionPeriod:null,downloadEndTime:null,otherDemand:null,openMarkInfo:null,openMarkTime:null,openMarkAddr:null,inMarkPublicity:null,inMarkComp:null,noticeTime:null,clickCount:null,isElectronic:null,sourceUrl:null,version:null,createTime:null,updateTime:null,isActive:null},modal:{add:!1,edit:!1,search:!1,detail:!1,detailContent:!1,projectDetail:!1,projectDetailSearch:!1,projectChoice:!1,python:!1},loading:{add:!1,edit:!1,search:!1,python:!1},urls:{addUrl:"/projecannounce/admin/save",batchAddUrl:"/projecannounce/admin/batch-save",editUrl:"/projecannounce/admin/update",batchEditUrl:"/projecannounce/admin/batch-update",searchUrl:"/projecannounce/admin/pager-cond",allUrl:"/projecannounce/admin/all",removeUrl:"/projecannounce/admin/remove/",batchRemoveUrl:"/projecannounce/admin/batch-remove",detailUrl:"/projecannounce/admin/one/",activeUrl:"/projecannounce/admin/active",batchActiveUrl:"/projecannounce/admin/batch-active",uploadUrl:"/projecannounce/admin/upload-img",projectSelectUrl:"/projecannounce/admin/project-select",oneProjectUrl:"/project/admin/one/",pythonUpdateDataUrl:"/projecannounce/admin/python"},page:{total:0},sourceDataUrl:"http://jxsggzy.cn/web/jyxx/002001/002001004/jyxx.html",typeLabel:"",python:{title:""},form:{id:null,projectId:null,title:null,projectType:null,announceDesc:null,firstCandidate:null,firstBuilderName:null,firstMarkMoney:null,secondCandidate:null,thirdCandidate:null,sourceUrl:null,inwodHtmlUrl:null,version:null,createTime:null,updateTime:null,isActive:null},validateRules:{firstCandidate:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],secondCandidate:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],thirdCandidate:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,title:null,projectType:null,projectId:null,projectIdMin:null,projectIdMax:null,announceDesc:null,firstBuilderName:null,firstMarkMoney:null,firstCandidate:null,secondCandidate:null,thirdCandidate:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(t,o){return t("span",o.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"公示编号",key:"id",minWidth:120,sortable:!0},{title:"项目编号",key:"projectId",minWidth:120,sortable:!0,render:function(t,o){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,o.row)}},props:{transfer:!0}},[t("span",[o.row.projectId,t("Icon",{props:{type:"ios-list",size:"25"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"moduleDetailProject"}},"详情"),t("DropdownItem",{props:{name:"showSearchProject"}},"搜索")])])}},{title:"项目标题",key:"title",minWidth:200,sortable:!0},{title:"项目类型",key:"projectType",minWidth:150,sortable:!0},{title:"公示详情",key:"announceDesc",minWidth:120,sortable:!0,render:function(t,o){return t("a",{on:{click:function(){i["B"](e,"detailContent"),e.form=JSON.parse(l()(o.row))}}},"点击查看")}},{title:"第一候选人",key:"firstCandidate",minWidth:120,sortable:!0},{title:"建造师",key:"firstBuilderName",minWidth:120,sortable:!0},{title:"中标金额",key:"firstMarkName",minWidth:120,sortable:!0},{title:"源地址",key:"sourceUrl",minWidth:200,sortable:!0,render:function(e,t){var o=t.row;return e("a",{attrs:{href:o.sourceUrl,target:"_blank"}},o.sourceUrl)}},{title:"内部地址",key:"inwordHtmlUrl",minWidth:200,sortable:!0},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:120,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:120,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(t,o){return t("i-switch",{props:{size:"large",value:0===o.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(t){e.active(o.row)}}},[t("span",{slot:"open"},"激活"),t("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(t,o){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,o.row)}},props:{transfer:!0}},[t("Button",{props:{type:"primary",size:"small"}},["选择操作 ",t("Icon",{props:{type:"ios-arrow-down"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"showEdit"}},"编辑"),t("DropdownItem",{props:{name:"showDetail"}},"详情")])])}}],tableDetails:[],selections:[]},isActiveSelect:u["r"],pythonProjectAnnounceTypeSelect:u["D"]}},computed:{},mounted:function(){this.search(),this.$refs.editorAdd.initEditor(this.urls.uploadUrl),this.$refs.editorEdit.initEditor(this.urls.uploadUrl)},methods:{showModal:function(e){"python"===e&&(this.python.title=this.pythonProjectAnnounceTypeSelect[0].value,this.typeLabel=this.pythonProjectAnnounceTypeSelect[0].label),i["B"](this,e)},changeModalVisibleResetForm:function(e,t){t||i["z"](this,e)},resetForm:function(e){i["z"](this,e)},cancelModal:function(e){i["h"](this,e)},resetFormCancelModal:function(e,t){i["h"](this,t),i["z"](this,e)},searchOkModal:function(e){i["h"](this,e),this.searchForm.pageNo=1,i["A"](this)},batchOpt:function(e){"batchActive"===e?i["f"](this,0):"batchInactive"===e?i["f"](this,1):"batchRemove"===e&&i["g"](this)},userOpt:function(e,t){"showEdit"===e?(this.showModal("edit"),this.form=JSON.parse(l()(t)),this.$refs.editorEdit.setHtml(this.form.announceDesc)):"showDetail"===e?(i["B"](this,"detail"),this.form=JSON.parse(l()(t))):"remove"===e?i["y"](this,t):"moduleDetailProject"===e?this.showProjectDetailModal(t.projectId):"showSearchProject"===e&&i["B"](this,"projectDetailSearch")},showProjectDetailModal:function(e){var t=this;Object(d["h"])(e).then(function(e){var o=e.data;o.code===f["b"]?(t.projectDetailForm=o.data,t.showModal("projectDetail")):t.$Message.error(o.message)}).catch(function(e){t.$Message.error(e)})},confirmSelectionProject:function(e){this.cancelModal("projectDetailSearch"),this.searchForm.projectIdMin=this.searchForm.projectIdMax=e,i["A"](this)},confirmProject:function(){this.$refs.ProjectListSingle.confirmSelection()},confirmChoiceProject:function(e){this.form.projectId=e,this.cancelModal("projectChoice")},confirmChoice:function(){this.$refs.ProjectListChoice.confirmSelection()},add:function(){i["c"](this)},edit:function(){i["q"](this)},active:function(e){i["b"](this,e)},search:function(){i["A"](this)},changeSelection:function(e){i["o"](this,e)},changeSort:function(e){i["p"](this,e)},changePageNo:function(e){i["j"](this,e)},changePageSize:function(e){i["k"](this,e)},handleChange:function(e,t){this.form.announceDesc=e},switchSourceDataUrl:function(e){var t=e.label;"房建市政公示"==t?this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002001/002001004/jyxx.html":"水利工程公示"==t?this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002003/002003004/jyxx.html":"交通工程公示"==t?this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002002/002002005/jyxx.html":"政府采购公示"==t?this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002006/002006004/jyxx.html":"重点项目公示"==t?this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002005/002005004/jyxx.html":"其他项目公示"==t&&(this.sourceDataUrl="http://jxsggzy.cn/web/jyxx/002013/002013002/jyxx.html"),this.typeLabel=t},crawlData:function(){var e=this;this.loading["python"]=!0,h["a"].request({url:this.urls.pythonUpdateDataUrl,method:"POST",data:this.python}).then(function(t){t.data.code!==f["b"]?e.$Message.error(t.data.message):e.$Message.success(t.data.message),e.loading["python"]=!1,e.cancelModal("python")}).catch(function(t){e.loading["python"]=!1,console.log(t),e.$Message.error("爬取数据失败")})}}},v=y,b=o("2877"),g=Object(b["a"])(v,r,a,!1,null,null,null);t["default"]=g.exports}}]);