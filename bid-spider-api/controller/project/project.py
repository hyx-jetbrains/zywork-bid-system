from flask import Blueprint, jsonify

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
    return jsonify(get_house_projects())

# 水利工程
@project.route('/conservancy')
def conservancy():
    return jsonify(get_conservancy_project())

# 交通工程
@project.route('/traffic')
def traffic():
    return jsonify(get_traffic_project())

# 政府采购
@project.route('/procurement')
def procurement():
    return jsonify(get_procurement_project())

# 重点项目
@project.route('/key')
def key():
    return jsonify(get_key_project())

# 其他项目
@project.route('/other')
def other():
    return jsonify(get_other_project())
