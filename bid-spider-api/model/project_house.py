import requests
from bs4 import BeautifulSoup
import time

from model.project import Project


def get_house_projects():
    current_house_file = open('current_house_file.txt', 'r+')
    # 获取已爬取的最新的链接
    current_house_href = current_house_file.readline()
    response = requests.get(url="http://ggzy.jiangxi.gov.cn/web/jyxx/002001/002001001/1.html")
    # 获取文本原来编码，使两者编码一致才能正确显示
    response.encoding = response.apparent_encoding
    # 使用的是html解析，一般使用lxml解析更好
    soup = BeautifulSoup(response.text,'html5lib')
    # find根据属性去获取对象，id,attr,tag...自定义属性
    target = soup.find('div',{'class':'ewb-infolist'})
    li_list = target.ul.find_all('li')
    latest_flag = False
    projects = []
    for li in li_list:
        href = 'http://ggzy.jiangxi.gov.cn' + li.a.get('href')
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
        project = Project()
        project.projectType = '房建市政'
        project.title = li.a.text
        project.sourceUrl = href
        # 打开招标详情页面
        project_res = requests.get(href)
        project_res.encoding = project_res.apparent_encoding
        project_soup = BeautifulSoup(project_res.text, 'html5lib')
        # 获取招标信息主体文档
        article_info = project_soup.find('div', {'class':'article-info'})
        # 处理招标信息表格
        company_name_tag = article_info.find(text=u'招标单位名称')
        if company_name_tag is not None:
            company_name_td = company_name_tag.parent.parent
            if company_name_td.name == 'tag':
                company_name = company_name_td.parent.parent.next_sibling.next_sibling.span.text
                project.markUnitName = company_name
        invest_tag = article_info.find(text=u'本项目投资')
        if invest_tag is not None:
            invest_td = invest_tag.parent.parent
            if invest_td.name == 'td':
                invest = invest_td.next_sibling.next_sibling.span.text
                project.projectInvest = invest
        check_tag = article_info.find(text=u'资格审查方式')
        if check_tag is not None:
            check_td = check_tag.parent.parent
            if check_td.name == 'td':
                check_pattern = check_td.next_sibling.next_sibling.span.text
                project.checkPattern = check_pattern
        imp_money_tag = article_info.find(text=u'资金已落实')
        if imp_money_tag is not None:
            imp_money_td = imp_money_tag.parent.parent
            if imp_money_td.name == 'td':
                imp_money = imp_money_td.next_sibling.next_sibling.span.text
                project.moneyToImplement = imp_money[0: len(imp_money) - 1]
        aptitude_tag = article_info.find(text=u'企业资质类别及等级')
        if aptitude_tag is not None:
            aptitude_td = aptitude_tag.parent.parent
            if aptitude_td.name == 'td':
                aptitude = aptitude_td.next_sibling.next_sibling.span.text
                project.compAptitudeType = aptitude
        builder_tag = article_info.find(text=u'注册建造师类别和等级')
        if builder_tag is not None:
            builder_td = builder_tag.parent.parent
            if builder_td.name == 'td':
                builder_level = builder_td.next_sibling.next_sibling.span.text
                project.builderLevel = builder_level
        phone_tag = article_info.find(text=u'联系电话')
        if phone_tag is not None:
            phone_td = phone_tag.parent.parent
            if phone_td.name == 'td':
                phone = phone_td.next_sibling.next_sibling.span.text
                project.phone = phone
        other_demand_tag = article_info.find(text=u'其他要求')
        if other_demand_tag is not None:
            other_demand_td = other_demand_tag.parent.parent
            if other_demand_td.name == 'td':
                other_demand = other_demand_td.next_sibling.next_sibling.span.text
                project.otherDemand = other_demand
        # 去除页面底部查看操作说明 与 交易主体登录按钮
        [s.extract() for s in article_info.find_all('a', {'class': 'buttomlink'})]
        project.projectDetail = str(article_info)
        project.noticeTime = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        projects.append(project.__dict__)
    current_house_file.close()
    print(projects)
    return projects
