import requests
import json
import time

from model.company import Company
from model.comp_personnel import CompPersonnel
from model.comp_aptitude import CompAptitude

# 获取cookie
def getCookies(compType, alink, url):
    # 第一次请求，后台会返回三个cookie值，需要保存起来
    response = requests.get(url=url)
    cookie_value = {}
    for key, value in response.cookies.items():
        cookie_value[key] = value
    return cookie_value

# 获取公司信息
def get_company_info(type, compType, pageNo, pageSize):
    # current_comp_info_file = open('current_comp_info_file.txt', 'r+')
    # 获取已爬取的最新的链接
    # current_comp_info_href = current_comp_info_file.readline()
    response = requests.get(url="http://jxsggzy.cn/jxggzy/services/JyxxWebservice/getTradeList?response=application/json&pageIndex="+pageNo+"&pageSize="+pageSize+"&&dsname=ztb_data&bname=&qytype="+type+"&itemvalue=" + compType)
    # 获取返回的内容为json字符串
    text = response.text
    textJson = json.loads(text)
    returnJson = json.loads(textJson['return'])
    # 公司列表
    tableJson = returnJson['Table']

    # latest_flag = False
    companys = []
    for table in tableJson:
        company = Company()
        alink = table['alink']
        city = table['szdq']
        company.city = city.replace('·', '/')
        company.compName = table['qymc']
        # 详细信息的url
        detailUrl = 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/dailiinfo/jxpDaiLiInfoDetailForWebAction.action?cmd=page_Load&DanWeiType='+compType+'&isCommondto=true&DanWeiGuid=' + alink
        # 详细页面的url
        pageUrl = "http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/FrameAll?DanWeiType=" + compType + "&DanWeiGuid=" + alink
        # 人员信息的url
        personnelUrl = 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/pminfo/jxpJtgcSgPmTempForWebListAction.action?cmd=page_Load&DanWeiType='+compType+'&DanWeiGuid='+alink+'&isCommondto=true'
        # 如果已爬取的最新链接不等于现在抓取的链接，则表示网站有更新新数据
        # if current_comp_info_href != detailUrl:
        #     if not latest_flag:
        #         # 清除文件原内容
        #         current_comp_info_file.seek(0)
        #         current_comp_info_file.truncate()
        #         # 记录新链接到文件中
        #         current_comp_info_file.write(detailUrl)
        #         latest_flag = True
        # else:
        #     # 网站没有更新新数据，则停止爬取
        #     break

        company.sourceUrl = pageUrl

        requestsCookies = getCookies(compType, alink, pageUrl)
        scrfcokie = requestsCookies['_CSRFCOOKIE']
        controls = get_detail_info(requestsCookies, scrfcokie, detailUrl, compType, alink)
        company = set_company_type(type, compType, company, requestsCookies, scrfcokie, personnelUrl, alink)
        company = set_company_info(controls, company)
        # current_comp_info_file.close()
        companys.append(company.__dict__)
    return companys


