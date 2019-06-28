package top.zywork.controller;

import net.bytebuddy.asm.Advice;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.annotation.SysLog;
import top.zywork.common.BeanUtils;
import top.zywork.common.CommonMethodUtils;
import top.zywork.common.UUIDUtils;
import top.zywork.common.UploadUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectAnnounceDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.StorageProviderEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ProjectAnnounceService;
import top.zywork.service.ProjectService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private UploadService uploadService;

    private ProjectService projectService;

    private ProjectAnnounceService projectAnnounceService;

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    @PostMapping("add")
    @SysLog(description = "用户添加")
    public ResponseStatusVO add() {
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("edit")
    @SysLog(description = "用户编辑")
    public ResponseStatusVO edit() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            logger.info("userId: {}, userName: {}", jwtUser.getUserId(), jwtUser.getUsername());
        }
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @GetMapping("remove/{id}")
    @SysLog(description = "用户删除")
    public ResponseStatusVO remove(@PathVariable("id") String id) {
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("upload")
    public ResponseStatusVO upload(MultipartFile file) {
        if (file == null) {
            return ResponseStatusVO.dataError("未上传文件", null);
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions("./upload", "test", "dbSaveUrl", false);
        uploadOptions.generateCompressSizes("200x200,300x300");
        return uploadService.uploadFile(StorageProviderEnum.LOCAL.getProvider(), file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @GetMapping("project")
    public ResponseStatusVO refreshProjectFile() {
        PagerDTO pagerDTO = projectService.listAll();
        List<Object> objectList = pagerDTO.getRows();
        int count = 0;
        if (null != objectList && objectList.size() > 0) {
            List<ProjectDTO> projectDTOList = BeanUtils.copy(objectList, ProjectDTO.class);
            for (ProjectDTO projectDTO : projectDTOList) {
                String inWordHtmlUrl = projectDTO.getInwardHtmlUrl();
                if (StringUtils.isNotEmpty(inWordHtmlUrl)) {
                    // 文件路径不为空，判断该文件是否存在
                    String url = "/data/bid-system/" + inWordHtmlUrl;
                    File file = new File(url);
                    if(file.exists()) {
                        // 文件存在，跳过本次循环
                        continue;
                    }
                }
                logger.info("project:文件不存在：" + projectDTO);
                // 路径为空或者文件不存在，需要重新生成文件
                String content = projectDTO.getProjectDetail();
                String fileName = UUIDUtils.uuid() +".html";
                String newFileName = CommonMethodUtils.generatorHtmlCode(fileName, content, location);
                if (org.apache.commons.lang.StringUtils.isNotEmpty(newFileName)) {
                    projectDTO.setInwardHtmlUrl(uri + "/" + newFileName);
                }
                int updateRow = projectAnnounceService.update(projectDTO);
                if (updateRow > 0) {
                    count++;
                }
            }
        }
        return ResponseStatusVO.ok("成功更新：" + count + "条记录", null);
    }

    @GetMapping("project-announce")
    public ResponseStatusVO refreshProjectAnnounceFile() {
        PagerDTO pagerDTO = projectAnnounceService.listAll();
        List<Object> objectList = pagerDTO.getRows();
        int count = 0;
        if (null != objectList && objectList.size() > 0) {
            List<ProjectAnnounceDTO> projectAnnounceDTOList = BeanUtils.copy(objectList, ProjectAnnounceDTO.class);
            for (ProjectAnnounceDTO projectAnnounceDTO : projectAnnounceDTOList) {
                String inWordHtmlUrl = projectAnnounceDTO.getInwordHtmlUrl();
                if (StringUtils.isNotEmpty(inWordHtmlUrl)) {
                    // 文件路径不为空，判断该文件是否存在
                    String url = "/data/bid-system/" + inWordHtmlUrl;
                    File file = new File(url);
                    if(file.exists()) {
                        // 文件存在，跳过本次循环
                        continue;
                    }
                }
                logger.info("project-announce:文件不存在：" + projectAnnounceDTO);
                // 路径为空或者文件不存在，需要重新生成文件
                String content = projectAnnounceDTO.getAnnounceDesc();
                String fileName = UUIDUtils.uuid() +".html";
                String newFileName = CommonMethodUtils.generatorHtmlCode(fileName, content, location);
                if (org.apache.commons.lang.StringUtils.isNotEmpty(newFileName)) {
                    projectAnnounceDTO.setInwordHtmlUrl(uri + "/" + newFileName);
                }
                int updateRow = projectAnnounceService.update(projectAnnounceDTO);
                if (updateRow > 0) {
                    count++;
                }
            }
        }
        return ResponseStatusVO.ok("成功更新：" + count + "条记录", null);
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setProjectAnnounceService(ProjectAnnounceService projectAnnounceService) {
        this.projectAnnounceService = projectAnnounceService;
    }
 }