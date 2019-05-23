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
import top.zywork.dto.CompWaterDeviseAchievementDTO;
import top.zywork.query.CompWaterDeviseAchievementQuery;
import top.zywork.service.CompWaterDeviseAchievementService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompWaterDeviseAchievementVO;

import java.util.List;

/**
 * CompWaterDeviseAchievementController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-water-devise-achievement")
public class CompWaterDeviseAchievementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompWaterDeviseAchievementController.class);

    private CompWaterDeviseAchievementService compWaterDeviseAchievementService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompWaterDeviseAchievementVO compWaterDeviseAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterDeviseAchievementService.save(BeanUtils.copy(compWaterDeviseAchievementVO, CompWaterDeviseAchievementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompWaterDeviseAchievementVO> compWaterDeviseAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterDeviseAchievementService.saveBatch(BeanUtils.copyListObj(compWaterDeviseAchievementVOList, CompWaterDeviseAchievementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compWaterDeviseAchievementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compWaterDeviseAchievementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompWaterDeviseAchievementVO compWaterDeviseAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compWaterDeviseAchievementService.update(BeanUtils.copy(compWaterDeviseAchievementVO, CompWaterDeviseAchievementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompWaterDeviseAchievementVO> compWaterDeviseAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compWaterDeviseAchievementService.updateBatch(BeanUtils.copyListObj(compWaterDeviseAchievementVOList, CompWaterDeviseAchievementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompWaterDeviseAchievementVO compWaterDeviseAchievementVO) {
        compWaterDeviseAchievementService.update(BeanUtils.copy(compWaterDeviseAchievementVO, CompWaterDeviseAchievementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompWaterDeviseAchievementVO> compWaterDeviseAchievementVOList) {
        compWaterDeviseAchievementService.updateBatch(BeanUtils.copyListObj(compWaterDeviseAchievementVOList, CompWaterDeviseAchievementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompWaterDeviseAchievementVO compWaterDeviseAchievementVO = new CompWaterDeviseAchievementVO();
        Object obj = compWaterDeviseAchievementService.getById(id);
        if (obj != null) {
            compWaterDeviseAchievementVO = BeanUtils.copy(obj, CompWaterDeviseAchievementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compWaterDeviseAchievementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compWaterDeviseAchievementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompWaterDeviseAchievementQuery compWaterDeviseAchievementQuery) {
        PagerDTO pagerDTO = compWaterDeviseAchievementService.listAllByCondition(compWaterDeviseAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompWaterDeviseAchievementQuery compWaterDeviseAchievementQuery) {
        PagerDTO pagerDTO = compWaterDeviseAchievementService.listPageByCondition(compWaterDeviseAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody CompWaterDeviseAchievementQuery compWaterDeviseAchievementQuery) {
        return listPageByCondition(compWaterDeviseAchievementQuery);
    }

    @Autowired
    public void setCompWaterDeviseAchievementService(CompWaterDeviseAchievementService compWaterDeviseAchievementService) {
        this.compWaterDeviseAchievementService = compWaterDeviseAchievementService;
    }
}