# 设置企业信息
def set_company_info(controls, company):
    print(controls)
    for control in controls:
        id = control['id']
        value = control['value']
        if value == '':
            continue
        if id == 'danweiname':
            # 单位名称
            company.compName = value
        if id == 'unitorgnum':
            # 组织机构/信用代码
            print(value)
        if id == 'faren':
            # 法定代表人
            company.legalPerson = value
        if id == 'areaname':
            # 注册地区
            value = value.replace('·', '/')
            company.regAddress = value
        if id == 'guoshuino':
            # 国税登记证编号
            print(value)
        if id == 'dishuino':
            # 地税登记证编号
            print(value)
        if id == 'licencenum':
            # 营业执照号码
            print(value)
        if id == 'zhuceziben':
            # 注册资本
            company.regCapital = value
        if id == 'currency':
            # 注册资本币种 156
            print(value)
        if id == 'yingyeqixianfrom':
            # 营业期限开始 1027612800000
            value = value / 1000
            timeArray = time.localtime(value)
            value = time.strftime("%Y-%m-%d", timeArray)
            print(value)
        if id == 'yingyeqixianto':
            # 营业期限结束 2605449600000
            value = value / 1000
            timeArray = time.localtime(value)
            value = time.strftime("%Y-%m-%d", timeArray)
            print(value)
        if id == 'jinyingfanwei':
            # 经营范围
            company.businessScope = value
        if id == 'faren2':
            # 企业负责人
            print(value)
        if id == 'farenzhiwu':
            # 职务
            print(value)
        if id == 'farenzhicheng':
            # 职称
            print(value)
        if id == 'faren2':
            # 企业负责人
            print(value)
        if id == 'faren2':
            # 企业负责人
            print(value)
        if id == 'localtel':
            # 联系电话
            company.compPhone = value
        if id == 'address':
            # 详细地址
            company.compAddr = value
    return company

# 设置公司类型
def set_company_type(type, compType, company, requestsCookies, scrfcokie, personnelUrl, alink):
    # 代理机构
    typeAgent = '1'
    typeAgentName = '代理机构'
    # 房建招标代理
    compTypeHouseAgent = '181'
    compTypeHouseAgentName = '房建招标代理'
    # 交通招标代理
    compTypeTrafficAgent = '182'
    compTypeTrafficAgentName = '交通招标代理'
    # 水利招标代理
    compTypeWaterAgent = '183'
    compTypeWaterAgentName = '水利招标代理'
    # 投标人
    typeBidder = '3'
    typeBidderName = '投标人'
    # 房建及市政施工单位
    compTypeHouseBidder = '131'
    compTypeHouseBidderName = '房建及市政施工单位'
    # 交通施工单位
    compTypeTrafficBidder = '132'
    compTypeTrafficBidderName = '交通施工单位'
    # 水利施工单位
    compTypeWaterBidder = '133'
    compTypeWaterBidderName = '水利施工单位'
    # 重点工程投标单位
    compTypeKeyProjectBidder = '135'
    compTypeKeyProjectBidderName = '重点工程投标单位'
    # 水利监理单位
    compTypeWaterMonitorBidder = '143'
    compTypeWaterMonitorBidderName = '水利监理单位'
    # 水利勘查设计单位
    compTypeWaterDeviseBidder = '163'
    compTypeWaterDeviseBidderName = '水利勘查设计单位'
    if type == typeAgent:
        company.compType = typeAgentName
        if compType == compTypeHouseAgent:
            company.industryType = compTypeHouseAgentName
        elif compType == compTypeTrafficAgent:
            company.industryType = compTypeTrafficAgentName
        elif compType == compTypeWaterAgent:
            company.industryType = compTypeWaterAgentName
    elif type == typeBidder:
        company.compType = typeBidderName
        # 只有投标人才有企业资质
        aptitudeControls = get_company_aptitude_info(requestsCookies, scrfcokie, compType, alink)
        compAptitudes = set_comp_aptitude_info(aptitudeControls)
        company.compAptitudeList = compAptitudes
        if compType == compTypeHouseBidder:
            company.industryType = compTypeHouseBidderName
        elif compType == compTypeTrafficBidder:
            company.industryType = compTypeTrafficBidderName
            # 只有交通施工单位才有企业人员信息
            personnelControls = get_company_people_info(requestsCookies, scrfcokie, personnelUrl, compType, alink)
            compPersonnels = set_comp_personnel_info(personnelControls)
            company.compPersonnelList = compPersonnels
        elif compType == compTypeWaterBidder:
            company.industryType = compTypeWaterBidderName
        elif compType == compTypeKeyProjectBidder:
            company.industryType = compTypeKeyProjectBidderName
        elif compType == compTypeWaterMonitorBidder:
            company.industryType = compTypeWaterMonitorBidderName
        elif compType == compTypeWaterDeviseBidder:
            company.industryType = compTypeWaterDeviseBidderName
    return company


