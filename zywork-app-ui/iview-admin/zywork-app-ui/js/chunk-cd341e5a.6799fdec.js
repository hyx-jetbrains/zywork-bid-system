(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-cd341e5a"],{"386d":function(t,e,o){o("214f")("search",1,function(t,e,o){return[function(o){"use strict";var a=t(this),r=void 0==o?void 0:o[e];return void 0!==r?r.call(o,a):new RegExp(o)[e](String(a))},o]})},"3f3b":function(t,e,o){"use strict";var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("Row",[o("i-col",{attrs:{span:"24"}},[o("Card",[o("Button",{attrs:{type:"primary"},on:{click:t.confirmSelection}},[t._v("确认选择")]),t._v(" \n\t\t\t\t\t"),o("Button",{attrs:{type:"primary"},on:{click:function(e){t.showModal("search")}}},[t._v("高级搜索")]),t._v(" \n\t\t\t\t\t"),o("Tooltip",{attrs:{content:"刷新",placement:"right"}},[o("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:t.search}})],1),o("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{"highlight-row":"",stripe:"",loading:t.table.loading,columns:t.table.tableColumns,data:t.table.tableDetails},on:{"on-current-change":t.changeCurrent,"on-sort-change":t.changeSort}}),o("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[o("div",{staticStyle:{float:"right"}},[o("Page",{attrs:{total:t.page.total,current:t.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":t.changePageNo,"on-page-size-change":t.changePageSize}})],1)])],1)],1)],1),o("Modal",{attrs:{title:"高级搜索"},model:{value:t.modal.search,callback:function(e){t.$set(t.modal,"search",e)},expression:"modal.search"}},[o("Form",{ref:"searchForm",attrs:{model:t.searchForm,"label-width":80}},[o("FormItem",{attrs:{label:"企业编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业编号"},model:{value:t.searchForm.idMin,callback:function(e){t.$set(t.searchForm,"idMin",e)},expression:"searchForm.idMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业编号"},model:{value:t.searchForm.idMax,callback:function(e){t.$set(t.searchForm,"idMax",e)},expression:"searchForm.idMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"辖区类别"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"jurisdictionTypeMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始辖区类别"},model:{value:t.searchForm.jurisdictionTypeMin,callback:function(e){t.$set(t.searchForm,"jurisdictionTypeMin",e)},expression:"searchForm.jurisdictionTypeMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"jurisdictionTypeMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束辖区类别"},model:{value:t.searchForm.jurisdictionTypeMax,callback:function(e){t.$set(t.searchForm,"jurisdictionTypeMax",e)},expression:"searchForm.jurisdictionTypeMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"市区",prop:"city"}},[o("Input",{attrs:{placeholder:"请输入市区"},model:{value:t.searchForm.city,callback:function(e){t.$set(t.searchForm,"city",e)},expression:"searchForm.city"}})],1),o("FormItem",{attrs:{label:"企业类型",prop:"compType"}},[o("Input",{attrs:{placeholder:"请输入企业类型"},model:{value:t.searchForm.compType,callback:function(e){t.$set(t.searchForm,"compType",e)},expression:"searchForm.compType"}})],1),o("FormItem",{attrs:{label:"行业分类",prop:"industryType"}},[o("Input",{attrs:{placeholder:"请输入行业分类"},model:{value:t.searchForm.industryType,callback:function(e){t.$set(t.searchForm,"industryType",e)},expression:"searchForm.industryType"}})],1),o("FormItem",{attrs:{label:"企业名称",prop:"compName"}},[o("Input",{attrs:{placeholder:"请输入企业名称"},model:{value:t.searchForm.compName,callback:function(e){t.$set(t.searchForm,"compName",e)},expression:"searchForm.compName"}})],1),o("FormItem",{attrs:{label:"法人",prop:"legalPerson"}},[o("Input",{attrs:{placeholder:"请输入法人"},model:{value:t.searchForm.legalPerson,callback:function(e){t.$set(t.searchForm,"legalPerson",e)},expression:"searchForm.legalPerson"}})],1),o("FormItem",{attrs:{label:"法人电话",prop:"legalPersonPhone"}},[o("Input",{attrs:{placeholder:"请输入法人电话"},model:{value:t.searchForm.legalPersonPhone,callback:function(e){t.$set(t.searchForm,"legalPersonPhone",e)},expression:"searchForm.legalPersonPhone"}})],1),o("FormItem",{attrs:{label:"注册地区",prop:"regAddress"}},[o("Input",{attrs:{placeholder:"请输入注册地区"},model:{value:t.searchForm.regAddress,callback:function(e){t.$set(t.searchForm,"regAddress",e)},expression:"searchForm.regAddress"}})],1),o("FormItem",{attrs:{label:"负责人",prop:"responsible"}},[o("Input",{attrs:{placeholder:"请输入负责人"},model:{value:t.searchForm.responsible,callback:function(e){t.$set(t.searchForm,"responsible",e)},expression:"searchForm.responsible"}})],1),o("FormItem",{attrs:{label:"负责人电话",prop:"responsiblePhone"}},[o("Input",{attrs:{placeholder:"请输入负责人电话"},model:{value:t.searchForm.responsiblePhone,callback:function(e){t.$set(t.searchForm,"responsiblePhone",e)},expression:"searchForm.responsiblePhone"}})],1),o("FormItem",{attrs:{label:"单位电话",prop:"compPhone"}},[o("Input",{attrs:{placeholder:"请输入单位电话"},model:{value:t.searchForm.compPhone,callback:function(e){t.$set(t.searchForm,"compPhone",e)},expression:"searchForm.compPhone"}})],1),o("FormItem",{attrs:{label:"联系地址",prop:"compAddr"}},[o("Input",{attrs:{placeholder:"请输入联系地址"},model:{value:t.searchForm.compAddr,callback:function(e){t.$set(t.searchForm,"compAddr",e)},expression:"searchForm.compAddr"}})],1),o("FormItem",{attrs:{label:"注册资本",prop:"regCapital"}},[o("Input",{attrs:{placeholder:"请输入注册资本"},model:{value:t.searchForm.regCapital,callback:function(e){t.$set(t.searchForm,"regCapital",e)},expression:"searchForm.regCapital"}})],1),o("FormItem",{attrs:{label:"经营范围",prop:"businessScope"}},[o("Input",{attrs:{placeholder:"请输入经营范围"},model:{value:t.searchForm.businessScope,callback:function(e){t.$set(t.searchForm,"businessScope",e)},expression:"searchForm.businessScope"}})],1),o("FormItem",{attrs:{label:"可承担业务",prop:"affordableBusiness"}},[o("Input",{attrs:{placeholder:"请输入可承担业务"},model:{value:t.searchForm.affordableBusiness,callback:function(e){t.$set(t.searchForm,"affordableBusiness",e)},expression:"searchForm.affordableBusiness"}})],1),o("FormItem",{attrs:{label:"版本号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:t.searchForm.versionMin,callback:function(e){t.$set(t.searchForm,"versionMin",e)},expression:"searchForm.versionMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:t.searchForm.versionMax,callback:function(e){t.$set(t.searchForm,"versionMax",e)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"创建时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"更新时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"是否激活"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:t.searchForm.isActiveMin,callback:function(e){t.$set(t.searchForm,"isActiveMin",e)},expression:"searchForm.isActiveMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:t.searchForm.isActiveMax,callback:function(e){t.$set(t.searchForm,"isActiveMax",e)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetForm("searchForm")}}},[t._v("清空")]),o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.cancelModal("search")}}},[t._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:t.loading.search},on:{click:function(e){t.searchOkModal("search")}}},[t._v("确定")])],1)],1),o("Modal",{attrs:{title:"详情"},model:{value:t.modal.detail,callback:function(e){t.$set(t.modal,"detail",e)},expression:"modal.detail"}},[o("p",[t._v("企业编号: "),o("span",{domProps:{textContent:t._s(t.form.id)}})]),o("p",[t._v("辖区类别: "),o("span",{domProps:{textContent:t._s(t.form.jurisdictionType)}})]),o("p",[t._v("市区: "),o("span",{domProps:{textContent:t._s(t.form.city)}})]),o("p",[t._v("企业类型: "),o("span",{domProps:{textContent:t._s(t.form.compType)}})]),o("p",[t._v("行业分类: "),o("span",{domProps:{textContent:t._s(t.form.industryType)}})]),o("p",[t._v("企业名称: "),o("span",{domProps:{textContent:t._s(t.form.compName)}})]),o("p",[t._v("法人: "),o("span",{domProps:{textContent:t._s(t.form.legalPerson)}})]),o("p",[t._v("法人电话: "),o("span",{domProps:{textContent:t._s(t.form.legalPersonPhone)}})]),o("p",[t._v("注册地区: "),o("span",{domProps:{textContent:t._s(t.form.regAddress)}})]),o("p",[t._v("负责人: "),o("span",{domProps:{textContent:t._s(t.form.responsible)}})]),o("p",[t._v("负责人电话: "),o("span",{domProps:{textContent:t._s(t.form.responsiblePhone)}})]),o("p",[t._v("单位电话: "),o("span",{domProps:{textContent:t._s(t.form.compPhone)}})]),o("p",[t._v("联系地址: "),o("span",{domProps:{textContent:t._s(t.form.compAddr)}})]),o("p",[t._v("注册资本: "),o("span",{domProps:{textContent:t._s(t.form.regCapital)}})]),o("p",[t._v("经营范围: "),o("span",{domProps:{textContent:t._s(t.form.businessScope)}})]),o("p",[t._v("可承担业务: "),o("span",{domProps:{textContent:t._s(t.form.affordableBusiness)}})]),o("p",[t._v("\n        源地址：\n        "),o("a",{attrs:{href:t.form.sourceUrl,target:"_blank"}},[t._v(t._s(t.form.sourceUrl))])]),o("p",[t._v("版本号: "),o("span",{domProps:{textContent:t._s(t.form.version)}})]),o("p",[t._v("创建时间: "),o("span",{domProps:{textContent:t._s(t.form.createTime)}})]),o("p",[t._v("更新时间: "),o("span",{domProps:{textContent:t._s(t.form.updateTime)}})]),o("p",[t._v("是否激活: "),o("span",{domProps:{textContent:t._s(t.form.isActive)}})])])],1)},r=[],n=(o("386d"),o("f62d")),s={name:"CompanyListSingle",data:function(){var t=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1},loading:{search:!1},urls:{searchUrl:"/company/admin/pager-cond",allUrl:"/company/admin/all",detailUrl:"/company/admin/one/"},page:{total:0},form:{id:null,jurisdictionType:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,sourceUrl:null,version:null,createTime:null,updateTime:null,isActive:null},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,jurisdictionType:null,jurisdictionTypeMin:null,jurisdictionTypeMax:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{width:60,align:"center",fixed:"left",render:function(e,o){return e("span",o.index+(t.searchForm.pageNo-1)*t.searchForm.pageSize+1)}},{title:"企业编号",key:"id",minWidth:120,sortable:!0},{title:"辖区类别",key:"jurisdictionType",minWidth:120,sortable:!0,render:function(t,e){var o=null;return 1==e.row.jurisdictionType?o="省内":2==e.row.jurisdictionType&&(o="省外"),t("span",o)}},{title:"市区",key:"city",minWidth:180,sortable:!0},{title:"企业类型",key:"compType",minWidth:120,sortable:!0},{title:"行业分类",key:"industryType",minWidth:120,sortable:!0},{title:"企业名称",key:"compName",minWidth:200,sortable:!0},{title:"法人",key:"legalPerson",minWidth:120,sortable:!0},{title:"法人电话",key:"legalPersonPhone",minWidth:120,sortable:!0},{title:"注册地区",key:"regAddress",minWidth:180,sortable:!0},{title:"负责人",key:"responsible",minWidth:120,sortable:!0},{title:"负责人电话",key:"responsiblePhone",minWidth:120,sortable:!0},{title:"单位电话",key:"compPhone",minWidth:120,sortable:!0},{title:"联系地址",key:"compAddr",minWidth:180,sortable:!0},{title:"注册资本",key:"regCapital",minWidth:120,sortable:!0},{title:"经营范围",key:"businessScope",minWidth:350,sortable:!0},{title:"可承担业务",key:"affordableBusiness",minWidth:350,sortable:!0},{title:"源地址",key:"sourceUrl",minWidth:120,sortable:!0,render:function(t,e){var o=e.row;return t("a",{attrs:{href:o.sourceUrl,target:"_blank"}},o.sourceUrl)}},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"操作",key:"action",width:80,align:"center",fixed:"right",render:function(e,o){return e("div",[e("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){t.showDetail("detail",o.row)}}},"详情")])}}],tableDetails:[],currentRow:{}}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(t){n["B"](this,t)},showDetail:function(t,e){n["B"](this,t),this.form=e},changeModalVisibleResetForm:function(t,e){e||n["z"](this,t)},resetForm:function(t){n["z"](this,t)},cancelModal:function(t){n["h"](this,t)},resetFormCancelModal:function(t,e){n["h"](this,e),n["z"](this,t)},searchOkModal:function(t){n["h"](this,t),this.searchForm.pageNo=1,n["A"](this)},search:function(){n["A"](this)},changeCurrent:function(t,e){n["i"](this,t,e)},changeSort:function(t){n["p"](this,t)},changePageNo:function(t){n["j"](this,t)},changePageSize:function(t){n["k"](this,t)},confirmSelection:function(){this.$emit("confirmSelection",this.table.currentRow.id)}}},l=s,i=o("2877"),c=Object(i["a"])(l,a,r,!1,null,null,null);e["a"]=c.exports},"718e":function(t,e,o){"use strict";var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("p",[t._v("企业编号: "),o("span",{domProps:{textContent:t._s(t.form.id)}})]),o("p",[t._v("辖区类别: "),o("span",{domProps:{textContent:t._s(t.form.jurisdictionType)}})]),o("p",[t._v("市区: "),o("span",{domProps:{textContent:t._s(t.form.city)}})]),o("p",[t._v("企业类型: "),o("span",{domProps:{textContent:t._s(t.form.compType)}})]),o("p",[t._v("行业分类: "),o("span",{domProps:{textContent:t._s(t.form.industryType)}})]),o("p",[t._v("企业名称: "),o("span",{domProps:{textContent:t._s(t.form.compName)}})]),o("p",[t._v("法人: "),o("span",{domProps:{textContent:t._s(t.form.legalPerson)}})]),o("p",[t._v("法人电话: "),o("span",{domProps:{textContent:t._s(t.form.legalPersonPhone)}})]),o("p",[t._v("注册地区: "),o("span",{domProps:{textContent:t._s(t.form.regAddress)}})]),o("p",[t._v("负责人: "),o("span",{domProps:{textContent:t._s(t.form.responsible)}})]),o("p",[t._v("负责人电话: "),o("span",{domProps:{textContent:t._s(t.form.responsiblePhone)}})]),o("p",[t._v("单位电话: "),o("span",{domProps:{textContent:t._s(t.form.compPhone)}})]),o("p",[t._v("联系地址: "),o("span",{domProps:{textContent:t._s(t.form.compAddr)}})]),o("p",[t._v("注册资本: "),o("span",{domProps:{textContent:t._s(t.form.regCapital)}})]),o("p",[t._v("经营范围: "),o("span",{domProps:{textContent:t._s(t.form.businessScope)}})]),o("p",[t._v("可承担业务: "),o("span",{domProps:{textContent:t._s(t.form.affordableBusiness)}})]),o("p",[t._v("\n      源地址：\n      "),o("a",{attrs:{href:t.form.sourceUrl,target:"_blank"}},[t._v(t._s(t.form.sourceUrl))])]),o("p",[t._v("版本号: "),o("span",{domProps:{textContent:t._s(t.form.version)}})]),o("p",[t._v("创建时间: "),o("span",{domProps:{textContent:t._s(t.form.createTime)}})]),o("p",[t._v("更新时间: "),o("span",{domProps:{textContent:t._s(t.form.updateTime)}})])])},r=[],n={name:"CompanyViewModal",props:{form:Object,detail:!1},data:function(){return{}},computed:{},mounted:function(){},methods:{}},s=n,l=o("2877"),i=Object(l["a"])(s,a,r,!1,null,null,null);e["a"]=i.exports},"816b":function(t,e,o){"use strict";o.d(e,"a",function(){return r}),o.d(e,"g",function(){return n}),o.d(e,"j",function(){return s}),o.d(e,"h",function(){return l}),o.d(e,"e",function(){return i}),o.d(e,"d",function(){return c}),o.d(e,"c",function(){return m}),o.d(e,"b",function(){return p}),o.d(e,"f",function(){return d}),o.d(e,"k",function(){return u}),o.d(e,"i",function(){return h});var a=o("66df"),r=function(){return a["a"].request({url:"/module/admin/all",method:"GET",data:""})},n=function(t){return a["a"].request({url:"/module/admin/one/"+t,method:"GET",data:""})},s=function(t){return a["a"].request({url:"/user-userdetail/admin/multi/"+t,method:"GET",data:""})},l=function(t){return a["a"].request({url:"/project/admin/one/"+t,method:"GET",data:""})},i=function(t){return a["a"].request({url:"/coupon/admin/one/"+t,method:"GET",data:""})},c=function(t){return a["a"].request({url:"/company/admin/one/"+t,method:"GET",data:""})},m=function(t){return a["a"].request({url:"/builder/admin/one/"+t,method:"GET",data:""})},p=function(t){return a["a"].request({url:"/aptitude-transfer/admin/one/"+t,method:"GET",data:""})},d=function(t){return a["a"].request({url:"/experquestion-type/admin/one/"+t,method:"GET",data:""})},u=function(t){return a["a"].request({url:"/user-expert/admin/one/"+t,method:"GET",data:""})},h=function(t){return a["a"].request({url:"/service/admin/one/"+t,method:"GET",data:""})}},d107:function(t,e,o){"use strict";o.r(e);var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("Row",[o("i-col",{attrs:{span:"24"}},[o("Card",[o("Button",{attrs:{type:"primary"},on:{click:function(e){t.showModal("add")}}},[t._v("添加")]),t._v(" \n\t\t\t\t"),o("Dropdown",{on:{"on-click":t.batchOpt}},[o("Button",{attrs:{type:"primary"}},[t._v("\n\t\t\t\t\t\t批量操作\n\t\t\t\t\t\t"),o("Icon",{attrs:{type:"ios-arrow-down"}})],1),o("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[o("DropdownItem",{attrs:{name:"batchActive"}},[t._v("批量激活")]),o("DropdownItem",{attrs:{name:"batchInactive"}},[o("span",{staticStyle:{color:"red"}},[t._v("批量冻结")])]),o("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[o("span",{staticStyle:{color:"red"}},[t._v("批量删除")])])],1)],1),t._v(" \n\t\t\t\t"),o("Button",{attrs:{type:"primary"},on:{click:function(e){t.showModal("search")}}},[t._v("高级搜索")]),t._v(" \n\t\t\t\t"),o("Tooltip",{attrs:{content:"刷新",placement:"right"}},[o("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:t.search}})],1),o("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:t.table.loading,columns:t.table.tableColumns,data:t.table.tableDetails},on:{"on-selection-change":t.changeSelection,"on-sort-change":t.changeSort}}),o("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[o("div",{staticStyle:{float:"right"}},[o("Page",{attrs:{total:t.page.total,current:t.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":t.changePageNo,"on-page-size-change":t.changePageSize}})],1)])],1)],1)],1),o("Modal",{attrs:{title:"添加"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("addForm",e)}},model:{value:t.modal.add,callback:function(e){t.$set(t.modal,"add",e)},expression:"modal.add"}},[o("Form",{ref:"addForm",attrs:{model:t.form,"label-width":80,rules:t.validateRules}},[o("FormItem",{attrs:{label:"企业编号",prop:"compId"}},[o("span",{domProps:{textContent:t._s(t.form.compId)}}),t._v("\n\t\t\t\t \n\t\t\t\t"),o("Button",{attrs:{type:"text"},on:{click:function(e){t.showModal("companyChoice")}}},[t._v("选择企业")]),t._v(" \n\t\t\t")],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:t.form.projectName,callback:function(e){t.$set(t.form,"projectName",e)},expression:"form.projectName"}})],1),o("FormItem",{attrs:{label:"项目负责人",prop:"name"}},[o("Input",{attrs:{placeholder:"请输入项目负责人"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),o("FormItem",{attrs:{label:"合同金额（万元）",prop:"contractAmount"}},[o("Input",{attrs:{placeholder:"请输入合同金额"},model:{value:t.form.contractAmount,callback:function(e){t.$set(t.form,"contractAmount",e)},expression:"form.contractAmount"}})],1),o("FormItem",{attrs:{label:"开工时间",prop:"startDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.form.startDate,placeholder:"请输入开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.form.startDate=e}}})],1),o("FormItem",{attrs:{label:"竣工时间",prop:"endDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.form.endDate,placeholder:"请输入竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.form.endDate=e}}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetFormCancelModal("addForm","add")}}},[t._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:t.loading.add},on:{click:t.add}},[t._v("添加")])],1)],1),o("Modal",{attrs:{title:"修改"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("editForm",e)}},model:{value:t.modal.edit,callback:function(e){t.$set(t.modal,"edit",e)},expression:"modal.edit"}},[o("Form",{ref:"editForm",attrs:{model:t.form,"label-width":80,rules:t.validateRules}},[o("FormItem",{attrs:{label:"企业编号",prop:"compId"}},[o("span",{domProps:{textContent:t._s(t.form.compId)}}),t._v("\n\t\t\t\t \n\t\t\t\t"),o("Button",{attrs:{type:"text"},on:{click:function(e){t.showModal("companyChoice")}}},[t._v("选择企业")]),t._v(" \n\t\t\t")],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:t.form.projectName,callback:function(e){t.$set(t.form,"projectName",e)},expression:"form.projectName"}})],1),o("FormItem",{attrs:{label:"项目负责人",prop:"name"}},[o("Input",{attrs:{placeholder:"请输入项目负责人"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),o("FormItem",{attrs:{label:"合同金额（万元）",prop:"contractAmount"}},[o("Input",{attrs:{placeholder:"请输入合同金额"},model:{value:t.form.contractAmount,callback:function(e){t.$set(t.form,"contractAmount",e)},expression:"form.contractAmount"}})],1),o("FormItem",{attrs:{label:"开工时间",prop:"startDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.form.startDate,placeholder:"请输入开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.form.startDate=e}}})],1),o("FormItem",{attrs:{label:"竣工时间",prop:"endDate"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.form.endDate,placeholder:"请输入竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.form.endDate=e}}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetFormCancelModal("editForm","edit")}}},[t._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:t.loading.edit},on:{click:t.edit}},[t._v("修改")])],1)],1),o("Modal",{attrs:{title:"高级搜索"},model:{value:t.modal.search,callback:function(e){t.$set(t.modal,"search",e)},expression:"modal.search"}},[o("Form",{ref:"searchForm",attrs:{model:t.searchForm,"label-width":80}},[o("FormItem",{attrs:{label:"企业水利业绩编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业水利业绩编号"},model:{value:t.searchForm.idMin,callback:function(e){t.$set(t.searchForm,"idMin",e)},expression:"searchForm.idMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"idMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业水利业绩编号"},model:{value:t.searchForm.idMax,callback:function(e){t.$set(t.searchForm,"idMax",e)},expression:"searchForm.idMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"企业编号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"compIdMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始企业编号"},model:{value:t.searchForm.compIdMin,callback:function(e){t.$set(t.searchForm,"compIdMin",e)},expression:"searchForm.compIdMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"compIdMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束企业编号"},model:{value:t.searchForm.compIdMax,callback:function(e){t.$set(t.searchForm,"compIdMax",e)},expression:"searchForm.compIdMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"工程名称",prop:"projectName"}},[o("Input",{attrs:{placeholder:"请输入工程名称"},model:{value:t.searchForm.projectName,callback:function(e){t.$set(t.searchForm,"projectName",e)},expression:"searchForm.projectName"}})],1),o("FormItem",{attrs:{label:"项目负责人",prop:"name"}},[o("Input",{attrs:{placeholder:"请输入项目负责人"},model:{value:t.searchForm.name,callback:function(e){t.$set(t.searchForm,"name",e)},expression:"searchForm.name"}})],1),o("FormItem",{attrs:{label:"合同金额",prop:"contractAmount"}},[o("Input",{attrs:{placeholder:"请输入合同金额"},model:{value:t.searchForm.contractAmount,callback:function(e){t.$set(t.searchForm,"contractAmount",e)},expression:"searchForm.contractAmount"}})],1),o("FormItem",{attrs:{label:"开工时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"startDateMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.startDateMin,placeholder:"请输入开始开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.startDateMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"startDateMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.startDateMax,placeholder:"请输入结束开工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.startDateMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"竣工时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"endDateMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.endDateMin,placeholder:"请输入开始竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.endDateMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"endDateMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.endDateMax,placeholder:"请输入结束竣工时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.endDateMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"版本号"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:t.searchForm.versionMin,callback:function(e){t.$set(t.searchForm,"versionMin",e)},expression:"searchForm.versionMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"versionMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:t.searchForm.versionMax,callback:function(e){t.$set(t.searchForm,"versionMax",e)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"创建时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"createTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"更新时间"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMin"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMin=e}}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"updateTimeMax"}},[o("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMax=e}}})],1)],1)],1)],1),o("FormItem",{attrs:{label:"是否激活"}},[o("Row",[o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMin"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:t.searchForm.isActiveMin,callback:function(e){t.$set(t.searchForm,"isActiveMin",e)},expression:"searchForm.isActiveMin"}})],1)],1),o("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),o("i-col",{attrs:{span:"11"}},[o("FormItem",{attrs:{prop:"isActiveMax"}},[o("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:t.searchForm.isActiveMax,callback:function(e){t.$set(t.searchForm,"isActiveMax",e)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetForm("searchForm")}}},[t._v("清空")]),o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.cancelModal("search")}}},[t._v("取消")]),o("Button",{attrs:{type:"primary",size:"large",loading:t.loading.search},on:{click:function(e){t.searchOkModal("search")}}},[t._v("搜索")])],1)],1),o("Modal",{attrs:{title:"详情"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("editForm",e)}},model:{value:t.modal.detail,callback:function(e){t.$set(t.modal,"detail",e)},expression:"modal.detail"}},[o("p",[t._v("企业水利业绩编号: "),o("span",{domProps:{textContent:t._s(t.form.id)}})]),o("p",[t._v("企业编号: "),o("span",{domProps:{textContent:t._s(t.form.compId)}})]),o("p",[t._v("工程名称: "),o("span",{domProps:{textContent:t._s(t.form.projectName)}})]),o("p",[t._v("项目负责人: "),o("span",{domProps:{textContent:t._s(t.form.name)}})]),o("p",[t._v("合同金额: "),o("span",{domProps:{textContent:t._s(t.form.contractAmount/100)}})]),o("p",[t._v("开工时间: "),o("span",{domProps:{textContent:t._s(t.form.startDate)}})]),o("p",[t._v("竣工时间: "),o("span",{domProps:{textContent:t._s(t.form.endDate)}})]),o("p",[t._v("版本号: "),o("span",{domProps:{textContent:t._s(t.form.version)}})]),o("p",[t._v("创建时间: "),o("span",{domProps:{textContent:t._s(t.form.createTime)}})]),o("p",[t._v("更新时间: "),o("span",{domProps:{textContent:t._s(t.form.updateTime)}})]),o("p",[t._v("是否激活: "),o("span",{domProps:{textContent:t._s(t.form.isActive)}})])]),o("Modal",{attrs:{transfer:!1,title:"企业详情"},model:{value:t.modal.companyDetail,callback:function(e){t.$set(t.modal,"companyDetail",e)},expression:"modal.companyDetail"}},[o("CompanyDetail",{attrs:{form:t.companyDetailForm}})],1),o("Modal",{attrs:{transfer:!1,fullscreen:"",title:"搜索主表信息"},model:{value:t.modal.companyChoice,callback:function(e){t.$set(t.modal,"companyChoice",e)},expression:"modal.companyChoice"}},[o("company-list-single",{ref:"CompanyListSingle",on:{confirmSelection:t.confirmSelection}}),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.cancelModal("companyChoice")}}},[t._v("取消")]),o("Button",{attrs:{type:"primary",size:"large"},on:{click:t.confirm}},[t._v("确认选择")])],1)],1)],1)},r=[],n=o("f499"),s=o.n(n),l=(o("386d"),o("f62d")),i=o("816b"),c=o("718e"),m=o("3f3b"),p={name:"CompWaterAchievement",components:{CompanyListSingle:m["a"],CompanyDetail:c["a"]},data:function(){var t=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1,companyDetail:!1,companyChoice:!1,operate:""},loading:{add:!1,edit:!1,search:!1},urls:{addUrl:"/comp-water-achievement/admin/save",batchAddUrl:"/comp-water-achievement/admin/batch-save",editUrl:"/comp-water-achievement/admin/update",batchEditUrl:"/comp-water-achievement/admin/batch-update",searchUrl:"/comp-water-achievement/admin/pager-cond",allUrl:"/comp-water-achievement/admin/all",removeUrl:"/comp-water-achievement/admin/remove/",batchRemoveUrl:"/comp-water-achievement/admin/batch-remove",detailUrl:"/comp-water-achievement/admin/one/",activeUrl:"/comp-water-achievement/admin/active",batchActiveUrl:"/comp-water-achievement/admin/batch-active"},page:{total:0},form:{id:null,compId:null,projectName:null,name:null,money:null,contractAmount:null,contractAmountDisplay:null,startDate:null,endDate:null,version:null,createTime:null,updateTime:null,isActive:null},companyDetailForm:{id:null,jurisdictionType:null,city:null,compType:null,industryType:null,compName:null,legalPerson:null,legalPersonPhone:null,regAddress:null,responsible:null,responsiblePhone:null,compPhone:null,compAddr:null,regCapital:null,businessScope:null,affordableBusiness:null,version:null,createTime:null,updateTime:null,isActive:null},validateRules:{compId:[{type:"integer",required:!0,message:"此项为必须项",trigger:"blur, change"}],projectName:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],name:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],contractAmount:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,compId:null,compIdMin:null,compIdMax:null,projectName:null,name:null,contractAmount:null,startDate:null,startDateMin:null,startDateMax:null,endDate:null,endDateMin:null,endDateMax:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(e,o){return e("span",o.index+(t.searchForm.pageNo-1)*t.searchForm.pageSize+1)}},{title:"企业水利业绩编号",key:"id",minWidth:160,sortable:!0},{title:"企业编号",key:"compId",minWidth:120,sortable:!0,render:function(e,o){return e("Dropdown",{on:{"on-click":function(e){t.userOpt(e,o.row)}},props:{transfer:!0}},[e("span",[o.row.compId,e("Icon",{props:{type:"ios-list",size:"25"}})]),e("DropdownMenu",{slot:"list"},[e("DropdownItem",{props:{name:"moduleDetail"}},"详情"),e("DropdownItem",{props:{name:"showSearch"}},"搜索")])])}},{title:"工程名称",key:"projectName",minWidth:180,sortable:!0},{title:"项目负责人",key:"name",minWidth:120,sortable:!0},{title:"合同金额（万元）",key:"contractAmount",minWidth:120,sortable:!0,render:function(t,e){var o=e.row.contractAmount;return t("span","￥"+o)}},{title:"开工时间",key:"startDate",minWidth:150,sortable:!0},{title:"竣工时间",key:"endDate",minWidth:150,sortable:!0},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(e,o){return e("i-switch",{props:{size:"large",value:0===o.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(e){t.active(o.row)}}},[e("span",{slot:"open"},"激活"),e("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(e,o){return e("Dropdown",{on:{"on-click":function(e){t.userOpt(e,o.row)}},props:{transfer:!0}},[e("Button",{props:{type:"primary",size:"small"}},["选择操作 ",e("Icon",{props:{type:"ios-arrow-down"}})]),e("DropdownMenu",{slot:"list"},[e("DropdownItem",{props:{name:"showEdit"}},"编辑"),e("DropdownItem",{props:{name:"showDetail"}},"详情"),e("DropdownItem",{props:{name:"remove"}},[e("span",{style:{color:"red"}},"删除")])])])}}],tableDetails:[],selections:[]}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(t){l["B"](this,t),this.modal.operate="operate"},changeModalVisibleResetForm:function(t,e){e||l["z"](this,t)},resetForm:function(t){l["z"](this,t)},cancelModal:function(t){l["h"](this,t)},resetFormCancelModal:function(t,e){l["h"](this,e),l["z"](this,t)},searchOkModal:function(t){l["h"](this,t),this.searchForm.pageNo=1,l["A"](this)},batchOpt:function(t){"batchActive"===t?l["f"](this,0):"batchInactive"===t?l["f"](this,1):"batchRemove"===t&&l["g"](this)},userOpt:function(t,e){"showEdit"===t?(l["B"](this,"edit"),this.form=JSON.parse(s()(e)),this.setPrice(0)):"showDetail"===t?(l["B"](this,"detail"),this.form=JSON.parse(s()(e))):"remove"===t?l["y"](this,e):"moduleDetail"===t?this.showUserDetailModal(e.compId):"showSearch"===t&&(l["B"](this,"companyChoice"),this.modal.operate="show")},showUserDetailModal:function(t){var e=this;Object(i["d"])(t).then(function(t){var o=t.data;1001===o.code?(e.companyDetailForm=o.data,e.modal.companyDetail=!0):e.$Message.error(o.message)}).catch(function(t){e.$Message.error(t)})},confirmSelection:function(t){this.modal.companyChoice=!1,"show"===this.modal.operate?(this.searchForm.compIdMin=t,this.searchForm.compIdMax=t,l["A"](this)):"operate"===this.modal.operate&&(this.form.compId=t)},confirm:function(){this.$refs.CompanyListSingle.confirmSelection()},setPrice:function(t){this.from.money=this.form.contractAmount},add:function(){this.setPrice(1),l["c"](this)},edit:function(){this.setPrice(1),l["q"](this)},active:function(t){l["b"](this,t)},search:function(){l["A"](this)},changeSelection:function(t){l["o"](this,t)},changeSort:function(t){l["p"](this,t)},changePageNo:function(t){l["j"](this,t)},changePageSize:function(t){l["k"](this,t)}}},d=p,u=o("2877"),h=Object(u["a"])(d,a,r,!1,null,null,null);e["default"]=h.exports}}]);