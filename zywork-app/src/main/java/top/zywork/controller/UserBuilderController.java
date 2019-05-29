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
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserBuilderService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserBuilderVO;

import javax.servlet.http.HttpServletRequest;

/**
 * UserBuilderController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserBuilder")
@HasHideProperty
public class UserBuilderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBuilderController.class);

    private UserBuilderService userBuilderService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userBuilderService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userBuilderService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserBuilderQuery userBuilderQuery) {
        PagerDTO pagerDTO = userBuilderService.listAllByCondition(userBuilderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserBuilderQuery userBuilderQuery) {
        PagerDTO pagerDTO = userBuilderService.listPageByCondition(userBuilderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 10:00
     * Description: 信息共享 -- 建造师 -- 应聘信息
     */
    @PostMapping("user/list-page")
    @HideProperty(url = "/UserBuilder/user/list-page", properties = {"builderPhone"})
    public ResponseStatusVO listPage(HttpServletRequest request, @RequestBody UserBuilderQuery userBuilderQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(userBuilderQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "listPage",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:40
     * Description: 我发布的建造师应聘信息
     */
    @PostMapping("user/list-builder-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserBuilderQuery userBuilderQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userBuilderQuery.setBuilderUserId(jwtUser.getUserId());
        userBuilderQuery.setBuilderIsActive((byte)0);
        return listPageByCondition(userBuilderQuery);
    }

    @Autowired
    public void setUserBuilderService(UserBuilderService userBuilderService) {
        this.userBuilderService = userBuilderService;
    }
}