# 获取公司详情信息
def get_detail_info(requestsCookies, scrfcokie, detailUrl, compType, alink):
    params = {
        'commonDto': '[{"id":"danweiname","bind":"unitcominfo.danweiname","type":"outputtext"},{"id":"unitorgnum","bind":"unitcominfo.unitorgnum","type":"outputtext"},{"id":"mini-5","bind":"btnA0009","type":"output"},{"id":"faren","bind":"unitcominfo.faren","type":"outputtext"},{"id":"country","bind":"unitcominfo.country","type":"outputtext"},{"id":"areaname","bind":"unitcominfo.areaname","type":"outputtext"},{"id":"webaddress","bind":"unitcominfo.webaddress","type":"outputtext"},{"id":"industryname","bind":"dataBean.industryname","type":"outputtext"},{"id":"guoshuino","bind":"unitcominfo.guoshuino","type":"outputtext"},{"id":"dishuino","bind":"unitcominfo.dishuino","type":"outputtext"},{"id":"locallianxiren","bind":"dataBean.locallianxiren","type":"outputtext"},{"id":"sbrname","bind":"dataBean.sbrname","type":"outputtext"},{"id":"localtel","bind":"dataBean.localtel","type":"outputtext"},{"id":"localfax","bind":"dataBean.localfax","type":"outputtext"},{"id":"localemail","bind":"dataBean.localemail","type":"outputtext"},{"id":"localzip","bind":"dataBean.localzip","type":"outputtext"},{"id":"address","bind":"dataBean.address","type":"outputtext"},{"id":"zixindengji","bind":"unitcominfo.zixindengji","type":"outputtext"},{"id":"statuscode","bind":"dataBean.statuscode","type":"outputtext"},{"id":"mini-28","bind":"dataBean.auditstatus","type":"outputtext"},{"id":"auditstatus","bind":"dataBean.auditstatus","type":"outputtext"},{"id":"licencenum","bind":"unitcominfo.licencenum","type":"outputtext"},{"id":"mini-32","bind":"btnA0010","type":"output"},{"id":"companytype","bind":"unitcominfo.companytype","type":"outputtext"},{"id":"builddate","bind":"unitcominfo.builddate","type":"outputtext"},{"id":"zhuceaddress","bind":"unitcominfo.zhuceaddress","type":"outputtext"},{"id":"zhuceziben","bind":"unitcominfo.zhuceziben","type":"outputtext"},{"id":"currency","bind":"unitcominfo.currency","type":"outputtext"},{"id":"yingyeqixianfrom","bind":"unitcominfo.yingyeqixianfrom","type":"outputtext"},{"id":"yingyeqixianto","bind":"unitcominfo.yingyeqixianto","type":"outputtext"},{"id":"dengjijiguan","bind":"unitcominfo.dengjijiguan","type":"outputtext"},{"id":"nianjianjieguo","bind":"unitcominfo.nianjianjieguo","type":"outputtext"},{"id":"jinyingfanwei","bind":"unitcominfo.jinyingfanwei","type":"outputtext"},{"id":"zizhinum","bind":"dataBean.zizhinum","type":"outputtext"},{"id":"zizhifazhengorg","bind":"dataBean.zizhifazhengorg","type":"outputtext"},{"id":"zizhitype","bind":"dataBean.zizhitype","type":"outputtext"},{"id":"zizhidengji","bind":"dataBean.zizhidengji","type":"outputtext"},{"id":"faren2","bind":"unitcominfo.faren","type":"outputtext"},{"id":"farenzhiwu","bind":"unitcominfo.farenzhiwu","type":"outputtext"},{"id":"farenzhicheng","bind":"unitcominfo.farenzhicheng","type":"outputtext"},{"id":"qiyefuzerenname","bind":"dataBean.qiyefuzerenname","type":"outputtext"},{"id":"qiyefuzerenzhiwu","bind":"dataBean.qiyefuzerenzhiwu","type":"outputtext"},{"id":"qiyefuzerenzhicheng","bind":"dataBean.qiyefuzerenzhicheng","type":"outputtext"},{"id":"jishufuzherenname","bind":"dataBean.jishufuzherenname","type":"outputtext"},{"id":"jishufuzherenzhiwu","bind":"dataBean.jishufuzherenzhiwu","type":"outputtext"},{"id":"jishufuzherenzhicheng","bind":"dataBean.jishufuzherenzhicheng","type":"outputtext"},{"id":"hefajiguan","bind":"dataBean.hefajiguan","type":"outputtext"},{"id":"zhengshustatus","bind":"dataBean.zhengshustatus","type":"outputtext"},{"id":"hefariqi","bind":"dataBean.hefariqi","type":"outputtext"},{"id":"zzrqstart","bind":"dataBean.zzrqstart","type":"outputtext"},{"id":"zzrqend","bind":"dataBean.zzrqend","type":"outputtext"},{"id":"chendanyewu","bind":"dataBean.chendanyewu","type":"outputtext"},{"id":"companydes","bind":"unitcominfo.companydes","type":"outputtext"},{"id":"xybsm","bind":"hyUnitComInfo.xybsm","type":"outputtext"},{"id":"mini-68","bind":"pageScript","type":"output"},{"id":"_common_hidden_viewdata","type":"hidden","value":""}]'
    }
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'X-Requested-With': 'XMLHttpRequest',
        # 'Cookie': cookies,
        'CSRFCOOKIE': scrfcokie,
        'Host': 'ggzyjy.jxsggzy.cn',
        'Origin': 'http://ggzyjy.jxsggzy.cn',
        'Referer': 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/dailiinfo/DaiLiInfo_Detail?DanWeiType='+compType+'&DanWeiGuid=' + alink,
        'Cache-Control': 'no-cache'
    }

    detailResponse = requests.post(url=detailUrl, data=params, headers=headers, cookies=requestsCookies)
    detailTextJson = json.loads(detailResponse.text)
    controls = detailTextJson['controls']
    return controls

