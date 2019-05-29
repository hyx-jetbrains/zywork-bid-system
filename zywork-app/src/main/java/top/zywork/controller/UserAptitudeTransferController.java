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
import top.zywork.query.UserAptitudeTransferQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserAptitudeTransferService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserAptitudeTransferVO;

import javax.servlet.http.HttpServletRequest;

/**
 * UserAptitudeTransferController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserAptitudeTransfer")
@HasHideProperty
public class UserAptitudeTransferController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserAptitudeTransferController.class);

    private UserAptitudeTransferService userAptitudeTransferService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userAptitudeTransferService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserAptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userAptitudeTransferService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserAptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserAptitudeTransferQuery userAptitudeTransferQuery) {
        PagerDTO pagerDTO = userAptitudeTransferService.listAllByCondition(userAptitudeTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserAptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserAptitudeTransferQuery userAptitudeTransferQuery) {
        PagerDTO pagerDTO = userAptitudeTransferService.listPageByCondition(userAptitudeTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserAptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:50
     * Description: 信息共享 -- 资质转让 -- 转让/求购
     */
    @PostMapping("user/list-page")
    @HideProperty(url = "/UserAptitudeTransfer/user/list-page", properties = {"aptitudeTransferPhone"})
    public ResponseStatusVO listPage(HttpServletRequest request, @RequestBody UserAptitudeTransferQuery userAptitudeTransferQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(userAptitudeTransferQuery);
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
     * Time: 10:50
     * Description: 我发布的资质转让/求购
     */
    @PostMapping("user/list-aptitudeTransfer-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserAptitudeTransferQuery userAptitudeTransferQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userAptitudeTransferQuery.setAptitudeTransferUserId(jwtUser.getUserId());
        userAptitudeTransferQuery.setAptitudeTransferIsActive((byte)0);
        return listPageByCondition(userAptitudeTransferQuery);
    }

    @Autowired
    public void setUserAptitudeTransferService(UserAptitudeTransferService userAptitudeTransferService) {
        this.userAptitudeTransferService = userAptitudeTransferService;
    }
}
