(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2a40cec8"],{"05a1":function(e,a,l){"use strict";var t=function(){var e=this,a=e.$createElement,l=e._self._c||a;return l("div",[l("Row",[l("i-col",{attrs:{span:"24"}},[l("Card",[l("Button",{attrs:{type:"primary"},on:{click:e.confirmSelection}},[e._v("确认选择")]),e._v(" \n          "),l("Button",{attrs:{type:"primary"},on:{click:function(a){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n          "),l("Tooltip",{attrs:{content:"刷新",placement:"right"}},[l("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),l("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{"highlight-row":"",stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-current-change":e.changeCurrent,"on-sort-change":e.changeSort}}),l("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[l("div",{staticStyle:{float:"right"}},[l("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),l("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(a){e.$set(e.modal,"search",a)},expression:"modal.search"}},[l("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[l("FormItem",{attrs:{label:"专家问题分类编号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始专家问题分类编号"},model:{value:e.searchForm.idMin,callback:function(a){e.$set(e.searchForm,"idMin",a)},expression:"searchForm.idMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束专家问题分类编号"},model:{value:e.searchForm.idMax,callback:function(a){e.$set(e.searchForm,"idMax",a)},expression:"searchForm.idMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"类别名称",prop:"name"}},[l("Input",{attrs:{placeholder:"请输入类别名称"},model:{value:e.searchForm.name,callback:function(a){e.$set(e.searchForm,"name",a)},expression:"searchForm.name"}})],1),l("FormItem",{attrs:{label:"备注",prop:"memo"}},[l("Input",{attrs:{placeholder:"请输入备注"},model:{value:e.searchForm.memo,callback:function(a){e.$set(e.searchForm,"memo",a)},expression:"searchForm.memo"}})],1),l("FormItem",{attrs:{label:"版本号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"versionMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始版本号"},model:{value:e.searchForm.versionMin,callback:function(a){e.$set(e.searchForm,"versionMin",a)},expression:"searchForm.versionMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"versionMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束版本号"},model:{value:e.searchForm.versionMax,callback:function(a){e.$set(e.searchForm,"versionMax",a)},expression:"searchForm.versionMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"创建时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,placeholder:"请输入开始创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.createTimeMin=a}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,placeholder:"请输入结束创建时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.createTimeMax=a}}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"更新时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,placeholder:"请输入开始更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.updateTimeMin=a}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,placeholder:"请输入结束更新时间",type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.updateTimeMax=a}}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"是否激活"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"isActiveMin"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入开始是否激活"},model:{value:e.searchForm.isActiveMin,callback:function(a){e.$set(e.searchForm,"isActiveMin",a)},expression:"searchForm.isActiveMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"isActiveMax"}},[l("InputNumber",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入结束是否激活"},model:{value:e.searchForm.isActiveMax,callback:function(a){e.$set(e.searchForm,"isActiveMax",a)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(a){e.resetForm("searchForm")}}},[e._v("清空")]),l("Button",{attrs:{type:"text",size:"large"},on:{click:function(a){e.cancelModal("search")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large",loading:e.loading.search},on:{click:function(a){e.searchOkModal("search")}}},[e._v("确定")])],1)],1),l("Modal",{attrs:{title:"详情"},model:{value:e.modal.detail,callback:function(a){e.$set(e.modal,"detail",a)},expression:"modal.detail"}},[l("p",[e._v("专家问题分类编号: "),l("span",{domProps:{textContent:e._s(e.form.id)}})]),l("p",[e._v("类别名称: "),l("span",{domProps:{textContent:e._s(e.form.name)}})]),l("p",[e._v("备注: "),l("span",{domProps:{textContent:e._s(e.form.memo)}})]),l("p",[e._v("版本号: "),l("span",{domProps:{textContent:e._s(e.form.version)}})]),l("p",[e._v("创建时间: "),l("span",{domProps:{textContent:e._s(e.form.createTime)}})]),l("p",[e._v("更新时间: "),l("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),l("p",[e._v("是否激活: "),l("span",{domProps:{textContent:e._s(e.form.isActive)}})])])],1)},n=[],r=(l("386d"),l("f62d")),o={name:"ExpertQuestionTypeListSingle",data:function(){var e=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1},loading:{search:!1},urls:{searchUrl:"/experquestion-type/admin/pager-cond",allUrl:"/experquestion-type/admin/all",detailUrl:"/experquestion-type/admin/one/"},page:{total:0},form:{id:null,name:null,memo:null,version:null,createTime:null,updateTime:null,isActive:null},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,name:null,memo:null,version:null,versionMin:null,versionMax:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{width:60,align:"center",fixed:"left",render:function(a,l){return a("span",l.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"专家问题分类编号",key:"id",minWidth:120,sortable:!0},{title:"类别名称",key:"name",minWidth:120,sortable:!0},{title:"备注",key:"memo",minWidth:120,sortable:!0},{title:"版本号",key:"version",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:120,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:120,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"操作",key:"action",width:80,align:"center",fixed:"right",render:function(a,l){return a("div",[a("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.showDetail("detail",l.row)}}},"详情")])}}],tableDetails:[],currentRow:{}}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){r["B"](this,e)},showDetail:function(e,a){r["B"](this,e),this.form=a},changeModalVisibleResetForm:function(e,a){a||r["z"](this,e)},resetForm:function(e){r["z"](this,e)},cancelModal:function(e){r["h"](this,e)},resetFormCancelModal:function(e,a){r["h"](this,a),r["z"](this,e)},searchOkModal:function(e){r["h"](this,e),this.searchForm.pageNo=1,r["A"](this)},search:function(){r["A"](this)},changeCurrent:function(e,a){r["i"](this,e,a)},changeSort:function(e){r["p"](this,e)},changePageNo:function(e){r["j"](this,e)},changePageSize:function(e){r["k"](this,e)},confirmSelection:function(){this.$emit("confirmExpertQuestionSelection",this.table.currentRow.id)}}},i=o,u=l("2877"),s=Object(u["a"])(i,t,n,!1,null,null,null);a["a"]=s.exports},"1a21":function(e,a,l){"use strict";l.d(a,"r",function(){return t}),l.d(a,"s",function(){return n}),l.d(a,"u",function(){return r}),l.d(a,"C",function(){return o}),l.d(a,"t",function(){return i}),l.d(a,"A",function(){return u}),l.d(a,"z",function(){return s}),l.d(a,"G",function(){return c}),l.d(a,"h",function(){return m}),l.d(a,"q",function(){return v}),l.d(a,"y",function(){return d}),l.d(a,"H",function(){return p}),l.d(a,"B",function(){return b}),l.d(a,"o",function(){return h}),l.d(a,"f",function(){return f}),l.d(a,"c",function(){return y}),l.d(a,"e",function(){return g}),l.d(a,"d",function(){return x}),l.d(a,"I",function(){return F}),l.d(a,"a",function(){return M}),l.d(a,"i",function(){return _}),l.d(a,"j",function(){return w}),l.d(a,"b",function(){return T}),l.d(a,"v",function(){return k}),l.d(a,"m",function(){return P}),l.d(a,"J",function(){return S}),l.d(a,"k",function(){return I}),l.d(a,"L",function(){return C}),l.d(a,"n",function(){return A}),l.d(a,"g",function(){return $}),l.d(a,"p",function(){return D}),l.d(a,"l",function(){return z}),l.d(a,"F",function(){return j}),l.d(a,"E",function(){return N}),l.d(a,"D",function(){return E});var t=[{value:0,label:"激活"},{value:1,label:"冻结"}],n=[{value:1,label:"是"},{value:0,label:"否"}],r=[{value:0,label:"未启动"},{value:1,label:"运行中"},{value:2,label:"已停止"},{value:3,label:"已暂停"},{value:4,label:"已删除"}],o=[{value:"房建市政",label:"房建市政"},{value:"水利工程",label:"水利工程"},{value:"交通工程",label:"交通工程"},{value:"政府采购",label:"政府采购"},{value:"重点工程",label:"重点工程"},{value:"其他项目",label:"其他项目"}],i=[{value:0,label:"非电子"},{value:1,label:"电子"}],u=[{value:"待审核",label:"待审核"},{value:"已发布",label:"已发布"}],s=[{value:"公告中",label:"公告中"},{value:"待开标",label:"待开标"},{value:"已开标",label:"已开标"}],c=[{value:0,label:"省内"},{value:1,label:"省外"}],m=[{value:"1",label:"代理机构"},{value:"3",label:"投标人"}],v={1:[{value:"181",label:"房建招标代理"},{value:"182",label:"交通招标代理"},{value:"183",label:"水利招标代理"}],3:[{value:"131",label:"房建及市政施工单位"},{value:"132",label:"交通施工单位"},{value:"133",label:"水利施工单位"},{value:"135",label:"重点工程投标单位"},{value:"143",label:"水利监理单位"},{value:"163",label:"水利勘查设计单位"}]},d=[{value:"南昌市",label:"南昌市"},{value:"景德镇市",label:"景德镇市"},{value:"萍乡市",label:"萍乡市"},{value:"九江市",label:"九江市"},{value:"新余市",label:"新余市"},{value:"鹰潭市",label:"鹰潭市"},{value:"赣州市",label:"赣州市"},{value:"吉安市",label:"吉安市"},{value:"宜春市",label:"宜春市"},{value:"抚州市",label:"抚州市"},{value:"上饶市",label:"上饶市"}],p=[{value:"Image",label:"图片"},{value:"Document",label:"文档"},{value:"Video",label:"视频"},{value:"Audio",label:"音频"}],b=[{value:0,label:"资审文件"},{value:1,label:"招标文件"},{value:2,label:"清单文件"},{value:3,label:"控股价文件"},{value:4,label:"澄清答疑文件"}],h=[{value:0,label:"未知"},{value:1,label:"男"},{value:2,label:"女"}],f=[{value:"一级建造师",label:"一级建造师"},{value:"二级建造师",label:"二级建造师"},{value:"造价工程师",label:"造价工程师"},{value:"技工证",label:"技工证"},{value:"结构工程师",label:"结构工程师"},{value:"建筑师",label:"建筑师"},{value:"监理工程师",label:"监理工程师"},{value:"注册咨询师",label:"注册咨询师"},{value:"电气工程师",label:"电气工程师"},{value:"公用设备工程师",label:"公用设备工程师"},{value:"土木工程师",label:"土木工程师"},{value:"职称证书",label:"职称证书"},{value:"中级职称证书",label:"中级职称证书"},{value:"高级职称证书",label:"高级职称证书"},{value:"八大员",label:"八大员"},{value:"其他证书",label:"其他证书"}],y={"一级建造师":[{value:"建筑工程",label:"建筑工程"},{value:"机电工程",label:"机电工程"},{value:"市政公用",label:"市政公用"},{value:"公路工程",label:"公路工程"},{value:"铁路工程",label:"铁路工程"},{value:"水利水电",label:"水利水电"},{value:"民航机场",label:"民航机场"},{value:"通信与广电",label:"通信与广电"}],"二级建造师":[{value:"建筑工程",label:"建筑工程"},{value:"机电工程",label:"机电工程"},{value:"水利水电工程",label:"水利水电工程"},{value:"公路工程",label:"公路工程"},{value:"矿业工程",label:"矿业工程"},{value:"市政公用工程",label:"市政公用工程"}],"造价工程师":[{value:"建设部",label:"建设部"},{value:"交通部",label:"交通部"},{value:"水利部",label:"水利部"}],"技工证":[{value:"初级技工证",label:"初级技工证"},{value:"中级技工证",label:"中级技工证"},{value:"高级技工证",label:"高级技工证"}],"结构工程师":[{value:"一级结构师",label:"一级结构师"},{value:"二级结构师",label:"二级结构师"}],"建筑师":[{value:"一级建筑师",label:"一级建筑师"},{value:"二级建筑师",label:"二级建筑师"}],"监理工程师":[],"注册咨询师":[{value:"环境工程和生态建设",label:"环境工程和生态建设"},{value:"市政公用工程",label:"市政公用工程"},{value:"其他",label:"其他"},{value:"公路/铁路/民航",label:"公路/铁路/民航"},{value:"城市轨道交通",label:"城市轨道交通"},{value:"水电/核电/火电",label:"水电/核电/火电"},{value:"煤炭/石化",label:"煤炭/石化"},{value:"石油天然气",label:"石油天然气"},{value:"化工、医药",label:"化工、医药"},{value:"建筑/建筑材料",label:"建筑/建筑材料"},{value:"机械/电子",label:"机械/电子"},{value:"轻工/纺织、化纤",label:"轻工/纺织、化纤"},{value:"钢铁/有色冶金",label:"钢铁/有色冶金"},{value:"农业/林业",label:"农业/林业"},{value:"通信/广播电影电视",label:"通信/广播电影电视"},{value:"地质/测量/岩土工程",label:"地质/测量/岩土工程"},{value:"港口河海工程",label:"港口河海工程"},{value:"城市规划",label:"城市规划"},{value:"综合经济",label:"综合经济"}],"电气工程师":[{value:"供配电",label:"供配电"},{value:"发输变电",label:"发输变电"}],"公用设备工程师":[{value:"暖通空调",label:"暖通空调"},{value:"动力",label:"动力"},{value:"给水排水",label:"给水排水"}],"土木工程师":[{value:"注册岩土",label:"注册岩土"},{value:"港口航道",label:"港口航道"},{value:"水利水电",label:"水利水电"}],"职称证书":[{value:"工民建",label:"工民建"},{value:"建筑工程/土建/房建",label:"建筑工程/土建/房建"},{value:"园林设计师",label:"园林设计师"},{value:"其他",label:"其他"},{value:"结构",label:"结构"},{value:"暖通空调/热处理",label:"暖通空调/热处理"},{value:"设计类",label:"设计类"},{value:"市政/公路/机电",label:"市政/公路/机电"},{value:"土建/造价/概预算",label:"土建/造价/概预算"},{value:"土木工程/道路桥梁",label:"土木工程/道路桥梁"},{value:"经济师专业类",label:"经济师专业类"},{value:"电气",label:"电气"},{value:"船舶/冷冻类",label:"船舶/冷冻类"},{value:"计算机系统集成",label:"计算机系统集成"},{value:"建筑设计类",label:"建筑设计类"},{value:"园林绿化",label:"园林绿化"},{value:"暖通",label:"暖通"},{value:"给排水",label:"给排水"},{value:"化工",label:"化工"},{value:"燃气",label:"燃气"},{value:"机械设备/机械",label:"机械设备/机械"},{value:"电子",label:"电子"},{value:"通信",label:"通信"},{value:"水利水电",label:"水利水电"},{value:"电力/热能动力",label:"电力/热能动力"},{value:"岩土",label:"岩土"},{value:"能源工程",label:"能源工程"},{value:"环保/规划",label:"环保/规划"},{value:"焊接",label:"焊接"},{value:"会计",label:"会计"},{value:"环境工程",label:"环境工程"},{value:"总图",label:"总图"},{value:"测量/测绘",label:"测量/测绘"},{value:"防护防化",label:"防护防化"},{value:"通风",label:"通风"}],"中级职称证书":[{value:"工民建",label:"工民建"},{value:"建筑工程/土建/房建",label:"建筑工程/土建/房建"},{value:"园林设计师",label:"园林设计师"},{value:"其他",label:"其他"},{value:"结构",label:"结构"},{value:"暖通空调/热处理",label:"暖通空调/热处理"},{value:"设计类",label:"设计类"},{value:"市政/公路/机电",label:"市政/公路/机电"},{value:"土建/造价/概预算",label:"土建/造价/概预算"},{value:"土木工程/道路桥梁",label:"土木工程/道路桥梁"},{value:"经济师专业类",label:"经济师专业类"},{value:"电气",label:"电气"},{value:"船舶/冷冻类",label:"船舶/冷冻类"},{value:"计算机系统集成",label:"计算机系统集成"},{value:"建筑设计类",label:"建筑设计类"},{value:"园林绿化",label:"园林绿化"},{value:"暖通",label:"暖通"},{value:"给排水",label:"给排水"},{value:"化工",label:"化工"},{value:"燃气",label:"燃气"},{value:"机械设备/机械",label:"机械设备/机械"},{value:"电子",label:"电子"},{value:"通信",label:"通信"},{value:"水利水电",label:"水利水电"},{value:"电力/热能动力",label:"电力/热能动力"},{value:"岩土",label:"岩土"},{value:"能源工程",label:"能源工程"},{value:"环保/规划",label:"环保/规划"},{value:"焊接",label:"焊接"},{value:"会计",label:"会计"},{value:"环境工程",label:"环境工程"},{value:"总图",label:"总图"},{value:"测量/测绘",label:"测量/测绘"},{value:"防护防化",label:"防护防化"},{value:"通风",label:"通风"}],"高级职称证书":[{value:"工民建",label:"工民建"},{value:"建筑工程/土建/房建",label:"建筑工程/土建/房建"},{value:"园林设计师",label:"园林设计师"},{value:"其他",label:"其他"},{value:"结构",label:"结构"},{value:"暖通空调/热处理",label:"暖通空调/热处理"},{value:"设计类",label:"设计类"},{value:"市政/公路/机电",label:"市政/公路/机电"},{value:"土建/造价/概预算",label:"土建/造价/概预算"},{value:"土木工程/道路桥梁",label:"土木工程/道路桥梁"},{value:"经济师专业类",label:"经济师专业类"},{value:"电气",label:"电气"},{value:"船舶/冷冻类",label:"船舶/冷冻类"},{value:"计算机系统集成",label:"计算机系统集成"},{value:"建筑设计类",label:"建筑设计类"},{value:"园林绿化",label:"园林绿化"},{value:"暖通",label:"暖通"},{value:"给排水",label:"给排水"},{value:"化工",label:"化工"},{value:"燃气",label:"燃气"},{value:"机械设备/机械",label:"机械设备/机械"},{value:"电子",label:"电子"},{value:"通信",label:"通信"},{value:"水利水电",label:"水利水电"},{value:"电力/热能动力",label:"电力/热能动力"},{value:"岩土",label:"岩土"},{value:"能源工程",label:"能源工程"},{value:"环保/规划",label:"环保/规划"},{value:"焊接",label:"焊接"},{value:"会计",label:"会计"},{value:"环境工程",label:"环境工程"},{value:"总图",label:"总图"},{value:"测量/测绘",label:"测量/测绘"},{value:"防护防化",label:"防护防化"},{value:"通风",label:"通风"}],"八大员":[{value:"通信",label:"通信"},{value:"施工员",label:"施工员"},{value:"质量员",label:"质量员"},{value:"安全员",label:"安全员"},{value:"机械员",label:"机械员"},{value:"造价员",label:"造价员"},{value:"劳务员",label:"劳务员"},{value:"材料员",label:"材料员"},{value:"资料员",label:"资料员"}],"其他证书":[]},g=[{value:"闲置中",label:"闲置中"},{value:"合同快到期",label:"合同快到期"}],x=[{value:"初始",label:"初始"},{value:"转注",label:"转注"}],F=[{value:"一万元以下",label:"一万元以下"},{value:"1-2万元",label:"1-2万元"},{value:"2-3万元",label:"2-3万元"},{value:"3-5万元",label:"3-5万元"},{value:"5-10万元",label:"5-10万元"},{value:"10-15万元",label:"10-15万元"},{value:"15万元以上",label:"15万元以上"}],M=[{value:0,label:"购买"},{value:1,label:"转让"}],_=[{value:"一级",label:"一级"},{value:"二级",label:"二级"},{value:"三级",label:"三级"}],w=[{value:"房建市政",label:"房建市政"},{value:"水利工程",label:"水利工程"},{value:"交通工程",label:"交通工程"},{value:"政府采购",label:"政府采购"},{value:"重点工程",label:"其他项目"}],T=[{value:"小轿车",label:"小轿车"},{value:"suv",label:"suv"},{value:"面包车",label:"面包车"},{value:"越野车",label:"越野车"},{value:"班车",label:"班车"}],k=[{value:0,label:"全职"},{value:1,label:"兼职"}],P=[{value:"不限",label:"不限"},{value:"大专",label:"大专"},{value:"本科",label:"本科"},{value:"硕士",label:"硕士"},{value:"博士",label:"博士"}],S=[{value:"资料",label:"资料"},{value:"文件夹",label:"文件夹"},{value:"物品",label:"物品"},{value:"包裹",label:"包裹"},{value:"重要证件",label:"重要证件"}],I=[{value:0,label:"待使用"},{value:1,label:"已使用"}],C=[{value:"验证不通过",label:"验证不通过"},{value:"验证通过",label:"验证通过"}],A=[{value:0,label:"审核中"},{value:1,label:"审核通过"},{value:2,label:"审核不通过"}],$=[{value:"资格后审",label:"资格后审"}],D=[{value:"赣州智悦网络科技有限公司",label:"赣州智悦网络科技有限公司"}],z=[{value:"充值VIP",label:"充值VIP"}],j=[{value:"招聘中",label:"招聘中"},{value:"已停止",label:"已停止"}],N=[{value:"project/house",label:"房建市政"},{value:"project/conservancy",label:"水利工程"},{value:"project/traffic",label:"交通工程"},{value:"project/procurement",label:"政府采购"},{value:"project/key",label:"重点项目"},{value:"project/other",label:"其他项目"}],E=[{value:"project-announce/house",label:"房建市政公示"},{value:"project-announce/conservancy",label:"水利工程公示"},{value:"project-announce/traffic",label:"交通工程公示"},{value:"project-announce/procurement",label:"政府采购公示"},{value:"project-announce/key",label:"重点项目公示"},{value:"project-announce/other",label:"其他项目公示"}]},"386d":function(e,a,l){l("214f")("search",1,function(e,a,l){return[function(l){"use strict";var t=e(this),n=void 0==l?void 0:l[a];return void 0!==n?n.call(l,t):new RegExp(l)[a](String(t))},l]})},"816b":function(e,a,l){"use strict";l.d(a,"a",function(){return n}),l.d(a,"g",function(){return r}),l.d(a,"j",function(){return o}),l.d(a,"h",function(){return i}),l.d(a,"e",function(){return u}),l.d(a,"d",function(){return s}),l.d(a,"c",function(){return c}),l.d(a,"b",function(){return m}),l.d(a,"f",function(){return v}),l.d(a,"k",function(){return d}),l.d(a,"i",function(){return p});var t=l("66df"),n=function(){return t["a"].request({url:"/module/admin/all",method:"GET",data:""})},r=function(e){return t["a"].request({url:"/module/admin/one/"+e,method:"GET",data:""})},o=function(e){return t["a"].request({url:"/user-userdetail/admin/multi/"+e,method:"GET",data:""})},i=function(e){return t["a"].request({url:"/project/admin/one/"+e,method:"GET",data:""})},u=function(e){return t["a"].request({url:"/coupon/admin/one/"+e,method:"GET",data:""})},s=function(e){return t["a"].request({url:"/company/admin/one/"+e,method:"GET",data:""})},c=function(e){return t["a"].request({url:"/builder/admin/one/"+e,method:"GET",data:""})},m=function(e){return t["a"].request({url:"/aptitude-transfer/admin/one/"+e,method:"GET",data:""})},v=function(e){return t["a"].request({url:"/experquestion-type/admin/one/"+e,method:"GET",data:""})},d=function(e){return t["a"].request({url:"/user-expert/admin/one/"+e,method:"GET",data:""})},p=function(e){return t["a"].request({url:"/service/admin/one/"+e,method:"GET",data:""})}},afcd:function(e,a,l){"use strict";var t=function(){var e=this,a=e.$createElement,l=e._self._c||a;return l("div",[l("p",[e._v("用户编号: "),l("span",{domProps:{textContent:e._s(e.form.userId)}})]),l("p",[e._v("手机号: "),l("span",{domProps:{textContent:e._s(e.form.userPhone)}})]),l("p",[e._v("用户邮箱: "),l("span",{domProps:{textContent:e._s(e.form.userEmail)}})]),l("p",[e._v("创建时间: "),l("span",{domProps:{textContent:e._s(e.form.userCreateTime)}})]),l("p",[e._v("昵称: "),l("span",{domProps:{textContent:e._s(e.form.userDetailNickname)}})]),l("p",[e._v("头像地址: "),l("span",{domProps:{textContent:e._s(e.form.userDetailHeadicon)}})]),l("p",[e._v("性别: "),l("span",{domProps:{textContent:e._s(e.form.userDetailGender)}})]),l("p",[e._v("生日: "),l("span",{domProps:{textContent:e._s(e.form.userDetailBirthday)}})]),l("p",[e._v("年龄: "),l("span",{domProps:{textContent:e._s(e.form.userDetailAge)}})]),l("p",[e._v("QQ号: "),l("span",{domProps:{textContent:e._s(e.form.userDetailQq)}})]),l("p",[e._v("QQ二维码: "),l("span",{domProps:{textContent:e._s(e.form.userDetailQqQrcode)}})]),l("p",[e._v("微信号: "),l("span",{domProps:{textContent:e._s(e.form.userDetailWechat)}})]),l("p",[e._v("微信二维码: "),l("span",{domProps:{textContent:e._s(e.form.userDetailWechatQrcode)}})]),l("p",[e._v("支付宝账号: "),l("span",{domProps:{textContent:e._s(e.form.userDetailAlipay)}})]),l("p",[e._v("支付宝二维码: "),l("span",{domProps:{textContent:e._s(e.form.userDetailAlipayQrcode)}})]),l("p",[e._v("分享码: "),l("span",{domProps:{textContent:e._s(e.form.userDetailShareCode)}})])])},n=[],r={name:"UserViewModal",props:{form:Object,detail:!1},data:function(){return{}},computed:{},mounted:function(){},methods:{}},o=r,i=l("2877"),u=Object(i["a"])(o,t,n,!1,null,null,null);a["a"]=u.exports},b1fd:function(e,a,l){"use strict";l.d(a,"a",function(){return u}),l.d(a,"b",function(){return s});l("386d");var t=l("795b"),n=l.n(t),r=l("66df"),o=(l("19de"),l("2e19")),i=l("f62d"),u=function(e){return new n.a(function(a,l){e.$refs["replayForm"].validate(function(t){t&&(e.loading["replay"]=!0,r["a"].request({url:e.urls.replayUrl,method:"POST",data:e.form}).then(function(l){e.loading["replay"]=!1,l.data.code!==o["b"]?e.$Message.error(l.data.message):(e.$Message.success(l.data.message),i["z"](e,"replayForm"),i["h"](e,"replay"),i["A"](e)),a(l)}).catch(function(a){console.log(a),e.loading["replay"]=!1,e.$Message.error("回复失败，稍候再试"),l(a)}))})})},s=function(e){return new n.a(function(a,l){r["a"].request({url:e.urls.replayPriceUrl,method:"POST",data:e.form}).then(function(l){e.loading["replayPrice"]=!1,l.data.code!==o["b"]?e.$Message.error(l.data.message):(e.$Message.success(l.data.message),i["h"](e,"replayPrice"),i["A"](e)),a(l)}).catch(function(a){console.log(a),e.loading["replayPrice"]=!1,e.$Message.error("设置失败，稍候再试"),l(a)})})}},c5b6:function(e,a,l){"use strict";var t=function(){var e=this,a=e.$createElement,l=e._self._c||a;return l("div",[l("p",[e._v("专家问题分类编号: "),l("span",{domProps:{textContent:e._s(e.form.id)}})]),l("p",[e._v("类别名称: "),l("span",{domProps:{textContent:e._s(e.form.name)}})]),l("p",[e._v("备注: "),l("span",{domProps:{textContent:e._s(e.form.memo)}})]),l("p",[e._v("版本号: "),l("span",{domProps:{textContent:e._s(e.form.version)}})]),l("p",[e._v("创建时间: "),l("span",{domProps:{textContent:e._s(e.form.createTime)}})]),l("p",[e._v("更新时间: "),l("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),l("p",[e._v("是否激活: "),l("span",{domProps:{textContent:e._s(e.form.isActive)}})])])},n=[],r={name:"ExpertQuestionTypeViewModal",props:{form:Object,detail:!1},data:function(){return{}},computed:{},mounted:function(){},methods:{}},o=r,i=l("2877"),u=Object(i["a"])(o,t,n,!1,null,null,null);a["a"]=u.exports},f36c:function(e,a,l){"use strict";var t=function(){var e=this,a=e.$createElement,l=e._self._c||a;return l("div",[l("Row",[l("i-col",{attrs:{span:"24"}},[l("Card",[l("Button",{attrs:{type:"primary"},on:{click:e.confirmSelection}},[e._v("确认选择")]),e._v(" \n\t\t\t\t"),l("Button",{attrs:{type:"primary"},on:{click:function(a){e.showModal("search")}}},[e._v("高级搜索")]),e._v(" \n\t\t\t\t"),l("Tooltip",{attrs:{content:"刷新",placement:"right"}},[l("Button",{attrs:{icon:"md-refresh",type:"success",shape:"circle"},on:{click:e.search}})],1),l("Table",{ref:"dataTable",staticStyle:{"margin-top":"20px"},attrs:{"highlight-row":"",stripe:"",loading:e.table.loading,columns:e.table.tableColumns,data:e.table.tableDetails},on:{"on-current-change":e.changeCurrent,"on-sort-change":e.changeSort}}),l("div",{staticStyle:{margin:"20px",overflow:"hidden"}},[l("div",{staticStyle:{float:"right"}},[l("Page",{attrs:{total:e.page.total,current:e.searchForm.pageNo,showSizer:"",showTotal:""},on:{"on-change":e.changePageNo,"on-page-size-change":e.changePageSize}})],1)])],1)],1)],1),l("Modal",{attrs:{title:"高级搜索"},model:{value:e.modal.search,callback:function(a){e.$set(e.modal,"search",a)},expression:"modal.search"}},[l("Form",{ref:"searchForm",attrs:{model:e.searchForm,"label-width":80}},[l("FormItem",{attrs:{label:"用户编号"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMin"}},[l("InputNumber",{staticStyle:{width:"100%"},model:{value:e.searchForm.idMin,callback:function(a){e.$set(e.searchForm,"idMin",a)},expression:"searchForm.idMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"idMax"}},[l("InputNumber",{staticStyle:{width:"100%"},model:{value:e.searchForm.idMax,callback:function(a){e.$set(e.searchForm,"idMax",a)},expression:"searchForm.idMax"}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"手机号",prop:"phone"}},[l("Input",{model:{value:e.searchForm.phone,callback:function(a){e.$set(e.searchForm,"phone",a)},expression:"searchForm.phone"}})],1),l("FormItem",{attrs:{label:"用户邮箱",prop:"email"}},[l("Input",{model:{value:e.searchForm.email,callback:function(a){e.$set(e.searchForm,"email",a)},expression:"searchForm.email"}})],1),l("FormItem",{attrs:{label:"登录密码",prop:"password"}},[l("Input",{model:{value:e.searchForm.password,callback:function(a){e.$set(e.searchForm,"password",a)},expression:"searchForm.password"}})],1),l("FormItem",{attrs:{label:"加密盐值",prop:"salt"}},[l("Input",{model:{value:e.searchForm.salt,callback:function(a){e.$set(e.searchForm,"salt",a)},expression:"searchForm.salt"}})],1),l("FormItem",{attrs:{label:"创建时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMin,type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.createTimeMin=a}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"createTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.createTimeMax,type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.createTimeMax=a}}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"更新时间"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMin"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMin,type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.updateTimeMin=a}}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"updateTimeMax"}},[l("DatePicker",{staticStyle:{width:"100%"},attrs:{value:e.searchForm.updateTimeMax,type:"datetime",format:"yyyy-MM-dd HH:mm:ss"},on:{"on-change":function(a){e.searchForm.updateTimeMax=a}}})],1)],1)],1)],1),l("FormItem",{attrs:{label:"是否激活"}},[l("Row",[l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"isActiveMin"}},[l("InputNumber",{staticStyle:{width:"100%"},model:{value:e.searchForm.isActiveMin,callback:function(a){e.$set(e.searchForm,"isActiveMin",a)},expression:"searchForm.isActiveMin"}})],1)],1),l("i-col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),l("i-col",{attrs:{span:"11"}},[l("FormItem",{attrs:{prop:"isActiveMax"}},[l("InputNumber",{staticStyle:{width:"100%"},model:{value:e.searchForm.isActiveMax,callback:function(a){e.$set(e.searchForm,"isActiveMax",a)},expression:"searchForm.isActiveMax"}})],1)],1)],1)],1)],1),l("div",{attrs:{slot:"footer"},slot:"footer"},[l("Button",{attrs:{type:"text",size:"large"},on:{click:function(a){e.resetForm("searchForm")}}},[e._v("清空")]),l("Button",{attrs:{type:"text",size:"large"},on:{click:function(a){e.cancelModal("search")}}},[e._v("取消")]),l("Button",{attrs:{type:"primary",size:"large"},on:{click:function(a){e.searchOkModal("search")}}},[e._v("确定")])],1)],1),l("Modal",{attrs:{title:"详情"},model:{value:e.modal.detail,callback:function(a){e.$set(e.modal,"detail",a)},expression:"modal.detail"}},[l("p",[e._v("用户编号: "),l("span",{domProps:{textContent:e._s(e.form.id)}})]),l("p",[e._v("手机号: "),l("span",{domProps:{textContent:e._s(e.form.phone)}})]),l("p",[e._v("用户邮箱: "),l("span",{domProps:{textContent:e._s(e.form.email)}})]),l("p",[e._v("创建时间: "),l("span",{domProps:{textContent:e._s(e.form.createTime)}})]),l("p",[e._v("更新时间: "),l("span",{domProps:{textContent:e._s(e.form.updateTime)}})]),l("p",[e._v("是否激活: "),l("span",{domProps:{textContent:e._s(e.form.isActive)}})])])],1)},n=[],r=(l("386d"),l("f62d")),o={name:"UserListSingle",data:function(){var e=this;return{modal:{add:!1,edit:!1,search:!1,detail:!1},loading:{search:!1},urls:{searchUrl:"/user/admin/pager-cond",allUrl:"/user/admin/all",detailUrl:"/user/admin/one/",multiUrl:"/user/admin/multi/"},page:{total:0},form:{id:null,phone:null,email:null,password:null,salt:null,createTime:null,updateTime:null,isActive:null},searchForm:{pageNo:1,pageSize:10,sortColumn:null,sortOrder:null,id:null,idMin:null,idMax:null,phone:null,email:null,password:null,salt:null,createTime:null,createTimeMin:null,createTimeMax:null,updateTime:null,updateTimeMin:null,updateTimeMax:null,isActive:null,isActiveMin:null,isActiveMax:null},table:{loading:!1,tableColumns:[{width:60,align:"center",fixed:"left",render:function(a,l){return a("span",l.index+(e.searchForm.pageNo-1)*e.searchForm.pageSize+1)}},{title:"用户编号",key:"id",minWidth:120,sortable:!0},{title:"手机号",key:"phone",minWidth:120,sortable:!0},{title:"用户邮箱",key:"email",minWidth:120,sortable:!0},{title:"创建时间",key:"createTime",minWidth:120,sortable:!0},{title:"更新时间",key:"updateTime",minWidth:120,sortable:!0},{title:"是否激活",key:"isActive",minWidth:120,sortable:!0},{title:"操作",key:"action",width:80,align:"center",fixed:"right",render:function(a,l){return a("div",[a("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.showDetail("detail",l.row)}}},"详情")])}}],tableDetails:[],selections:[],currentRow:{}}}},computed:{},mounted:function(){this.search()},methods:{showModal:function(e){r["B"](this,e)},showDetail:function(e,a){r["B"](this,e),this.form=a},changeModalVisibleResetForm:function(e,a){a||r["z"](this,e)},resetForm:function(e){r["z"](this,e)},cancelModal:function(e){r["h"](this,e)},resetFormCancelModal:function(e,a){r["h"](this,a),r["z"](this,e)},searchOkModal:function(e){r["h"](this,e),this.searchForm.pageNo=1,r["A"](this)},search:function(){r["A"](this)},changeSelection:function(e){r["o"](this,e)},changeCurrent:function(e,a){r["i"](this,e,a)},changeSort:function(e){r["p"](this,e)},changePageNo:function(e){r["j"](this,e)},changePageSize:function(e){r["k"](this,e)},confirmSelection:function(){this.$emit("confirmSelection",this.table.currentRow.id)}}},i=o,u=l("2877"),s=Object(u["a"])(i,t,n,!1,null,null,null);a["a"]=s.exports}}]);