export const isActiveSelect = [
  {
    value: 0,
    label: '激活'
  },
  {
    value: 1,
    label: '冻结'
  }
]
/**
 * @description 是否默认下拉框
 */
export const isDefaultSelect = [
  {
    value: 1,
    label: '是'
  },
  {
    value: 0,
    label: '否'
  }
]
/**
 * @description 定时任务状态下拉框
 */
export const jobStatusSelect = [
  {
    value: 0,
    label: '未启动'
  },
  {
    value: 1,
    label: '运行中'
  },
  {
    value: 2,
    label: '已停止'
  },
  {
    value: 3,
    label: '已暂停'
  },
  {
    value: 4,
    label: '已删除'
  }
]
/**
 * @description 招投标项目类型下拉框
 */
export const projectType = [
  {
    value: '房建市政',
    label: '房建市政'
  },
  {
    value: '水利工程',
    label: '水利工程'
  },
  {
    value: '交通工程',
    label: '交通工程'
  },
  {
    value: '政府采购',
    label: '政府采购'
  },
  {
    value: '重点工程',
    label: '重点工程'
  },
  {
    value: '其他项目',
    label: '其他项目'
  }
]
/**
 * @description 招投标项目是否电子标下拉框
 */
export const isElectronic = [
  {
    value: 0,
    label: '非电子'
  },
  {
    value: 1,
    label: '电子'
  }
]
/**
 * @description 招投标项目发布状态下拉框
 */
export const projectReleaseStatus = [
  {
    value: '待审核',
    label: '待审核'
  },
  {
    value: '已发布',
    label: '已发布'
  }
]
/**
 * @description 招投标项目开标状态
 */
export const projectMarkStatus = [
  {
    value: '公告中',
    label: '公告中'
  },
  {
    value: '待开标',
    label: '待开标'
  },
  {
    value: '已开标',
    label: '已开标'
  }
]

/**
 * @description 辖区类别
 */
export const region = [
	{
		value: 0,
		label: '省内'
	},
	{
		value: 1,
		label: '省外'
	}
]

/**
 * @description 企业类型
 */
export const compType = [
  {
    value: '1',
    label: '代理机构'
  },
  {
    value: '3',
    label: '投标人'
  }
]

/**
 * @description行业类型
 */
export const industryType = {
  '1' : [
    {
      value: '181',
      label: '房建招标代理'
    },
    {
      value: '182',
      label: '交通招标代理'
    },
    {
      value: '183',
      label: '水利招标代理'
    }
  ],
  '3': [
    {
      value: '131',
      label: '房建及市政施工单位'
    },
    {
      value: '132',
      label: '交通施工单位'
    },
    {
      value: '133',
      label: '水利施工单位'
    },
    {
      value: '135',
      label: '重点工程投标单位'
    },
    {
      value: '143',
      label: '水利监理单位'
    },
    {
      value: '163',
      label: '水利勘查设计单位'
    },
    {
      value: '141',
      label: '房建及市政监理单位'
    },
    {
      value: '161',
      label: '房建及市政设计单位'
    }
  ]
}

/**
 * @description 招投标项目城市下拉框，江西省的所有市
 */
export const projectCity = [
  {
    value: '南昌市',
    label: '南昌市'
  },
  {
    value: '景德镇市',
    label: '景德镇市'
  },
  {
    value: '萍乡市',
    label: '萍乡市'
  },
  {
    value: '九江市',
    label: '九江市'
  },
  {
    value: '新余市',
    label: '新余市'
  },
  {
    value: '鹰潭市',
    label: '鹰潭市'
  },
  {
    value: '赣州市',
    label: '赣州市'
  },
  {
    value: '吉安市',
    label: '吉安市'
  },
  {
    value: '宜春市',
    label: '宜春市'
  },
  {
    value: '抚州市',
    label: '抚州市'
  },
  {
    value: '上饶市',
    label: '上饶市'
  }
]

/**
 * 资源类型
 */