# 获取企业人员信息
def get_company_people_info(requestsCookies, scrfcokie, personnelUrl, compType, alink):
    params = {
        'commonDto': '[{"id":"datagrid","type":"datagrid","action":"defaultModel","idField":"rowguid","pageIndex":0,"pageSize":100,"sortField":"","sortOrder":"","columns":[],"url":"jxpFJDaiLiPeopleListForWebAction.action?cmd=defaultModel","data":[]}]'
    }
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'X-Requested-With': 'XMLHttpRequest',
        # 'Cookie': cookies,
        'CSRFCOOKIE': scrfcokie,
        'Host': 'ggzyjy.jxsggzy.cn',
        'Origin': 'http://ggzyjy.jxsggzy.cn',
        'Referer': 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/pminfo/JtgcSgPM_List?DanWeiType='+compType+'&DanWeiGuid=' + alink,
        'Cache-Control': 'no-cache'
    }

    detailResponse = requests.post(url=personnelUrl, data=params, headers=headers, cookies=requestsCookies)
    detailTextJson = json.loads(detailResponse.text)
    controls = detailTextJson['controls']
    return controls

# 设置企业人员信息
def set_comp_personnel_info(controls):
    compPersonnels = []
    controls = controls[0]
    total = controls['total']
    if total > 0:
        dataList = controls['data']
        for data in dataList:
            compPersonnel = CompPersonnel()
            compPersonnel.name = data['pmname']
            compPersonnel.jobDetail = data['ZiGeZhengShu']
            zhicheng = data['zhicheng']
            if zhicheng == '3':
                zhicheng = '副高级'
            elif zhicheng == '2':
                zhicheng = '中级'
            elif zhicheng == '4':
                zhicheng = '正高级'
            elif zhicheng == '1':
                zhicheng = '初级'
            compPersonnel.jobTitle =zhicheng
            compPersonnels.append(compPersonnel.__dict__)
    return compPersonnels

