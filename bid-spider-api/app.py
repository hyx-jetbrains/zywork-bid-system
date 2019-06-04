from flask import Flask
from controller.project.project import project
from controller.company.company import company

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

app.register_blueprint(project, url_prefix='/project')
app.register_blueprint(company, url_prefix="/company")

if __name__ == '__main__':
    app.run()