export const resourceType = [
  {
    value: 'Image',
    label: '图片'
  },
  {
    value: 'Document',
    label: '文档'
  },
  {
    value: 'Video',
    label: '视频'
  },
  {
    value: 'Audio',
    label: '音频'
  }
]
/**
 * 项目资源类型
 */
export const projectResourceType = [
  {
    value: 0,
    label: '资审文件'
  },
  {
    value: 1,
    label: '招标文件'
  },
  {
    value: 2,
    label: '清单文件'
  },
  {
    value: 3,
    label: '控股价文件'
  },
  {
    value: 4,
    label: '澄清答疑文件'
  }
]

/**
 * 性别下拉框
 */
export const gender = [
  {
    value: 0,
    label: '未知'
  },
  {
    value: 1,
    label: '男'
  },
  {
    value: 2,
    label: '女'
  }
]

export const certificateType = [
  {
    value: '一级建造师',
    label: '一级建造师'
  },
  {
    value: '二级建造师',
    label: '二级建造师'
  },
  {
    value: '造价工程师',
    label: '造价工程师'
  },
  {
    value: '技工证',
    label: '技工证'
  },
  {
    value: '结构工程师',
    label: '结构工程师'
  },
  {
    value: '建筑师',
    label: '建筑师'
  },
  {
    value: '监理工程师',
    label: '监理工程师'
  },
  {
    value: '注册咨询师',
    label: '注册咨询师'
  },
  {
    value: '电气工程师',
    label: '电气工程师'
  },
  {
    value: '公用设备工程师',
    label: '公用设备工程师'
  },
  {
    value: '土木工程师',
    label: '土木工程师'
  },
  {
    value: '职称证书',
    label: '职称证书'
  },
  {
    value: '中级职称证书',
    label: '中级职称证书'
  },
  {
    value: '高级职称证书',
    label: '高级职称证书'
  },
  {
    value: '八大员',
    label: '八大员'
  },
  {
    value: '其他证书',
    label: '其他证书'
  }
]

