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
import top.zywork.dto.AptitudeResourceDTO;
import top.zywork.query.AptitudeResourceQuery;
import top.zywork.service.AptitudeResourceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.AptitudeResourceVO;

import java.util.List;

/**
 * AptitudeResourceController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/aptitude-resource")
public class AptitudeResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AptitudeResourceController.class);

    private AptitudeResourceService aptitudeResourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated AptitudeResourceVO aptitudeResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeResourceService.save(BeanUtils.copy(aptitudeResourceVO, AptitudeResourceDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<AptitudeResourceVO> aptitudeResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeResourceService.saveBatch(BeanUtils.copyListObj(aptitudeResourceVOList, AptitudeResourceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        aptitudeResourceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        aptitudeResourceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated AptitudeResourceVO aptitudeResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = aptitudeResourceService.update(BeanUtils.copy(aptitudeResourceVO, AptitudeResourceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<AptitudeResourceVO> aptitudeResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeResourceService.updateBatch(BeanUtils.copyListObj(aptitudeResourceVOList, AptitudeResourceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody AptitudeResourceVO aptitudeResourceVO) {
        aptitudeResourceService.update(BeanUtils.copy(aptitudeResourceVO, AptitudeResourceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<AptitudeResourceVO> aptitudeResourceVOList) {
        aptitudeResourceService.updateBatch(BeanUtils.copyListObj(aptitudeResourceVOList, AptitudeResourceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        AptitudeResourceVO aptitudeResourceVO = new AptitudeResourceVO();
        Object obj = aptitudeResourceService.getById(id);
        if (obj != null) {
            aptitudeResourceVO = BeanUtils.copy(obj, AptitudeResourceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", aptitudeResourceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = aptitudeResourceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody AptitudeResourceQuery aptitudeResourceQuery) {
        PagerDTO pagerDTO = aptitudeResourceService.listAllByCondition(aptitudeResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody AptitudeResourceQuery aptitudeResourceQuery) {
        PagerDTO pagerDTO = aptitudeResourceService.listPageByCondition(aptitudeResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setAptitudeResourceService(AptitudeResourceService aptitudeResourceService) {
        this.aptitudeResourceService = aptitudeResourceService;
    }
}
