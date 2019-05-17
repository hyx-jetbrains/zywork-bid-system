package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserMarkSeekcarRecordQuery;
import top.zywork.query.UserMarkSeekcarRecordQuery;
import top.zywork.service.UserMarkSeekcarRecordService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserMarkSeekcarRecordVO;

/**
 * UserMarkSeekcarRecordController控制器类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/UserMarkSeekcarRecord")
public class UserMarkSeekcarRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserMarkSeekcarRecordController.class);

    private UserMarkSeekcarRecordService userMarkSeekcarRecordService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userMarkSeekcarRecordService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userMarkSeekcarRecordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserMarkSeekcarRecordQuery userMarkSeekcarRecordQuery) {
        PagerDTO pagerDTO = userMarkSeekcarRecordService.listAllByCondition(userMarkSeekcarRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserMarkSeekcarRecordQuery userMarkSeekcarRecordQuery) {
        PagerDTO pagerDTO = userMarkSeekcarRecordService.listPageByCondition(userMarkSeekcarRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /***
     * @description:  信息共享 -- 开标找车 -- 我有车 -- 找车记录
     * @param userMarkSeekcarRecordQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 11:55
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody UserMarkSeekcarRecordQuery userMarkSeekcarRecordQuery) {
        return listPageByCondition(userMarkSeekcarRecordQuery);
    }

    @Autowired
    public void setUserMarkSeekcarRecordService(UserMarkSeekcarRecordService userMarkSeekcarRecordService) {
        this.userMarkSeekcarRecordService = userMarkSeekcarRecordService;
    }
}