export const certificateMajor = {
  '一级建造师' : [
    {
      value: '建筑工程',
      label: '建筑工程'
    },
    {
      value: '机电工程',
      label: '机电工程'
    },
    {
      value: '市政公用',
      label: '市政公用'
    },
    {
      value: '公路工程',
      label: '公路工程'
    },
    {
      value: '铁路工程',
      label: '铁路工程'
    },
    {
      value: '水利水电',
      label: '水利水电'
    },
    {
      value: '民航机场',
      label: '民航机场'
    },
    {
      value: '通信与广电',
      label: '通信与广电'
    }
  ],
  '二级建造师' : [
    {
      value: '建筑工程',
      label: '建筑工程'
    },
    {
      value: '机电工程',
      label: '机电工程'
    },
    {
      value: '水利水电工程',
      label: '水利水电工程'
    },
    {
      value: '公路工程',
      label: '公路工程'
    },
    {
      value: '矿业工程',
      label: '矿业工程'
    },
    {
      value: '市政公用工程',
      label: '市政公用工程'
    }
  ],
  '造价工程师': [
    {
      value: '建设部',
      label: '建设部'
    },
    {
      value: '交通部',
      label: '交通部'
    },
    {
      value: '水利部',
      label: '水利部'
    }
  ],
  '技工证' : [
    {
      value: '初级技工证',
      label: '初级技工证'
    },
    {
      value: '中级技工证',
      label: '中级技工证'
    },
    {
      value: '高级技工证',
      label: '高级技工证'
    }
  ],
  '结构工程师' : [
    {
      value: '一级结构师',
      label: '一级结构师'
    },
    {
      value: '二级结构师',
      label: '二级结构师'
    },
  ],
  '建筑师': [
    {
      value: '一级建筑师',
      label: '一级建筑师'
    },
    {
      value: '二级建筑师',
      label: '二级建筑师'
    }
  ],
  '监理工程师' : [],
  '注册咨询师' : [
    {
      value: '环境工程和生态建设',
      label: '环境工程和生态建设'
    },
    {
      value: '市政公用工程',
      label: '市政公用工程'
    },
    {
      value: '其他',
      label: '其他'
    },
    {
      value: '公路/铁路/民航',
      label: '公路/铁路/民航'
    },
    {
      value: '城市轨道交通',
      label: '城市轨道交通'
    },
    {
      value: '水电/核电/火电',
      label: '水电/核电/火电'
    },
    {
      value: '煤炭/石化',
      label: '煤炭/石化'
    },
    {
      value: '石油天然气',
      label: '石油天然气'
    },
    {
      value: '化工、医药',
      label: '化工、医药'
    },
    {
      value: '建筑/建筑材料',
      label: '建筑/建筑材料'
    },
    {
      value: '机械/电子',
      label: '机械/电子'
    },
    {
      value: '轻工/纺织、化纤',
      label: '轻工/纺织、化纤'
    },
    {
      value: '钢铁/有色冶金',
      label: '钢铁/有色冶金'
    },
    {
      value: '农业/林业',
      label: '农业/林业'
    },
    {
      value: '通信/广播电影电视',
      label: '通信/广播电影电视'
    },
    {
      value: '地质/测量/岩土工程',
      label: '地质/测量/岩土工程'
    },
    {
      value: '港口河海工程',
      label: '港口河海工程'
    },
    {
      value: '城市规划',
      label: '城市规划'
    },
    {
      value: '综合经济',
      label: '综合经济'
    }
  ],
  '电气工程师' : [
    {
      value: '供配电',
      label: '供配电'
    },
    {
      value: '发输变电',
      label: '发输变电'
    }
  ],
  '公用设备工程师' : [
    {
      value: '暖通空调',
      label: '暖通空调'
    },
    {
      value: '动力',
      label: '动力'
    },
    {
      value: '给水排水',
      label: '给水排水'
    }
  ],
  '土木工程师' : [
    {
      value: '注册岩土',
      label: '注册岩土'
    },
    {
      value: '港口航道',
      label: '港口航道'
    },
    {
      value: '水利水电',
      label: '水利水电'
    }
  ],
  '职称证书' : [
    {
      value: '工民建',
      label: '工民建'
    },
    {
      value: '建筑工程/土建/房建',
      label: '建筑工程/土建/房建'
    },
    {
      value: '园林设计师',
      label: '园林设计师'
    },
    {
      value: '其他',
      label: '其他'
    },
    {
      value: '结构',
      label: '结构'
    },
    {
      value: '暖通空调/热处理',
      label: '暖通空调/热处理'
    },
    {
      value: '设计类',
      label: '设计类'
    },
    {
      value: '市政/公路/机电',
      label: '市政/公路/机电'
    },
    {
      value: '土建/造价/概预算',
      label: '土建/造价/概预算'
    },
    {
      value: '土木工程/道路桥梁',
      label: '土木工程/道路桥梁'
    },
    {
      value: '经济师专业类',
      label: '经济师专业类'
    },
    {
      value: '电气',
      label: '电气'
    },
    {
      value: '船舶/冷冻类',
      label: '船舶/冷冻类'
    },
    {
      value: '计算机系统集成',
      label: '计算机系统集成'
    },
    {
      value: '建筑设计类',
      label: '建筑设计类'
    },
    {
      value: '园林绿化',
      label: '园林绿化'
    },
    {
      value: '暖通',
      label: '暖通'
    },
    {
      value: '给排水',
      label: '给排水'
    },
    {
      value: '化工',
      label: '化工'
    },
    {
      value: '燃气',
      label: '燃气'
    },
    {
      value: '机械设备/机械',
      label: '机械设备/机械'
    },
    {
      value: '电子',
      label: '电子'
    },
    {
      value: '通信',
      label: '通信'
    },
    {
      value: '水利水电',
      label: '水利水电'
    },
    {
      value: '电力/热能动力',
      label: '电力/热能动力'
    },
    {
      value: '岩土',
      label: '岩土'
    },
    {
      value: '能源工程',
      label: '能源工程'
    },
    {
      value: '环保/规划',
      label: '环保/规划'
    },
    {
      value: '焊接',
      label: '焊接'
    },
    {
      value: '会计',
      label: '会计'
    },
    {
      value: '环境工程',
      label: '环境工程'
    },
    {
      value: '总图',
      label: '总图'
    },
    {
      value: '测量/测绘',
      label: '测量/测绘'
    },
    {
      value: '防护防化',
      label: '防护防化'
    },
    {
      value: '通风',
      label: '通风'
    }
  ],
  '中级职称证书': [
    {
      value: '工民建',
      label: '工民建'
    },
    {
      value: '建筑工程/土建/房建',
      label: '建筑工程/土建/房建'
    },
    {
      value: '园林设计师',
      label: '园林设计师'
    },
    {
      value: '其他',
      label: '其他'
    },
    {
      value: '结构',
      label: '结构'
    },
    {
      value: '暖通空调/热处理',
      label: '暖通空调/热处理'
    },
    {
      value: '设计类',
      label: '设计类'
    },
    {
      value: '市政/公路/机电',
      label: '市政/公路/机电'
    },
    {
      value: '土建/造价/概预算',
      label: '土建/造价/概预算'
    },
    {
      value: '土木工程/道路桥梁',
      label: '土木工程/道路桥梁'
    },
    {
      value: '经济师专业类',
      label: '经济师专业类'
    },
    {
      value: '电气',
      label: '电气'
    },
    {
      value: '船舶/冷冻类',
      label: '船舶/冷冻类'
    },
    {
      value: '计算机系统集成',
      label: '计算机系统集成'
    },
    {
      value: '建筑设计类',
      label: '建筑设计类'
    },
    {
      value: '园林绿化',
      label: '园林绿化'
    },
    {
      value: '暖通',
      label: '暖通'
    },
    {
      value: '给排水',
      label: '给排水'
    },
    {
      value: '化工',
      label: '化工'
    },
    {
      value: '燃气',
      label: '燃气'
    },
    {
      value: '机械设备/机械',
      label: '机械设备/机械'
    },
    {
      value: '电子',
      label: '电子'
    },
    {
      value: '通信',
      label: '通信'
    },
    {
      value: '水利水电',
      label: '水利水电'
    },
    {
      value: '电力/热能动力',
      label: '电力/热能动力'
    },
    {
      value: '岩土',
      label: '岩土'
    },
    {
      value: '能源工程',
      label: '能源工程'
    },
    {
      value: '环保/规划',
      label: '环保/规划'
    },
    {
      value: '焊接',
      label: '焊接'
    },
    {
      value: '会计',
      label: '会计'
    },
    {
      value: '环境工程',
      label: '环境工程'
    },
    {
      value: '总图',
      label: '总图'
    },
    {
      value: '测量/测绘',
      label: '测量/测绘'
    },
    {
      value: '防护防化',
      label: '防护防化'
    },
    {
      value: '通风',
      label: '通风'
    }
  ],
  '高级职称证书': [
    {
      value: '工民建',
      label: '工民建'
    },
    {
      value: '建筑工程/土建/房建',
      label: '建筑工程/土建/房建'
    },
    {
      value: '园林设计师',
      label: '园林设计师'
    },
    {
      value: '其他',
      label: '其他'
    },
    {
      value: '结构',
      label: '结构'
    },
    {
      value: '暖通空调/热处理',
      label: '暖通空调/热处理'
    },
    {
      value: '设计类',
      label: '设计类'
    },
    {
      value: '市政/公路/机电',
      label: '市政/公路/机电'
    },
    {
      value: '土建/造价/概预算',
      label: '土建/造价/概预算'
    },
    {
      value: '土木工程/道路桥梁',
      label: '土木工程/道路桥梁'
    },
    {
      value: '经济师专业类',
      label: '经济师专业类'
    },
    {
      value: '电气',
      label: '电气'
    },
    {
      value: '船舶/冷冻类',
      label: '船舶/冷冻类'
    },
    {
      value: '计算机系统集成',
      label: '计算机系统集成'
    },
    {
      value: '建筑设计类',
      label: '建筑设计类'
    },
    {
      value: '园林绿化',
      label: '园林绿化'
    },
    {
      value: '暖通',
      label: '暖通'
    },
    {
      value: '给排水',
      label: '给排水'
    },
    {
      value: '化工',
      label: '化工'
    },
    {
      value: '燃气',
      label: '燃气'
    },
    {
      value: '机械设备/机械',
      label: '机械设备/机械'
    },
    {
      value: '电子',
      label: '电子'
    },
    {
      value: '通信',
      label: '通信'
    },
    {
      value: '水利水电',
      label: '水利水电'
    },
    {
      value: '电力/热能动力',
      label: '电力/热能动力'
    },
    {
      value: '岩土',
      label: '岩土'
    },
    {
      value: '能源工程',
      label: '能源工程'
    },
    {
      value: '环保/规划',
      label: '环保/规划'
    },
    {
      value: '焊接',
      label: '焊接'
    },
    {
      value: '会计',
      label: '会计'
    },
    {
      value: '环境工程',
      label: '环境工程'
    },
    {
      value: '总图',
      label: '总图'
    },
    {
      value: '测量/测绘',
      label: '测量/测绘'
    },
    {
      value: '防护防化',
      label: '防护防化'
    },
    {
      value: '通风',
      label: '通风'
    }
  ],
  '八大员' : [
    {
      value: '通信',
      label: '通信'
    },
    {
      value: '施工员',
      label: '施工员'
    },
    {
      value: '质量员',
      label: '质量员'
    },
    {
      value: '安全员',
      label: '安全员'
    },
    {
      value: '机械员',
      label: '机械员'
    },
    {
      value: '造价员',
      label: '造价员'
    },
    {
      value: '劳务员',
      label: '劳务员'
    },
    {
      value: '材料员',
      label: '材料员'
    },
    {
      value: '资料员',
      label: '资料员'
    }
  ],
  '其他证书' : []
}

