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
import top.zywork.dto.CompBuilderDTO;
import top.zywork.query.CompBuilderQuery;
import top.zywork.service.CompBuilderService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompBuilderVO;

import java.util.List;

/**
 * CompBuilderController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-builder")
public class CompBuilderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompBuilderController.class);

    private CompBuilderService compBuilderService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompBuilderVO compBuilderVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compBuilderService.save(BeanUtils.copy(compBuilderVO, CompBuilderDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompBuilderVO> compBuilderVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compBuilderService.saveBatch(BeanUtils.copyListObj(compBuilderVOList, CompBuilderDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compBuilderService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compBuilderService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompBuilderVO compBuilderVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compBuilderService.update(BeanUtils.copy(compBuilderVO, CompBuilderDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompBuilderVO> compBuilderVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compBuilderService.updateBatch(BeanUtils.copyListObj(compBuilderVOList, CompBuilderDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompBuilderVO compBuilderVO) {
        compBuilderService.update(BeanUtils.copy(compBuilderVO, CompBuilderDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompBuilderVO> compBuilderVOList) {
        compBuilderService.updateBatch(BeanUtils.copyListObj(compBuilderVOList, CompBuilderDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompBuilderVO compBuilderVO = new CompBuilderVO();
        Object obj = compBuilderService.getById(id);
        if (obj != null) {
            compBuilderVO = BeanUtils.copy(obj, CompBuilderVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compBuilderVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compBuilderService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompBuilderQuery compBuilderQuery) {
        PagerDTO pagerDTO = compBuilderService.listAllByCondition(compBuilderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompBuilderQuery compBuilderQuery) {
        PagerDTO pagerDTO = compBuilderService.listPageByCondition(compBuilderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody CompBuilderQuery compBuilderQuery) {
        return listAllByCondition(compBuilderQuery);
    }

    @Autowired
    public void setCompBuilderService(CompBuilderService compBuilderService) {
        this.compBuilderService = compBuilderService;
    }
}
