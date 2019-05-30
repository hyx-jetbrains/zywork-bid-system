package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.HasHideProperty;
import top.zywork.annotation.HideProperty;
import top.zywork.common.BeanUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.query.CompTrafficAchievementQuery;
import top.zywork.query.ProjectAnnounceProjectQuery;
import top.zywork.service.ProjectAnnounceProjectService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ProjectAnnounceProjectVO;

import javax.servlet.http.HttpServletRequest;

/**
 * ProjectAnnounceProjectController控制器类<br/>
 *
 * 创建于2019-05-29<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/ProjectAnnounceProject")
@HasHideProperty
public class ProjectAnnounceProjectController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectAnnounceProjectController.class);

    private ProjectAnnounceProjectService projectAnnounceProjectService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = projectAnnounceProjectService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectAnnounceProjectService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectAnnounceProjectQuery projectAnnounceProjectQuery) {
        PagerDTO pagerDTO = projectAnnounceProjectService.listAllByCondition(projectAnnounceProjectQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectAnnounceProjectQuery projectAnnounceProjectQuery) {
        PagerDTO pagerDTO = projectAnnounceProjectService.listPageByCondition(projectAnnounceProjectQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/ProjectAnnounceProject/user/pager-cond", properties = {"projectAnnounceFirstCandidate","projectAnnounceSecondCandidate","projectAnnounceThirdCandidate"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody ProjectAnnounceProjectQuery projectAnnounceProjectQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(projectAnnounceProjectQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setProjectAnnounceProjectService(ProjectAnnounceProjectService projectAnnounceProjectService) {
        this.projectAnnounceProjectService = projectAnnounceProjectService;
    }
}
