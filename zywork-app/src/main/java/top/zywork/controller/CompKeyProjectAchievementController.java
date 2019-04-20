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
import top.zywork.dto.CompKeyProjectAchievementDTO;
import top.zywork.query.CompKeyProjectAchievementQuery;
import top.zywork.service.CompKeyProjectAchievementService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompKeyProjectAchievementVO;

import java.util.List;

/**
 * CompKeyProjectAchievementController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-key-projecachievement")
public class CompKeyProjectAchievementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompKeyProjectAchievementController.class);

    private CompKeyProjectAchievementService compKeyProjectAchievementService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompKeyProjectAchievementVO compKeyProjectAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compKeyProjectAchievementService.save(BeanUtils.copy(compKeyProjectAchievementVO, CompKeyProjectAchievementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompKeyProjectAchievementVO> compKeyProjectAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compKeyProjectAchievementService.saveBatch(BeanUtils.copyListObj(compKeyProjectAchievementVOList, CompKeyProjectAchievementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compKeyProjectAchievementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compKeyProjectAchievementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompKeyProjectAchievementVO compKeyProjectAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compKeyProjectAchievementService.update(BeanUtils.copy(compKeyProjectAchievementVO, CompKeyProjectAchievementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompKeyProjectAchievementVO> compKeyProjectAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compKeyProjectAchievementService.updateBatch(BeanUtils.copyListObj(compKeyProjectAchievementVOList, CompKeyProjectAchievementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompKeyProjectAchievementVO compKeyProjectAchievementVO) {
        compKeyProjectAchievementService.update(BeanUtils.copy(compKeyProjectAchievementVO, CompKeyProjectAchievementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompKeyProjectAchievementVO> compKeyProjectAchievementVOList) {
        compKeyProjectAchievementService.updateBatch(BeanUtils.copyListObj(compKeyProjectAchievementVOList, CompKeyProjectAchievementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompKeyProjectAchievementVO compKeyProjectAchievementVO = new CompKeyProjectAchievementVO();
        Object obj = compKeyProjectAchievementService.getById(id);
        if (obj != null) {
            compKeyProjectAchievementVO = BeanUtils.copy(obj, CompKeyProjectAchievementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compKeyProjectAchievementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compKeyProjectAchievementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompKeyProjectAchievementQuery compKeyProjectAchievementQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementService.listAllByCondition(compKeyProjectAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompKeyProjectAchievementQuery compKeyProjectAchievementQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementService.listPageByCondition(compKeyProjectAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setCompKeyProjectAchievementService(CompKeyProjectAchievementService compKeyProjectAchievementService) {
        this.compKeyProjectAchievementService = compKeyProjectAchievementService;
    }
}
