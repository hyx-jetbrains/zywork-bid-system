package top.zywork.service;

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
}
