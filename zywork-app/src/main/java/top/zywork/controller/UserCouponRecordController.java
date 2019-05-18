package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserCouponRecordQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserCouponRecordService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserCouponRecordVO;

/**
 * UserCouponRecordController控制器类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserCouponRecord")
public class UserCouponRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserCouponRecordController.class);

    private UserCouponRecordService userCouponRecordService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userCouponRecordService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userCouponRecordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserCouponRecordQuery userCouponRecordQuery) {
        PagerDTO pagerDTO = userCouponRecordService.listAllByCondition(userCouponRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserCouponRecordQuery userCouponRecordQuery) {
        PagerDTO pagerDTO = userCouponRecordService.listPageByCondition(userCouponRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/18
     * Time: 11:56
     * Description: 抵扣券使用记录
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserCouponRecordQuery userCouponRecordQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userCouponRecordQuery.setCouponRecordUserId(jwtUser.getUserId());
        return listPageByCondition(userCouponRecordQuery);
    }

    @Autowired
    public void setUserCouponRecordService(UserCouponRecordService userCouponRecordService) {
        this.userCouponRecordService = userCouponRecordService;
    }
}
