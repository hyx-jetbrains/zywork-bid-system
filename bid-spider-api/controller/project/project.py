from flask import Blueprint, jsonify, request

from model.project.project_conservancy import get_conservancy_project
from model.project.project_house import get_house_projects
from model.project.project_key import get_key_project
from model.project.project_other import get_other_project
from model.project.project_procurement import get_procurement_project
from model.project.project_traffic import get_traffic_project

project = Blueprint('project', __name__)


# 房建及市政工程
@project.route('/house')
def index():
    pageNo = request.args.get('pageNo')
    return jsonify(get_house_projects(pageNo))

# 水利工程
@project.route('/conservancy')
def conservancy():
    pageNo = request.args.get('pageNo')
    return jsonify(get_conservancy_project(pageNo))

# 交通工程
@project.route('/traffic')
def traffic():
    pageNo = request.args.get('pageNo')
    return jsonify(get_traffic_project(pageNo))

# 政府采购
@project.route('/procurement')
def procurement():
    pageNo = request.args.get('pageNo')
    return jsonify(get_procurement_project(pageNo))

# 重点项目
@project.route('/key')
def key():
    pageNo = request.args.get('pageNo')
    return jsonify(get_key_project(pageNo))

# 其他项目
@project.route('/other')
def other():
    pageNo = request.args.get('pageNo')
    return jsonify(get_other_project(pageNo))
