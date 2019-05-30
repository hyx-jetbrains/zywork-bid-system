package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.MarkSeekcarQuery;
import top.zywork.query.UserMarkSeekcarQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserMarkSeekcarService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserMarkSeekcarVO;

/**
 * UserMarkSeekcarController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserMarkSeekcar")
public class UserMarkSeekcarController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserMarkSeekcarController.class);

    private UserMarkSeekcarService userMarkSeekcarService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userMarkSeekcarService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userMarkSeekcarService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserMarkSeekcarQuery userMarkSeekcarQuery) {
        PagerDTO pagerDTO = userMarkSeekcarService.listAllByCondition(userMarkSeekcarQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserMarkSeekcarQuery userMarkSeekcarQuery) {
        PagerDTO pagerDTO = userMarkSeekcarService.listPageByCondition(userMarkSeekcarQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:07
     * Description: 信息共享 -- 开标拼车 -- 我要找车
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPage(@RequestBody UserMarkSeekcarQuery userMarkSeekcarQuery) {
        userMarkSeekcarQuery.setMarkSeekcarIsActive((byte)0);
        return listPageByCondition(userMarkSeekcarQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:07
     * Description: 开标拼车 -- 我要找车
     */
    @PostMapping("user/list-markSeekcar-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserMarkSeekcarQuery userMarkSeekcarQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userMarkSeekcarQuery.setMarkSeekcarUserId(jwtUser.getUserId());
        userMarkSeekcarQuery.setMarkSeekcarIsActive((byte)0);
        return listPageByCondition(userMarkSeekcarQuery);
    }

    @Autowired
    public void setUserMarkSeekcarService(UserMarkSeekcarService userMarkSeekcarService) {
        this.userMarkSeekcarService = userMarkSeekcarService;
    }
}
