
// 下面是下拉框常用的数据
/**
 * 担保公司数组
 */
export const guaranteeCompanyArray = ['江西数达信息科技有限公司']
/**
 * 证书状态数组
 */
export const certificateStatusArray = ['闲置中', '合同快到期']
/**
 * 证书注册状态数组
 */
export const certificateRegStatusArray = ['初始', '转注']
/**
 * 性别数组
 */
export const genderArray = ['未知', '男', '女']
/**
 * 是否全职数组
 */
export const fulltimeArray = ['全职', '兼职']
/**
 * 学历数组
 */
export const educationArray = ['不限', '大专', '本科', '硕士', '博士']
/**
 * 薪资数组
 */
export const salaryArray = [
	'一万元以下', '1-2万元', '2-3万元', '3-5万元', '5-10万元', '10-15万元', '15万元以上'
]
/**
 * vip等级数组
 */
export const vipLevelArray = ['一级', '二级', '三级']
/**
 * 支付状态数组
 */
export const payTypeArray = ['微信']
/**
 * 支付状态数组
 */
export const payStatusArray = ['全部', '待支付', '已支付']
/**
 * 收支状态数组
 */
export const revenueExpenditureStatusArray = ['全部', '收入', '支出']
/**
 * 江西城市数组
 */
export const jxCityArray = ['全省', '南昌市', '赣州市', '萍乡市', '吉安市', '上饶市', '新余市', '抚州市', '九江市', '鹰潭市', '宜春市', '景德镇市']
/**
 * 消息读取状态
 */
export const messageReadTypeArray = ['全部', '未读', '已读']
/**
 * 企业资质等级数组
 */
export const companyAptitudeLevelArray = ['一级', '二级', '三级']
/**
 * 企业资质类型数组
 */
export const companyAptitudeTypeArray = ['房建', '市政', '公路', '水利', '通信', '其他']
/**
 * 汽车车型数组
 */
export const carTypeArray = ['小轿车', 'suv', '面包车', '越野车', '班车']
/**
 * 资料类型数组
 */
export const dataTypeArray= ['资料', '文件夹', '物品', '重要证件']
/**
 * 企业业绩数组
 */
export const achievementTypeArray = ['房建业绩', '水利业绩', '交通业绩', '重点工程业绩', '水利监理业绩', '水利勘查设计业绩']
/**
 * 购买服务年限的年数
 */
export const buyServiceValidYearArray = [1, 2, 3, 4, 5]
/**
 * 证书类别数组
 */
export const certificateTypeArray = [
	'一级建造师',
	'二级建造师',
	'造价工程师',
	'技工证',
	'结构工程师',
	'建筑师',
	'监理工程师',
	'注册咨询师',
	'电气工程师',
	'公用设备工程师',
	'土木工程师',
	'职称证书',
	'中级职称证书',
	'高级职称证书',
	'八大员',
	'其他证书'
]

/**
 * 证书专业类型
 */
