from flask import Flask
from controller.project.project import project

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

app.register_blueprint(project, url_prefix='/project')

if __name__ == '__main__':
    app.run()
