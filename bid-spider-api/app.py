from flask import Flask
from controller.project.project import project
from controller.project_announce.project_announce import projectAnnounce
from controller.company.company import company
from controller.comp_house_achievement.comp_house_achievement import compHouseAchievement

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

app.register_blueprint(project, url_prefix='/project')
app.register_blueprint(projectAnnounce, url_prefix="/project-announce")
app.register_blueprint(company, url_prefix="/company")
app.register_blueprint(compHouseAchievement, url_prefix="/comp-house-achievement")

if __name__ == '__main__':
    app.run()
