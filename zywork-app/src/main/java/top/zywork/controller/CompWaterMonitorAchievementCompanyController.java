package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.HideProperty;
import top.zywork.common.BeanUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.query.CompWaterMonitorAchievementCompanyQuery;
import top.zywork.query.CompWaterMonitorAchievementQuery;
import top.zywork.service.CompWaterMonitorAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompWaterMonitorAchievementCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompWaterMonitorAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompWaterMonitorAchievementCompany")
public class CompWaterMonitorAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompWaterMonitorAchievementCompanyController.class);

    private CompWaterMonitorAchievementCompanyService compWaterMonitorAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compWaterMonitorAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compWaterMonitorAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompWaterMonitorAchievementCompanyQuery compWaterMonitorAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterMonitorAchievementCompanyService.listAllByCondition(compWaterMonitorAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompWaterMonitorAchievementCompanyQuery compWaterMonitorAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterMonitorAchievementCompanyService.listPageByCondition(compWaterMonitorAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompWaterMonitorAchievementCompany/user/pager-cond", properties = {"companyCompName","compWaterMonitorAchievementProjectName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompWaterMonitorAchievementCompanyQuery compWaterMonitorAchievementCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compWaterMonitorAchievementCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompWaterMonitorAchievementCompanyService(CompWaterMonitorAchievementCompanyService compWaterMonitorAchievementCompanyService) {
        this.compWaterMonitorAchievementCompanyService = compWaterMonitorAchievementCompanyService;
    }
}
