(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4fb735ad"],{a31e:function(e,t,l){"use strict";l.r(t);var a=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("Row",[l("i-col",{attrs:{span:"24"}},[l("Card",[l("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("add")}}},[e._v("添加")]),e._v(" \n        "),l("Dropdown",{on:{"on-click":e.batchOpt}},[l("Button",{attrs:{type:"primary"}},[e._v("\n            批量操作\n            "),l("Icon",{attrs:{type:"ios-arrow-down"}})],1),l("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[l("DropdownItem",{attrs:{name:"batchActive"}},[e._v("批量激活")]),l("DropdownItem",{attrs:{name:"batchInactive"}},[l("span",{staticStyle:{color:"red"}},[e._v("批量冻结")])]),l("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[l("span",{staticStyle:{color:"red"}},[e._v("批量删除")])])],1)],1),e._v(" \n        "),l("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n        "),l("Tooltip",{attrs:{content:"刷新",placement:"right"}},[l("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),l("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-selection-change":e.changeSelection,"on-sort-change":e.changeSort}}),l("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[l("div",{staticStyle:{float:"right"}},[l("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),l("Modal",{attrs:{title:"添加"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("addForm",t)}},model:{value:e.modal.add,callback:function(t){e.$set(e.modal,"add",t)},expression:"modal.add"}},[l("Form",{ref:"addForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[l("FormItem",{attrs:{label:"发布用户",prop:"userId"}},[l("span",{domProps:{textContent:e._s(e.form.userId)}}),e._v("\n         \n        "),l("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("userChoice")}}},[e._v("选择用户")]),e._v(" \n      ")],1),l("FormItem",{attrs:{label:"招聘岗位",prop:"jobTitle"}},[l("Input",{attrs:{placeholder:"请输入招聘岗位"},model:{value:e.form.jobTitle,callback:function(t){e.$set(e.form,"jobTitle",t)},expression:"form.jobTitle"}})],1),l("FormItem",{attrs:{label:"是否全职",prop:"isFulltime"}},[l("Select",{attrs:{placeholder:"请选择求职类型",filterable:""},model:{value:e.form.isFulltime,callback:function(t){e.$set(e.form,"isFulltime",t)},expression:"form.isFulltime"}},e._l(e.jobTypeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[l("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.form.workYear,callback:function(t){e.$set(e.form,"workYear",t)},expression:"form.workYear"}})],1),l("FormItem",{attrs:{label:"要求学历",prop:"education"}},[l("Select",{attrs:{placeholder:"请选择学历",clearable:"",filterable:""},model:{value:e.form.education,callback:function(t){e.$set(e.form,"education",t)},expression:"form.education"}},e._l(e.educationList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"提供月薪",prop:"salary"}},[l("Select",{attrs:{placeholder:"请选择要求薪资/月",clearable:"",filterable:""},model:{value:e.form.salary,callback:function(t){e.$set(e.form,"salary",t)},expression:"form.salary"}},e._l(e.salaryRangeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"工作地",prop:"workAddr"}},[l("Cascader",{attrs:{data:e.cityData,trigger:"hover","change-on-select":"",filterable:"",clearable:""},model:{value:e.tempAddress,callback:function(t){e.tempAddress=t},expression:"tempAddress"}})],1),l("FormItem",{attrs:{label:"招聘状态",prop:"recruitStatus"}},[l("Select",{attrs:{placeholder:"请选择招聘状态"},model:{value:e.form.recruitStatus,callback:function(t){e.$set(e.form,"recruitStatus",t)},expression:"form.recruitStatus"}},e._l(e.recruitStatusSelect,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"职位描述",prop:"memo"}},[l("Input",{attrs:{type:"textarea",autosize:e.descriptionAutoSize,placeholder:"请输入职位描述"},model:{value:e.form.memo,callback:function(t){e.$set(e.form,"memo",t)},expression:"form.memo"}})],1)],1),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("addForm","add")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large",loading:e.loading.add},on:{click:e.add}},[e._v("添加")])],1)],1),l("Modal",{attrs:{title:"修改"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.edit,callback:function(t){e.$set(e.modal,"edit",t)},expression:"modal.edit"}},[l("Form",{ref:"editForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[l("FormItem",{attrs:{label:"发布用户",prop:"userId"}},[l("span",{domProps:{textContent:e._s(e.form.userId)}}),e._v("\n         \n        "),l("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("userChoice")}}},[e._v("选择用户")]),e._v(" \n      ")],1),l("FormItem",{attrs:{label:"招聘岗位",prop:"jobTitle"}},[l("Input",{attrs:{placeholder:"请输入招聘岗位"},model:{value:e.form.jobTitle,callback:function(t){e.$set(e.form,"jobTitle",t)},expression:"form.jobTitle"}})],1),l("FormItem",{attrs:{label:"是否全职",prop:"isFulltime"}},[l("Select",{attrs:{placeholder:"请选择求职类型",filterable:""},model:{value:e.form.isFulltime,callback:function(t){e.$set(e.form,"isFulltime",t)},expression:"form.isFulltime"}},e._l(e.jobTypeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[l("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.form.workYear,callback:function(t){e.$set(e.form,"workYear",t)},expression:"form.workYear"}})],1),l("FormItem",{attrs:{label:"要求学历",prop:"education"}},[l("Select",{attrs:{placeholder:"请选择学历",clearable:"",filterable:""},model:{value:e.form.education,callback:function(t){e.$set(e.form,"education",t)},expression:"form.education"}},e._l(e.educationList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"提供月薪",prop:"salary"}},[l("Select",{attrs:{placeholder:"请选择要求薪资/月",clearable:"",filterable:""},model:{value:e.form.salary,callback:function(t){e.$set(e.form,"salary",t)},expression:"form.salary"}},e._l(e.salaryRangeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"工作地",prop:"workAddr"}},[l("Cascader",{attrs:{data:e.cityData,trigger:"hover","change-on-select":"",filterable:"",clearable:""},model:{value:e.tempAddress,callback:function(t){e.tempAddress=t},expression:"tempAddress"}})],1),l("FormItem",{attrs:{label:"招聘状态",prop:"recruitStatus"}},[l("Select",{attrs:{placeholder:"请选择招聘状态"},model:{value:e.form.recruitStatus,callback:function(t){e.$set(e.form,"recruitStatus",t)},expression:"form.recruitStatus"}},e._l(e.recruitStatusSelect,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"职位描述",prop:"memo"}},[l("Input",{attrs:{type:"textarea",autosize:e.descriptionAutoSize,placeholder:"请输入职位描述"},model:{value:e.form.memo,callback:function(t){e.$set(e.form,"memo",t)},expression:"form.memo"}})],1)],1),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("editForm","edit")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large",loading:e.loading.edit},on:{click:e.edit}},[e._v("修改")])],1)],1),l("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[l("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[l("FormItem",{attrs:{label:"招聘编号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始招聘编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束招聘编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"用户编号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"userIdMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始用户编号"},model:{value:e.searchForm.userIdMin,callback:function(t){e.$set(e.searchForm,"userIdMin",t)},expression:"searchForm.userIdMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"userIdMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束用户编号"},model:{value:e.searchForm.userIdMax,callback:function(t){e.$set(e.searchForm,"userIdMax",t)},expression:"searchForm.userIdMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"招聘岗位",prop:"jobTitle"}},[l("Input",{attrs:{placeholder:"请输入招聘岗位"},model:{value:e.searchForm.jobTitle,callback:function(t){e.$set(e.searchForm,"jobTitle",t)},expression:"searchForm.jobTitle"}})],1),l("FormItem",{attrs:{label:"是否全职"}},[l("Select",{attrs:{placeholder:"请选择求职类型",clearable:"",filterable:""},model:{value:e.searchForm.isFulltime,callback:function(t){e.$set(e.searchForm,"isFulltime",t)},expression:"searchForm.isFulltime"}},e._l(e.jobTypeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[l("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.searchForm.workYear,callback:function(t){e.$set(e.searchForm,"workYear",t)},expression:"searchForm.workYear"}})],1),l("FormItem",{attrs:{label:"要求学历",prop:"education"}},[l("Select",{attrs:{placeholder:"请选择学历",clearable:"",filterable:""},model:{value:e.searchForm.education,callback:function(t){e.$set(e.searchForm,"education",t)},expression:"searchForm.education"}},e._l(e.educationList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"提供月薪",prop:"salary"}},[l("Select",{attrs:{placeholder:"请选择要求薪资/月",clearable:"",filterable:""},model:{value:e.searchForm.salary,callback:function(t){e.$set(e.searchForm,"salary",t)},expression:"searchForm.salary"}},e._l(e.salaryRangeList,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"招聘状态",prop:"recruitStatus"}},[l("Select",{attrs:{placeholder:"请选择招聘状态"},model:{value:e.searchForm.recruitStatus,callback:function(t){e.$set(e.searchForm,"recruitStatus",t)},expression:"searchForm.recruitStatus"}},e._l(e.recruitStatusSelect,function(t){return l("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"是否激活",prop:"isActive"}},[l("Select",{attrs:{placeholder:"请选择是否激活",clearable:"",filterable:""},model:{value:e.searchForm.isActive,callback:function(t){e.$set(e.searchForm,"isActive",t)},expression:"searchForm.isActive"}},e._l(e.isActiveSelect,function(t){return l("i-option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),l("FormItem",{attrs:{label:"版本号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"versionMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"versionMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"创建时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"更新时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1)],1),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("搜索")])],1)],1),l("Modal",{attrs:{title:"详情"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[l("p",[e._v("\n      招聘编号:\n      "),l("span",{domProps:{textContent:e._s(e.form.id)}})]),l("p",[e._v("\n      用户编号:\n      "),l("span",{domProps:{textContent:e._s(e.form.userId)}})]),l("p",[e._v("\n      招聘岗位:\n      "),l("span",{domProps:{textContent:e._s(e.form.jobTitle)}})]),l("p",[e._v("\n      是否全职:\n      "),l("span",{domProps:{textContent:e._s(e.form.isFulltime)}})]),l("p",[e._v("\n      工作时间（年）:\n      "),l("span",{domProps:{textContent:e._s(e.form.workYear)}})]),l("p",[e._v("\n      要求学历:\n      "),l("span",{domProps:{textContent:e._s(e.form.education)}})]),l("p",[e._v("\n      提供月薪:\n      "),l("span",{domProps:{textContent:e._s(e.form.salary)}})]),l("p",[e._v("\n      工作地:\n      "),l("span",{domProps:{textContent:e._s(e.form.workAddr)}})]),l("p",[e._v("\n      职位描述:\n      "),l("span",{domProps:{textContent:e._s(e.form.memo)}})]),l("p",[e._v("\n      招聘状态:\n      "),l("span",{domProps:{textContent:e._s(e.form.recruitStatus)}})]),l("p",[e._v("\n      版本号:\n      "),l("span",{domProps:{textContent:e._s(e.form.version)}})]),l("p",[e._v("\n      创建时间:\n      "),l("span",{domProps:{textContent:e._s(e.form.createTime)}})]),l("p",[e._v("\n      更新时间:\n      "),l("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),l("p",[e._v("\n      是否激活:\n      "),l("span",{domProps:{textContent:e._s(e.form.isActive)}})])]),l("Modal",{attrs:{transfer:!1,title:"用户详情"},model:{value:e.modal.userDetail,callback:function(t){e.$set(e.modal,"userDetail",t)},expression:"modal.userDetail"}},[l("userDetail",{attrs:{form:e.userDetailForm},on:{setDetail:e.setDetailModal}})],1),l("Modal",{attrs:{transfer:!1,fullscreen:"",title:"搜索主表信息"},model:{value:e.modal.userDetalSearch,callback:function(t){e.$set(e.modal,"userDetalSearch",t)},expression:"modal.userDetalSearch"}},[l("user-list-single",{ref:"UserListSingle",on:{confirmSelection:e.confirmSelection}}),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("userDetalSearch")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large"},on:{click:e.confirm}},[e._v("确认选择")])],1)],1),l("Modal",{attrs:{transfer:!1,fullscreen:"",title:"选择用户"},model:{value:e.modal.userChoice,callback:function(t){e.$set(e.modal,"userChoice",t)},expression:"modal.userChoice"}},[l("user-list-choice",{ref:"UserListChoice",on:{confirmChoice:e.confirmChoice}}),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("userChoice")}}},[e._v("取消")])],1)],1)],1)},r=[],o=(l("28a5"),l("f499")),s=l.n(o),i=(l("386d"),l("f62d")),n=l("f36c"),c=l("27e5"),u=l("afcd"),m=l("816b"),d=l("1a21"),p=l("f2db"),h={name:"Recruit",components:{userDetail:u["a"],UserListSingle:n["a"],UserListChoice:c["a"]},data:function(){var e=this;return{userDetailForm:{userId:null,userPhone:null,userEmail:null,userCreateTime:null,userDetailNickname:null,userDetailHeadicon:null,userDetailGender:null,userDetailBirthday:null,userDetailAge:null,userDetailQq:null,userDetailQqQrcode:null,userDetailWechat:null,userDetailWechatQrcode:null,userDetailAlipay:null,userDetailAlipayQrcode:null,userDetailShareCode:null,userDetailVersion:null},modal:{add:!1,edit:!1,search:!1,detail:!1,userDetail:!1,userDetalSearch:!1,userChoice:!1},loading:{add:!1,edit:!1,search:!1},urls:{addUrl:"/recruit/admin/save",batchAddUrl:"/recruit/admin/batch-save",editUrl:"/recruit/admin/update",batchEditUrl:"/recruit/admin/batch-update",searchUrl:"/recruit/admin/pager-cond",allUrl:"/recruit/admin/all",removeUrl:"/recruit/admin/remove/",batchRemoveUrl:"/recruit/admin/batch-remove",detailUrl:"/recruit/admin/one/",activeUrl:"/recruit/admin/active",batchActiveUrl:"/recruit/admin/batch-active"},page:{total:0},form:{id:null,userId:null,jobTitle:null,isFulltime:null,workYear:null,education:null,salary:null,workAddr:null,memo:null,recruitStatus:null,version:null,createTime:null,updateTime:null,isActive:null},validateRules:{userId:[{type:"integer",required:!0,message:"此项为必须项",trigger:"blur, change"}],jobTitle:[{type:"string",required:!0,message:"此项为必须项",trigger:"blur"},{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],workYear:[{type:"string",min:1,max:10,message:"必须1-10个字符",trigger:"blur"}],education:[{type:"string",min:1,max:10,message:"必须1-10个字符",trigger:"blur"}],salary:[{type:"string",min:1,max:10,message:"必须1-10个字符",trigger:"blur"}],workAddr:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],memo:[{type:"string",min:1,max:255,message:"必须1-255个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,userId:null,userIdMin:null,userIdMax:null,jobTitle:null,isFulltime:null,isFulltimeMin:null,isFulltimeMax:null,workYear:null,education:null,salary:null,workAddr:null,recruitStatus:null,memo:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(t,l){return t("span",l.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"招聘编号",key:"id",minWidth:120,sortable:!0},{title:"用户编号",key:"userId",minWidth:120,sortable:!0,render:function(t,l){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,l.row)}},props:{transfer:!0}},[t("span",[l.row.userId,t("Icon",{props:{type:"ios-list",size:"25"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"moduleDetail"}},"详情"),t("DropdownItem",{props:{name:"showSearch"}},"搜索")])])}},{title:"招聘岗位",key:"jobTitle",minWidth:120,sortable:!0},{title:"是否全职",key:"isFulltime",minWidth:120,sortable:!0,render:function(e,t){var l=t.row,a=0===l.isFulltime?"primary":1===l.isFulltime?"info":"error",r=0===l.isFulltime?"全职":1===l.isFulltime?"兼职":"未知";return e("Button",{props:{size:"small",type:a}},r)}},{title:"工作时间（年）",key:"workYear",minWidth:160,sortable:!0},{title:"要求学历",key:"education",minWidth:120,sortable:!0},{title:"提供月薪",key:"salary",minWidth:120,sortable:!0},{title:"工作地",key:"workAddr",minWidth:120,sortable:!0},{title:"职位描述",key:"memo",minWidth:120,sortable:!0},{title:"招聘状态",key:"recruitStatus",minWidth:120,sortable:!0,render:function(e,t){var l=t.row,a="招聘中"===l.recruitStatus?"primary":"已停止"===l.recruitStatus?"default":"error";return e("Button",{props:{size:"small",type:a}},l.recruitStatus)}},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(t,l){return t("i-switch",{props:{size:"large",value:0===l.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(t){e.active(l.row)}}},[t("span",{slot:"open"},"激活"),t("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(t,l){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,l.row)}},props:{transfer:!0}},[t("Button",{props:{type:"primary",size:"small"}},["选择操作 ",t("Icon",{props:{type:"ios-arrow-down"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"showEdit"}},"编辑"),t("DropdownItem",{props:{name:"showDetail"}},"详情"),t("DropdownItem",{props:{name:"remove"}},[t("span",{style:{color:"red"}},"删除")])])])}}],tableDetails:[],selections:[]},isActiveSelect:d["s"],jobTypeList:d["w"],educationList:d["m"],salaryRangeList:d["L"],descriptionAutoSize:{minRows:3,maxRows:5},cityData:p,tempAddress:[],recruitStatusSelect:d["I"]}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){"add"===e&&(this.form.recruitStatus=this.recruitStatusSelect[0].value,this.form.isFulltime=this.jobTypeList[0].value),i["B"](this,e)},changeModalVisibleResetForm:function(e,t){t||i["z"](this,e)},resetForm:function(e){i["z"](this,e)},cancelModal:function(e){i["h"](this,e)},resetFormCancelModal:function(e,t){i["h"](this,t),i["z"](this,e)},searchOkModal:function(e){i["h"](this,e),this.searchForm.pageNo=1,i["A"](this)},batchOpt:function(e){"batchActive"===e?i["f"](this,0):"batchInactive"===e?i["f"](this,1):"batchRemove"===e&&i["g"](this)},userOpt:function(e,t){if("showEdit"===e){i["B"](this,"edit"),this.form=JSON.parse(s()(t));for(var l=this.form.workAddr.split("/"),a=0;a<l.length;a++)this.tempAddress.push(l[a])}else"showDetail"===e?(i["B"](this,"detail"),this.form=JSON.parse(s()(t))):"remove"===e?i["y"](this,t):"moduleDetail"===e?this.showUserDetailModal(t.userId):"showSearch"===e&&i["B"](this,"userDetalSearch")},showUserDetailModal:function(e){var t=this;Object(m["j"])(e).then(function(e){var l=e.data;1001===l.code?(t.userDetailForm=l.data.rows[0],t.modal.userDetail=!0):t.$Message.error(l.message)}).catch(function(e){t.$Message.error(e)})},setDetailModal:function(e){this.modal.userDetail=e},confirmSelection:function(e){this.modal.userDetalSearch=!1,this.searchForm.userIdMin=e,this.searchForm.userIdMax=e,i["A"](this)},confirm:function(){this.$refs.UserListSingle.confirmSelection()},setAddress:function(){this.tempAddress.length<=0?this.$Message.error("地址为必填项"):1===this.tempAddress.length?this.form.workAddr=this.tempAddress[0]:2===this.tempAddress.length?this.form.workAddr=this.tempAddress[0]+"/"+this.tempAddress[1]:3===this.tempAddress.length&&(this.form.workAddr=this.tempAddress[0]+"/"+this.tempAddress[1]+"/"+this.tempAddress[2])},add:function(){this.setAddress(),i["c"](this)},edit:function(){this.setAddress(),i["q"](this)},active:function(e){i["b"](this,e)},search:function(){i["A"](this)},changeSelection:function(e){i["o"](this,e)},changeSort:function(e){i["p"](this,e)},changePageNo:function(e){i["j"](this,e)},changePageSize:function(e){i["k"](this,e)},confirmChoice:function(e){this.form.userId=e,this.cancelModal("userChoice")}}},v=h,b=l("2877"),f=Object(b["a"])(v,a,r,!1,null,null,null);t["default"]=f.exports},f2db:function(e){e.exports=[{value:"江西",label:"江西",children:[{value:"南昌市",label:"南昌市",children:[{value:"东湖区",label:"东湖区"},{value:"西湖区",label:"西湖区"},{value:"青云谱区",label:"青云谱区"},{value:"湾里区",label:"湾里区"},{value:"青山湖区",label:"青山湖区"},{value:"南昌县",label:"南昌县"},{value:"新建县",label:"新建县"},{value:"安义县",label:"安义县"},{value:"进贤县",label:"进贤县"}]},{value:"景德镇市",label:"景德镇市",children:[{value:"昌江区",label:"昌江区"},{value:"珠山区",label:"珠山区"},{value:"浮梁县",label:"浮梁县"},{value:"乐平市",label:"乐平市"}]},{value:"萍乡市",label:"萍乡市",children:[{value:"安源区",label:"安源区"},{value:"湘东区",label:"湘东区"},{value:"莲花县",label:"莲花县"},{value:"上栗县",label:"上栗县"},{value:"芦溪县",label:"芦溪县"}]},{value:"九江市",label:"九江市",children:[{value:"庐山区",label:"庐山区"},{value:"浔阳区",label:"浔阳区"},{value:"九江县",label:"九江县"},{value:"武宁县",label:"武宁县"},{value:"修水县",label:"修水县"},{value:"永修县",label:"永修县"},{value:"德安县",label:"德安县"},{value:"星子县",label:"星子县"},{value:"都昌县",label:"都昌县"},{value:"湖口县",label:"湖口县"},{value:"彭泽县",label:"彭泽县"},{value:"瑞昌市",label:"瑞昌市"}]},{value:"新余市",label:"新余市",children:[{value:"渝水区",label:"渝水区"},{value:"分宜县",label:"分宜县"}]},{value:"鹰潭市",label:"鹰潭市",children:[{value:"月湖区",label:"月湖区"},{value:"余江县",label:"余江县"},{value:"贵溪市",label:"贵溪市"}]},{value:"赣州市",label:"赣州市",children:[{value:"章贡区",label:"章贡区"},{value:"赣县",label:"赣县"},{value:"信丰县",label:"信丰县"},{value:"大余县",label:"大余县"},{value:"上犹县",label:"上犹县"},{value:"崇义县",label:"崇义县"},{value:"安远县",label:"安远县"},{value:"龙南县",label:"龙南县"},{value:"定南县",label:"定南县"},{value:"全南县",label:"全南县"},{value:"宁都县",label:"宁都县"},{value:"于都县",label:"于都县"},{value:"兴国县",label:"兴国县"},{value:"会昌县",label:"会昌县"},{value:"寻乌县",label:"寻乌县"},{value:"石城县",label:"石城县"},{value:"瑞金市",label:"瑞金市"},{value:"南康市",label:"南康市"}]},{value:"吉安市",label:"吉安市",children:[{value:"吉州区",label:"吉州区"},{value:"青原区",label:"青原区"},{value:"吉安县",label:"吉安县"},{value:"吉水县",label:"吉水县"},{value:"峡江县",label:"峡江县"},{value:"新干县",label:"新干县"},{value:"永丰县",label:"永丰县"},{value:"泰和县",label:"泰和县"},{value:"遂川县",label:"遂川县"},{value:"万安县",label:"万安县"},{value:"安福县",label:"安福县"},{value:"永新县",label:"永新县"},{value:"井冈山市",label:"井冈山市"}]},{value:"宜春市",label:"宜春市",children:[{value:"袁州区",label:"袁州区"},{value:"奉新县",label:"奉新县"},{value:"万载县",label:"万载县"},{value:"上高县",label:"上高县"},{value:"宜丰县",label:"宜丰县"},{value:"靖安县",label:"靖安县"},{value:"铜鼓县",label:"铜鼓县"},{value:"丰城市",label:"丰城市"},{value:"樟树市",label:"樟树市"},{value:"高安市",label:"高安市"}]},{value:"抚州市",label:"抚州市",children:[{value:"临川区",label:"临川区"},{value:"南城县",label:"南城县"},{value:"黎川县",label:"黎川县"},{value:"南丰县",label:"南丰县"},{value:"崇仁县",label:"崇仁县"},{value:"乐安县",label:"乐安县"},{value:"宜黄县",label:"宜黄县"},{value:"金溪县",label:"金溪县"},{value:"资溪县",label:"资溪县"},{value:"东乡县",label:"东乡县"},{value:"广昌县",label:"广昌县"}]},{value:"上饶市",label:"上饶市",children:[{value:"信州区",label:"信州区"},{value:"上饶县",label:"上饶县"},{value:"广丰县",label:"广丰县"},{value:"玉山县",label:"玉山县"},{value:"铅山县",label:"铅山县"},{value:"横峰县",label:"横峰县"},{value:"弋阳县",label:"弋阳县"},{value:"余干县",label:"余干县"},{value:"鄱阳县",label:"鄱阳县"},{value:"万年县",label:"万年县"},{value:"婺源县",label:"婺源县"},{value:"德兴市",label:"德兴市"}]}]}]}}]);