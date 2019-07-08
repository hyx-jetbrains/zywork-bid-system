package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserBuilderReqQuery;
import top.zywork.query.UserLabourQuery;
import top.zywork.query.UserLabourReqQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserLabourReqService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserLabourReqVO;

import javax.servlet.http.HttpServletRequest;

/**
 * UserLabourReqController控制器类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/UserLabourReq")
public class UserLabourReqController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserLabourReqController.class);

    private UserLabourReqService userLabourReqService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userLabourReqService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userLabourReqService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserLabourReqQuery userLabourReqQuery) {
        PagerDTO pagerDTO = userLabourReqService.listAllByCondition(userLabourReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserLabourReqQuery userLabourReqQuery) {
        PagerDTO pagerDTO = userLabourReqService.listPageByCondition(userLabourReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserLabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /***
     * @description:  信息共享  -  劳务信息  -  劳务招聘
     * @param userLabourReqQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 14:57
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPage(@RequestBody UserLabourReqQuery userLabourReqQuery) {
        return listPageByCondition(userLabourReqQuery);
    }

    /***
     * @description:  我发布的劳务招聘信息
     * @param userLabourReqQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 14:57
     */
    @PostMapping("user/list-labour-req-page")
    public ResponseStatusVO listPageByUserId(@RequestBody UserLabourReqQuery userLabourReqQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userLabourReqQuery.setLabourReqUserId(jwtUser.getUserId());
        userLabourReqQuery.setLabourReqIsActive((byte)0);
        return listPageByCondition(userLabourReqQuery);
    }

    @Autowired
    public void setUserLabourReqService(UserLabourReqService userLabourReqService) {
        this.userLabourReqService = userLabourReqService;
    }
}