/**
 * 证书状态
 */
export const certificateStatus = [
  {
    value: '闲置中',
    label: '闲置中'
  },
  {
    value: '合同快到期',
    label: '合同快到期'
  }
]

/**
 * 证书注册状态
 */
export const certificateRegStatus = [
  {
    value: '初始',
    label: '初始'
  },
  {
    value: '转注',
    label: '转注'
  }
]

/**
 * 薪资范围
 */
export const salaryRange = [
  {
    value: '一万元以下',
    label: '一万元以下'
  },
  {
    value: '1-2万元',
    label: '1-2万元'
  },
  {
    value: '2-3万元',
    label: '2-3万元'
  },
  {
    value: '3-5万元',
    label: '3-5万元'
  },
  {
    value: '5-10万元',
    label: '5-10万元'
  },
  {
    value: '10-15万元',
    label: '10-15万元'
  },
  {
    value: '15万元以上',
    label: '15万元以上'
  },
]

/**
 * 资质转让类别
 */
export const aptitudeTransferType = [
  {
    value: 0,
    label: '购买'
  },
  {
    value: 1,
    label: '转让'
  }
]

/**
 * 企业资质等级
 */
export const companyAptitudeLevel = [
  {
    value: '一级',
    label: '一级'
  },
  {
    value: '二级',
    label: '二级'
  },
  {
    value: '三级',
    label: '三级'
  }
]

