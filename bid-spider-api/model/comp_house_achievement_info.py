import requests
from bs4 import BeautifulSoup
import time

from model.project import Project
from model.comp_house_achievement import CompHouseAchievement


def get_house_achievement():
    current_house_file = open('current_house_achievement_file.txt', 'r+')
    # 获取已爬取的最新的链接
    current_house_href = current_house_file.readline()
    response = requests.get(url="http://59.52.254.77:8081/jxhthy/HeTongBAMis2_JX/Pages/QueryInfo/Query_List.aspx")
    # 获取文本原来编码，使两者编码一致才能正确显示
    response.encoding = response.apparent_encoding
    # 使用的是html解析，一般使用lxml解析更好
    soup = BeautifulSoup(response.text, 'html5lib')
    # find根据属性获取table对象
    table = soup.find('table', {'rules' : 'all'})
    tbody = table.find('tbody')
    tr_list = tbody.find_all('tr')
    compHouseAchievements = []

    latest_flag = False
    for tr in tr_list:
        if tr.get('class')[0] == 'HeaderStyle':
            continue
        a = tr.find('a')
        ahref = a.get('href')
        href = 'http://59.52.254.77:8081/jxhthy/HeTongBAMis2_JX/Pages/QueryInfo/ZBTZS_Detail.aspx?' + ahref.split('?')[1]
        # 如果已爬取的最新链接不等于现在抓取的链接，则表示网站有更新新数据
        if current_house_href != href:
            if not latest_flag:
                # 清除文件原内容
                current_house_file.seek(0)
                current_house_file.truncate()
                # 记录新链接到文件中
                current_house_file.write(href)
                latest_flag = True
        else:
            # 网站没有更新新数据，则停止爬取
            break
        # 有更新，打开业绩详情
        detailResponse = requests.get(href)
        # 获取文本原来编码，使两者编码一致才能正确显示
        detailResponse.encoding = detailResponse.apparent_encoding
        # 使用的是html解析，一般使用lxml解析更好
        detailSoup = BeautifulSoup(detailResponse.text, 'html5lib')
        table = detailSoup.find('table', {'class' : 'table'})
        compHouseAchievement = CompHouseAchievement()
        compHouseAchievement = get_from_table(compHouseAchievement, table)
        compHouseAchievements.append(compHouseAchievement.__dict__)
    current_house_file.close()
    return compHouseAchievements

# 从表格中获取房建业绩信息
def get_from_table(compHouseAchievement, table):
    # 处理房建业绩信息表格
    compHouseAchievement.projectName = get_from_td(table, 'ctl00_ContentPlaceHolder1_ProjectName_1110')
    compHouseAchievement.builderName = get_from_td(table, 'ctl00_ContentPlaceHolder1_RenYuanName_1110')
    compHouseAchievement.markMoney = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZhongBiaoJinE_1110')
    compHouseAchievement.buildScale = get_from_td(table, 'ctl00_ContentPlaceHolder1_PrjSize_1110')
    compHouseAchievement.regionType = get_from_td(table, 'ctl00_ContentPlaceHolder1_XiaQuName_1110')
    compHouseAchievement.buildComp = get_from_td(table, 'ctl00_ContentPlaceHolder1_JSDanWeiName_1110')
    compHouseAchievement.projectAddr = get_from_td(table, 'ctl00_ContentPlaceHolder1_Pro_Address_1110')
    compHouseAchievement.contractDate = get_from_td(table, 'ctl00_ContentPlaceHolder1_ContractDate_1110')
    compHouseAchievement.markDate = get_from_td(table, 'ctl00_ContentPlaceHolder1_BASJ_1110')
    compHouseAchievement.name = get_from_td(table, 'ctl00_ContentPlaceHolder1_RenYuanName_1110')
    compHouseAchievement.certificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZhengShuBH_1110')
    compHouseAchievement.constructors = get_from_td(table, 'ctl00_ContentPlaceHolder1_SG_Name_1110')
    compHouseAchievement.constructorsCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_SG_ShangGangCard_1110')
    compHouseAchievement.constructorsIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_SG_CardNO_1110')
    compHouseAchievement.qualityWorker = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZHJ_Name_1110')
    compHouseAchievement.qualityWorkerCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZHJ_ShangGangCard_1110')
    compHouseAchievement.qualityWorkerIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZHJ_CardNO_1110')
    compHouseAchievement.securityOfficer = get_from_td(table, 'ctl00_ContentPlaceHolder1_AQ_Name_1110')
    compHouseAchievement.securityOfficerCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_AQ_ShangGangCard_1110')
    compHouseAchievement.securityOfficerIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_AQ_CardNO_1110')
    compHouseAchievement.standardWorker = get_from_td(table, 'ctl00_ContentPlaceHolder1_BiaoZhunY_Name_1110')
    compHouseAchievement.standardWorkerCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_BiaoZhunY_ShangGangCard_1110')
    compHouseAchievement.standardWorkerIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_BiaoZhunY_CardNO_1110')
    compHouseAchievement.materialMan = get_from_td(table, 'ctl00_ContentPlaceHolder1_CL_Name_1110')
    compHouseAchievement.materialManCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_CL_ShangGangCard_1110')
    compHouseAchievement.materialManIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_CL_CardNO_1110')
    compHouseAchievement.mechanic = get_from_td(table, 'ctl00_ContentPlaceHolder1_JXY_Name_1110')
    compHouseAchievement.mechanicCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_JXY_ShangGangCard_1110')
    compHouseAchievement.mechanicIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_JXY_CardNO_1110')
    compHouseAchievement.labors = get_from_td(table, 'ctl00_ContentPlaceHolder1_LWY_Name_1110')
    compHouseAchievement.laborsCertificateNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_LWY_ShangGangCard_1110')
    compHouseAchievement.laborsIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_LWY_CardNO_1110')
    compHouseAchievement.dataClerk = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZLY_Name_1110')
    compHouseAchievement.dataClerkCertificateNum = get_from_td(table,  'ctl00_ContentPlaceHolder1_ZLY_ShangGangCard_1110')
    compHouseAchievement.dataClerkIdNum = get_from_td(table, 'ctl00_ContentPlaceHolder1_ZYL_CardNO_1110')
    return compHouseAchievement


# 解析指定td的内容
def get_from_td(table, zh_text):
    tag = table.find(id=zh_text)
    if tag is not None:
        text = tag.text
        return text
    return None
