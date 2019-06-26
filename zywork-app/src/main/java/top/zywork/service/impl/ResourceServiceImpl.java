package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateUtils;
import top.zywork.common.UploadUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.ResourceConstants;
import top.zywork.dao.ResourceDAO;
import top.zywork.dos.ResourceDO;
import top.zywork.dto.ResourceDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.security.JwtUser;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ResourceService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResourceVO;
import top.zywork.vo.ResponseStatusVO;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * ResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "resourceService")
public class ResourceServiceImpl extends AbstractBaseService implements ResourceService {

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

    private ResourceDAO resourceDAO;

    private UploadService uploadService;

    @Autowired
    public void setResourceDAO(ResourceDAO resourceDAO) {
        super.setBaseDAO(resourceDAO);
        this.resourceDAO = resourceDAO;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostConstruct
    public void init() {
        super.init(ResourceDO.class, ResourceDTO.class);
    }

    /***
     * @description: 保存资源数据，获取到资源的id
     * @param userId 用户ID
     * @param mimeType 资源类型
     * @param url 资源地址
     * @param extension 资源后缀
     * @return: top.zywork.dto.ResourceDTO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-25 10:12
     */
    public ResourceDTO saveResourceData(Long userId, String mimeType, String url, String extension) {
        ResourceDTO resourceDTO = new ResourceDTO();
        try {
            resourceDTO.setUserId(userId);
            resourceDTO.setMimeType(mimeType);
            resourceDTO.setUrl(url);
            resourceDTO.setExtension(extension);
            resourceDAO.save(resourceDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourceDTO;
    }

    @Override
    public ResponseStatusVO saveResource(JwtUser jwtUser, MultipartFile file, String resourceType,
                                         String resourceExts, Long resourceSize, boolean keepFileName, String fileDir) {
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        String imgDir = this.imgDir;
        String imgUrl = this.imgUrl;
        if (!ProjectConstants.NOT_CREATE_DIR.equals(fileDir)) {
            // 表示是项目资源上传，需要区分目录
            StringBuilder sb = new StringBuilder();
            sb.append(File.separator)
                    .append("project_")
                    .append(fileDir)
                    .append(File.separator)
                    .append(DateUtils.currentTimeMillis());
            imgDir += sb.toString();
            imgUrl += sb.toString();
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl, keepFileName);
        if (ResourceConstants.RESOURCE_TYPE_IMAGE.equals(resourceType)) {
            // 如果是图片资源，则需要压缩
            uploadOptions.generateCompressSizes(compressSizes);
        }
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file,
                resourceExts, resourceSize, uploadOptions);
        if (!responseStatusVO.getCode().equals(ResponseStatusEnum.OK.getCode())) {
            return responseStatusVO;
        }
        String url = responseStatusVO.getData().toString();
        String[] urlArr = url.split("\\.");
        String extension = urlArr[urlArr.length-1];
        ResourceDTO resourceDTO = saveResourceData(jwtUser.getUserId(), resourceType, url, extension);
        ResourceVO resourceVO = BeanUtils.copy(resourceDTO, ResourceVO.class);
        return ResponseStatusVO.ok("上传成功", resourceVO);
    }
}
