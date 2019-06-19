from flask import Blueprint, jsonify, request
from model.comp_house_achievement_info import get_house_achievement

compHouseAchievement = Blueprint('comp-house-achievement', __name__)


@compHouseAchievement.route('/house')
def index():
    pageNo = request.args.get("pageNo")
    return jsonify(get_house_achievement(pageNo))
