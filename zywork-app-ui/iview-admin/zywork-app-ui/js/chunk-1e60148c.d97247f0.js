(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1e60148c"],{"386d":function(e,t,o){o("214f")("search",1,function(e,t,o){return[function(o){"use strict";var a=e(this),r=void 0==o?void 0:o[t];return void 0!==r?r.call(o,a):new RegExp(o)[t](String(a))},o]})},"3f3b":function(e,t,o){"use strict";var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("Row",[o("i-col",{attrs:{span:"24"}},[o("Card",[o("Button",{attrs:{type:"primary"},on:{click:e.confirmSelection}},[e._v("确认选择")]),e._v(" \n\t\t\t\t\t"),o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n\t\t\t\t\t"),o("Tooltip",{attrs:{content:"刷新",placement:"right"}},[o("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),o("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{"highlight-row":"",stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-current-change":e.changeCurrent,"on-sort-change":e.changeSort}}),o("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[o("div",{staticStyle:{float:"right"}},[o("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),o("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[o("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[o("FormItem",{attrs:{label:"企业编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"辖区类别"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"jurisdictionTypeMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始辖区类别"},model:{value:e.searchForm.jurisdictionTypeMin,callback:function(t){e.$set(e.searchForm,"jurisdictionTypeMin",t)},expression:"searchForm.jurisdictionTypeMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"jurisdictionTypeMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束辖区类别"},model:{value:e.searchForm.jurisdictionTypeMax,callback:function(t){e.$set(e.searchForm,"jurisdictionTypeMax",t)},expression:"searchForm.jurisdictionTypeMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"市区",prop:"city"}},[o("Input",{attrs:{placeholder:"请输入市区"},model:{value:e.searchForm.city,callback:function(t){e.$set(e.searchForm,"city",t)},expression:"searchForm.city"}})],1),o("FormItem",{attrs:{label:"企业类型",prop:"compType"}},[o("Input",{attrs:{placeholder:"请输入企业类型"},model:{value:e.searchForm.compType,callback:function(t){e.$set(e.searchForm,"compType",t)},expression:"searchForm.compType"}})],1),o("FormItem",{attrs:{label:"行业分类",prop:"industryType"}},[o("Input",{attrs:{placeholder:"请输入行业分类"},model:{value:e.searchForm.industryType,callback:function(t){e.$set(e.searchForm,"industryType",t)},expression:"searchForm.industryType"}})],1),o("FormItem",{attrs:{label:"企业名称",prop:"compName"}},[o("Input",{attrs:{placeholder:"请输入企业名称"},model:{value:e.searchForm.compName,callback:function(t){e.$set(e.searchForm,"compName",t)},expression:"searchForm.compName"}})],1),o("FormItem",{attrs:{label:"法人",prop:"legalPerson"}},[o("Input",{attrs:{placeholder:"请输入法人"},model:{value:e.searchForm.legalPerson,callback:function(t){e.$set(e.searchForm,"legalPerson",t)},expression:"searchForm.legalPerson"}})],1),o("FormItem",{attrs:{label:"法人电话",prop:"legalPersonPhone"}},[o("Input",{attrs:{placeholder:"请输入法人电话"},model:{value:e.searchForm.legalPersonPhone,callback:function(t){e.$set(e.searchForm,"legalPersonPhone",t)},expression:"searchForm.legalPersonPhone"}})],1),o("FormItem",{attrs:{label:"注册地区",prop:"regAddress"}},[o("Input",{attrs:{placeholder:"请输入注册地区"},model:{value:e.searchForm.regAddress,callback:function(t){e.$set(e.searchForm,"regAddress",t)},expression:"searchForm.regAddress"}})],1),o("FormItem",{attrs:{label:"负责人",prop:"responsible"}},[o("Input",{attrs:{placeholder:"请输入负责人"},model:{value:e.searchForm.responsible,callback:function(t){e.$set(e.searchForm,"responsible",t)},expression:"searchForm.responsible"}})],1),o("FormItem",{attrs:{label:"负责人电话",prop:"responsiblePhone"}},[o("Input",{attrs:{placeholder:"请输入负责人电话"},model:{value:e.searchForm.responsiblePhone,callback:function(t){e.$set(e.searchForm,"responsiblePhone",t)},expression:"searchForm.responsiblePhone"}})],1),o("FormItem",{attrs:{label:"单位电话",prop:"compPhone"}},[o("Input",{attrs:{placeholder:"请输入单位电话"},model:{value:e.searchForm.compPhone,callback:function(t){e.$set(e.searchForm,"compPhone",t)},expression:"searchForm.compPhone"}})],1),o("FormItem",{attrs:{label:"联系地址",prop:"compAddr"}},[o("Input",{attrs:{placeholder:"请输入联系地址"},model:{value:e.searchForm.compAddr,callback:function(t){e.$set(e.searchForm,"compAddr",t)},expression:"searchForm.compAddr"}})],1),o("FormItem",{attrs:{label:"注册资本",prop:"regCapital"}},[o("Input",{attrs:{placeholder:"请输入注册资本"},model:{value:e.searchForm.regCapital,callback:function(t){e.$set(e.searchForm,"regCapital",t)},expression:"searchForm.regCapital"}})],1),o("FormItem",{attrs:{label:"经营范围",prop:"businessScope"}},[o("Input",{attrs:{placeholder:"请输入经营范围"},model:{value:e.searchForm.businessScope,callback:function(t){e.$set(e.searchForm,"businessScope",t)},expression:"searchForm.businessScope"}})],1),o("FormItem",{attrs:{label:"可承担业务",prop:"affordableBusiness"}},[o("Input",{attrs:{placeholder:"请输入可承担业务"},model:{value:e.searchForm.affordableBusiness,callback:function(t){e.$set(e.searchForm,"affordableBusiness",t)},expression:"searchForm.affordableBusiness"}})],1),o("FormItem",{attrs:{label:"版本号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"创建时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"更新时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"是否激活"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:e.searchForm.isActiveMin,callback:function(t){e.$set(e.searchForm,"isActiveMin",t)},expression:"searchForm.isActiveMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:e.searchForm.isActiveMax,callback:function(t){e.$set(e.searchForm,"isActiveMax",t)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("确定")])],1)],1),o("Modal",{attrs:{title:"详情"},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[o("p",[e._v("企业编号: "),o("span",{domProps:{textContent:e._s(e.form.id)}})]),o("p",[e._v("辖区类别: "),o("span",{domProps:{textContent:e._s(e.form.jurisdictionType)}})]),o("p",[e._v("市区: "),o("span",{domProps:{textContent:e._s(e.form.city)}})]),o("p",[e._v("企业类型: "),o("span",{domProps:{textContent:e._s(e.form.compType)}})]),o("p",[e._v("行业分类: "),o("span",{domProps:{textContent:e._s(e.form.industryType)}})]),o("p",[e._v("企业名称: "),o("span",{domProps:{textContent:e._s(e.form.compName)}})]),o("p",[e._v("法人: "),o("span",{domProps:{textContent:e._s(e.form.legalPerson)}})]),o("p",[e._v("法人电话: "),o("span",{domProps:{textContent:e._s(e.form.legalPersonPhone)}})]),o("p",[e._v("注册地区: "),o("span",{domProps:{textContent:e._s(e.form.regAddress)}})]),o("p",[e._v("负责人: "),o("span",{domProps:{textContent:e._s(e.form.responsible)}})]),o("p",[e._v("负责人电话: "),o("span",{domProps:{textContent:e._s(e.form.responsiblePhone)}})]),o("p",[e._v("单位电话: "),o("span",{domProps:{textContent:e._s(e.form.compPhone)}})]),o("p",[e._v("联系地址: "),o("span",{domProps:{textContent:e._s(e.form.compAddr)}})]),o("p",[e._v("注册资本: "),o("span",{domProps:{textContent:e._s(e.form.regCapital)}})]),o("p",[e._v("经营范围: "),o("span",{domProps:{textContent:e._s(e.form.businessScope)}})]),o("p",[e._v("可承担业务: "),o("span",{domProps:{textContent:e._s(e.form.affordableBusiness)}})]),o("p",[e._v("\n        源地址：\n        "),o("a",{attrs:{href:e.form.sourceUrl,target:"_blank"}},[e._v(e._s(e.form.sourceUrl))])]),o("p",[e._v("版本号: "),o("span",{domProps:{textContent:e._s(e.form.version)}})]),o("p",[e._v("创建时间: "),o("span",{domProps:{textContent:e._s(e.form.createTime)}})]),o("p",[e._v("更新时间: "),o("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),o("p",[e._v("是否激活: "),o("span",{domProps:{textContent:e._s(e.form.isActive)}})])])],1)},r=[],n=(o("386d"),o("f62d")),s={name:"CompanyListSingle",data:function(){var e=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1},loading:{search:!1},urls:{searchUrl:"/company/admin/pager-cond",allUrl:"/company/admin/all",detailUrl:"/company/admin/one/"},page:{total:0},form:{id:null,jurisdictionType:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,sourceUrl:null,version:null,createTime:null,updateTime:null,isActive:null},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,jurisdictionType:null,jurisdictionTypeMin:null,jurisdictionTypeMax:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{width:60,align:"center",fixed:"left",render:function(t,o){return t("span",o.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"企业编号",key:"id",minWidth:120,sortable:!0},{title:"辖区类别",key:"jurisdictionType",minWidth:120,sortable:!0,render:function(e,t){var o=null;return 1==t.row.jurisdictionType?o="省内":2==t.row.jurisdictionType&&(o="省外"),e("span",o)}},{title:"市区",key:"city",minWidth:180,sortable:!0},{title:"企业类型",key:"compType",minWidth:120,sortable:!0},{title:"行业分类",key:"industryType",minWidth:120,sortable:!0},{title:"企业名称",key:"compName",minWidth:200,sortable:!0},{title:"法人",key:"legalPerson",minWidth:120,sortable:!0},{title:"法人电话",key:"legalPersonPhone",minWidth:120,sortable:!0},{title:"注册地区",key:"regAddress",minWidth:180,sortable:!0},{title:"负责人",key:"responsible",minWidth:120,sortable:!0},{title:"负责人电话",key:"responsiblePhone",minWidth:120,sortable:!0},{title:"单位电话",key:"compPhone",minWidth:120,sortable:!0},{title:"联系地址",key:"compAddr",minWidth:180,sortable:!0},{title:"注册资本",key:"regCapital",minWidth:120,sortable:!0},{title:"经营范围",key:"businessScope",minWidth:350,sortable:!0},{title:"可承担业务",key:"affordableBusiness",minWidth:350,sortable:!0},{title:"源地址",key:"sourceUrl",minWidth:120,sortable:!0,render:function(e,t){var o=t.row;return e("a",{attrs:{href:o.sourceUrl,target:"_blank"}},o.sourceUrl)}},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"操作",key:"action",width:80,align:"center",fixed:"right",render:function(t,o){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.showDetail("detail",o.row)}}},"详情")])}}],tableDetails:[],currentRow:{}}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){n["B"](this,e)},showDetail:function(e,t){n["B"](this,e),this.form=t},changeModalVisibleResetForm:function(e,t){t||n["z"](this,e)},resetForm:function(e){n["z"](this,e)},cancelModal:function(e){n["h"](this,e)},resetFormCancelModal:function(e,t){n["h"](this,t),n["z"](this,e)},searchOkModal:function(e){n["h"](this,e),this.searchForm.pageNo=1,n["A"](this)},search:function(){n["A"](this)},changeCurrent:function(e,t){n["i"](this,e,t)},changeSort:function(e){n["p"](this,e)},changePageNo:function(e){n["j"](this,e)},changePageSize:function(e){n["k"](this,e)},confirmSelection:function(){this.$emit("confirmSelection",this.table.currentRow.id)}}},l=s,i=o("2877"),c=Object(i["a"])(l,a,r,!1,null,null,null);t["a"]=c.exports},"718e":function(e,t,o){"use strict";var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("p",[e._v("企业编号: "),o("span",{domProps:{textContent:e._s(e.form.id)}})]),o("p",[e._v("辖区类别: "),o("span",{domProps:{textContent:e._s(e.form.jurisdictionType)}})]),o("p",[e._v("市区: "),o("span",{domProps:{textContent:e._s(e.form.city)}})]),o("p",[e._v("企业类型: "),o("span",{domProps:{textContent:e._s(e.form.compType)}})]),o("p",[e._v("行业分类: "),o("span",{domProps:{textContent:e._s(e.form.industryType)}})]),o("p",[e._v("企业名称: "),o("span",{domProps:{textContent:e._s(e.form.compName)}})]),o("p",[e._v("法人: "),o("span",{domProps:{textContent:e._s(e.form.legalPerson)}})]),o("p",[e._v("法人电话: "),o("span",{domProps:{textContent:e._s(e.form.legalPersonPhone)}})]),o("p",[e._v("注册地区: "),o("span",{domProps:{textContent:e._s(e.form.regAddress)}})]),o("p",[e._v("负责人: "),o("span",{domProps:{textContent:e._s(e.form.responsible)}})]),o("p",[e._v("负责人电话: "),o("span",{domProps:{textContent:e._s(e.form.responsiblePhone)}})]),o("p",[e._v("单位电话: "),o("span",{domProps:{textContent:e._s(e.form.compPhone)}})]),o("p",[e._v("联系地址: "),o("span",{domProps:{textContent:e._s(e.form.compAddr)}})]),o("p",[e._v("注册资本: "),o("span",{domProps:{textContent:e._s(e.form.regCapital)}})]),o("p",[e._v("经营范围: "),o("span",{domProps:{textContent:e._s(e.form.businessScope)}})]),o("p",[e._v("可承担业务: "),o("span",{domProps:{textContent:e._s(e.form.affordableBusiness)}})]),o("p",[e._v("\n      源地址：\n      "),o("a",{attrs:{href:e.form.sourceUrl,target:"_blank"}},[e._v(e._s(e.form.sourceUrl))])]),o("p",[e._v("版本号: "),o("span",{domProps:{textContent:e._s(e.form.version)}})]),o("p",[e._v("创建时间: "),o("span",{domProps:{textContent:e._s(e.form.createTime)}})]),o("p",[e._v("更新时间: "),o("span",{domProps:{textContent:e._s(e.form.updateTime)}})])])},r=[],n={name:"CompanyViewModal",props:{form:Object,detail:!1},data:function(){return{}},computed:{},mounted:function(){},methods:{}},s=n,l=o("2877"),i=Object(l["a"])(s,a,r,!1,null,null,null);t["a"]=i.exports},"816b":function(e,t,o){"use strict";o.d(t,"a",function(){return r}),o.d(t,"g",function(){return n}),o.d(t,"j",function(){return s}),o.d(t,"h",function(){return l}),o.d(t,"e",function(){return i}),o.d(t,"d",function(){return c}),o.d(t,"c",function(){return m}),o.d(t,"b",function(){return p}),o.d(t,"f",function(){return d}),o.d(t,"k",function(){return u}),o.d(t,"i",function(){return h});var a=o("66df"),r=function(){return a["a"].request({url:"/module/admin/all",method:"GET",data:""})},n=function(e){return a["a"].request({url:"/module/admin/one/"+e,method:"GET",data:""})},s=function(e){return a["a"].request({url:"/user-userdetail/admin/multi/"+e,method:"GET",data:""})},l=function(e){return a["a"].request({url:"/project/admin/one/"+e,method:"GET",data:""})},i=function(e){return a["a"].request({url:"/coupon/admin/one/"+e,method:"GET",data:""})},c=function(e){return a["a"].request({url:"/company/admin/one/"+e,method:"GET",data:""})},m=function(e){return a["a"].request({url:"/builder/admin/one/"+e,method:"GET",data:""})},p=function(e){return a["a"].request({url:"/aptitude-transfer/admin/one/"+e,method:"GET",data:""})},d=function(e){return a["a"].request({url:"/experquestion-type/admin/one/"+e,method:"GET",data:""})},u=function(e){return a["a"].request({url:"/user-expert/admin/one/"+e,method:"GET",data:""})},h=function(e){return a["a"].request({url:"/service/admin/one/"+e,method:"GET",data:""})}},"91c8":function(e,t,o){"use strict";o.r(t);var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("Row",[o("i-col",{attrs:{span:"24"}},[o("Card",[o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("add")}}},[e._v("添加")]),e._v(" \n\t\t\t\t"),o("Dropdown",{on:{"on-click":e.batchOpt}},[o("Button",{attrs:{type:"primary"}},[e._v("\n\t\t\t\t\t\t批量操作\n\t\t\t\t\t\t"),o("Icon",{attrs:{type:"ios-arrow-down"}})],1),o("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[o("DropdownItem",{attrs:{name:"batchActive"}},[e._v("批量激活")]),o("DropdownItem",{attrs:{name:"batchInactive"}},[o("span",{staticStyle:{color:"red"}},[e._v("批量冻结")])]),o("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[o("span",{staticStyle:{color:"red"}},[e._v("批量删除")])])],1)],1),e._v(" \n\t\t\t\t"),o("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n\t\t\t\t"),o("Tooltip",{attrs:{content:"刷新",placement:"right"}},[o("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),o("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-selection-change":e.changeSelection,"on-sort-change":e.changeSort}}),o("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[o("div",{staticStyle:{float:"right"}},[o("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),o("Modal",{attrs:{title:"添加"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("addForm",t)}},model:{value:e.modal.add,callback:function(t){e.$set(e.modal,"add",t)},expression:"modal.add"}},[o("Form",{ref:"addForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[o("FormItem",{attrs:{label:"企业编号",prop:"compId"}},[o("span",{domProps:{textContent:e._s(e.form.compId)}}),e._v("\n\t\t\t\t \n\t\t\t\t"),o("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("companyChoice")}}},[e._v("选择企业")]),e._v(" \n\t\t\t")],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:e.form.projectName,callback:function(t){e.$set(e.form,"projectName",t)},expression:"form.projectName"}})],1),o("FormItem",{attrs:{label:"建设单位",prop:"buildComp"}},[o("Input",{attrs:{placeholder:"请输入建设单位"},model:{value:e.form.buildComp,callback:function(t){e.$set(e.form,"buildComp",t)},expression:"form.buildComp"}})],1),o("FormItem",{attrs:{label:"中标金额（万元）",prop:"markMoney"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.form.markMoney,callback:function(t){e.$set(e.form,"markMoney",t)},expression:"form.markMoney"}})],1),o("FormItem",{attrs:{label:"开工时间",prop:"startDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.form.startDate,placeholder:"请输入开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.form.startDate=t}}})],1),o("FormItem",{attrs:{label:"竣工时间",prop:"endDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.form.endDate,placeholder:"请输入竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.form.endDate=t}}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("addForm","add")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.add},on:{click:e.add}},[e._v("添加")])],1)],1),o("Modal",{attrs:{title:"修改"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.edit,callback:function(t){e.$set(e.modal,"edit",t)},expression:"modal.edit"}},[o("Form",{ref:"editForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[o("FormItem",{attrs:{label:"企业编号",prop:"compId"}},[o("span",{domProps:{textContent:e._s(e.form.compId)}}),e._v("\n\t\t\t\t \n\t\t\t\t"),o("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("companyChoice")}}},[e._v("选择企业")]),e._v(" \n\t\t\t")],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:e.form.projectName,callback:function(t){e.$set(e.form,"projectName",t)},expression:"form.projectName"}})],1),o("FormItem",{attrs:{label:"建设单位",prop:"buildComp"}},[o("Input",{attrs:{placeholder:"请输入建设单位"},model:{value:e.form.buildComp,callback:function(t){e.$set(e.form,"buildComp",t)},expression:"form.buildComp"}})],1),o("FormItem",{attrs:{label:"中标金额（万元）",prop:"markMoney"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.form.markMoney,callback:function(t){e.$set(e.form,"markMoney",t)},expression:"form.markMoney"}})],1),o("FormItem",{attrs:{label:"开工时间",prop:"startDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.form.startDate,placeholder:"请输入开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.form.startDate=t}}})],1),o("FormItem",{attrs:{label:"竣工时间",prop:"endDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.form.endDate,placeholder:"请输入竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.form.endDate=t}}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("editForm","edit")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.edit},on:{click:e.edit}},[e._v("修改")])],1)],1),o("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[o("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[o("FormItem",{attrs:{label:"企业重点工程业绩编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业重点工程业绩编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业重点工程业绩编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"企业编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"compIdMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业编号"},model:{value:e.searchForm.compIdMin,callback:function(t){e.$set(e.searchForm,"compIdMin",t)},expression:"searchForm.compIdMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"compIdMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业编号"},model:{value:e.searchForm.compIdMax,callback:function(t){e.$set(e.searchForm,"compIdMax",t)},expression:"searchForm.compIdMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:e.searchForm.projectName,callback:function(t){e.$set(e.searchForm,"projectName",t)},expression:"searchForm.projectName"}})],1),o("FormItem",{attrs:{label:"建设单位",prop:"buildComp"}},[o("Input",{attrs:{placeholder:"请输入建设单位"},model:{value:e.searchForm.buildComp,callback:function(t){e.$set(e.searchForm,"buildComp",t)},expression:"searchForm.buildComp"}})],1),o("FormItem",{attrs:{label:"中标金额",prop:"markMoney"}},[o("Input",{attrs:{placeholder:"请输入中标金额"},model:{value:e.searchForm.markMoney,callback:function(t){e.$set(e.searchForm,"markMoney",t)},expression:"searchForm.markMoney"}})],1),o("FormItem",{attrs:{label:"开工时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"startDateMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.startDateMin,placeholder:"请输入开始开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.startDateMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"startDateMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.startDateMax,placeholder:"请输入结束开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.startDateMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"竣工时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"endDateMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.endDateMin,placeholder:"请输入开始竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.endDateMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"endDateMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.endDateMax,placeholder:"请输入结束竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.endDateMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"版本号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"创建时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"更新时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"是否激活"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:e.searchForm.isActiveMin,callback:function(t){e.$set(e.searchForm,"isActiveMin",t)},expression:"searchForm.isActiveMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:e.searchForm.isActiveMax,callback:function(t){e.$set(e.searchForm,"isActiveMax",t)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("搜索")])],1)],1),o("Modal",{attrs:{title:"详情"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[o("p",[e._v("企业重点工程业绩编号: "),o("span",{domProps:{textContent:e._s(e.form.id)}})]),o("p",[e._v("企业编号: "),o("span",{domProps:{textContent:e._s(e.form.compId)}})]),o("p",[e._v("工程名称: "),o("span",{domProps:{textContent:e._s(e.form.projectName)}})]),o("p",[e._v("建设单位: "),o("span",{domProps:{textContent:e._s(e.form.buildComp)}})]),o("p",[e._v("中标金额: "),o("span",{domProps:{textContent:e._s(e.form.markMoney/100)}})]),o("p",[e._v("开工时间: "),o("span",{domProps:{textContent:e._s(e.form.startDate)}})]),o("p",[e._v("竣工时间: "),o("span",{domProps:{textContent:e._s(e.form.endDate)}})]),o("p",[e._v("版本号: "),o("span",{domProps:{textContent:e._s(e.form.version)}})]),o("p",[e._v("创建时间: "),o("span",{domProps:{textContent:e._s(e.form.createTime)}})]),o("p",[e._v("更新时间: "),o("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),o("p",[e._v("是否激活: "),o("span",{domProps:{textContent:e._s(e.form.isActive)}})])]),o("Modal",{attrs:{transfer:!1,title:"企业详情"},model:{value:e.modal.companyDetail,callback:function(t){e.$set(e.modal,"companyDetail",t)},expression:"modal.companyDetail"}},[o("CompanyDetail",{attrs:{form:e.companyDetailForm}})],1),o("Modal",{attrs:{transfer:!1,fullscreen:"",title:"搜索主表信息"},model:{value:e.modal.companyChoice,callback:function(t){e.$set(e.modal,"companyChoice",t)},expression:"modal.companyChoice"}},[o("company-list-single",{ref:"CompanyListSingle",on:{confirmSelection:e.confirmSelection}}),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("companyChoice")}}},[e._v("取消")]),o("Button",{attrs:{type:"primary",size:"large"},on:{click:e.confirm}},[e._v("确认选择")])],1)],1)],1)},r=[],n=o("f499"),s=o.n(n),l=(o("386d"),o("f62d")),i=o("816b"),c=o("718e"),m=o("3f3b"),p={name:"CompKeyProjectAchievement",components:{CompanyListSingle:m["a"],CompanyDetail:c["a"]},data:function(){var e=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1,companyDetail:!1,companyChoice:!1,operate:""},loading:{add:!1,edit:!1,search:!1},urls:{addUrl:"/comp-key-projecachievement/admin/save",batchAddUrl:"/comp-key-projecachievement/admin/batch-save",editUrl:"/comp-key-projecachievement/admin/update",batchEditUrl:"/comp-key-projecachievement/admin/batch-update",searchUrl:"/comp-key-projecachievement/admin/pager-cond",allUrl:"/comp-key-projecachievement/admin/all",removeUrl:"/comp-key-projecachievement/admin/remove/",batchRemoveUrl:"/comp-key-projecachievement/admin/batch-remove",detailUrl:"/comp-key-projecachievement/admin/one/",activeUrl:"/comp-key-projecachievement/admin/active",batchActiveUrl:"/comp-key-projecachievement/admin/batch-active"},page:{total:0},form:{id:null,compId:null,projectName:null,buildComp:null,markMoney:null,money:null,markMoneyDisplay:null,startDate:null,endDate:null,version:null,createTime:null,updateTime:null,isActive:null},companyDetailForm:{id:null,jurisdictionType:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,version:null,createTime:null,updateTime:null,isActive:null},validateRules:{compId:[{type:"integer",required:!0,message:"此项为必须项",trigger:"blur, change"}],projectName:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],buildComp:[{type:"string",min:1,max:32,message:"必须1-32个字符",trigger:"blur"}],markMoney:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,compId:null,compIdMin:null,compIdMax:null,projectName:null,buildComp:null,markMoney:null,startDate:null,startDateMin:null,startDateMax:null,endDate:null,endDateMin:null,endDateMax:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(t,o){return t("span",o.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"企业重点工程业绩编号",key:"id",minWidth:160,sortable:!0},{title:"企业编号",key:"compId",minWidth:120,sortable:!0,render:function(t,o){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,o.row)}},props:{transfer:!0}},[t("span",[o.row.compId,t("Icon",{props:{type:"ios-list",size:"25"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"moduleDetail"}},"详情"),t("DropdownItem",{props:{name:"showSearch"}},"搜索")])])}},{title:"工程名称",key:"projectName",minWidth:200,sortable:!0},{title:"建设单位",key:"buildComp",minWidth:180,sortable:!0},{title:"中标金额（万元）",key:"markMoney",minWidth:120,sortable:!0,render:function(e,t){var o=t.row.markMoney;return e("span","￥"+o)}},{title:"开工时间",key:"startDate",minWidth:150,sortable:!0},{title:"竣工时间",key:"endDate",minWidth:150,sortable:!0},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(t,o){return t("i-switch",{props:{size:"large",value:0===o.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(t){e.active(o.row)}}},[t("span",{slot:"open"},"激活"),t("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(t,o){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,o.row)}},props:{transfer:!0}},[t("Button",{props:{type:"primary",size:"small"}},["选择操作 ",t("Icon",{props:{type:"ios-arrow-down"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"showEdit"}},"编辑"),t("DropdownItem",{props:{name:"showDetail"}},"详情"),t("DropdownItem",{props:{name:"remove"}},[t("span",{style:{color:"red"}},"删除")])])])}}],tableDetails:[],selections:[]}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){l["B"](this,e),this.modal.operate="operate"},changeModalVisibleResetForm:function(e,t){t||l["z"](this,e)},resetForm:function(e){l["z"](this,e)},cancelModal:function(e){l["h"](this,e)},resetFormCancelModal:function(e,t){l["h"](this,t),l["z"](this,e)},searchOkModal:function(e){l["h"](this,e),this.searchForm.pageNo=1,l["A"](this)},batchOpt:function(e){"batchActive"===e?l["f"](this,0):"batchInactive"===e?l["f"](this,1):"batchRemove"===e&&l["g"](this)},userOpt:function(e,t){"showEdit"===e?(l["B"](this,"edit"),this.form=JSON.parse(s()(t)),this.setPrice(0)):"showDetail"===e?(l["B"](this,"detail"),this.form=JSON.parse(s()(t))):"remove"===e?l["y"](this,t):"moduleDetail"===e?this.showUserDetailModal(t.compId):"showSearch"===e&&(l["B"](this,"companyChoice"),this.modal.operate="show")},showUserDetailModal:function(e){var t=this;Object(i["d"])(e).then(function(e){var o=e.data;1001===o.code?(t.companyDetailForm=o.data,t.modal.companyDetail=!0):t.$Message.error(o.message)}).catch(function(e){t.$Message.error(e)})},confirmSelection:function(e){this.modal.companyChoice=!1,"show"===this.modal.operate?(this.searchForm.compIdMin=e,this.searchForm.compIdMax=e,l["A"](this)):"operate"===this.modal.operate&&(this.form.compId=e)},confirm:function(){this.$refs.CompanyListSingle.confirmSelection()},setPrice:function(e){this.form.money=this.from.markMoney},add:function(){this.setPrice(1),l["c"](this)},edit:function(){this.setPrice(1),l["q"](this)},active:function(e){l["b"](this,e)},search:function(){l["A"](this)},changeSelection:function(e){l["o"](this,e)},changeSort:function(e){l["p"](this,e)},changePageNo:function(e){l["j"](this,e)},changePageSize:function(e){l["k"](this,e)}}},d=p,u=o("2877"),h=Object(u["a"])(d,a,r,!1,null,null,null);t["default"]=h.exports}}]);