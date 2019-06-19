package top.zywork.service;

import org.apache.ibatis.annotations.Param;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.query.ProjectQuery;
import top.zywork.vo.ProjectVO;

import java.util.List;

/**
 * ProjectService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface ProjectService extends BaseService {

    /***
     * @description: 获取中标公示，根据开标时间进行判断，用于保存和更新
     * @param projectVO
     * @return: top.zywork.vo.ProjectVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-23 11:15
     */
    ProjectVO getOpenMark(ProjectVO projectVO);

    /***
     * @description: 批量更新项目的中标公示
     * @param projectVOList
     * @return: java.util.List<top.zywork.vo.ProjectVO>
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-23 11:21
     */
    List<ProjectVO> getOpenMarkList(List<ProjectVO> projectVOList);

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:11
     * Description: 根据用户id查询收藏项目
     */
    PagerDTO listPageByUserId(@Param("query") Object queryObj, @Param("userId") Long userId);

    PagerDTO  listProjectByPage(ProjectQuery projectQuery);

    PagerDTO findProjectByd(@Param("id") Long id);

    Object getProjectBySelect(@Param("id") Long id, @Param("city") String city, @Param("list") List<Object> list);

    /***
     * @description:  更新项目的状态为待开标，只有job调用，其他地方请不要调用这个方法
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-18 18:29
     */
    void updateMarkStatus();
}
