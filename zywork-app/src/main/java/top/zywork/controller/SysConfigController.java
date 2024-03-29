package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.SysConfigDTO;
import top.zywork.enums.SysConfigEnum;
import top.zywork.query.SysConfigQuery;
import top.zywork.service.SysConfigService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.SysConfigVO;
import top.zywork.weixin.CustomerConfig;
import top.zywork.weixin.GuaranteeConfig;

import java.util.List;

/**
 * SysConfigController控制器类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/sys-config")
public class SysConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

    private SysConfigService sysConfigService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated SysConfigVO sysConfigVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysConfigService.save(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysConfigService.saveBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        sysConfigService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        sysConfigService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated SysConfigVO sysConfigVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = sysConfigService.update(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        sysConfigService.updateBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody SysConfigVO sysConfigVO) {
        sysConfigService.update(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList) {
        sysConfigService.updateBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        SysConfigVO sysConfigVO = new SysConfigVO();
        Object obj = sysConfigService.getById(id);
        if (obj != null) {
            sysConfigVO = BeanUtils.copy(obj, SysConfigVO.class);
        }
        return ResponseStatusVO.ok("查询成功", sysConfigVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = sysConfigService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysConfigVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody SysConfigQuery sysConfigQuery) {
        PagerDTO pagerDTO = sysConfigService.listAllByCondition(sysConfigQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysConfigVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SysConfigQuery sysConfigQuery) {
        PagerDTO pagerDTO = sysConfigService.listPageByCondition(sysConfigQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysConfigVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("any/customer-config")
    public ResponseStatusVO getCustomerConfig() {
        CustomerConfig customerConfig = sysConfigService.getByName(SysConfigEnum.CUSTOMER_CONFIG.getValue(), CustomerConfig.class);
        return ResponseStatusVO.ok("查询成功", customerConfig);
    }

    @GetMapping("any/guarantee-config")
    public ResponseStatusVO getGuaranteeConfig() {
        GuaranteeConfig guaranteeConfig = sysConfigService.getByName(SysConfigEnum.GUARANTEE_MEMO_CONFIG.getValue(), GuaranteeConfig.class);
        return ResponseStatusVO.ok("查询成功", guaranteeConfig);
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
