package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserBuilderReqQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserBuilderReqService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserBuilderReqVO;

/**
 * UserBuilderReqController控制器类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/UserBuilderReq")
public class UserBuilderReqController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBuilderReqController.class);

    private UserBuilderReqService userBuilderReqService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userBuilderReqService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userBuilderReqService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserBuilderReqQuery userBuilderReqQuery) {
        PagerDTO pagerDTO = userBuilderReqService.listAllByCondition(userBuilderReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserBuilderReqQuery userBuilderReqQuery) {
        PagerDTO pagerDTO = userBuilderReqService.listPageByCondition(userBuilderReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBuilderReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:28
     * Description: 信息共享 -- 建造师 -- 招聘信息
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody UserBuilderReqQuery userBuilderReqQuery) {
        return listPageByCondition(userBuilderReqQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:28
     * Description: 我发布的建造师招聘信息
     */
    @PostMapping("user/list-builderReq-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserBuilderReqQuery userBuilderReqQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userBuilderReqQuery.setBuilderReqUserId(jwtUser.getUserId());
        userBuilderReqQuery.setBuilderReqIsActive((byte)0);
        return listPageByCondition(userBuilderReqQuery);
    }

    @Autowired
    public void setUserBuilderReqService(UserBuilderReqService userBuilderReqService) {
        this.userBuilderReqService = userBuilderReqService;
    }
}
