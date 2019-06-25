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
import top.zywork.query.CompTrafficAchievementCompanyQuery;
import top.zywork.query.CompTrafficAchievementQuery;
import top.zywork.service.CompTrafficAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompTrafficAchievementCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompTrafficAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompTrafficAchievementCompany")
@HasHideProperty
public class CompTrafficAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompTrafficAchievementCompanyController.class);

    private CompTrafficAchievementCompanyService compTrafficAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compTrafficAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compTrafficAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompTrafficAchievementCompanyQuery compTrafficAchievementCompanyQuery) {
        PagerDTO pagerDTO = compTrafficAchievementCompanyService.listAllByCondition(compTrafficAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompTrafficAchievementCompanyQuery compTrafficAchievementCompanyQuery) {
        PagerDTO pagerDTO = compTrafficAchievementCompanyService.listPageByCondition(compTrafficAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompTrafficAchievementCompany/user/pager-cond", properties = {"companyCompName","compTrafficAchievementProjectName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompTrafficAchievementCompanyQuery compTrafficAchievementCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compTrafficAchievementCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompTrafficAchievementCompanyService(CompTrafficAchievementCompanyService compTrafficAchievementCompanyService) {
        this.compTrafficAchievementCompanyService = compTrafficAchievementCompanyService;
    }
}
