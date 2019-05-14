from flask import Blueprint, jsonify
from model.project_house import get_house_projects

project = Blueprint('project', __name__)


@project.route('/house')
def index():
    return jsonify(get_house_projects())
