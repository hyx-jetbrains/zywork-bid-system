(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21a053"],{ba75:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("Row",[a("i-col",{attrs:{span:"24"}},[a("Card",[a("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("add")}}},[e._v("添加")]),e._v(" \n\t\t\t\t"),a("Dropdown",{on:{"on-click":e.batchOpt}},[a("Button",{attrs:{type:"primary"}},[e._v("\n\t\t\t\t\t\t批量操作\n\t\t\t\t\t\t"),a("Icon",{attrs:{type:"ios-arrow-down"}})],1),a("DropdownMenu",{attrs:{slot:"list"},slot:"list"},[a("DropdownItem",{attrs:{name:"batchActive"}},[e._v("批量激活")]),a("DropdownItem",{attrs:{name:"batchInactive"}},[a("span",{staticStyle:{color:"red"}},[e._v("批量冻结")])]),a("DropdownItem",{attrs:{name:"batchRemove",divided:""}},[a("span",{staticStyle:{color:"red"}},[e._v("批量删除")])])],1)],1),e._v(" \n\t\t\t\t"),a("Button",{attrs:{type:"primary"},on:{click:function(t){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n\t\t\t\t"),a("Tooltip",{attrs:{content:"刷新",placement:"right"}},[a("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),a("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-selection-change":e.changeSelection,"on-sort-change":e.changeSort}}),a("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[a("div",{staticStyle:{float:"right"}},[a("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),a("Modal",{attrs:{title:"添加"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("addForm",t)}},model:{value:e.modal.add,callback:function(t){e.$set(e.modal,"add",t)},expression:"modal.add"}},[a("Form",{ref:"addForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[a("FormItem",{attrs:{label:"用户",prop:"userId"}},[a("span",{domProps:{textContent:e._s(e.form.userId)}}),a("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("userChoice")}}},[e._v("选择用户")]),e._v(" \n\t\t\t")],1),a("FormItem",{attrs:{label:"姓名",prop:"name"}},[a("Input",{attrs:{placeholder:"请输入姓名"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("FormItem",{attrs:{label:"性别",prop:"gender"}},[a("Select",{attrs:{placeholder:"请选择性别",clearable:"",filterable:""},model:{value:e.form.gender,callback:function(t){e.$set(e.form,"gender",t)},expression:"form.gender"}},e._l(e.genderList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"年龄",prop:"age"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入年龄"},model:{value:e.form.age,callback:function(t){e.$set(e.form,"age",t)},expression:"form.age"}})],1),a("FormItem",{attrs:{label:"求职类型",prop:"isFulltime"}},[a("Select",{attrs:{placeholder:"请选择求职类型",clearable:"",filterable:""},model:{value:e.form.isFulltime,callback:function(t){e.$set(e.form,"isFulltime",t)},expression:"form.isFulltime"}},e._l(e.jobTypeList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"求职岗位",prop:"jobTitle"}},[a("Input",{attrs:{placeholder:"请输入求职岗位"},model:{value:e.form.jobTitle,callback:function(t){e.$set(e.form,"jobTitle",t)},expression:"form.jobTitle"}})],1),a("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[a("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.form.workYear,callback:function(t){e.$set(e.form,"workYear",t)},expression:"form.workYear"}})],1),a("FormItem",{attrs:{label:"学历",prop:"education"}},[a("Select",{attrs:{placeholder:"请选择学历",clearable:"",filterable:""},model:{value:e.form.education,callback:function(t){e.$set(e.form,"education",t)},expression:"form.education"}},e._l(e.educationList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"要求薪资/月",prop:"salary"}},[a("Select",{attrs:{placeholder:"请选择要求薪资/月",clearable:"",filterable:""},model:{value:e.form.salary,callback:function(t){e.$set(e.form,"salary",t)},expression:"form.salary"}},e._l(e.salaryRangeList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"我的资质",prop:"aptitude"}},[a("Input",{attrs:{placeholder:"请输入我的资质"},model:{value:e.form.aptitude,callback:function(t){e.$set(e.form,"aptitude",t)},expression:"form.aptitude"}})],1),a("FormItem",{attrs:{label:"个人简介",prop:"intorduce"}},[a("Input",{attrs:{type:"textarea",autosize:e.descriptionAutoSize,placeholder:"请输入个人简介"},model:{value:e.form.intorduce,callback:function(t){e.$set(e.form,"intorduce",t)},expression:"form.intorduce"}})],1),a("FormItem",{attrs:{label:"是否允许平台推荐",prop:"isRecommend"}},[a("i-switch",{model:{value:e.isRecommend,callback:function(t){e.isRecommend=t},expression:"isRecommend"}},[a("Icon",{attrs:{slot:"open",type:"md-checkmark"},slot:"open"}),a("Icon",{attrs:{slot:"close",type:"md-close"},slot:"close"})],1)],1),a("FormItem",{attrs:{label:"是否开放简历",prop:"isShow"}},[a("i-switch",{model:{value:e.isShow,callback:function(t){e.isShow=t},expression:"isShow"}},[a("Icon",{attrs:{slot:"open",type:"md-checkmark"},slot:"open"}),a("Icon",{attrs:{slot:"close",type:"md-close"},slot:"close"})],1)],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("addForm","add")}}},[e._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:e.loading.add},on:{click:e.add}},[e._v("添加")])],1)],1),a("Modal",{attrs:{title:"修改"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.edit,callback:function(t){e.$set(e.modal,"edit",t)},expression:"modal.edit"}},[a("Form",{ref:"editForm",attrs:{model:e.form,"label-width":80,rules:e.validateRules}},[a("FormItem",{attrs:{label:"用户",prop:"userId"}},[a("span",{domProps:{textContent:e._s(e.form.userId)}}),a("Button",{attrs:{type:"text"},on:{click:function(t){e.showModal("userChoice")}}},[e._v("选择用户")]),e._v(" \n\t\t\t")],1),a("FormItem",{attrs:{label:"姓名",prop:"name"}},[a("Input",{attrs:{placeholder:"请输入姓名"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("FormItem",{attrs:{label:"性别",prop:"gender"}},[a("Select",{attrs:{placeholder:"请选择性别",clearable:"",filterable:""},model:{value:e.form.gender,callback:function(t){e.$set(e.form,"gender",t)},expression:"form.gender"}},e._l(e.genderList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"年龄",prop:"age"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入年龄"},model:{value:e.form.age,callback:function(t){e.$set(e.form,"age",t)},expression:"form.age"}})],1),a("FormItem",{attrs:{label:"求职类型",prop:"isFulltime"}},[a("Select",{attrs:{placeholder:"请选择求职类型",clearable:"",filterable:""},model:{value:e.form.isFulltime,callback:function(t){e.$set(e.form,"isFulltime",t)},expression:"form.isFulltime"}},e._l(e.jobTypeList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"求职岗位",prop:"jobTitle"}},[a("Input",{attrs:{placeholder:"请输入求职岗位"},model:{value:e.form.jobTitle,callback:function(t){e.$set(e.form,"jobTitle",t)},expression:"form.jobTitle"}})],1),a("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[a("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.form.workYear,callback:function(t){e.$set(e.form,"workYear",t)},expression:"form.workYear"}})],1),a("FormItem",{attrs:{label:"学历",prop:"education"}},[a("Select",{attrs:{placeholder:"请选择学历",clearable:"",filterable:""},model:{value:e.form.education,callback:function(t){e.$set(e.form,"education",t)},expression:"form.education"}},e._l(e.educationList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"要求薪资/月",prop:"salary"}},[a("Select",{attrs:{placeholder:"请选择要求薪资/月",clearable:"",filterable:""},model:{value:e.form.salary,callback:function(t){e.$set(e.form,"salary",t)},expression:"form.salary"}},e._l(e.salaryRangeList,function(t){return a("i-option",{key:t.key,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"我的资质",prop:"aptitude"}},[a("Input",{attrs:{placeholder:"请输入我的资质"},model:{value:e.form.aptitude,callback:function(t){e.$set(e.form,"aptitude",t)},expression:"form.aptitude"}})],1),a("FormItem",{attrs:{label:"个人简介",prop:"intorduce"}},[a("Input",{attrs:{type:"textarea",autosize:e.descriptionAutoSize,placeholder:"请输入个人简介"},model:{value:e.form.intorduce,callback:function(t){e.$set(e.form,"intorduce",t)},expression:"form.intorduce"}})],1),a("FormItem",{attrs:{label:"是否允许平台推荐",prop:"isRecommend"}},[a("i-switch",{model:{value:e.isRecommend,callback:function(t){e.isRecommend=t},expression:"isRecommend"}},[a("Icon",{attrs:{slot:"open",type:"md-checkmark"},slot:"open"}),a("Icon",{attrs:{slot:"close",type:"md-close"},slot:"close"})],1)],1),a("FormItem",{attrs:{label:"是否开放简历",prop:"isShow"}},[a("i-switch",{model:{value:e.isShow,callback:function(t){e.isShow=t},expression:"isShow"}},[a("Icon",{attrs:{slot:"open",type:"md-checkmark"},slot:"open"}),a("Icon",{attrs:{slot:"close",type:"md-close"},slot:"close"})],1)],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetFormCancelModal("editForm","edit")}}},[e._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:e.loading.edit},on:{click:e.edit}},[e._v("修改")])],1)],1),a("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(t){e.$set(e.modal,"search",t)},expression:"modal.search"}},[a("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[a("FormItem",{attrs:{label:"简历编号"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"idMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始简历编号"},model:{value:e.searchForm.idMin,callback:function(t){e.$set(e.searchForm,"idMin",t)},expression:"searchForm.idMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"idMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束简历编号"},model:{value:e.searchForm.idMax,callback:function(t){e.$set(e.searchForm,"idMax",t)},expression:"searchForm.idMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"用户编号"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"userIdMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始用户编号"},model:{value:e.searchForm.userIdMin,callback:function(t){e.$set(e.searchForm,"userIdMin",t)},expression:"searchForm.userIdMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"userIdMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束用户编号"},model:{value:e.searchForm.userIdMax,callback:function(t){e.$set(e.searchForm,"userIdMax",t)},expression:"searchForm.userIdMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"姓名",prop:"name"}},[a("Input",{attrs:{placeholder:"请输入姓名"},model:{value:e.searchForm.name,callback:function(t){e.$set(e.searchForm,"name",t)},expression:"searchForm.name"}})],1),a("FormItem",{attrs:{label:"性别",prop:"gender"}},[a("Input",{attrs:{placeholder:"请输入性别"},model:{value:e.searchForm.gender,callback:function(t){e.$set(e.searchForm,"gender",t)},expression:"searchForm.gender"}})],1),a("FormItem",{attrs:{label:"年龄"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"ageMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始年龄"},model:{value:e.searchForm.ageMin,callback:function(t){e.$set(e.searchForm,"ageMin",t)},expression:"searchForm.ageMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"ageMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束年龄"},model:{value:e.searchForm.ageMax,callback:function(t){e.$set(e.searchForm,"ageMax",t)},expression:"searchForm.ageMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"求职类型"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isFulltimeMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始求职类型"},model:{value:e.searchForm.isFulltimeMin,callback:function(t){e.$set(e.searchForm,"isFulltimeMin",t)},expression:"searchForm.isFulltimeMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isFulltimeMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束求职类型"},model:{value:e.searchForm.isFulltimeMax,callback:function(t){e.$set(e.searchForm,"isFulltimeMax",t)},expression:"searchForm.isFulltimeMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"求职岗位",prop:"jobTitle"}},[a("Input",{attrs:{placeholder:"请输入求职岗位"},model:{value:e.searchForm.jobTitle,callback:function(t){e.$set(e.searchForm,"jobTitle",t)},expression:"searchForm.jobTitle"}})],1),a("FormItem",{attrs:{label:"工作时间（年）",prop:"workYear"}},[a("Input",{attrs:{placeholder:"请输入工作时间（年）"},model:{value:e.searchForm.workYear,callback:function(t){e.$set(e.searchForm,"workYear",t)},expression:"searchForm.workYear"}})],1),a("FormItem",{attrs:{label:"学历",prop:"education"}},[a("Input",{attrs:{placeholder:"请输入学历"},model:{value:e.searchForm.education,callback:function(t){e.$set(e.searchForm,"education",t)},expression:"searchForm.education"}})],1),a("FormItem",{attrs:{label:"要求薪资/月",prop:"salary"}},[a("Input",{attrs:{placeholder:"请输入要求薪资/月"},model:{value:e.searchForm.salary,callback:function(t){e.$set(e.searchForm,"salary",t)},expression:"searchForm.salary"}})],1),a("FormItem",{attrs:{label:"是否允许平台推荐"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isRecommendMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否允许平台推荐"},model:{value:e.searchForm.isRecommendMin,callback:function(t){e.$set(e.searchForm,"isRecommendMin",t)},expression:"searchForm.isRecommendMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isRecommendMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否允许平台推荐"},model:{value:e.searchForm.isRecommendMax,callback:function(t){e.$set(e.searchForm,"isRecommendMax",t)},expression:"searchForm.isRecommendMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"我的资质",prop:"aptitude"}},[a("Input",{attrs:{placeholder:"请输入我的资质"},model:{value:e.searchForm.aptitude,callback:function(t){e.$set(e.searchForm,"aptitude",t)},expression:"searchForm.aptitude"}})],1),a("FormItem",{attrs:{label:"个人简介",prop:"intorduce"}},[a("Input",{attrs:{placeholder:"请输入个人简介"},model:{value:e.searchForm.intorduce,callback:function(t){e.$set(e.searchForm,"intorduce",t)},expression:"searchForm.intorduce"}})],1),a("FormItem",{attrs:{label:"是否开放简历"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isShowMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否开放简历"},model:{value:e.searchForm.isShowMin,callback:function(t){e.$set(e.searchForm,"isShowMin",t)},expression:"searchForm.isShowMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"isShowMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否开放简历"},model:{value:e.searchForm.isShowMax,callback:function(t){e.$set(e.searchForm,"isShowMax",t)},expression:"searchForm.isShowMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"是否激活",prop:"isActive"}},[a("Select",{attrs:{placeholder:"请选择是否激活",clearable:"",filterable:""},model:{value:e.searchForm.isActive,callback:function(t){e.$set(e.searchForm,"isActive",t)},expression:"searchForm.isActive"}},e._l(e.isActiveSelect,function(t){return a("i-option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),a("FormItem",{attrs:{label:"版本号"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"versionMin"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(t){e.$set(e.searchForm,"versionMin",t)},expression:"searchForm.versionMin"}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"versionMax"}},[a("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(t){e.$set(e.searchForm,"versionMax",t)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"创建时间"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"createTimeMin"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMin=t}}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"createTimeMax"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.createTimeMax=t}}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"更新时间"}},[a("Row",[a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"updateTimeMin"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMin=t}}})],1)],1),a("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("i-col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"updateTimeMax"}},[a("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(t){e.searchForm.updateTimeMax=t}}})],1)],1)],1)],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.resetForm("searchForm")}}},[e._v("清空")]),a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("search")}}},[e._v("取消")]),a("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(t){e.searchOkModal("search")}}},[e._v("搜索")])],1)],1),a("Modal",{attrs:{title:"详情"},on:{"on-visible-change":function(t){e.changeModalVisibleResetForm("editForm",t)}},model:{value:e.modal.detail,callback:function(t){e.$set(e.modal,"detail",t)},expression:"modal.detail"}},[a("p",[e._v("\n\t\t\t简历编号:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.id)}})]),a("p",[e._v("\n\t\t\t用户编号:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.userId)}})]),a("p",[e._v("\n\t\t\t姓名:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.name)}})]),a("p",[e._v("\n\t\t\t性别:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.gender)}})]),a("p",[e._v("\n\t\t\t年龄:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.age)}})]),a("p",[e._v("\n\t\t\t求职类型:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.isFulltime)}})]),a("p",[e._v("\n\t\t\t求职岗位:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.jobTitle)}})]),a("p",[e._v("\n\t\t\t工作时间（年）:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.workYear)}})]),a("p",[e._v("\n\t\t\t学历:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.education)}})]),a("p",[e._v("\n\t\t\t要求薪资/月:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.salary)}})]),a("p",[e._v("\n\t\t\t是否允许平台推荐:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.isRecommend)}})]),a("p",[e._v("\n\t\t\t我的资质:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.aptitude)}})]),a("p",[e._v("\n\t\t\t个人简介:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.intorduce)}})]),a("p",[e._v("\n\t\t\t是否开放简历:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.isShow)}})]),a("p",[e._v("\n\t\t\t版本号:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.version)}})]),a("p",[e._v("\n\t\t\t创建时间:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.createTime)}})]),a("p",[e._v("\n\t\t\t更新时间:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),a("p",[e._v("\n\t\t\t是否激活:\n\t\t\t"),a("span",{domProps:{textContent:e._s(e.form.isActive)}})])]),a("Modal",{attrs:{transfer:!1,title:"用户详情"},model:{value:e.modal.userDetail,callback:function(t){e.$set(e.modal,"userDetail",t)},expression:"modal.userDetail"}},[a("userDetail",{attrs:{form:e.userDetailForm},on:{setDetail:e.setDetailModal}})],1),a("Modal",{attrs:{transfer:!1,fullscreen:"",title:"搜索主表信息"},model:{value:e.modal.userDetalSearch,callback:function(t){e.$set(e.modal,"userDetalSearch",t)},expression:"modal.userDetalSearch"}},[a("user-list-single",{ref:"UserListSingle",on:{confirmSelection:e.confirmSelection}}),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("userDetalSearch")}}},[e._v("取消")]),a("Button",{attrs:{type:"primary",size:"large"},on:{click:e.confirm}},[e._v("确认选择")])],1)],1),a("Modal",{attrs:{transfer:!1,fullscreen:"",title:"选择用户"},model:{value:e.modal.userChoice,callback:function(t){e.$set(e.modal,"userChoice",t)},expression:"modal.userChoice"}},[a("user-list-choice",{ref:"UserListChoice",on:{confirmChoice:e.confirmChoice}}),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.cancelModal("userChoice")}}},[e._v("取消")])],1)],1)],1)},o=[],l=a("f499"),s=a.n(l),n=(a("386d"),a("f62d")),i=a("f36c"),c=a("27e5"),m=a("afcd"),u=a("816b"),d=a("1a21"),p=a("c24f"),h={name:"Resume",components:{userDetail:m["a"],UserListSingle:i["a"],UserListChoice:c["a"]},data:function(){var e=this;return{userDetailForm:{userId:null,userPhone:null,userEmail:null,userCreateTime:null,userDetailNickname:null,userDetailHeadicon:null,userDetailGender:null,userDetailBirthday:null,userDetailAge:null,userDetailQq:null,userDetailQqQrcode:null,userDetailWechat:null,userDetailWechatQrcode:null,userDetailAlipay:null,userDetailAlipayQrcode:null,userDetailShareCode:null,userDetailVersion:null},modal:{add:!1,edit:!1,search:!1,detail:!1,userDetail:!1,userDetalSearch:!1,userChoice:!1},loading:{add:!1,edit:!1,search:!1},urls:{addUrl:"/resume/admin/save",batchAddUrl:"/resume/admin/batch-save",editUrl:"/resume/admin/update",batchEditUrl:"/resume/admin/batch-update",searchUrl:"/resume/admin/pager-cond",allUrl:"/resume/admin/all",removeUrl:"/resume/admin/remove/",batchRemoveUrl:"/resume/admin/batch-remove",detailUrl:"/resume/admin/one/",activeUrl:"/resume/admin/active",batchActiveUrl:"/resume/admin/batch-active"},page:{total:0},form:{id:null,userId:null,name:null,gender:null,age:null,isFulltime:null,jobTitle:null,workYear:null,education:null,salary:null,isRecommend:null,aptitude:null,intorduce:null,isShow:null,version:null,createTime:null,updateTime:null,isActive:null},validateRules:{name:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],jobTitle:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],workYear:[{type:"string",min:1,max:10,message:"必须1-10个字符",trigger:"blur"}],education:[{type:"string",min:1,max:10,message:"必须1-10个字符",trigger:"blur"}],salary:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],aptitude:[{type:"string",min:1,max:20,message:"必须1-20个字符",trigger:"blur"}],intorduce:[{type:"string",min:1,max:255,message:"必须1-255个字符",trigger:"blur"}]},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,userId:null,userIdMin:null,userIdMax:null,name:null,gender:null,age:null,ageMin:null,ageMax:null,isFulltime:null,isFulltimeMin:null,isFulltimeMax:null,jobTitle:null,workYear:null,education:null,salary:null,isRecommend:null,isRecommendMin:null,isRecommendMax:null,aptitude:null,intorduce:null,isShow:null,isShowMin:null,isShowMax:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{type:"selection",width:45,key:"id",align:"center",fixed:"left"},{width:60,align:"center",fixed:"left",render:function(t,a){return t("span",a.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"简历编号",key:"id",minWidth:120,sortable:!0},{title:"用户编号",key:"userId",minWidth:120,sortable:!0,render:function(t,a){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,a.row)}},props:{transfer:!0}},[t("span",[a.row.userId,t("Icon",{props:{type:"ios-list",size:"25"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"moduleDetail"}},"详情"),t("DropdownItem",{props:{name:"showSearch"}},"搜索")])])}},{title:"姓名",key:"name",minWidth:120,sortable:!0},{title:"性别",key:"gender",minWidth:120,sortable:!0,render:function(e,t){var a=t.row,r="1"==a.gender?"男":"2"==a.gender?"女":"未知";return e("span",{},r)}},{title:"年龄",key:"age",minWidth:120,sortable:!0},{title:"求职类型",key:"isFulltime",minWidth:120,sortable:!0,render:function(e,t){var a=null;return 0==t.row.isFulltime?a="全职":1==t.row.isFulltime&&(a="兼职"),e("span",a)}},{title:"求职岗位",key:"jobTitle",minWidth:150,sortable:!0},{title:"工作时间（年）",key:"workYear",minWidth:150,sortable:!0},{title:"学历",key:"education",minWidth:120,sortable:!0},{title:"要求薪资/月",key:"salary",minWidth:120,sortable:!0},{title:"是否允许平台推荐",key:"isRecommend",minWidth:180,sortable:!0,render:function(t,a){return t("i-switch",{props:{size:"large",value:0===a.row.isRecommend},style:{marginRight:"5px"},on:{"on-change":function(t){e.setIsRecommend(a.row)}}},[t("span",{slot:"open"},"是"),t("span",{slot:"close"},"否")])}},{title:"我的资质",key:"aptitude",minWidth:160,sortable:!0},{title:"个人简介",key:"intorduce",minWidth:180,sortable:!0},{title:"是否开放简历",key:"isShow",minWidth:150,sortable:!0,render:function(t,a){return t("i-switch",{props:{size:"large",value:0===a.row.isShow},style:{marginRight:"5px"},on:{"on-change":function(t){e.setIsShow(a.row)}}},[t("span",{slot:"open"},"是"),t("span",{slot:"close"},"否")])}},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:150,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:150,sortable:!0},{title:"激活状态",key:"isActive",minWidth:100,align:"center",render:function(t,a){return t("i-switch",{props:{size:"large",value:0===a.row.isActive},style:{marginRight:"5px"},on:{"on-change":function(t){e.active(a.row)}}},[t("span",{slot:"open"},"激活"),t("span",{slot:"close"},"冻结")])}},{title:"操作",key:"action",width:120,align:"center",fixed:"right",render:function(t,a){return t("Dropdown",{on:{"on-click":function(t){e.userOpt(t,a.row)}},props:{transfer:!0}},[t("Button",{props:{type:"primary",size:"small"}},["选择操作 ",t("Icon",{props:{type:"ios-arrow-down"}})]),t("DropdownMenu",{slot:"list"},[t("DropdownItem",{props:{name:"showEdit"}},"编辑"),t("DropdownItem",{props:{name:"showDetail"}},"详情"),t("DropdownItem",{props:{name:"remove"}},[t("span",{style:{color:"red"}},"删除")])])])}}],tableDetails:[],selections:[]},isActiveSelect:d["s"],genderList:d["o"],jobTypeList:d["w"],educationList:d["m"],salaryRangeList:d["L"],descriptionAutoSize:{minRows:3,maxRows:5},isRecommend:!1,isShow:!1}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){"add"===e&&(this.isShow=!1,this.isRecommend=!1,this.form.gender=this.genderList[0].value,this.form.isFulltime=this.jobTypeList[0].value,this.form.education=this.educationList[0].value,this.form.salary=this.salaryRangeList[0].value),n["B"](this,e)},changeModalVisibleResetForm:function(e,t){t||n["z"](this,e)},resetForm:function(e){n["z"](this,e)},cancelModal:function(e){n["h"](this,e)},resetFormCancelModal:function(e,t){n["h"](this,t),n["z"](this,e)},searchOkModal:function(e){n["h"](this,e),this.searchForm.pageNo=1,n["A"](this)},batchOpt:function(e){"batchActive"===e?n["f"](this,0):"batchInactive"===e?n["f"](this,1):"batchRemove"===e&&n["g"](this)},setSwitchData:function(e){0===e.isRecommend?this.isRecommend=!0:this.isRecommend=!1,0===e.isShow?this.isShow=!0:this.isShow=!1},userOpt:function(e,t){"showEdit"===e?(n["B"](this,"edit"),this.form=JSON.parse(s()(t)),this.setSwitchData(t)):"showDetail"===e?(n["B"](this,"detail"),this.form=JSON.parse(s()(t))):"remove"===e?n["y"](this,t):"moduleDetail"===e?this.showUserDetailModal(t.userId):"showSearch"===e&&n["B"](this,"userDetalSearch")},showUserDetailModal:function(e){var t=this;Object(u["j"])(e).then(function(e){var a=e.data;1001===a.code?(t.userDetailForm=a.data.rows[0],t.modal.userDetail=!0):t.$Message.error(a.message)}).catch(function(e){t.$Message.error(e)})},setDetailModal:function(e){this.modal.userDetail=e},confirmSelection:function(e){this.modal.userDetalSearch=!1,this.searchForm.userIdMin=e,this.searchForm.userIdMax=e,n["A"](this)},confirm:function(){this.$refs.UserListSingle.confirmSelection()},setSwitch:function(){this.isRecommend?this.form.isRecommend=0:this.form.isRecommend=1,this.isShow?this.form.isShow=0:this.form.isShow=1},add:function(){this.setSwitch(),n["c"](this)},edit:function(){this.setSwitch(),n["q"](this)},active:function(e){n["b"](this,e)},search:function(){n["A"](this)},changeSelection:function(e){n["o"](this,e)},changeSort:function(e){n["p"](this,e)},changePageNo:function(e){n["j"](this,e)},changePageSize:function(e){n["k"](this,e)},confirmChoice:function(e){this.form.userId=e,this.cancelModal("userChoice")},setIsShow:function(e){Object(p["setResumeIsShow"])(this,e)},setIsRecommend:function(e){Object(p["setResumeIsRecommend"])(this,e)}}},f=h,b=a("2877"),v=Object(b["a"])(f,r,o,!1,null,null,null);t["default"]=v.exports}}]);