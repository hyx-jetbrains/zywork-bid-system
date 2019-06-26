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
import top.zywork.dto.SysInfoDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.SysInfoQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ResourceService;
import top.zywork.service.SysInfoService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.SysInfoVO;

import java.util.List;

/**
 * SysInfoController控制器类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/sys-info")
public class SysInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SysInfoController.class);

    private SysInfoService sysInfoService;

    private ResourceService resourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated SysInfoVO sysInfoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysInfoService.save(BeanUtils.copy(sysInfoVO, SysInfoDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SysInfoVO> sysInfoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysInfoService.saveBatch(BeanUtils.copyListObj(sysInfoVOList, SysInfoDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        sysInfoService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        sysInfoService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated SysInfoVO sysInfoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = sysInfoService.update(BeanUtils.copy(sysInfoVO, SysInfoDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SysInfoVO> sysInfoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysInfoService.updateBatch(BeanUtils.copyListObj(sysInfoVOList, SysInfoDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody SysInfoVO sysInfoVO) {
        sysInfoService.update(BeanUtils.copy(sysInfoVO, SysInfoDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SysInfoVO> sysInfoVOList) {
        sysInfoService.updateBatch(BeanUtils.copyListObj(sysInfoVOList, SysInfoDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        SysInfoVO sysInfoVO = new SysInfoVO();
        Object obj = sysInfoService.getById(id);
        if (obj != null) {
            sysInfoVO = BeanUtils.copy(obj, SysInfoVO.class);
        }
        return ResponseStatusVO.ok("查询成功", sysInfoVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = sysInfoService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody SysInfoQuery sysInfoQuery) {
        PagerDTO pagerDTO = sysInfoService.listAllByCondition(sysInfoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SysInfoQuery sysInfoQuery) {
        PagerDTO pagerDTO = sysInfoService.listPageByCondition(sysInfoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-res")
    public ResponseStatusVO upload(MultipartFile file, String type) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO responseStatusVO = resourceService.saveResource(jwtUser, file,
                ResourceConstants.RESOURCE_TYPE_IMAGE, UploadTypeEnum.IMAGE.getAllowedExts(),
                UploadTypeEnum.IMAGE.getMaxSize(), false, ProjectConstants.NOT_CREATE_DIR);
        if (ResponseStatusEnum.OK.getCode().equals(responseStatusVO.getCode())) {
            responseStatusVO.setMessage(type);
        }
        return responseStatusVO;
    }

    @GetMapping("any/sys-info")
    public ResponseStatusVO getSysInfo() {
        return listAll();
    }

    @Autowired
    public void setSysInfoService(SysInfoService sysInfoService) {
        this.sysInfoService = sysInfoService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
