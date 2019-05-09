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
import top.zywork.dto.ExpertQuestionTypeDTO;
import top.zywork.query.ExpertQuestionTypeQuery;
import top.zywork.service.ExpertQuestionTypeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ExpertQuestionTypeVO;

import java.util.List;

/**
 * ExpertQuestionTypeController控制器类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/experquestion-type")
public class ExpertQuestionTypeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpertQuestionTypeController.class);

    private ExpertQuestionTypeService expertQuestionTypeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ExpertQuestionTypeVO expertQuestionTypeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertQuestionTypeService.save(BeanUtils.copy(expertQuestionTypeVO, ExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ExpertQuestionTypeVO> expertQuestionTypeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertQuestionTypeService.saveBatch(BeanUtils.copyListObj(expertQuestionTypeVOList, ExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        expertQuestionTypeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        expertQuestionTypeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ExpertQuestionTypeVO expertQuestionTypeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = expertQuestionTypeService.update(BeanUtils.copy(expertQuestionTypeVO, ExpertQuestionTypeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ExpertQuestionTypeVO> expertQuestionTypeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertQuestionTypeService.updateBatch(BeanUtils.copyListObj(expertQuestionTypeVOList, ExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ExpertQuestionTypeVO expertQuestionTypeVO) {
        expertQuestionTypeService.update(BeanUtils.copy(expertQuestionTypeVO, ExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ExpertQuestionTypeVO> expertQuestionTypeVOList) {
        expertQuestionTypeService.updateBatch(BeanUtils.copyListObj(expertQuestionTypeVOList, ExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ExpertQuestionTypeVO expertQuestionTypeVO = new ExpertQuestionTypeVO();
        Object obj = expertQuestionTypeService.getById(id);
        if (obj != null) {
            expertQuestionTypeVO = BeanUtils.copy(obj, ExpertQuestionTypeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", expertQuestionTypeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = expertQuestionTypeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ExpertQuestionTypeQuery expertQuestionTypeQuery) {
        PagerDTO pagerDTO = expertQuestionTypeService.listAllByCondition(expertQuestionTypeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ExpertQuestionTypeQuery expertQuestionTypeQuery) {
        PagerDTO pagerDTO = expertQuestionTypeService.listPageByCondition(expertQuestionTypeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setExpertQuestionTypeService(ExpertQuestionTypeService expertQuestionTypeService) {
        this.expertQuestionTypeService = expertQuestionTypeService;
    }
}
