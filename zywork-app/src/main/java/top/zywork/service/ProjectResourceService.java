package top.zywork.service;

import top.zywork.query.ProjectResourceQuery;
import top.zywork.vo.ResponseStatusVO;

/**
 * ProjectResourceService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface ProjectResourceService extends BaseService {

    /**
     * 根据指定条件来删除项目资源附件
     * @param projectResourceQuery
     */
    ResponseStatusVO deleteByCond(ProjectResourceQuery projectResourceQuery);
}
