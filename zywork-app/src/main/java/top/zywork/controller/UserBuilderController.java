package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserBuilderQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserBuilderService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserBuilderVO;

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
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody UserBuilderQuery userBuilderQuery) {
        userBuilderQuery.setBuilderIsActive((byte)0);
        return listPageByCondition(userBuilderQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:40
     * Description: 我发布的建造师应聘信息
     */
    @PostMapping("user/list-builder-page")
    public ResponseStatusVO listPageByUserId(UserBuilderQuery userBuilderQuery) {
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
