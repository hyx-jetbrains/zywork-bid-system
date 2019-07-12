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
import top.zywork.annotation.HasHideProperty;
import top.zywork.annotation.HideProperty;
import top.zywork.common.*;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.PythonConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectAnnounceDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.python.ProjectAnnouncePythonService;
import top.zywork.python.ProjectPythonService;
import top.zywork.query.ProjectAnnounceQuery;
import top.zywork.query.ProjectQuery;
import top.zywork.service.ProjectAnnounceService;
import top.zywork.service.ProjectService;
import top.zywork.service.UploadService;
import top.zywork.vo.ProjectVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ProjectAnnounceVO;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * ProjectAnnounceController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/projecannounce")
@HasHideProperty
public class ProjectAnnounceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectAnnounceController.class);

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

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    private ProjectAnnounceService projectAnnounceService;

    private ProjectService projectService;

    private UploadService uploadService;

    private ProjectAnnouncePythonService projectAnnouncePythonService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ProjectAnnounceVO projectAnnounceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }

        Object obj = projectAnnounceService.getByTitle(projectAnnounceVO.getTitle());
        if (null != obj) {
            return ResponseStatusVO.error("该信息已存在", null);
        }
        Long projectId = projectAnnounceVO.getProjectId();
        String firstCandidate = projectAnnounceVO.getFirstCandidate();
        if (!ResponseStatusEnum.OK.getCode().equals(updateProject(projectId, firstCandidate).getCode())) {
            return ResponseStatusVO.error("更新项目失败，请重试", null);
        }

        projectAnnounceVO = generatorProjectAnnounceVO(projectAnnounceVO);

        projectAnnounceService.save(BeanUtils.copy(projectAnnounceVO, ProjectAnnounceDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ProjectAnnounceVO> projectAnnounceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectAnnounceService.saveBatch(BeanUtils.copyListObj(projectAnnounceVOList, ProjectAnnounceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        projectAnnounceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        projectAnnounceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ProjectAnnounceVO projectAnnounceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }

        Long projectId = projectAnnounceVO.getProjectId();
        String firstCandidate = projectAnnounceVO.getFirstCandidate();
        if (!ResponseStatusEnum.OK.getCode().equals(updateProject(projectId, firstCandidate).getCode())) {
            return ResponseStatusVO.error("更新项目失败，请重试", null);
        }

        Object obj = projectAnnounceService.getById(projectAnnounceVO.getId());
        if (null != obj) {
            ProjectAnnounceVO tempProjectAnnounceVO = BeanUtils.copy(obj, ProjectAnnounceVO.class);
            String url = "/data/bid-system/" + tempProjectAnnounceVO.getInwordHtmlUrl();
            File file = new File(url);
            if(file.exists()) {
                file.delete();
            }
        }


        projectAnnounceVO = generatorProjectAnnounceVO(projectAnnounceVO);

        int updateRows = projectAnnounceService.update(BeanUtils.copy(projectAnnounceVO, ProjectAnnounceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    private ProjectAnnounceVO generatorProjectAnnounceVO(ProjectAnnounceVO projectAnnounceVO) {
        String content = projectAnnounceVO.getAnnounceDesc();
        if (org.apache.commons.lang.StringUtils.isEmpty(content)) {
            logger.error("项目公示生成html错误：内容为空：" + projectAnnounceVO);
            return projectAnnounceVO;
        }
        String fileName = UUIDUtils.uuid() +".html";
        String newFileName = CommonMethodUtils.generatorHtmlCode(fileName, content, location);
        if (org.apache.commons.lang.StringUtils.isNotEmpty(newFileName)) {
            projectAnnounceVO.setInwordHtmlUrl(uri + "/" + newFileName);
        }
        return projectAnnounceVO;
    }

    /***
     * @description:  更新项目的中标单位信息
     * @param projectId 项目id
     * @param firstCandidate 中标公司
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-22 11:38
     */
    private ResponseStatusVO updateProject(Long projectId, String firstCandidate) {
        if (org.apache.commons.lang.StringUtils.isEmpty(projectId.toString())
                || org.apache.commons.lang.StringUtils.isEmpty(firstCandidate)
                || projectId == 0) {
            return ResponseStatusVO.ok("不需要更新", null);
        }
        Object projectObj = projectService.getById(projectId);
        if (null == projectObj) {
            return ResponseStatusVO.error("项目不存在", null);
        }
        ProjectDTO projectDTO = BeanUtils.copy(projectObj, ProjectDTO.class);
        projectDTO.setInMarkComp(firstCandidate);
        projectService.update(projectDTO);
        return ResponseStatusVO.ok("更新成功", null);
    }
    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ProjectAnnounceVO> projectAnnounceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectAnnounceService.updateBatch(BeanUtils.copyListObj(projectAnnounceVOList, ProjectAnnounceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ProjectAnnounceVO projectAnnounceVO) {
        projectAnnounceService.update(BeanUtils.copy(projectAnnounceVO, ProjectAnnounceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ProjectAnnounceVO> projectAnnounceVOList) {
        projectAnnounceService.updateBatch(BeanUtils.copyListObj(projectAnnounceVOList, ProjectAnnounceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ProjectAnnounceVO projectAnnounceVO = new ProjectAnnounceVO();
        Object obj = projectAnnounceService.getById(id);
        if (obj != null) {
            projectAnnounceVO = BeanUtils.copy(obj, ProjectAnnounceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", projectAnnounceVO);
    }

    /**
     * User: 危锦辉
     * Date: 2019/05/13
     * Time: 18:53
     * Description: 根据项目ID获取公告详情
     */
    @GetMapping("any/getByProjectId/{projectId}")
    public ResponseStatusVO getByProjectId(@PathVariable("projectId") Long projectId) {
        ProjectAnnounceVO projectAnnounceVO = new ProjectAnnounceVO();
        Object obj = projectAnnounceService.getByProjectId(projectId);
        if(obj != null) {
            projectAnnounceVO = BeanUtils.copy(obj, ProjectAnnounceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", projectAnnounceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectAnnounceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectAnnounceQuery projectAnnounceQuery) {
        PagerDTO pagerDTO = projectAnnounceService.listAllByCondition(projectAnnounceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectAnnounceQuery projectAnnounceQuery) {
        PagerDTO pagerDTO = projectAnnounceService.listPageByCondition(projectAnnounceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectAnnounceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-img")
    public ResponseStatusVO upload(MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl, false);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @GetMapping("admin/project-select/{projectId}")
    public ResponseStatusVO getProjectSelect(@PathVariable("projectId") Long projectId) {
        List<ProjectDTO> projectDTOList = projectAnnounceService.getProjectSelect(projectId);
        if (null == projectDTOList || projectDTOList.size() <= 0) {
            return ResponseStatusVO.error("未获取到数据", null);
        }
        List<ProjectVO> projectVOList = BeanUtils.copy(projectDTOList, ProjectVO.class);
        return ResponseStatusVO.ok("查询成功", projectVOList);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody ProjectAnnounceQuery projectAnnounceQuery) {
        return listPageByCondition(projectAnnounceQuery);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/projecannounce/user/pager-cond", properties = {"title"})
    public ResponseStatusVO userListPageByCond(HttpServletRequest request, @RequestBody ProjectAnnounceQuery projectAnnounceQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(projectAnnounceQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCond",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    /***
     * @description:  python爬取数据
     * @param projectAnnounceQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-13 11:34
     */
    @PostMapping("admin/python")
    public ResponseStatusVO pythonGetData(@RequestBody ProjectAnnounceQuery projectAnnounceQuery) {
        if (null == projectAnnounceQuery.getPageNo()) {
            return ResponseStatusVO.error("请输入页码", null);
        }
        String url = PythonConstants.BASE_URL + projectAnnounceQuery.getTitle() + "?pageNo=" + projectAnnounceQuery.getPageNo();
        boolean isUpdate = projectAnnounceQuery.getFirstBuilderName().equals(PythonConstants.IS_UPDATE_FLAG_STR);
        projectAnnouncePythonService.saveProjectAnnounce(url, isUpdate);
        return ResponseStatusVO.ok("后台更新中", null);
    }

    @GetMapping("any/top/{top}")
    public ResponseStatusVO getTop(@PathVariable("top") Long top) {
        List<Object> objectList = projectAnnounceService.getTop(top);
        List<ProjectAnnounceDTO> projectAnnounceDTOList = BeanUtils.copy(objectList, ProjectAnnounceDTO.class);
        return ResponseStatusVO.ok("查询成功", projectAnnounceDTOList);
    }

    @Autowired
    public void setProjectAnnounceService(ProjectAnnounceService projectAnnounceService) {
        this.projectAnnounceService = projectAnnounceService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Autowired
    public void setProjectPythonService(ProjectAnnouncePythonService projectAnnouncePythonService) {
        this.projectAnnouncePythonService = projectAnnouncePythonService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

}