# 获取企业资质信息
def get_company_aptitude_info(requestsCookies, scrfcokie, compType, alink):
    # 房建及市政施工单位
    compTypeHouseBidder = '131'
    # 交通施工单位
    compTypeTrafficBidder = '132'
    # 水利施工单位
    compTypeWaterBidder = '133'
    # 重点工程投标单位
    compTypeKeyProjectBidder = '135'
    # 水利监理单位
    compTypeWaterMonitorBidder = '143'
    # 水利勘查设计单位
    compTypeWaterDeviseBidder = '163'
    aptitudeType = ''
    aptitudeTypeUrl = ''
    if compType == compTypeHouseBidder:
        aptitudeType = 'FjSgZiZhi_List'
        aptitudeTypeUrl = 'jxpFjShiGongZiZhiListForWebAction.action'
    elif compType == compTypeTrafficBidder:
        aptitudeType = 'JtgcSgZiZhi_List'
        aptitudeTypeUrl = 'jxpJtgcSgZiZhiListForWebAction.action'
    elif compType == compTypeWaterBidder:
        aptitudeType = 'SlSgZiZhi_List'
        aptitudeTypeUrl = 'jxpSlShiGongZiZhiListForWebAction.action'
    elif compType == compTypeKeyProjectBidder:
        aptitudeType = 'ZDSgZiZhi_List'
        aptitudeTypeUrl = 'jxpZDShiGongZiZhiListForWebAction.action'
    elif compType == compTypeWaterMonitorBidder:
        aptitudeType = 'SlJlZiZhi_List'
        aptitudeTypeUrl = 'jxpSlJlShiGongZiZhiListForWebAction.action'
    elif compType == compTypeWaterDeviseBidder:
        aptitudeType = 'SlKcZiZhi_List'
        aptitudeTypeUrl = 'jxpSlKcShiGongZiZhiListForWebAction.action'

    aptitudeUrl = 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/shigongzizhi/'+aptitudeTypeUrl+'?cmd=page_Load&DanWeiType='+compType+'&DanWeiGuid='+alink+'&isCommondto=true'
    params = {
        'commonDto': '[{"id":"datagrid","type":"datagrid","action":"defaultModel","idField":"rowguid","pageIndex":0,"pageSize":100,"sortField":"","sortOrder":"","columns":[],"data":[]}]'
    }
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'X-Requested-With': 'XMLHttpRequest',
        # 'Cookie': cookies,
        'CSRFCOOKIE': scrfcokie,
        'Host': 'ggzyjy.jxsggzy.cn',
        'Origin': 'http://ggzyjy.jxsggzy.cn',
        'Referer': 'http://ggzyjy.jxsggzy.cn/hygs/huiyuaninfo/pages/shigongzizhi/'+aptitudeType+'?DanWeiType='+compType+'&DanWeiGuid=' + alink,
        'Cache-Control': 'no-cache'
    }

    detailResponse = requests.post(url=aptitudeUrl, data=params, headers=headers, cookies=requestsCookies)
    detailTextJson = json.loads(detailResponse.text)
    controls = detailTextJson['controls']
    return controls

# 设置企业资质信息
def set_comp_aptitude_info(controls):
    compAptitudes = []
    controls = controls[0]
    total = controls['total']
    if total > 0:
        dataList = controls['data']
        for data in dataList:
            compAptitude = CompAptitude()
            compAptitude.certificateNum = data['zhengshuno']
            compAptitude.certificateDetail = data['showzy']
            compAptitudes.append(compAptitude.__dict__)
    return compAptitudes