(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a7fd0780"],{"386d":function(t,e,a){a("214f")("search",1,function(t,e,a){return[function(a){"use strict";var o=t(this),r=void 0==a?void 0:a[e];return void 0!==r?r.call(a,o):new RegExp(a)[e](String(o))},a]})},b14a:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("Row",[a("i-col",{attrs:{span:"24"}},[a("Card",[a("Button",{attrs:{type:"primary"},on:{click:function(e){t.showModal("add")}}},[t._v("添加")]),t._v(" \n          "),a("Dropdown",{on:{"on-click":t.batchOpt}},[a("Button",{attrs:{type:"primary"}},[t._v("\n              批量操作\n              "),a("Icon",{attrs:{type:"ios-arrow-down"}})],1),a("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[a("DropdownItem",{attrs:{name:"batchActive"}},[t._v("批量激活")]),a("DropdownItem",{attrs:{name:"batchInactive"}},[a("span",{staticStyle:{color:"red"}},[t._v("批量冻结")])]),a("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[a("span",{staticStyle:{color:"red"}},[t._v("批量删除")])])],1)],1),t._v(" \n          "),a("Button",{attrs:{type:"primary"},on:{click:function(e){t.showModal("search")}}},[t._v("高级搜索")]),t._v(" \n          "),a("Tooltip",{attrs:{content:"刷新",placement:"right"}},[a("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:t.search}})],1),a("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:t.table.loading,columns:t.table.tableColumns,data:t.table.tableDetails},on:{"on-selection-change":t.changeSelection,"on-sort-change":t.changeSort}}),a("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[a("div",{staticStyle:{float:"right"}},[a("Page",{attrs:{total:t.page.total,current:t.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":t.changePageNo,"on-page-size-change":t.changePageSize}})],1)])],1)],1)],1),a("Modal",{attrs:{title:"添加"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("addForm",e)}},model:{value:t.modal.add,callback:function(e){t.$set(t.modal,"add",e)},expression:"modal.add"}},[a("Form",{ref:"addForm",attrs:{model:t.form,"label-width":80,rules:t.validateRules}},[a("FormItem",{attrs:{label:"公告标题",prop:"title"}},[a("Input",{attrs:{placeholder:"请输入公告标题"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),a("FormItem",{attrs:{label:"公告内容",prop:"content"}},[a("Input",{attrs:{placeholder:"请输入公告内容"},model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1),a("FormItem",{attrs:{label:"公告简介",prop:"synopsis"}},[a("Input",{attrs:{placeholder:"请输入公告简介"},model:{value:t.form.synopsis,callback:function(e){t.$set(t.form,"synopsis",e)},expression:"form.synopsis"}})],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetFormCancelModal("addForm","add")}}},[t._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:t.loading.add},on:{click:t.add}},[t._v("添加")])],1)],1),a("Modal",{attrs:{title:"修改"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("editForm",e)}},model:{value:t.modal.edit,callback:function(e){t.$set(t.modal,"edit",e)},expression:"modal.edit"}},[a("Form",{ref:"editForm",attrs:{model:t.form,"label-width":80,rules:t.validateRules}},[a("FormItem",{attrs:{label:"公告标题",prop:"title"}},[a("Input",{attrs:{placeholder:"请输入公告标题"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),a("FormItem",{attrs:{label:"公告内容",prop:"content"}},[a("Input",{attrs:{placeholder:"请输入公告内容"},model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1),a("FormItem",{attrs:{label:"公告简介",prop:"synopsis"}},[a("Input",{attrs:{placeholder:"请输入公告简介"},model:{value:t.form.synopsis,callback:function(e){t.$set(t.form,"synopsis",e)},expression:"form.synopsis"}})],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetFormCancelModal("editForm","edit")}}},[t._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:t.loading.edit},on:{click:t.edit}},[t._v("修改")])],1)],1),a("Modal",{attrs:{title:"高级搜索"},model:{value:t.modal.search,callback:function(e){t.$set(t.modal,"search",e)},expression:"modal.search"}},[a("Form",{ref:"searchForm",attrs:{model:t.searchForm,"label-width":80}},[a("FormItem",{attrs:{label:"更新公告编号"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"idMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始更新公告编号"},model:{value:t.searchForm.idMin,callback:function(e){t.$set(t.searchForm,"idMin",e)},expression:"searchForm.idMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"idMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束更新公告编号"},model:{value:t.searchForm.idMax,callback:function(e){t.$set(t.searchForm,"idMax",e)},expression:"searchForm.idMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"公告标题",prop:"title"}},[a("Input",{attrs:{placeholder:"请输入公告标题"},model:{value:t.searchForm.title,callback:function(e){t.$set(t.searchForm,"title",e)},expression:"searchForm.title"}})],1),a("FormItem",{attrs:{label:"公告内容",prop:"content"}},[a("Input",{attrs:{placeholder:"请输入公告内容"},model:{value:t.searchForm.content,callback:function(e){t.$set(t.searchForm,"content",e)},expression:"searchForm.content"}})],1),a("FormItem",{attrs:{label:"公告简介",prop:"synopsis"}},[a("Input",{attrs:{placeholder:"请输入公告简介"},model:{value:t.searchForm.synopsis,callback:function(e){t.$set(t.searchForm,"synopsis",e)},expression:"searchForm.synopsis"}})],1),a("FormItem",{attrs:{label:"版本号"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"versionMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:t.searchForm.versionMin,callback:function(e){t.$set(t.searchForm,"versionMin",e)},expression:"searchForm.versionMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"versionMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:t.searchForm.versionMax,callback:function(e){t.$set(t.searchForm,"versionMax",e)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"更新时间"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"updateTimeMin"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMin=e}}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"updateTimeMax"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.updateTimeMax=e}}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"创建时间"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"createTimeMin"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMin=e}}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"createTimeMax"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:t.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(e){t.searchForm.createTimeMax=e}}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"是否激活"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isActiveMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:t.searchForm.isActiveMin,callback:function(e){t.$set(t.searchForm,"isActiveMin",e)},expression:"searchForm.isActiveMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isActiveMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:t.searchForm.isActiveMax,callback:function(e){t.$set(t.searchForm,"isActiveMax",e)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.resetForm("searchForm")}}},[t._v("清空")]),a("Button",{attrs:{type:"text",size:"large"},on:{click:function(e){t.cancelModal("search")}}},[t._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:t.loading.search},on:{click:function(e){t.searchOkModal("search")}}},[t._v("搜索")])],1)],1),a("Modal",{attrs:{title:"详情"},on:{"on-visible-change":function(e){t.changeModalVisibleResetForm("editForm",e)}},model:{value:t.modal.detail,callback:function(e){t.$set(t.modal,"detail",e)},expression:"modal.detail"}},[a("p",[t._v("更新公告编号: "),a("span",{domProps:{textContent:t._s(t.form.id)}})]),a("p",[t._v("公告标题: "),a("span",{domProps:{textContent:t._s(t.form.title)}})]),a("p",[t._v("公告内容: "),a("span",{domProps:{textContent:t._s(t.form.content)}})]),a("p",[t._v("公告简介: "),a("span",{domProps:{textContent:t._s(t.form.synopsis)}})]),a("p",[t._v("版本号: "),a("span",{domProps:{textContent:t._s(t.form.version)}})]),a("p",[t._v("更新时间: "),a("span",{domProps:{textContent:t._s(t.form.updateTime)}})]),a("p",[t._v("创建时间: "),a("span",{domProps:{textContent:t._s(t.form.createTime)}})]),a("p",[t._v("是否激活: "),a("span",{domProps:{textContent:t._s(t.form.isActive)}})])])],1)},r=[],n=a("f499"),i=a.n(n),s=(a("386d"),a("f62d")),l={name:"UpdateNotice",data:function(){var t=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1},loading:{add:!1,edit:!1,search:!1},urls:{addUrl:"/update-notice/admin/save",batchAddUrl:"/update-notice/admin/batch-save",editUrl:"/update-notice/admin/update",batchEditUrl:"/update-notice/admin/batch-update",searchUrl:"/update-notice/admin/pager-cond",allUrl:"/update-notice/admin/all",removeUrl:"/update-notice/admin/remove/",batchRemoveUrl:"/update-notice/admin/batch-remove",detailUrl:"/update-notice/admin/one/",activeUrl:"/update-notice/admin/active",batchActiveUrl:"/update-notice/admin/batch-active"},page:{total:0},form:{id:null,title:null,content:null,synopsis:null,version:null,updateTime:null,createTime:null,isActive:null},validateRules:{title:[{type:"string",min:1,max:32,message:"必须1-32个字符",trigger:"blur"}],content:[{type:"string",min:1,max:65535,message:"必须1-65535个字符",trigger:"blur"}],synopsis:[{type:"string",min:1,max:200,message:"必须1-200个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,title:null,content:null,synopsis:null,version:null,versionMin:null,versionMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,createTime:null,createTimeMin:null,createTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(e,a){return e("span",a.index+(t.searchForm.pageNo-1)*t.searchForm.pageSize+1)}},{title:"更新公告编号",key:"id",minWidth:120,sortable:!0},{title:"公告标题",key:"title",minWidth:120,sortable:!0},{title:"公告内容",key:"content",minWidth:120,sortable:!0},{title:"公告简介",key:"synopsis",minWidth:120,sortable:!0},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:120,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(e,a){return e("i-switch",{props:{size:"large",value:0===a.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(e){t.active(a.row)}}},[e("span",{slot:"open"},"激活"),e("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(e,a){return e("Dropdown",{on:{"on-click":function(e){t.userOpt(e,a.row)}},props:{transfer:!0}},[e("Button",{props:{type:"primary",size:"small"}},["选择操作 ",e("Icon",{props:{type:"ios-arrow-down"}})]),e("DropdownMenu",{slot:"list"},[e("DropdownItem",{props:{name:"showEdit"}},"编辑"),e("DropdownItem",{props:{name:"showDetail"}},"详情"),e("DropdownItem",{props:{name:"remove"}},[e("span",{style:{color:"red"}},"删除")])])])}}],tableDetails:[],selections:[]}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(t){s["B"](this,t)},changeModalVisibleResetForm:function(t,e){e||s["z"](this,t)},resetForm:function(t){s["z"](this,t)},cancelModal:function(t){s["h"](this,t)},resetFormCancelModal:function(t,e){s["h"](this,e),s["z"](this,t)},searchOkModal:function(t){s["h"](this,t),this.searchForm.pageNo=1,s["A"](this)},batchOpt:function(t){"batchActive"===t?s["f"](this,0):"batchInactive"===t?s["f"](this,1):"batchRemove"===t&&s["g"](this)},userOpt:function(t,e){"showEdit"===t?(s["B"](this,"edit"),this.form=JSON.parse(i()(e))):"showDetail"===t?(s["B"](this,"detail"),this.form=JSON.parse(i()(e))):"remove"===t&&s["y"](this,e)},add:function(){s["c"](this)},edit:function(){s["q"](this)},active:function(t){s["b"](this,t)},search:function(){s["A"](this)},changeSelection:function(t){s["o"](this,t)},changeSort:function(t){s["p"](this,t)},changePageNo:function(t){s["j"](this,t)},changePageSize:function(t){s["k"](this,t)}}},c=l,m=a("2877"),d=Object(m["a"])(c,o,r,!1,null,null,null);e["default"]=d.exports}}]);