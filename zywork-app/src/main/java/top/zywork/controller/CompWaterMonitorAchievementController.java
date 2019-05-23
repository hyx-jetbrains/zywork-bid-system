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
import top.zywork.dto.CompWaterMonitorAchievementDTO;
import top.zywork.query.CompWaterMonitorAchievementQuery;
import top.zywork.service.CompWaterMonitorAchievementService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompWaterMonitorAchievementVO;

import java.util.List;

/**
 * CompWaterMonitorAchievementController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-water-monitor-achievement")
public class CompWaterMonitorAchievementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompWaterMonitorAchievementController.class);

    private CompWaterMonitorAchievementService compWaterMonitorAchievementService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompWaterMonitorAchievementVO compWaterMonitorAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterMonitorAchievementService.save(BeanUtils.copy(compWaterMonitorAchievementVO, CompWaterMonitorAchievementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompWaterMonitorAchievementVO> compWaterMonitorAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterMonitorAchievementService.saveBatch(BeanUtils.copyListObj(compWaterMonitorAchievementVOList, CompWaterMonitorAchievementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compWaterMonitorAchievementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compWaterMonitorAchievementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompWaterMonitorAchievementVO compWaterMonitorAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compWaterMonitorAchievementService.update(BeanUtils.copy(compWaterMonitorAchievementVO, CompWaterMonitorAchievementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompWaterMonitorAchievementVO> compWaterMonitorAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterMonitorAchievementService.updateBatch(BeanUtils.copyListObj(compWaterMonitorAchievementVOList, CompWaterMonitorAchievementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompWaterMonitorAchievementVO compWaterMonitorAchievementVO) {
        compWaterMonitorAchievementService.update(BeanUtils.copy(compWaterMonitorAchievementVO, CompWaterMonitorAchievementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompWaterMonitorAchievementVO> compWaterMonitorAchievementVOList) {
        compWaterMonitorAchievementService.updateBatch(BeanUtils.copyListObj(compWaterMonitorAchievementVOList, CompWaterMonitorAchievementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompWaterMonitorAchievementVO compWaterMonitorAchievementVO = new CompWaterMonitorAchievementVO();
        Object obj = compWaterMonitorAchievementService.getById(id);
        if (obj != null) {
            compWaterMonitorAchievementVO = BeanUtils.copy(obj, CompWaterMonitorAchievementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compWaterMonitorAchievementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compWaterMonitorAchievementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompWaterMonitorAchievementQuery compWaterMonitorAchievementQuery) {
        PagerDTO pagerDTO = compWaterMonitorAchievementService.listAllByCondition(compWaterMonitorAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompWaterMonitorAchievementQuery compWaterMonitorAchievementQuery) {
        PagerDTO pagerDTO = compWaterMonitorAchievementService.listPageByCondition(compWaterMonitorAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterMonitorAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody CompWaterMonitorAchievementQuery compWaterMonitorAchievementQuery) {
        return listPageByCondition(compWaterMonitorAchievementQuery);
    }

    @Autowired
    public void setCompWaterMonitorAchievementService(CompWaterMonitorAchievementService compWaterMonitorAchievementService) {
        this.compWaterMonitorAchievementService = compWaterMonitorAchievementService;
    }
}
