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
import top.zywork.dto.BuilderResourceDTO;
import top.zywork.query.BuilderResourceQuery;
import top.zywork.service.BuilderResourceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.BuilderResourceVO;

import java.util.List;

/**
 * BuilderResourceController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/builder-resource")
public class BuilderResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BuilderResourceController.class);

    private BuilderResourceService builderResourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated BuilderResourceVO builderResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderResourceService.save(BeanUtils.copy(builderResourceVO, BuilderResourceDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<BuilderResourceVO> builderResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderResourceService.saveBatch(BeanUtils.copyListObj(builderResourceVOList, BuilderResourceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        builderResourceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        builderResourceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated BuilderResourceVO builderResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = builderResourceService.update(BeanUtils.copy(builderResourceVO, BuilderResourceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<BuilderResourceVO> builderResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderResourceService.updateBatch(BeanUtils.copyListObj(builderResourceVOList, BuilderResourceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody BuilderResourceVO builderResourceVO) {
        builderResourceService.update(BeanUtils.copy(builderResourceVO, BuilderResourceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<BuilderResourceVO> builderResourceVOList) {
        builderResourceService.updateBatch(BeanUtils.copyListObj(builderResourceVOList, BuilderResourceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        BuilderResourceVO builderResourceVO = new BuilderResourceVO();
        Object obj = builderResourceService.getById(id);
        if (obj != null) {
            builderResourceVO = BeanUtils.copy(obj, BuilderResourceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", builderResourceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = builderResourceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody BuilderResourceQuery builderResourceQuery) {
        PagerDTO pagerDTO = builderResourceService.listAllByCondition(builderResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody BuilderResourceQuery builderResourceQuery) {
        PagerDTO pagerDTO = builderResourceService.listPageByCondition(builderResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setBuilderResourceService(BuilderResourceService builderResourceService) {
        this.builderResourceService = builderResourceService;
    }
}
