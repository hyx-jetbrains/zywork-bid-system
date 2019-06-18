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
import top.zywork.dto.UpdateNoticeResourceDTO;
import top.zywork.query.UpdateNoticeResourceQuery;
import top.zywork.service.UpdateNoticeResourceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UpdateNoticeResourceVO;

import java.util.List;

/**
 * UpdateNoticeResourceController控制器类<br/>
 *
 * 创建于2019-06-18<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/update-notice-resource")
public class UpdateNoticeResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UpdateNoticeResourceController.class);

    private UpdateNoticeResourceService updateNoticeResourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UpdateNoticeResourceVO updateNoticeResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeResourceService.save(BeanUtils.copy(updateNoticeResourceVO, UpdateNoticeResourceDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UpdateNoticeResourceVO> updateNoticeResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeResourceService.saveBatch(BeanUtils.copyListObj(updateNoticeResourceVOList, UpdateNoticeResourceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        updateNoticeResourceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        updateNoticeResourceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UpdateNoticeResourceVO updateNoticeResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = updateNoticeResourceService.update(BeanUtils.copy(updateNoticeResourceVO, UpdateNoticeResourceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UpdateNoticeResourceVO> updateNoticeResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeResourceService.updateBatch(BeanUtils.copyListObj(updateNoticeResourceVOList, UpdateNoticeResourceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UpdateNoticeResourceVO updateNoticeResourceVO) {
        updateNoticeResourceService.update(BeanUtils.copy(updateNoticeResourceVO, UpdateNoticeResourceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UpdateNoticeResourceVO> updateNoticeResourceVOList) {
        updateNoticeResourceService.updateBatch(BeanUtils.copyListObj(updateNoticeResourceVOList, UpdateNoticeResourceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UpdateNoticeResourceVO updateNoticeResourceVO = new UpdateNoticeResourceVO();
        Object obj = updateNoticeResourceService.getById(id);
        if (obj != null) {
            updateNoticeResourceVO = BeanUtils.copy(obj, UpdateNoticeResourceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", updateNoticeResourceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = updateNoticeResourceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UpdateNoticeResourceQuery updateNoticeResourceQuery) {
        PagerDTO pagerDTO = updateNoticeResourceService.listAllByCondition(updateNoticeResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UpdateNoticeResourceQuery updateNoticeResourceQuery) {
        PagerDTO pagerDTO = updateNoticeResourceService.listPageByCondition(updateNoticeResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUpdateNoticeResourceService(UpdateNoticeResourceService updateNoticeResourceService) {
        this.updateNoticeResourceService = updateNoticeResourceService;
    }
}
