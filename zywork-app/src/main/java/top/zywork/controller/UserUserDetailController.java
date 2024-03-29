package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserUserDetailQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserUserDetailService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserUserDetailVO;

/**
 * UserUserDetailController控制器类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-userdetail")
public class UserUserDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserUserDetailController.class);

    private UserUserDetailService userUserDetailService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userUserDetailService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 查询登录用户自己的信息
     *
     * @return
     */
    @GetMapping("user/get")
    public ResponseStatusVO getUserDetail() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        } else {
            return listById(jwtUser.getUserId());
        }
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userUserDetailService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserUserDetailQuery userUserDetailQuery) {
        PagerDTO pagerDTO = userUserDetailService.listAllByCondition(userUserDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserUserDetailQuery userUserDetailQuery) {
        PagerDTO pagerDTO = userUserDetailService.listPageByCondition(userUserDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUserUserDetailService(UserUserDetailService userUserDetailService) {
        this.userUserDetailService = userUserDetailService;
    }
}
