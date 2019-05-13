from flask import Blueprint, jsonify
from model.project_house import get_projects

project = Blueprint('project', __name__)


@project.route('/all')
def index():
    return jsonify(get_projects())
