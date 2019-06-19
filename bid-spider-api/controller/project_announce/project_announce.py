from flask import Blueprint, jsonify, request

from model.project.project_announce_conservancy import get_conservancy_announce_projects
from model.project.project_announce_house import get_house_announce_projects
from model.project.project_announce_key import get_key_announce_projects
from model.project.project_announce_other import get_other_announce_projects
from model.project.project_announce_procurement import get_procurement_announce_projects
from model.project.project_announce_traffic import get_traffic_announce_projects

projectAnnounce = Blueprint('project-announce', __name__)


# 房建及市政工程
@projectAnnounce.route('/house')
def index():
    pageNo = request.args.get('pageNo')
    return jsonify(get_house_announce_projects(pageNo))

# 水利工程
@projectAnnounce.route('/conservancy')
def conservancy():
    pageNo = request.args.get('pageNo')
    return jsonify(get_conservancy_announce_projects(pageNo))

# 交通工程
@projectAnnounce.route('/traffic')
def traffic():
    pageNo = request.args.get('pageNo')
    return jsonify(get_traffic_announce_projects(pageNo))

# 政府采购
@projectAnnounce.route('/procurement')
def procurement():
    pageNo = request.args.get('pageNo')
    return jsonify(get_procurement_announce_projects(pageNo))

# 重点项目
@projectAnnounce.route('/key')
def key():
    pageNo = request.args.get('pageNo')
    return jsonify(get_key_announce_projects(pageNo))

# 其他项目
@projectAnnounce.route('/other')
def other():
    pageNo = request.args.get('pageNo')
    return jsonify(get_other_announce_projects(pageNo))
