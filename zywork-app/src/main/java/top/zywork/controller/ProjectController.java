package top.zywork.controller;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.*;
import top.zywork.constant.NoticeConstants;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.PythonConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.enums.NoticeEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.python.ProjectPythonService;
import top.zywork.query.ProjectQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ProjectService;
import top.zywork.service.SubscribeService;
import top.zywork.service.UploadService;
import top.zywork.service.UserNoticeService;
import top.zywork.vo.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    private ProjectService projectService;

    private UploadService uploadService;

    private SubscribeService subscribeService;

    private UserNoticeService userNoticeService;

    private ProjectPythonService projectPythonService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ProjectVO projectVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        Object obj = projectService.getByTitle(projectVO.getTitle());
        if (null != obj) {
            return ResponseStatusVO.error("该信息已存在", null);
        }

        projectVO = generatorProjectVo(projectVO);
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

        Object obj = projectService.getById(projectVO.getId());
        if(obj != null) {
            ProjectVO project = BeanUtils.copy(obj, ProjectVO.class);
            String url = "/data/bid-system/" + project.getInwardHtmlUrl();
            File file = new File(url);
            if(file.exists()) {
                file.delete();
            }
        }

        projectVO = generatorProjectVo(projectVO);
        int updateRows = projectService.update(BeanUtils.copy(projectVO, ProjectDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    private ProjectVO generatorProjectVo(ProjectVO projectVO) {
        String fileName = UUIDUtils.uuid() +".html";
        CommonMethodUtils.generatorHtmlCode(fileName, projectVO.getProjectDetail(), location);
        projectVO.setInwardHtmlUrl(uri + "/" + fileName);
        projectVO = projectService.getOpenMark(projectVO);
        return projectVO;
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
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl, false);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @PostMapping("admin/releaseProject")
    public ResponseStatusVO releaseProject(@RequestBody ProjectVO projectVO) {
        Object obj = getById(projectVO.getId()).getData();
        if (null == obj) {
            return ResponseStatusVO.error("项目不存在", null);
        }
        projectService.update(BeanUtils.copy(projectVO, ProjectDTO.class));
        projectVO = BeanUtils.copy(obj, ProjectVO.class);
        // 查询所有的订阅信息
        PagerDTO pagerDTO = subscribeService.listAll();
        List<Object> objList = pagerDTO.getRows();
        if(objList != null && objList.size() > 0) {
            List<SubscribeVO> list = BeanUtils.copy(objList, SubscribeVO.class);
            Long projectId = projectVO.getId();
            for(SubscribeVO subscribeVO: list) {
                Long userId = subscribeVO.getUserId();
                // 一、判断用户是否开通了订阅推送
                if (0 == subscribeVO.getIsSubscribe()) {
                    // 用户未开通订阅推送，直接跳过当前循环
                    continue;
                }
                // 二、用户开通了订阅推送，判断城市是否匹配
                if (!subscribeVO.getCity().equals("全省")) {
                    // 用户设置的不是全省，需要判断当前项目是否满足
                    if (!projectVO.getCity().equals(subscribeVO.getCity())) {
                        // 和用户订阅的城市不匹配，跳出本次循环，继续判断下个用户
                        continue;
                    }
                }
                // 三、用户设置了全省或者当前这个项目和用户订阅的城市匹配，继续判断项目类型是否匹配
                if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getProjectType())) {
                    // 用户设置了订阅的项目类型
                    if (!subscribeVO.getProjectType().contains(projectVO.getProjectType())) {
                        // 当前项目不在用户订阅的项目类型当中
                        continue;
                    }
                }
                if ("政府采购".equals(projectVO.getProjectType())) {
                    // 如果当前项目是政府采购，还需要判断用户有没有订阅关键字
                    if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getKeyword())) {
                        // 用户有输入关键字
                        if (!projectVO.getTitle().contains(subscribeVO.getKeyword())) {
                            // 当前项目不包含用户订阅的关键字
                            continue;
                        }
                    }
                }

                Pattern pat = Pattern.compile(ProjectConstants.ZHCN_TEXT_REG);
                Matcher mat = pat.matcher(projectVO.getProjectInvest());
                Double projectInvest = Double.valueOf(mat.toString().trim());
                // 四、用户设置了全省或者当前这个项目和用户订阅的城市匹配，并且没有设置订阅的类型，继续判断金额区间
                if (0 != subscribeVO.getMinMoney()) {
                    // 用设置了最小金额
                    double minMoney = Double.valueOf(subscribeVO.getMinMoney());
                    if (projectInvest < minMoney) {
                        // 当前项目的金额小于用户订阅的最小金额
                        continue;
                    }
                }
                if (0 != subscribeVO.getMaxMoney()) {
                    // 用户设置了最大金额
                    double maxMoney = Double.valueOf(subscribeVO.getMaxMoney());
                    if (projectInvest > maxMoney) {
                        // 当前项目的金额大于用户订阅的金额
                        continue;
                    }
                }
                // 五、上面的条件都满足，继续判断订阅的招标单位
                if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getTenderee())) {
                    // 用户有订阅专门的投标单位
                    if (!subscribeVO.getTenderee().contains(projectVO.getInMarkComp())) {
                        // 当前项目的招标单位不在用户的订阅里面
                        continue;
                    }
                }
                // 六、满足用户的所有订阅条件，给用户推送消息
                saveNotice(userId, projectId);
            }
        }
        return ResponseStatusVO.ok("发布成功", null);
    }

    public void saveNotice(Long userId, Long ProjectId) {
        UserNoticeVO userNoticeVO= new UserNoticeVO();
        userNoticeVO.setUserId(userId);
        userNoticeVO.setItemId(ProjectId);
        userNoticeVO.setPageUrl(NoticeConstants.projectUrl);
        userNoticeVO.setTitle("项目订阅更新");
        userNoticeVO.setMainContent("项目订阅更新");
        userNoticeVO.setDetailContent("您订阅的项目有一条新的申请记录，具体内容可点击《立即查看》按钮前往查看");
        userNoticeVO.setNoticeType(NoticeEnum.SUBSCRIBE_MESSAGE.getValue());
        userNoticeService.save(userNoticeVO);
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
    public ResponseStatusVO userUpdate(@RequestBody ProjectVO projectVO, BindingResult bindingResult) {
        int updateRows = projectService.update(projectVO);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        }
        return ResponseStatusVO.error("更新失败", null);
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
        PagerDTO pagerDTO = projectService.listProjectByPage(projectQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        if(pagerDTO.getRows() != null) {
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceCountVO.class));
        }
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("user/multi/{id}")
    public ResponseStatusVO findProjectById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = projectService.findProjectByd(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        if (null != pagerDTO && null != pagerDTO.getRows()) {
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceCountVO.class));
        }
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:16releaseProject
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
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceCountVO.class));
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

    /***
     * @description:  python爬取数据
     * @param projectQuery
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-13 11:34
     */
    @PostMapping("admin/python")
    public ResponseStatusVO pythonGetData(@RequestBody ProjectQuery projectQuery) {
        String url = PythonConstants.BASE_URL + projectQuery.getTitle() + "?pageNo=" + projectQuery.getPageNo();
        boolean isUpdate = projectQuery.getInMarkComp().equals(PythonConstants.IS_UPDATE_FLAG_STR);
        projectPythonService.saveProject(url, isUpdate);
        return ResponseStatusVO.ok("后台更新中", null);
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Autowired
    public void setSubscribeService(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @Autowired
    public void setUserNoticeService(UserNoticeService userNoticeService) {
        this.userNoticeService = userNoticeService;
    }

    @Autowired
    public void setProjectPythonService(ProjectPythonService projectPythonService) {
        this.projectPythonService = projectPythonService;
    }
}
