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
import top.zywork.dto.CompHouseAchievementDTO;
import top.zywork.query.CompHouseAchievementQuery;
import top.zywork.service.CompHouseAchievementService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompHouseAchievementVO;

import java.util.List;

/**
 * CompHouseAchievementController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-house-achievement")
public class CompHouseAchievementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompHouseAchievementController.class);

    private CompHouseAchievementService compHouseAchievementService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompHouseAchievementVO compHouseAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compHouseAchievementService.save(BeanUtils.copy(compHouseAchievementVO, CompHouseAchievementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompHouseAchievementVO> compHouseAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compHouseAchievementService.saveBatch(BeanUtils.copyListObj(compHouseAchievementVOList, CompHouseAchievementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compHouseAchievementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compHouseAchievementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompHouseAchievementVO compHouseAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compHouseAchievementService.update(BeanUtils.copy(compHouseAchievementVO, CompHouseAchievementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompHouseAchievementVO> compHouseAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compHouseAchievementService.updateBatch(BeanUtils.copyListObj(compHouseAchievementVOList, CompHouseAchievementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompHouseAchievementVO compHouseAchievementVO) {
        compHouseAchievementService.update(BeanUtils.copy(compHouseAchievementVO, CompHouseAchievementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompHouseAchievementVO> compHouseAchievementVOList) {
        compHouseAchievementService.updateBatch(BeanUtils.copyListObj(compHouseAchievementVOList, CompHouseAchievementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompHouseAchievementVO compHouseAchievementVO = new CompHouseAchievementVO();
        Object obj = compHouseAchievementService.getById(id);
        if (obj != null) {
            compHouseAchievementVO = BeanUtils.copy(obj, CompHouseAchievementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compHouseAchievementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compHouseAchievementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompHouseAchievementQuery compHouseAchievementQuery) {
        PagerDTO pagerDTO = compHouseAchievementService.listAllByCondition(compHouseAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompHouseAchievementQuery compHouseAchievementQuery) {
        PagerDTO pagerDTO = compHouseAchievementService.listPageByCondition(compHouseAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompHouseAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setCompHouseAchievementService(CompHouseAchievementService compHouseAchievementService) {
        this.compHouseAchievementService = compHouseAchievementService;
    }
}
