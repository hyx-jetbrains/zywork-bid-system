package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.ResourceConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UpdateNoticeDTO;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.UpdateNoticeQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ResourceService;
import top.zywork.service.UpdateNoticeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UpdateNoticeVO;

import java.util.List;

/**
 * UpdateNoticeController控制器类<br/>
 *
 * 创建于2019-05-27<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/update-notice")
public class UpdateNoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UpdateNoticeController.class);

    private UpdateNoticeService updateNoticeService;

    private ResourceService resourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UpdateNoticeVO updateNoticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeService.save(BeanUtils.copy(updateNoticeVO, UpdateNoticeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UpdateNoticeVO> updateNoticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeService.saveBatch(BeanUtils.copyListObj(updateNoticeVOList, UpdateNoticeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        updateNoticeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        updateNoticeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UpdateNoticeVO updateNoticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = updateNoticeService.update(BeanUtils.copy(updateNoticeVO, UpdateNoticeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UpdateNoticeVO> updateNoticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        updateNoticeService.updateBatch(BeanUtils.copyListObj(updateNoticeVOList, UpdateNoticeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UpdateNoticeVO updateNoticeVO) {
        updateNoticeService.update(BeanUtils.copy(updateNoticeVO, UpdateNoticeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UpdateNoticeVO> updateNoticeVOList) {
        updateNoticeService.updateBatch(BeanUtils.copyListObj(updateNoticeVOList, UpdateNoticeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UpdateNoticeVO updateNoticeVO = new UpdateNoticeVO();
        Object obj = updateNoticeService.getById(id);
        if (obj != null) {
            updateNoticeVO = BeanUtils.copy(obj, UpdateNoticeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", updateNoticeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = updateNoticeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UpdateNoticeQuery updateNoticeQuery) {
        PagerDTO pagerDTO = updateNoticeService.listAllByCondition(updateNoticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UpdateNoticeQuery updateNoticeQuery) {
        PagerDTO pagerDTO = updateNoticeService.listPageByCondition(updateNoticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UpdateNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/list-page")
    public ResponseStatusVO userListPage(@RequestBody UpdateNoticeQuery updateNoticeQuery) {
        updateNoticeQuery.setSortColumn("createTime");
        updateNoticeQuery.setSortOrder("desc");
        return listPageByCondition(updateNoticeQuery);
    }

    @PostMapping("admin/upload-res")
    public ResponseStatusVO upload(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO responseStatusVO = resourceService.saveResource(jwtUser, file,
                ResourceConstants.RESOURCE_TYPE_DOCUMENT, UploadTypeEnum.OFFICE.getAllowedExts(),
                UploadTypeEnum.OFFICE.getMaxSize(), true, ProjectConstants.NOT_CREATE_DIR);
        return responseStatusVO;
    }

    @Autowired
    public void setUpdateNoticeService(UpdateNoticeService updateNoticeService) {
        this.updateNoticeService = updateNoticeService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
