import requests
from bs4 import BeautifulSoup
import os
import uuid

from model.project import Project


def get_projects():
    response = requests.get(url="http://ggzy.jiangxi.gov.cn/web/jyxx/002001/002001001/1.html")
    # 获取文本原来编码，使两者编码一致才能正确显示
    response.encoding = response.apparent_encoding

    # 使用的是html解析，一般使用lxml解析更好
    soup = BeautifulSoup(response.text,'html5lib')
    # find根据属性去获取对象，id,attr,tag...自定义属性
    target = soup.find('div',{'class':'ewb-infolist'})
    li_list = target.ul.find_all('li')
    for li in li_list:
        href = 'http://ggzy.jiangxi.gov.cn' + li.a.get('href')
        print(href)
        print(li.a.text)
        project_res = requests.get(href)
        project_res.encoding = project_res.apparent_encoding
        project_soup = BeautifulSoup(project_res.text, 'html5lib')
        article_info = project_soup.find('div', {'class':'article-info'})
        # 去除页面底部查看操作说明 与 交易主体登录按钮
        [s.extract() for s in project_soup.find_all('a', {'class': 'buttomlink'})]
        print(article_info)
    project = Project()
    project.title = '测试'
    project.projectType = '测试'
    return project.__dict__
