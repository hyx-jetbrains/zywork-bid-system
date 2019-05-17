package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.MarkSeekcarDTO;
import top.zywork.dto.MarkSeekcarRecordDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.MarkSeekcarRecordDTO;
import top.zywork.query.MarkSeekcarRecordQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.MarkSeekcarRecordService;
import top.zywork.service.MarkSeekcarService;
import top.zywork.vo.*;

import java.util.List;

/**
 * MarkSeekcarRecordController控制器类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/mark-seekcar-record")
public class MarkSeekcarRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MarkSeekcarRecordController.class);

    private MarkSeekcarRecordService markSeekcarRecordService;

    private MarkSeekcarService markSeekcarService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated MarkSeekcarRecordVO markSeekcarRecordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarRecordService.save(BeanUtils.copy(markSeekcarRecordVO, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<MarkSeekcarRecordVO> markSeekcarRecordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarRecordService.saveBatch(BeanUtils.copyListObj(markSeekcarRecordVOList, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        markSeekcarRecordService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        markSeekcarRecordService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated MarkSeekcarRecordVO markSeekcarRecordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = markSeekcarRecordService.update(BeanUtils.copy(markSeekcarRecordVO, MarkSeekcarRecordDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<MarkSeekcarRecordVO> markSeekcarRecordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarRecordService.updateBatch(BeanUtils.copyListObj(markSeekcarRecordVOList, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody MarkSeekcarRecordVO markSeekcarRecordVO) {
        markSeekcarRecordService.update(BeanUtils.copy(markSeekcarRecordVO, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<MarkSeekcarRecordVO> markSeekcarRecordVOList) {
        markSeekcarRecordService.updateBatch(BeanUtils.copyListObj(markSeekcarRecordVOList, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        MarkSeekcarRecordVO markSeekcarRecordVO = new MarkSeekcarRecordVO();
        Object obj = markSeekcarRecordService.getById(id);
        if (obj != null) {
            markSeekcarRecordVO = BeanUtils.copy(obj, MarkSeekcarRecordVO.class);
        }
        return ResponseStatusVO.ok("查询成功", markSeekcarRecordVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = markSeekcarRecordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody MarkSeekcarRecordQuery markSeekcarRecordQuery) {
        PagerDTO pagerDTO = markSeekcarRecordService.listAllByCondition(markSeekcarRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody MarkSeekcarRecordQuery markSeekcarRecordQuery) {
        PagerDTO pagerDTO = markSeekcarRecordService.listPageByCondition(markSeekcarRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /***
     * @description: 我有车-保存找车记录
     * @param seekcarId 找车编号
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 10:37
     */
    @GetMapping("any/save-seekcar-record/{seekcarId}")
    public ResponseStatusVO saveSeekcarRecord(@PathVariable("seekcarId") Long seekcarId) {
        if (null == seekcarId || 0 == seekcarId) {
            return ResponseStatusVO.error("申请失败，请刷新重试", null);
        }
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.error("申请失败", null);
        }
        MarkSeekcarVO markSeekcarVO = BeanUtils.copy(markSeekcarService.getById(seekcarId), MarkSeekcarVO.class);
        if (null == markSeekcarVO) {
            return ResponseStatusVO.error("申请失败", null);
        }
        long userId = jwtUser.getUserId();
        long tempUserId = markSeekcarVO.getUserId();
        if (userId == tempUserId) {
            return ResponseStatusVO.error("申请失败,不能申请自己发布的找车信息", null);
        }
        MarkSeekcarRecordDTO markSeekcarRecordDTO = markSeekcarRecordService.getByUserIdAndSeekcarId(userId, seekcarId);
        if (markSeekcarRecordDTO != null) {
            return ResponseStatusVO.error("申请失败，已经申请过了", null);
        }
        int recordCount = markSeekcarVO.getRecordCount();
        markSeekcarVO.setRecordCount(++recordCount);
        markSeekcarService.update(BeanUtils.copy(markSeekcarVO, MarkSeekcarDTO.class));
        MarkSeekcarRecordVO markSeekcarRecordVO = new MarkSeekcarRecordVO();
        markSeekcarRecordVO.setUserId(userId);
        markSeekcarRecordVO.setMarkSeekcarId(seekcarId);
        markSeekcarRecordService.save(BeanUtils.copy(markSeekcarRecordVO, MarkSeekcarRecordDTO.class));
        return ResponseStatusVO.ok("申请成功", null);
    }

    @Autowired
    public void setMarkSeekcarRecordService(MarkSeekcarRecordService markSeekcarRecordService) {
        this.markSeekcarRecordService = markSeekcarRecordService;
    }

    @Autowired
    public void setMarkSeekcarService(MarkSeekcarService markSeekcarService) {
        this.markSeekcarService = markSeekcarService;
    }
}
