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
import top.zywork.query.CompKeyProjectAchievementCompanyQuery;
import top.zywork.query.CompKeyProjectAchievementQuery;
import top.zywork.service.CompKeyProjectAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompKeyProjectAchievementCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompKeyProjectAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompKeyProjectAchievementCompany")
@HasHideProperty
public class CompKeyProjectAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompKeyProjectAchievementCompanyController.class);

    private CompKeyProjectAchievementCompanyService compKeyProjectAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompKeyProjectAchievementCompanyQuery compKeyProjectAchievementCompanyQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listAllByCondition(compKeyProjectAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompKeyProjectAchievementCompanyQuery compKeyProjectAchievementCompanyQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listPageByCondition(compKeyProjectAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompKeyProjectAchievementCompany/user/pager-cond", properties = {"companyCompName", "compKeyProjectAchievementProjectName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompKeyProjectAchievementCompanyQuery compKeyProjectAchievementCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compKeyProjectAchievementCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompKeyProjectAchievementCompanyService(CompKeyProjectAchievementCompanyService compKeyProjectAchievementCompanyService) {
        this.compKeyProjectAchievementCompanyService = compKeyProjectAchievementCompanyService;
    }
}
