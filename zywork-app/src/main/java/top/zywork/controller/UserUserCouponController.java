package top.zywork.controller;

import com.beust.jcommander.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserUserCouponQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserUserCouponService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserUserCouponVO;

import java.util.Date;

/**
 * UserUserCouponController控制器类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserUserCoupon")
public class  UserUserCouponController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserUserCouponController.class);

    private UserUserCouponService userUserCouponService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userUserCouponService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userUserCouponService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserUserCouponQuery userUserCouponQuery) {
        PagerDTO pagerDTO = userUserCouponService.listAllByCondition(userUserCouponQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserUserCouponQuery userUserCouponQuery) {
        PagerDTO pagerDTO = userUserCouponService.listPageByCondition(userUserCouponQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserCouponVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/18
     * Time: 11:31
     * Description: 抵扣券
     */
    @PostMapping("user/list-page/{status}")
    public ResponseStatusVO listPageByUserId(@RequestBody UserUserCouponQuery userUserCouponQuery,@PathVariable("status") Integer status) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        if(status != null) {
            if(status == 1) {
                userUserCouponQuery.setCouponValidTimeMin(new Date());
            } else if(status == 2) {
                userUserCouponQuery.setCouponValidTimeMax(new Date());
            }
        }

        userUserCouponQuery.setUserCouponUserId(jwtUser.getUserId());
        return listPageByCondition(userUserCouponQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/18
     * Time: 11:31
     * Description: 抵扣券
     */
    @PostMapping("user/list-all/{status}")
    public ResponseStatusVO listAllByUserId(@RequestBody UserUserCouponQuery userUserCouponQuery,@PathVariable("status") Integer status) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        if(status != null) {
            if(status == 1) {
                userUserCouponQuery.setCouponValidTimeMin(new Date());
            } else if(status == 2) {
                userUserCouponQuery.setCouponValidTimeMax(new Date());
            }
        }

        userUserCouponQuery.setUserCouponUserId(jwtUser.getUserId());
        return listAllByCondition(userUserCouponQuery);
    }

    @Autowired
    public void setUserUserCouponService(UserUserCouponService userUserCouponService) {
        this.userUserCouponService = userUserCouponService;
    }
}
