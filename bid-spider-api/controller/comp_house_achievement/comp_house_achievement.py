from flask import Blueprint, jsonify, request
from model.comp_house_achievement_info import get_house_achievement, init_file

compHouseAchievement = Blueprint('comp-house-achievement', __name__)


# 获取房建业绩详细信息
@compHouseAchievement.route('/house')
def index():
    pageNo = request.args.get("pageNo")
    return jsonify(get_house_achievement(pageNo))

# 初始化房建业绩的文件
@compHouseAchievement.route("/initFile")
def initFile():
    return init_file()