export const certificateMajorTypeObj = {
  '一级建造师' : [
    '建筑工程',
    '机电工程',
    '市政公用',
    '公路工程',
    '铁路工程',
    '水利水电',
    '民航机场',
    '通信与广电'
  ],
  '二级建造师' : [
    '建筑工程',
    '机电工程',
    '水利水电工程',
    '公路工程',
    '矿业工程',
    '市政公用工程'
  ],
  '造价工程师': [
    '建设部',
    '交通部',
    '水利部'
  ],
  '技工证' : [
    '初级技工证',
    '中级技工证',
    '高级技工证'
  ],
  '结构工程师' : [
    '一级结构师',
    '二级结构师'
  ],
  '建筑师': [
    '一级建筑师',
    '二级建筑师'
  ],
  '监理工程师' : [],
  '注册咨询师' : [
    '环境工程和生态建设',
    '市政公用工程',
    '其他',
    '公路/铁路/民航',
    '城市轨道交通',
    '水电/核电/火电',
    '煤炭/石化',
    '石油天然气',
    '化工、医药',
    '建筑/建筑材料',
    '机械/电子',
    '轻工/纺织、化纤',
    '钢铁/有色冶金',
    '农业/林业',
    '通信/广播电影电视',
    '地质/测量/岩土工程',
    '港口河海工程',
    '城市规划',
    '综合经济'
  ],
  '电气工程师' : [
    '供配电',
    '发输变电'
  ],
  '公用设备工程师' : [
    '暖通空调',
    '动力',
    '给水排水'
  ],
  '土木工程师' : [
    '注册岩土',
    '港口航道',
    '水利水电'
  ],
  '职称证书' : [
    '工民建',
    '建筑工程/土建/房建',
    '园林设计师',
    '其他',
    '结构',
    '暖通空调/热处理',
    '设计类',
    '市政/公路/机电',
    '土建/造价/概预算',
    '土木工程/道路桥梁',
    '经济师专业类',
    '电气',
    '船舶/冷冻类',
    '计算机系统集成',
    '建筑设计类',
    '园林绿化',
    '暖通',
    '给排水',
    '化工',
    '燃气',
    '机械设备/机械',
    '电子',
    '通信',
    '水利水电',
    '电力/热能动力',
    '岩土',
    '能源工程',
    '环保/规划',
    '焊接',
    '会计',
    '环境工程',
    '总图',
    '测量/测绘',
    '防护防化',
    '通风'
  ],
  '中级职称证书': [
    '工民建',
    '建筑工程/土建/房建',
    '园林设计师',
    '其他',
    '结构',
    '暖通空调/热处理',
    '设计类',
    '市政/公路/机电',
    '土建/造价/概预算',
    '土木工程/道路桥梁',
    '经济师专业类',
    '电气',
    '船舶/冷冻类',
    '计算机系统集成',
    '建筑设计类',
    '园林绿化',
    '暖通',
    '给排水',
    '化工',
    '燃气',
    '机械设备/机械',
    '电子',
    '通信',
    '水利水电',
    '电力/热能动力',
    '岩土',
    '能源工程',
    '环保/规划',
    '焊接',
    '会计',
    '环境工程',
    '总图',
    '测量/测绘',
    '防护防化',
    '通风'
  ],
  '高级职称证书': [
    '工民建',
    '建筑工程/土建/房建',
    '园林设计师',
    '其他',
    '结构',
    '暖通空调/热处理',
    '设计类',
    '市政/公路/机电',
    '土建/造价/概预算',
    '土木工程/道路桥梁',
    '经济师专业类',
    '电气',
    '船舶/冷冻类',
    '计算机系统集成',
    '建筑设计类',
    '园林绿化',
    '暖通',
    '给排水',
    '化工',
    '燃气',
    '机械设备/机械',
    '电子',
    '通信',
    '水利水电',
    '电力/热能动力',
    '岩土',
    '能源工程',
    '环保/规划',
    '焊接',
    '会计',
    '环境工程',
    '总图',
    '测量/测绘',
    '防护防化',
    '通风'
  ],
  '八大员' : [
    '通信',
    '施工员',
    '质量员',
    '安全员',
    '机械员',
    '造价员',
    '劳务员',
    '材料员',
    '资料员'
  ],
  '其他证书' : []
}

// 下面是发布信息和我的发布用到的数组
/**
 * 建造师类型数组
 */
export const builderTypeArray = ['招聘', '应聘']
/**
 * 资质类型数组
 */
export const aptitudeTypeArray = ['求购', '转让']
/**
 * 开标拼车数组
 */
export const openMarkArray = ['车主找人', '人找车主']


// 下面是分段器用到的数组
/**
 * 操作数组
 */
export const operationArray = ['全部', '未处理', '已处理']

/**
 * 项目状态数组
 */
export const projectStatusArray = ['全部', '公告中', '待开标', '已开标']

/**
 * 抵扣券状态数组
 */
export const couponStatusArray = ['全部', '未使用', '已过期']

/**
 * 文件类型数组
 */
export const fileTypeArray = ['资审文件', '招标文件', '清单文件', '控股价文件', '澄清答疑文件']

/**
 * 行业分类数组
 */
export const industryTypeArray = ['全部', '房建招标代理', '交通招标代理', '水利招标代理', '房建及市政施工单位', '交通施工单位', '水利施工单位', '重点工程投标单位', '水利监理单位', '水利勘查设计单位', '房建及市政设计单位', '房建及市政监理单位']
/**
 * 项目分类数组
 */
export const projectTypeArray = ['全部', '房建市政', '水利工程', '交通工程', '政府采购', '重点工程', '其他项目']