/**
 * 企业资质类别
 */
export const companyAptitudeType = [
  {
    value: '房建市政',
    label: '房建市政'
  },
  {
    value: '水利工程',
    label: '水利工程'
  },
  {
    value: '交通工程',
    label: '交通工程'
  },
  {
    value: '政府采购',
    label: '政府采购'
  },
  {
    value: '重点工程',
    label: '其他项目'
  }
]

/**
 * 轿车类别
 */
export const carType = [
  {
    value: '小轿车',
    label: '小轿车'
  },
  {
    value: 'suv',
    label: 'suv'
  },
  {
    value: '面包车',
    label: '面包车'
  },
  {
    value: '越野车',
    label: '越野车'
  },
  {
    value: '班车',
    label: '班车'
  }
]

/**
 * 求职类别
 */
export const jobType = [
  {
    value: 0,
    label: '全职'
  },
  {
    value: 1,
    label: '兼职'
  }
]

/**
 * 学历
 */
export const education = [
  {
    value: '不限',
    label: '不限'
  },
  {
    value: '大专',
    label: '大专'
  },
  {
    value: '本科',
    label: '本科'
  },
  {
    value: '硕士',
    label: '硕士'
  },
  {
    value: '博士',
    label: '博士'
  }
]

/**
 * 资料类别
 */
