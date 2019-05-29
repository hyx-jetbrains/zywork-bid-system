package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserSeekDataQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserSeekDataService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserSeekDataVO;

/**
 * UserSeekDataController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserSeekData")
public class UserSeekDataController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserSeekDataController.class);

    private UserSeekDataService userSeekDataService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userSeekDataService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserSeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userSeekDataService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserSeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserSeekDataQuery userSeekDataQuery) {
        PagerDTO pagerDTO = userSeekDataService.listAllByCondition(userSeekDataQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserSeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserSeekDataQuery userSeekDataQuery) {
        PagerDTO pagerDTO = userSeekDataService.listPageByCondition(userSeekDataQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserSeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:48
     * Description: 信息共享 -- 求带资料
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPage(@RequestBody UserSeekDataQuery userSeekDataQuery) {
        userSeekDataQuery.setSeekDataIsActive((byte)0);
        return listPageByCondition(userSeekDataQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:48
     * Description: 我的求带资料
     */
    @PostMapping("user/list-seekData-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserSeekDataQuery userSeekDataQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userSeekDataQuery.setSeekDataUserId(jwtUser.getUserId());
        userSeekDataQuery.setSeekDataIsActive((byte)0);
        return listPageByCondition(userSeekDataQuery);
    }

    @Autowired
    public void setUserSeekDataService(UserSeekDataService userSeekDataService) {
        this.userSeekDataService = userSeekDataService;
    }
}
