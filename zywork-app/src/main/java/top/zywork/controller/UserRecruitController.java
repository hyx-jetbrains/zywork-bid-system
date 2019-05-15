package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserRecruitQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserRecruitService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserRecruitVO;

/**
 * UserRecruitController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserRecruit")
public class UserRecruitController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserRecruitController.class);

    private UserRecruitService userRecruitService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userRecruitService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userRecruitService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserRecruitQuery userRecruitQuery) {
        PagerDTO pagerDTO = userRecruitService.listAllByCondition(userRecruitQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserRecruitQuery userRecruitQuery) {
        PagerDTO pagerDTO = userRecruitService.listPageByCondition(userRecruitQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:46
     * Description: 信息共享 -- 岗位招聘
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody UserRecruitQuery userRecruitQuery) {
        userRecruitQuery.setRecruitIsActive((byte)0);
        return listPageByCondition(userRecruitQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:46
     * Description: 我发布的岗位招聘
     */
    @PostMapping("user/list-recruit-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserRecruitQuery userRecruitQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userRecruitQuery.setRecruitUserId(jwtUser.getUserId());
        userRecruitQuery.setRecruitIsActive((byte)0);
        return listPageByCondition(userRecruitQuery);
    }

    @Autowired
    public void setUserRecruitService(UserRecruitService userRecruitService) {
        this.userRecruitService = userRecruitService;
    }
}
