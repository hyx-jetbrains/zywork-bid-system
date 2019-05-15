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
import top.zywork.dto.OftenQuestionDTO;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.OftenQuestionQuery;
import top.zywork.service.OftenQuestionService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.OftenQuestionVO;

import java.util.List;

/**
 * OftenQuestionController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/often-question")
public class OftenQuestionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OftenQuestionController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.question.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.question.imgDir}")
    private String imgDir;

    @Value("${storage.local.question.imgUrl}")
    private String imgUrl;

    private OftenQuestionService oftenQuestionService;

    private UploadService uploadService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated OftenQuestionVO oftenQuestionVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        oftenQuestionService.save(BeanUtils.copy(oftenQuestionVO, OftenQuestionDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<OftenQuestionVO> oftenQuestionVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        oftenQuestionService.saveBatch(BeanUtils.copyListObj(oftenQuestionVOList, OftenQuestionDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        oftenQuestionService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        oftenQuestionService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated OftenQuestionVO oftenQuestionVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = oftenQuestionService.update(BeanUtils.copy(oftenQuestionVO, OftenQuestionDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<OftenQuestionVO> oftenQuestionVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        oftenQuestionService.updateBatch(BeanUtils.copyListObj(oftenQuestionVOList, OftenQuestionDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody OftenQuestionVO oftenQuestionVO) {
        oftenQuestionService.update(BeanUtils.copy(oftenQuestionVO, OftenQuestionDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<OftenQuestionVO> oftenQuestionVOList) {
        oftenQuestionService.updateBatch(BeanUtils.copyListObj(oftenQuestionVOList, OftenQuestionDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        OftenQuestionVO oftenQuestionVO = new OftenQuestionVO();
        Object obj = oftenQuestionService.getById(id);
        if (obj != null) {
            oftenQuestionVO = BeanUtils.copy(obj, OftenQuestionVO.class);
        }
        return ResponseStatusVO.ok("查询成功", oftenQuestionVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = oftenQuestionService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), OftenQuestionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody OftenQuestionQuery oftenQuestionQuery) {
        PagerDTO pagerDTO = oftenQuestionService.listAllByCondition(oftenQuestionQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), OftenQuestionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody OftenQuestionQuery oftenQuestionQuery) {
        PagerDTO pagerDTO = oftenQuestionService.listPageByCondition(oftenQuestionQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), OftenQuestionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-img")
    public ResponseStatusVO upload(MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        uploadOptions.generateCompressSizes(compressSizes);
        return uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 16:31
     * Description: 常见问题
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPage(@RequestBody OftenQuestionQuery oftenQuestionQuery) {
        oftenQuestionQuery.setIsActive((byte)0);
        return listPageByCondition(oftenQuestionQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 16:35
     * Description: 常见问题详情
     */
    @GetMapping("user/getById/{id}")
    public ResponseStatusVO getOftenQuestionById(@PathVariable("id") Long id) {
        return getById(id);
    }

    @Autowired
    public void setOftenQuestionService(OftenQuestionService oftenQuestionService) {
        this.oftenQuestionService = oftenQuestionService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

}
