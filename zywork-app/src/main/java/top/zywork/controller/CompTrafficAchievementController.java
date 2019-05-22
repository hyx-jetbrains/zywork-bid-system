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
import top.zywork.dto.CompTrafficAchievementDTO;
import top.zywork.query.CompTrafficAchievementQuery;
import top.zywork.service.CompTrafficAchievementService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompTrafficAchievementVO;

import java.util.List;

/**
 * CompTrafficAchievementController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-traffic-achievement")
public class CompTrafficAchievementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompTrafficAchievementController.class);

    private CompTrafficAchievementService compTrafficAchievementService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompTrafficAchievementVO compTrafficAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compTrafficAchievementService.save(BeanUtils.copy(compTrafficAchievementVO, CompTrafficAchievementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompTrafficAchievementVO> compTrafficAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compTrafficAchievementService.saveBatch(BeanUtils.copyListObj(compTrafficAchievementVOList, CompTrafficAchievementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compTrafficAchievementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compTrafficAchievementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompTrafficAchievementVO compTrafficAchievementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compTrafficAchievementService.update(BeanUtils.copy(compTrafficAchievementVO, CompTrafficAchievementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompTrafficAchievementVO> compTrafficAchievementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compTrafficAchievementService.updateBatch(BeanUtils.copyListObj(compTrafficAchievementVOList, CompTrafficAchievementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompTrafficAchievementVO compTrafficAchievementVO) {
        compTrafficAchievementService.update(BeanUtils.copy(compTrafficAchievementVO, CompTrafficAchievementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompTrafficAchievementVO> compTrafficAchievementVOList) {
        compTrafficAchievementService.updateBatch(BeanUtils.copyListObj(compTrafficAchievementVOList, CompTrafficAchievementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompTrafficAchievementVO compTrafficAchievementVO = new CompTrafficAchievementVO();
        Object obj = compTrafficAchievementService.getById(id);
        if (obj != null) {
            compTrafficAchievementVO = BeanUtils.copy(obj, CompTrafficAchievementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compTrafficAchievementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compTrafficAchievementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompTrafficAchievementQuery compTrafficAchievementQuery) {
        PagerDTO pagerDTO = compTrafficAchievementService.listAllByCondition(compTrafficAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompTrafficAchievementQuery compTrafficAchievementQuery) {
        PagerDTO pagerDTO = compTrafficAchievementService.listPageByCondition(compTrafficAchievementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompTrafficAchievementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody CompTrafficAchievementQuery compTrafficAchievementQuery) {
        return listAllByCondition(compTrafficAchievementQuery);
    }

    @Autowired
    public void setCompTrafficAchievementService(CompTrafficAchievementService compTrafficAchievementService) {
        this.compTrafficAchievementService = compTrafficAchievementService;
    }
}
