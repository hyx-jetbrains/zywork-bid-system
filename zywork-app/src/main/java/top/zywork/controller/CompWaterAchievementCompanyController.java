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
import top.zywork.query.CompWaterAchievementCompanyQuery;
import top.zywork.query.CompWaterAchievementQuery;
import top.zywork.service.CompWaterAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompWaterAchievementCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompWaterAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompWaterAchievementCompany")
@HasHideProperty
public class CompWaterAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompWaterAchievementCompanyController.class);

    private CompWaterAchievementCompanyService compWaterAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compWaterAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compWaterAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompWaterAchievementCompanyQuery compWaterAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterAchievementCompanyService.listAllByCondition(compWaterAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompWaterAchievementCompanyQuery compWaterAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterAchievementCompanyService.listPageByCondition(compWaterAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompWaterAchievementCompany/user/pager-cond", properties = {"companyCompName", "compWaterAchievementProjectName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompWaterAchievementCompanyQuery compWaterAchievementCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compWaterAchievementCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompWaterAchievementCompanyService(CompWaterAchievementCompanyService compWaterAchievementCompanyService) {
        this.compWaterAchievementCompanyService = compWaterAchievementCompanyService;
    }
}
