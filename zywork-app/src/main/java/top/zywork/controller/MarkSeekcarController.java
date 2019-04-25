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
import top.zywork.dto.PagerDTO;
import top.zywork.dto.MarkSeekcarDTO;
import top.zywork.query.MarkSeekcarQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.MarkSeekcarService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.MarkSeekcarVO;

import java.util.List;

/**
 * MarkSeekcarController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/mark-seekcar")
public class MarkSeekcarController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MarkSeekcarController.class);

    private MarkSeekcarService markSeekcarService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated MarkSeekcarVO markSeekcarVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarVO.setUserId(jwtUser.getUserId());
        markSeekcarService.save(BeanUtils.copy(markSeekcarVO, MarkSeekcarDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<MarkSeekcarVO> markSeekcarVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarService.saveBatch(BeanUtils.copyListObj(markSeekcarVOList, MarkSeekcarDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        markSeekcarService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        markSeekcarService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated MarkSeekcarVO markSeekcarVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = markSeekcarService.update(BeanUtils.copy(markSeekcarVO, MarkSeekcarDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<MarkSeekcarVO> markSeekcarVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markSeekcarService.updateBatch(BeanUtils.copyListObj(markSeekcarVOList, MarkSeekcarDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody MarkSeekcarVO markSeekcarVO) {
        markSeekcarService.update(BeanUtils.copy(markSeekcarVO, MarkSeekcarDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<MarkSeekcarVO> markSeekcarVOList) {
        markSeekcarService.updateBatch(BeanUtils.copyListObj(markSeekcarVOList, MarkSeekcarDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        MarkSeekcarVO markSeekcarVO = new MarkSeekcarVO();
        Object obj = markSeekcarService.getById(id);
        if (obj != null) {
            markSeekcarVO = BeanUtils.copy(obj, MarkSeekcarVO.class);
        }
        return ResponseStatusVO.ok("查询成功", markSeekcarVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = markSeekcarService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody MarkSeekcarQuery markSeekcarQuery) {
        PagerDTO pagerDTO = markSeekcarService.listAllByCondition(markSeekcarQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody MarkSeekcarQuery markSeekcarQuery) {
        PagerDTO pagerDTO = markSeekcarService.listPageByCondition(markSeekcarQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkSeekcarVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setMarkSeekcarService(MarkSeekcarService markSeekcarService) {
        this.markSeekcarService = markSeekcarService;
    }
}
