import requests
from bs4 import BeautifulSoup
import time

from model.project.project import Project


# 重点工程
def get_key_project(pageNo):
    # current_key_file = open('current_key_file.txt', 'r+')
    # 获取已爬取的最新的链接
    # current_key_href = current_key_file.readline()
    response = requests.get(url="http://ggzy.jiangxi.gov.cn/web/jyxx/002005/002005001/"+pageNo+".html")
    # 获取文本原来编码，使两者编码一致才能正确显示
    response.encoding = response.apparent_encoding
    # 使用的是html解析，一般使用lxml解析更好
    soup = BeautifulSoup(response.text, 'html5lib')
    target = soup.find('div', {'class': 'ewb-infolist'})
    li_list = target.ul.find_all('li')
    latest_flag = False
    projects = []
    for li in li_list:
        href = 'http://ggzy.jiangxi.gov.cn' + li.a.get('href')
        # 如果已爬取的最新链接不等于现在抓取的链接，则表示网站有更新新数据
        # if current_key_href != href:
        #     if not latest_flag:
        #         # 清除文件原内容
        #         current_key_file.seek(0)
        #         current_key_file.truncate()
        #         # 记录新链接到文件中
        #         current_key_file.write(href)
        #         latest_flag = True
        # else:
        #     # 网站没有更新新数据，则停止爬取
        #     break
        project = Project()
        project.projectType = '重点工程'
        project.title = li.a.text
        project.sourceUrl = href
        # 打开招标详情页面
        project_res = requests.get(href)
        project_res.encoding = project_res.apparent_encoding
        project_soup = BeautifulSoup(project_res.text, 'html5lib')
        # 获取招标信息主体文档
        article_info = project_soup.find('div', {'class': 'article-info'})
        get_from_table(project, article_info)
        # 去除页面底部查看操作说明 与 交易主体登录按钮
        [s.extract() for s in article_info.find_all('a', {'class': 'buttomlink'})]
        project.projectDetail = str(article_info)
        project.noticeTime = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        projects.append(project.__dict__)
    # current_key_file.close()
    print(projects)
    return projects


# 从表格中获取招标信息
def get_from_table(project, article_info):
    # 处理招标信息表格
    project.markUnitName = get_from_td(article_info, u'招标单位名称')
    project.projectInvest = get_from_td(article_info, u'本项目投资')
    project.checkPattern = get_from_td(article_info, u'资格审查方式')
    imp_money = get_from_td(article_info, u'资金已落实')
    if imp_money is not None:
        project.moneyToImplement = imp_money[0: len(imp_money) - 1]
    project.compAptitudeType = get_from_td(article_info, u'企业资质类别及等级')
    project.builderLevel = get_from_td(article_info, u'注册建造师类别和等级')
    project.phone = get_from_td(article_info, u'联系电话')
    project.otherDemand = get_from_td(article_info, u'其他要求')


# 解析指定td的内容
def get_from_td(article_info, zh_text):
    tag = article_info.find(text=zh_text)
    if tag is not None:
        td = tag.parent.parent
        if td.name == 'td':
            text = td.next_sibling.next_sibling.span.text
            return text
    return None

