package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserCouponDTO;
import top.zywork.query.UserCouponQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.CouponService;
import top.zywork.service.UserCouponService;
import top.zywork.vo.CouponVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserCouponVO;

import java.util.List;

/**
 * UserCouponController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/user-coupon")
public class UserCouponController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserCouponController.class);

    private UserCouponService userCouponService;

    private CouponService couponService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserCouponVO userCouponVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int res = userCouponService.save(BeanUtils.copy(userCouponVO, UserCouponDTO.class));
        if (1 == res) {
            // 保存成功，扣除优惠券
            CouponVO couponVO = BeanUtils.copy(couponService.getById(userCouponVO.getCouponId()), CouponVO.class);
            couponVO.setCouponCount(couponVO.getCouponCount()-1);
            couponService.update(couponVO);
        }
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserCouponVO> userCouponVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userCouponService.saveBatch(BeanUtils.copyListObj(userCouponVOList, UserCouponDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userCouponService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userCouponService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserCouponVO userCouponVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userCouponService.update(BeanUtils.copy(userCouponVO, UserCouponDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserCouponVO> userCouponVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userCouponService.updateBatch(BeanUtils.copyListObj(userCouponVOList, UserCouponDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserCouponVO userCouponVO) {
        userCouponService.update(BeanUtils.copy(userCouponVO, UserCouponDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserCouponVO> userCouponVOList) {
        userCouponService.updateBatch(BeanUtils.copyListObj(userCouponVOList, UserCouponDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserCouponVO userCouponVO = new UserCouponVO();
        Object obj = userCouponService.getById(id);
        if (obj != null) {
            userCouponVO = BeanUtils.copy(obj, UserCouponVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userCouponVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userCouponService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserCouponQuery userCouponQuery) {
        PagerDTO pagerDTO = userCouponService.listAllByCondition(userCouponQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserCouponQuery userCouponQuery) {
        PagerDTO pagerDTO = userCouponService.listPageByCondition(userCouponQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 16:17
     * Description: 抵扣券
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserCouponQuery userCouponQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userCouponQuery.setUserId(jwtUser.getUserId());
        userCouponQuery.setIsActive((byte)0);
        return listPageByCondition(userCouponQuery);
    }

    @Autowired
    public void setUserCouponService(UserCouponService userCouponService) {
        this.userCouponService = userCouponService;
    }

    @Autowired
    public void setCouponService(CouponService couponService) {
        this.couponService = couponService;
    }
}
