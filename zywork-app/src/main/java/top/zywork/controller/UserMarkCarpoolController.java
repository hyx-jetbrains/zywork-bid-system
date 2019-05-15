package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserMarkCarpoolQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserMarkCarpoolService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserMarkCarpoolVO;

/**
 * UserMarkCarpoolController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserMarkCarpool")
public class UserMarkCarpoolController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserMarkCarpoolController.class);

    private UserMarkCarpoolService userMarkCarpoolService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userMarkCarpoolService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userMarkCarpoolService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserMarkCarpoolQuery userMarkCarpoolQuery) {
        PagerDTO pagerDTO = userMarkCarpoolService.listAllByCondition(userMarkCarpoolQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserMarkCarpoolQuery userMarkCarpoolQuery) {
        PagerDTO pagerDTO = userMarkCarpoolService.listPageByCondition(userMarkCarpoolQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:59
     * Description: 信息共享 -- 开标拼车 -- 我是车主
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody UserMarkCarpoolQuery userMarkCarpoolQuery) {
        userMarkCarpoolQuery.setMarkCarpoolIsActive((byte)0);
        return listPageByCondition(userMarkCarpoolQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:59
     * Description: 开标拼车 -- 我是车主
     */
    @PostMapping("user/list-markCarpool-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserMarkCarpoolQuery userMarkCarpoolQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userMarkCarpoolQuery.setMarkCarpoolUserId(jwtUser.getUserId());
        userMarkCarpoolQuery.setMarkCarpoolIsActive((byte)0);
        return listPageByCondition(userMarkCarpoolQuery);
    }

    @Autowired
    public void setUserMarkCarpoolService(UserMarkCarpoolService userMarkCarpoolService) {
        this.userMarkCarpoolService = userMarkCarpoolService;
    }
}
