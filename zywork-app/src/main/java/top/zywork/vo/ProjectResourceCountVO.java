package top.zywork.vo;

import java.util.List;

/**
 * User: DengMin
 * Date: 2019/05/30
 * Time: 18:00
 * Description: No Description
 */
public class ProjectResourceCountVO extends BaseVO{

    private List<Object> obj;

    private ProjectVO project;

    public List<Object> getObj() {
        return obj;
    }

    public void setObj(List<Object> obj) {
        this.obj = obj;
    }

    public ProjectVO getProject() {
        return project;
    }

    public void setProject(ProjectVO project) {
        this.project = project;
    }
}
