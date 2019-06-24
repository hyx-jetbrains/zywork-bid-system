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

    private BuilderService builderService;

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
        ResponseStatusVO responseStatusVO = resourceService.saveResource(jwtUser, file,
                ResourceConstants.RESOURCE_TYPE_IMAGE, UploadTypeEnum.IMAGE.getAllowedExts(),
                UploadTypeEnum.IMAGE.getMaxSize(), false);
        return responseStatusVO;
    }

    @PostMapping("user/upload-res")
    public ResponseStatusVO userUpload(MultipartFile file) {
        return upload(file);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 10:58
     * Description: 根据ID查询详情
     */
    @GetMapping("any/getBuilderById/{id}")
    public ResponseStatusVO getBuilderById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 11:33
     * Description: 发布建造师应聘信息
     */
    @PostMapping("user/release-builder")
    public ResponseStatusVO releaseBuilder(@RequestBody @Validated BuilderVO builderVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        builderVO.setUserId(jwtUser.getUserId());
        return save(builderVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/20
     * Time: 9:52
     * Description: 删除我发布的建造师应聘记录
     */
    @GetMapping("user/delete/{id}")
    public ResponseStatusVO delete(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        return removeById(id);
    }

    @Autowired
    public void setBuilderService(BuilderService builderService) {
        this.builderService = builderService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
