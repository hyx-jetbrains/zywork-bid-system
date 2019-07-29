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
import top.zywork.dto.PagerDTO;
import top.zywork.dto.AdvertisementDTO;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.AdvertisementQuery;
import top.zywork.service.AdvertisementService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.AdvertisementVO;

import java.util.List;

/**
 * AdvertisementController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AdvertisementController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.advertisement.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.advertisement.imgDir}")
    private String imgDir;

    @Value("${storage.local.advertisement.imgUrl}")
    private String imgUrl;

    private AdvertisementService advertisementService;

    private UploadService uploadService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated AdvertisementVO advertisementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        advertisementService.save(BeanUtils.copy(advertisementVO, AdvertisementDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<AdvertisementVO> advertisementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        advertisementService.saveBatch(BeanUtils.copyListObj(advertisementVOList, AdvertisementDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        advertisementService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        advertisementService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated AdvertisementVO advertisementVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = advertisementService.update(BeanUtils.copy(advertisementVO, AdvertisementDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<AdvertisementVO> advertisementVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        advertisementService.updateBatch(BeanUtils.copyListObj(advertisementVOList, AdvertisementDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody AdvertisementVO advertisementVO) {
        advertisementService.update(BeanUtils.copy(advertisementVO, AdvertisementDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<AdvertisementVO> advertisementVOList) {
        advertisementService.updateBatch(BeanUtils.copyListObj(advertisementVOList, AdvertisementDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        AdvertisementVO advertisementVO = new AdvertisementVO();
        Object obj = advertisementService.getById(id);
        if (obj != null) {
            advertisementVO = BeanUtils.copy(obj, AdvertisementVO.class);
        }
        return ResponseStatusVO.ok("查询成功", advertisementVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = advertisementService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AdvertisementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/15
     * Time: 14:54
     * Description: 轮播图
     */
    @PostMapping("any/all-cond")
    public ResponseStatusVO userlistAll(@RequestBody AdvertisementQuery advertisementQuery) {
        return listAllByCondition(advertisementQuery);
    }

    /**
     * 根据id获取轮播图信息
     * @param id
     * @return
     */
    @GetMapping("any/one/{id}")
    public ResponseStatusVO anyGetByid(@PathVariable("id") Long id) {
        return getById(id);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody AdvertisementQuery advertisementQuery) {
        PagerDTO pagerDTO = advertisementService.listAllByCondition(advertisementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AdvertisementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody AdvertisementQuery advertisementQuery) {
        PagerDTO pagerDTO = advertisementService.listPageByCondition(advertisementQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AdvertisementVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-img")
    public ResponseStatusVO upload(MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl, false);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @Autowired
    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
