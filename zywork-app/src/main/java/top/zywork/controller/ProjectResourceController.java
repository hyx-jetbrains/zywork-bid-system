package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.common.UploadUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.ResourceConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.dto.ProjectResourceDTO;
import top.zywork.dto.ResourceDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.ProjectResourceQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.*;
import top.zywork.vo.*;
import top.zywork.weixin.DeletePwdConfig;

import java.io.File;
import java.util.List;

/**
 * ProjectResourceController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/projecresource")
public class ProjectResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectResourceController.class);

    private ProjectResourceService projectResourceService;

    private ResourceService resourceService;

    private ProjectService projectService;

    private SysConfigService sysConfigService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ProjectResourceVO projectResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }

        int i = projectResourceService.save(BeanUtils.copy(projectResourceVO, ProjectResourceDTO.class));
        if (i > 0) {
            // 保存成功更新项目表个数
            Long projectId = projectResourceVO.getProjectId();
            ProjectResourceQuery projectResourceQuery = new ProjectResourceQuery();
            projectResourceQuery.setProjectId(projectId);
            projectResourceQuery.setIsActive((byte)0);
            Long count = projectResourceService.countByCondition(projectResourceQuery);
            Object obj = projectService.getById(projectResourceVO.getProjectId());
            ProjectVO projectVO = BeanUtils.copy(obj, ProjectVO.class);
            projectVO.setResourceCount(count.intValue());
            projectService.update(projectVO);
            if (projectResourceVO.getResType() == 4) {
                // 上传的文件类型是答疑文件，需要给用户推送消息
                projectService.subscribleNotice(projectVO, ProjectConstants.PROJECT_SUBSCRIBE_TYPE_UPLOAD_FILE);
            }
        }
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ProjectResourceVO> projectResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectResourceService.saveBatch(BeanUtils.copyListObj(projectResourceVOList, ProjectResourceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    private void removeProjectResourceCount(ProjectResourceDTO projectResourceDTO) {
        ProjectVO projectVO = BeanUtils.copy(projectService.getById(projectResourceDTO.getProjectId()), ProjectVO.class);
        projectVO.setResourceCount(projectVO.getResourceCount() - 1);
        projectService.update(projectVO);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        ProjectResourceDTO projectResourceDTO = BeanUtils.copy(projectResourceService.getById(id), ProjectResourceDTO.class);
        Long resourceId = projectResourceDTO.getResourceId();
        removeProjectResourceCount(projectResourceDTO);
        ResourceDTO resourceDTO = BeanUtils.copy(resourceService.getById(resourceId), ResourceDTO.class);
        String url = "/data/bid-system/" + resourceDTO.getUrl();
        File file = new File(url);
        if(file.exists()) {
            file.delete();
        }
        resourceService.removeById(resourceId);
        projectResourceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        projectResourceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        for (String id : ids) {
            ProjectResourceDTO projectResourceDTO = BeanUtils.copy(projectResourceService.getById(id), ProjectResourceDTO.class);
            removeProjectResourceCount(projectResourceDTO);
        }
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ProjectResourceVO projectResourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = projectResourceService.update(BeanUtils.copy(projectResourceVO, ProjectResourceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ProjectResourceVO> projectResourceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectResourceService.updateBatch(BeanUtils.copyListObj(projectResourceVOList, ProjectResourceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ProjectResourceVO projectResourceVO) {
        projectResourceService.update(BeanUtils.copy(projectResourceVO, ProjectResourceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ProjectResourceVO> projectResourceVOList) {
        projectResourceService.updateBatch(BeanUtils.copyListObj(projectResourceVOList, ProjectResourceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ProjectResourceVO projectResourceVO = new ProjectResourceVO();
        Object obj = projectResourceService.getById(id);
        if (obj != null) {
            projectResourceVO = BeanUtils.copy(obj, ProjectResourceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", projectResourceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectResourceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectResourceQuery projectResourceQuery) {
        PagerDTO pagerDTO = projectResourceService.listAllByCondition(projectResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectResourceQuery projectResourceQuery) {
        PagerDTO pagerDTO = projectResourceService.listPageByCondition(projectResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-res")
    public ResponseStatusVO upload(MultipartFile file, String projectId) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO responseStatusVO = resourceService.saveResource(jwtUser, file,
                ResourceConstants.RESOURCE_TYPE_DOCUMENT, UploadTypeEnum.OFFICE.getAllowedExts(),
                UploadTypeEnum.OFFICE.getMaxSize(), true, projectId);
        return responseStatusVO;
    }

    @PostMapping("admin/delete")
    public ResponseStatusVO delete(@RequestBody ProjectResourceQuery projectResourceQuery) {
        DeletePwdConfig deletePwdConfig = sysConfigService.getByName(SysConfigEnum.DELETE_PWD_CONFIG.getValue(), DeletePwdConfig.class);
        if (!projectResourceQuery.getPassword().equals(deletePwdConfig.getPassword())) {
            return ResponseStatusVO.error("密码错误，请输入正确的密码", null);
        }
        if (projectResourceQuery.getCreateTimeMax().getTime() < projectResourceQuery.getCreateTimeMin().getTime()) {
            return ResponseStatusVO.error("结束时间不能小于开始时间", null);
        }
        return projectResourceService.deleteByCond(projectResourceQuery);
    }

    @Autowired
    public void setProjectResourceService(ProjectResourceService projectResourceService) {
        this.projectResourceService = projectResourceService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
