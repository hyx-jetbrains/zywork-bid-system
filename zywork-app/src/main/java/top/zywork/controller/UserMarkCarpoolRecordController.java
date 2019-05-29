package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserMarkCarpoolRecordQuery;
import top.zywork.service.UserMarkCarpoolRecordService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserMarkCarpoolRecordVO;

/**
 * UserMarkCarpoolRecordController控制器类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/UserMarkCarpoolRecord")
public class UserMarkCarpoolRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserMarkCarpoolRecordController.class);

    private UserMarkCarpoolRecordService userMarkCarpoolRecordService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userMarkCarpoolRecordService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userMarkCarpoolRecordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserMarkCarpoolRecordQuery userMarkCarpoolRecordQuery) {
        PagerDTO pagerDTO = userMarkCarpoolRecordService.listAllByCondition(userMarkCarpoolRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserMarkCarpoolRecordQuery userMarkCarpoolRecordQuery) {
        PagerDTO pagerDTO = userMarkCarpoolRecordService.listPageByCondition(userMarkCarpoolRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }


    /***
     * @description:  信息共享 -- 开标拼车 -- 我是车主 -- 拼车记录
     * @param userMarkCarpoolRecordQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 11:55
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPage(@RequestBody UserMarkCarpoolRecordQuery userMarkCarpoolRecordQuery) {
        return listPageByCondition(userMarkCarpoolRecordQuery);
    }

    @Autowired
    public void setUserMarkCarpoolRecordService(UserMarkCarpoolRecordService userMarkCarpoolRecordService) {
        this.userMarkCarpoolRecordService = userMarkCarpoolRecordService;
    }
}
