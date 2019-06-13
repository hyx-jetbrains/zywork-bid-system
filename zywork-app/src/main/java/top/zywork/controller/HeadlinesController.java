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
import top.zywork.dto.HeadlinesDTO;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.HeadlinesQuery;
import top.zywork.service.HeadlinesService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.HeadlinesVO;

import java.util.List;

/**
 * HeadlinesController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/headlines")
public class HeadlinesController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(HeadlinesController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.headlines.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.headlines.imgDir}")
    private String imgDir;

    @Value("${storage.local.headlines.imgUrl}")
    private String imgUrl;

    private HeadlinesService headlinesService;

    private UploadService uploadService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated HeadlinesVO headlinesVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        headlinesService.save(BeanUtils.copy(headlinesVO, HeadlinesDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<HeadlinesVO> headlinesVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        headlinesService.saveBatch(BeanUtils.copyListObj(headlinesVOList, HeadlinesDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        headlinesService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        headlinesService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated HeadlinesVO headlinesVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = headlinesService.update(BeanUtils.copy(headlinesVO, HeadlinesDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<HeadlinesVO> headlinesVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        headlinesService.updateBatch(BeanUtils.copyListObj(headlinesVOList, HeadlinesDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody HeadlinesVO headlinesVO) {
        headlinesService.update(BeanUtils.copy(headlinesVO, HeadlinesDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<HeadlinesVO> headlinesVOList) {
        headlinesService.updateBatch(BeanUtils.copyListObj(headlinesVOList, HeadlinesDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        HeadlinesVO headlinesVO = new HeadlinesVO();
        Object obj = headlinesService.getById(id);
        if (obj != null) {
            headlinesVO = BeanUtils.copy(obj, HeadlinesVO.class);
        }
        return ResponseStatusVO.ok("查询成功", headlinesVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = headlinesService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), HeadlinesVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody HeadlinesQuery headlinesQuery) {
        PagerDTO pagerDTO = headlinesService.listAllByCondition(headlinesQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), HeadlinesVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody HeadlinesQuery headlinesQuery) {
        PagerDTO pagerDTO = headlinesService.listPageByCondition(headlinesQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), HeadlinesVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-img")
    public ResponseStatusVO upload(MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl, false);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    /**
     * User: DengMin
     * Date: 2019/05/15
     * Time: 10:59
     * Description: 头条新闻
     */
    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListAllByCondition(@RequestBody HeadlinesQuery headlinesQuery) {
        headlinesQuery.setIsActive((byte)0);
        return listPageByCondition(headlinesQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/15
     * Time: 10:59
     * Description: 头条新闻详情
     */
    @GetMapping("any/one/{id}")
    public ResponseStatusVO getHeadlinesById(@PathVariable("id") Long id) {
        return getById(id);
    }

    @Autowired
    public void setHeadlinesService(HeadlinesService headlinesService) {
        this.headlinesService = headlinesService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
