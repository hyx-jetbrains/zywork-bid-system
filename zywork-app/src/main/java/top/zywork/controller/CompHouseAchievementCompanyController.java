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
import top.zywork.query.CompHouseAchievementCompanyQuery;
import top.zywork.query.CompHouseAchievementQuery;
import top.zywork.service.CompHouseAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompHouseAchievementCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompHouseAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompHouseAchievementCompany")
public class CompHouseAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompHouseAchievementCompanyController.class);

    private CompHouseAchievementCompanyService compHouseAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compHouseAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compHouseAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompHouseAchievementCompanyQuery compHouseAchievementCompanyQuery) {
        PagerDTO pagerDTO = compHouseAchievementCompanyService.listAllByCondition(compHouseAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompHouseAchievementCompanyQuery compHouseAchievementCompanyQuery) {
        PagerDTO pagerDTO = compHouseAchievementCompanyService.listPageByCondition(compHouseAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompHouseAchievementCompany/user/pager-cond", properties = {"companyCompName","compHouseAchievementProjectName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompHouseAchievementCompanyQuery compHouseAchievementCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compHouseAchievementCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompHouseAchievementCompanyService(CompHouseAchievementCompanyService compHouseAchievementCompanyService) {
        this.compHouseAchievementCompanyService = compHouseAchievementCompanyService;
    }
}
