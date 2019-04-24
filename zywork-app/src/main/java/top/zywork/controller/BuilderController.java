package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.common.UploadUtils;
import top.zywork.constant.ResourceConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.BuilderDTO;
import top.zywork.dto.ResourceDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.BuilderQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.JwtUtils;
import top.zywork.security.SecurityUtils;
import top.zywork.service.BuilderService;
import top.zywork.service.ResourceService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResourceVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.BuilderVO;

import java.util.List;

/**
 * BuilderController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/builder")
public class BuilderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BuilderController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.resource.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.resource.imgDir}")
    private String imgDir;

    @Value("${storage.local.resource.imgUrl}")
    private String imgUrl;

    private BuilderService builderService;

    private UploadService uploadService;

    private ResourceService resourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated BuilderVO builderVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        builderVO.setUserId(jwtUser.getUserId());
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderService.saveBuilder(builderVO);
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<BuilderVO> builderVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderService.saveBatch(BeanUtils.copyListObj(builderVOList, BuilderDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        builderService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        builderService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated BuilderVO builderVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = builderService.update(BeanUtils.copy(builderVO, BuilderDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<BuilderVO> builderVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        builderService.updateBatch(BeanUtils.copyListObj(builderVOList, BuilderDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody BuilderVO builderVO) {
        builderService.update(BeanUtils.copy(builderVO, BuilderDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<BuilderVO> builderVOList) {
        builderService.updateBatch(BeanUtils.copyListObj(builderVOList, BuilderDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        BuilderVO builderVO = new BuilderVO();
        Object obj = builderService.getById(id);
        if (obj != null) {
            builderVO = BeanUtils.copy(obj, BuilderVO.class);
        }
        return ResponseStatusVO.ok("查询成功", builderVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = builderService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody BuilderQuery builderQuery) {
        PagerDTO pagerDTO = builderService.listAllByCondition(builderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody BuilderQuery builderQuery) {
        PagerDTO pagerDTO = builderService.listPageByCondition(builderQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), BuilderVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-res")
    public ResponseStatusVO upload(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (!responseStatusVO.getCode().equals(ResponseStatusEnum.OK.getCode())) {
            return responseStatusVO;
        }
        String fileName = file.getOriginalFilename();
        String extension = fileName.split("\\.")[1];
        String url = responseStatusVO.getData().toString();
        ResourceDTO resourceDTO = resourceService.saveResource(jwtUser.getUserId(), ResourceConstants.RESOURCE_TYPE_IMAGE, url, extension);
        ResourceVO resourceVO = BeanUtils.copy(resourceDTO, ResourceVO.class);
        return ResponseStatusVO.ok("上传成功", resourceVO);
    }

    @Autowired
    public void setBuilderService(BuilderService builderService) {
        this.builderService = builderService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
