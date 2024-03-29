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
import top.zywork.query.CompAptitudeCompanyQuery;
import top.zywork.query.CompAptitudeQuery;
import top.zywork.service.CompAptitudeCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompAptitudeCompanyVO;

import javax.servlet.http.HttpServletRequest;

/**
 * CompAptitudeCompanyController控制器类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompAptitudeCompany")
@HasHideProperty
public class CompAptitudeCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompAptitudeCompanyController.class);

    private CompAptitudeCompanyService compAptitudeCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compAptitudeCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compAptitudeCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompAptitudeCompanyQuery compAptitudeCompanyQuery) {
        PagerDTO pagerDTO = compAptitudeCompanyService.listAllByCondition(compAptitudeCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompAptitudeCompanyQuery compAptitudeCompanyQuery) {
        PagerDTO pagerDTO = compAptitudeCompanyService.listPageByCondition(compAptitudeCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/CompAptitudeCompany/user/pager-cond", properties = {"companyCompName"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompAptitudeCompanyQuery compAptitudeCompanyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compAptitudeCompanyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompAptitudeCompanyService(CompAptitudeCompanyService compAptitudeCompanyService) {
        this.compAptitudeCompanyService = compAptitudeCompanyService;
    }
}
