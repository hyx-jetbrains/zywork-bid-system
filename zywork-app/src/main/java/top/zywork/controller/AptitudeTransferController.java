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
import top.zywork.dto.AptitudeTransferDTO;
import top.zywork.dto.ResourceDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.AptitudeTransferQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.AptitudeTransferService;
import top.zywork.service.ResourceService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResourceVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.AptitudeTransferVO;

import java.util.List;

/**
 * AptitudeTransferController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/aptitude-transfer")
public class AptitudeTransferController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AptitudeTransferController.class);

    private AptitudeTransferService aptitudeTransferService;

    private ResourceService resourceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated AptitudeTransferVO aptitudeTransferVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        aptitudeTransferVO.setUserId(jwtUser.getUserId());
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeTransferService.saveAptitudeTransfer(aptitudeTransferVO);
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<AptitudeTransferVO> aptitudeTransferVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeTransferService.saveBatch(BeanUtils.copyListObj(aptitudeTransferVOList, AptitudeTransferDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        aptitudeTransferService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        aptitudeTransferService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated AptitudeTransferVO aptitudeTransferVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = aptitudeTransferService.update(BeanUtils.copy(aptitudeTransferVO, AptitudeTransferDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<AptitudeTransferVO> aptitudeTransferVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        aptitudeTransferService.updateBatch(BeanUtils.copyListObj(aptitudeTransferVOList, AptitudeTransferDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody AptitudeTransferVO aptitudeTransferVO) {
        aptitudeTransferService.update(BeanUtils.copy(aptitudeTransferVO, AptitudeTransferDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<AptitudeTransferVO> aptitudeTransferVOList) {
        aptitudeTransferService.updateBatch(BeanUtils.copyListObj(aptitudeTransferVOList, AptitudeTransferDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        AptitudeTransferVO aptitudeTransferVO = new AptitudeTransferVO();
        Object obj = aptitudeTransferService.getById(id);
        if (obj != null) {
            aptitudeTransferVO = BeanUtils.copy(obj, AptitudeTransferVO.class);
        }
        return ResponseStatusVO.ok("查询成功", aptitudeTransferVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = aptitudeTransferService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody AptitudeTransferQuery aptitudeTransferQuery) {
        PagerDTO pagerDTO = aptitudeTransferService.listAllByCondition(aptitudeTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody AptitudeTransferQuery aptitudeTransferQuery) {
        PagerDTO pagerDTO = aptitudeTransferService.listPageByCondition(aptitudeTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AptitudeTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/upload-res")
    public ResponseStatusVO upload(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO responseStatusVO = resourceService.saveResource(jwtUser, file,
                ResourceConstants.RESOURCE_TYPE_IMAGE, UploadTypeEnum.IMAGE.getAllowedExts(),
                UploadTypeEnum.IMAGE.getMaxSize());
        return responseStatusVO;
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:50
     * Description: 信息共享 -- 资质转让 -- 转让/求购
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody AptitudeTransferQuery aptitudeTransferQuery) {
        return listPageByCondition(aptitudeTransferQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 10:55
     * Description: 根据ID查询
     */
    @GetMapping("any/getAptitudeTransferById/{id}")
    public ResponseStatusVO getAptitudeTransferById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 10:50
     * Description: 我发布的资质转让/求购
     */
    @PostMapping("user/all")
    public ResponseStatusVO listPageByUserId(@RequestBody AptitudeTransferQuery aptitudeTransferQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        aptitudeTransferQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(aptitudeTransferQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 11:43
     * Description: 发布资质转让
     */
    @PostMapping("user/release-aptitudeTransfer")
    public ResponseStatusVO releaseAptitudeTransfer(@RequestBody @Validated AptitudeTransferVO aptitudeTransferVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        aptitudeTransferVO.setUserId(jwtUser.getUserId());
        return save(aptitudeTransferVO, bindingResult);
    }

    @Autowired
    public void setAptitudeTransferService(AptitudeTransferService aptitudeTransferService) {
        this.aptitudeTransferService = aptitudeTransferService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
