from flask import request
from flask import Blueprint, jsonify
from model.company_info import get_company_info

company = Blueprint('company', __name__)


@company.route('/info')
def index():
    type = request.args.get('type')
    compType = request.args.get('compType')
    pageNo = request.args.get('pageNo')
    pageSize = request.args.get('pageSize')
    return jsonify(get_company_info(type, compType, pageNo, pageSize))
