from flask import Blueprint, jsonify

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
    return jsonify(get_house_announce_projects())

# 水利工程
@projectAnnounce.route('/conservancy')
def conservancy():
    return jsonify(get_conservancy_announce_projects())

# 交通工程
@projectAnnounce.route('/traffic')
def traffic():
    return jsonify(get_traffic_announce_projects())

# 政府采购
@projectAnnounce.route('/procurement')
def procurement():
    return jsonify(get_procurement_announce_projects())

# 重点项目
@projectAnnounce.route('/key')
def key():
    return jsonify(get_key_announce_projects())

# 其他项目
@projectAnnounce.route('/other')
def other():
    return jsonify(get_other_announce_projects())