export const seekDataType = [
  {
    value: '资料',
    label: '资料'
  },
  {
    value: '文件夹',
    label: '文件夹'
  },
  {
    value: '物品',
    label: '物品'
  },
  {
    value: '包裹',
    label: '包裹'
  },
  {
    value: '重要证件',
    label: '重要证件'
  }
]

/**
 * 优惠券使用状态
 */
export const couponUseStatusSelect = [
  {
    value: 0,
    label: '待使用'
  },
  {
    value: 1,
    label: '已使用'
  }
]

/**
 * 验证状态
 */
export const validStatus = [
	{
		value: '验证不通过',
		label: '验证不通过'
	},
	{
		value: '验证通过',
		label: '验证通过'
	}
]

export const examine = [
	{
		value: 0,
		label: '审核中'
	},
	{
		value: 1,
		label: '审核通过'
	},
	{
		value: 2,
		label: '审核不通过'
	},
]

/**
 * 审查方式下拉框
 */
export const checkPatternSelect = [
  {
    value: '资格后审',
    label: '资格后审'
  }
]

/**
 * 担保公司下拉框
 */
export const guaranteeCompSelect = [
  {
    value: '赣州智悦网络科技有限公司',
    label: '赣州智悦网络科技有限公司'
  }
]

/**
 * 抵扣券类别下拉框
 */
export const couponeTypeSelect = [
  {
    value: '充值VIP',
    label: '充值VIP'
  }
]

/**
 * 招聘状态
 */
export const recruitStatusSelect = [
  {
    value: '招聘中',
    label: '招聘中'
  },
  {
    value: '已停止',
    label: '已停止'
  }
]

/**
 * 企业分类
 */
export const pythonTypeSelect = [
  {
    value: '1',
    label: '代理机构'
  },
  {
    value: '3',
    label: '投标人'
  }
]

/**
 * 爬取项目信息爬取类型下拉框
 */
export const pythonProjectTypeSelect = [
  {
    value: 'project/house',
    label: '房建市政'
  },
  {
    value: 'project/conservancy',
    label: '水利工程'
  },
  {
    value: 'project/traffic',
    label: '交通工程'
  }, 
  {
    value: 'project/procurement',
    label: '政府采购'
  },
  {
    value: 'project/key',
    label: '重点项目'
  },
  {
    value: 'project/other',
    label: '其他项目'
  }
]
/**
 * 爬取项目公示信息爬取类型下拉框
 */
export const pythonProjectAnnounceTypeSelect = [
  {
    value: 'project-announce/house',
    label: '房建市政'
  },
  {
    value: 'project-announce/conservancy',
    label: '水利工程'
  },
  {
    value: 'project-announce/traffic',
    label: '交通工程'
  },
  {
    value: 'project-announce/procurement',
    label: '政府采购'
  },
  {
    value: 'project-announce/key',
    label: '重点项目'
  },
  {
    value: 'project-announce/other',
    label: '其他项目'
  }
]

/**
 * 求职类型
 */
export const jobTypeSelect = [
  {
    value: '长期',
    label: '长期'
  },
  {
    value: '短期',
    label: '短期'
  },
  {
    value: '钟点',
    label: '钟点'
  }
]
