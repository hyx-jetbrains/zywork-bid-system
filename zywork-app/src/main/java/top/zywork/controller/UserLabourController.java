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
import top.zywork.query.UserBuilderQuery;
import top.zywork.query.UserLabourQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserLabourService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserLabourVO;

import javax.servlet.http.HttpServletRequest;

/**
 * UserLabourController控制器类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/UserLabour")
@HasHideProperty
public class UserLabourController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserLabourController.class);

    private UserLabourService userLabourService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userLabourService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userLabourService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserLabourQuery userLabourQuery) {
        PagerDTO pagerDTO = userLabourService.listAllByCondition(userLabourQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserLabourQuery userLabourQuery) {
        PagerDTO pagerDTO = userLabourService.listPageByCondition(userLabourQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /***
     * @description:  信息共享 -  劳务信息  -  劳务求职
     * @param request
     * @param userLabourQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 14:41
     */
    @PostMapping("user/list-page")
    @HideProperty(url = "/UserLabour/user/list-page", properties = {"labourPhone"})
    public ResponseStatusVO listPage(HttpServletRequest request, @RequestBody UserLabourQuery userLabourQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(userLabourQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "listPage",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    /***
     * @description:  我发布的劳务求职信息
     * @param userLabourQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 14:43
     */
    @PostMapping("user/list-labour-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserLabourQuery userLabourQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userLabourQuery.setLabourUserId(jwtUser.getUserId());
        userLabourQuery.setLabourIsActive((byte)0);
        return listPageByCondition(userLabourQuery);
    }


    @Autowired
    public void setUserLabourService(UserLabourService userLabourService) {
        this.userLabourService = userLabourService;
    }
}
