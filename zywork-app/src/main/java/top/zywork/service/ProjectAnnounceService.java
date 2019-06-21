package top.zywork.service;


import top.zywork.dto.ProjectDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * ProjectAnnounceService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface ProjectAnnounceService extends BaseService {


    /***
     * @description: 取前端所需的下拉框，用于公示详情的下拉框
     * @return: java.util.List<top.zywork.dto.ProjectDTO>
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-23 13:09
     */
    List<ProjectDTO> getProjectSelect(Long projectId);

    Object getByProjectId(Long projectId);

    Object getByTitle(String title);

}
