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
import top.zywork.common.*;
import top.zywork.constant.ProjectConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.ProjectQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ProjectCollectionService;
import top.zywork.service.ProjectService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ProjectVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ProjectController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.project.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.project.imgDir}")
    private String imgDir;

    @Value("${storage.local.project.imgUrl}")
    private String imgUrl;

    private ProjectService projectService;

    private UploadService uploadService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ProjectVO projectVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectVO = projectService.getOpenMark(projectVO);
        projectService.save(BeanUtils.copy(projectVO, ProjectDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ProjectVO> projectVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectVOList = projectService.getOpenMarkList(projectVOList);
        projectService.saveBatch(BeanUtils.copyListObj(projectVOList, ProjectDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        projectService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        projectService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ProjectVO projectVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectVO = projectService.getOpenMark(projectVO);
        int updateRows = projectService.update(BeanUtils.copy(projectVO, ProjectDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ProjectVO> projectVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectVOList = projectService.getOpenMarkList(projectVOList);
        projectService.updateBatch(BeanUtils.copyListObj(projectVOList, ProjectDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ProjectVO projectVO) {
        projectService.update(BeanUtils.copy(projectVO, ProjectDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ProjectVO> projectVOList) {
        projectService.updateBatch(BeanUtils.copyListObj(projectVOList, ProjectDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ProjectVO projectVO = new ProjectVO();
        Object obj = projectService.getById(id);
        if (obj != null) {
            projectVO = BeanUtils.copy(obj, ProjectVO.class);
        }
        return ResponseStatusVO.ok("查询成功", projectVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectQuery projectQuery) {
        PagerDTO pagerDTO = projectService.listAllByCondition(projectQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectQuery projectQuery) {
        PagerDTO pagerDTO = projectService.listPageByCondition(projectQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }


    @PostMapping("admin/upload-img")
    public ResponseStatusVO upload(MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @PostMapping("admin/releaseProject")
    public ResponseStatusVO releaseProject(@RequestBody ProjectVO projectVO) {
        projectService.update(BeanUtils.copy(projectVO, ProjectDTO.class));
        return ResponseStatusVO.ok("发布成功", null);
    }

    @PostMapping("admin/batch-release")
    public ResponseStatusVO releaseProjectBatch(@RequestBody @Validated List<ProjectVO> projectVOList) {
        projectService.updateBatch(BeanUtils.copyListObj(projectVOList, ProjectDTO.class));
        return ResponseStatusVO.ok("批量发布成功", null);
    }

    /**
     * 用户端更新，主要用于更新点击次数
     * @param projectVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/update")
    public ResponseStatusVO userUpdate(@RequestBody @Validated ProjectVO projectVO, BindingResult bindingResult) {
        return update(projectVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/15
     * Time: 11:01
     * Description: 招标信息
     */
    @PostMapping("any/list-pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody ProjectQuery projectQuery) {
        projectQuery.setIsActive((byte) 0);
        return listPageByCondition(projectQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:16
     * Description: 我的收藏
     */
    @PostMapping("user/list-projectCollection-page")
    public ResponseStatusVO listPageCond(@RequestBody ProjectQuery projectQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        PagerDTO pagerDTO = projectService.listPageByUserId(projectQuery, jwtUser.getUserId());
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        if (null != pagerDTO && null != pagerDTO.getRows()) {
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectVO.class));
        }
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 18:23
     * Description: 招标详情
     */
    @GetMapping("any/getById/{id}")
    public ResponseStatusVO getProjectById(@PathVariable("id") Long id) {
        return getById(id);
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
