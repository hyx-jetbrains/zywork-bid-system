import requests
from bs4 import BeautifulSoup

from model.project.project_announce import ProjectAnnounce


# 交通工程
def get_traffic_announce_projects(pageNo):
    # current_announce_traffic_file = open('current_announce_traffic_file.txt', 'r+')
    # 获取已爬取的最新的链接
    # current_announce_traffic_href = current_announce_traffic_file.readline()
    response = requests.get(url="http://www.jxsggzy.cn/web/jyxx/002002/002002005/"+pageNo+".html")
    # 获取文本原来编码，使两者编码一致才能正确显示
    response.encoding = response.apparent_encoding
    # 使用的是html解析，一般使用lxml解析更好
    soup = BeautifulSoup(response.text, 'html5lib')
    # find根据属性去获取对象，id,attr,tag...自定义属性
    target = soup.find('div', {'class': 'ewb-infolist'})
    li_list = target.ul.find_all('li')
    latest_flag = False
    projects = []
    for li in li_list:
        href = 'http://ggzy.jiangxi.gov.cn' + li.a.get('href')
        # 如果已爬取的最新链接不等于现在抓取的链接，则表示网站有更新新数据
        # if current_announce_traffic_href != href:
        #     if not latest_flag:
        #         # 清除文件原内容
        #         current_announce_traffic_file.seek(0)
        #         current_announce_traffic_file.truncate()
        #         # 记录新链接到文件中
        #         current_announce_traffic_file.write(href)
        #         latest_flag = True
        # else:
        #     # 网站没有更新新数据，则停止爬取
        #     break
        projectAnnounce = ProjectAnnounce()
        projectAnnounce.title = li.a.text
        projectAnnounce.sourceUrl = href
        projectAnnounce.projectType = '交通工程'
        # 打开招标详情页面
        project_res = requests.get(href)
        project_res.encoding = project_res.apparent_encoding
        project_soup = BeautifulSoup(project_res.text, 'html5lib')
        # 获取招标信息主体文档
        article_info = project_soup.find('div', {'class': 'article-info'})
        get_from_table(projectAnnounce, article_info)
        # 去除页面底部查看操作说明 与 交易主体登录按钮
        [s.extract() for s in article_info.find_all('a', {'class': 'buttomlink'})]
        projectAnnounce.announceDesc = str(article_info)
        projects.append(projectAnnounce.__dict__)
    # current_announce_traffic_file.close()
    print(projects)
    return projects


# 从表格中获取招标信息
def get_from_table(projectAnnounce, article_info):
    # 处理招标信息表格
    projectAnnounce.firstCandidate = get_from_td(article_info, u'第一中标排序单位名称')
    projectAnnounce.firstBuilderName = get_from_td(article_info, u'建造师姓名')
    imp_money = get_from_td(article_info, u'投标报价')
    if imp_money is not None:
        projectAnnounce.firstMarkMoney = imp_money[0: len(imp_money) - 1]
    projectAnnounce.secondCandidate = get_from_td(article_info, u'第二中标排序单位名称')
    projectAnnounce.thirdCandidate = get_from_td(article_info, u'第三中标排序单位名称')


# 解析指定td的内容
def get_from_td(article_info, zh_text):
    tag = article_info.find(text=zh_text)
    if tag is not None:
        td = tag.parent.parent
        if td.name == 'td':
            text = td.next_sibling.next_sibling.span.text
            return text
    return None
