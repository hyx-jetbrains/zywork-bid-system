package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ServiceDTO;
import top.zywork.query.ServiceQuery;
import top.zywork.service.ServiceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ServiceVO;

import java.util.List;

/**
 * ServiceController控制器类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/service")
public class ServiceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    private ServiceService serviceService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ServiceVO serviceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        serviceService.save(BeanUtils.copy(serviceVO, ServiceDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ServiceVO> serviceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        serviceService.saveBatch(BeanUtils.copyListObj(serviceVOList, ServiceDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        serviceService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        serviceService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ServiceVO serviceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = serviceService.update(BeanUtils.copy(serviceVO, ServiceDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ServiceVO> serviceVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        serviceService.updateBatch(BeanUtils.copyListObj(serviceVOList, ServiceDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ServiceVO serviceVO) {
        serviceService.update(BeanUtils.copy(serviceVO, ServiceDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ServiceVO> serviceVOList) {
        serviceService.updateBatch(BeanUtils.copyListObj(serviceVOList, ServiceDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ServiceVO serviceVO = new ServiceVO();
        Object obj = serviceService.getById(id);
        if (obj != null) {
            serviceVO = BeanUtils.copy(obj, ServiceVO.class);
        }
        return ResponseStatusVO.ok("查询成功", serviceVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = serviceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ServiceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ServiceQuery serviceQuery) {
        PagerDTO pagerDTO = serviceService.listAllByCondition(serviceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ServiceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ServiceQuery serviceQuery) {
        PagerDTO pagerDTO = serviceService.listPageByCondition(serviceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ServiceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 小程序端查询所有的服务
     * @param id
     * @return
     */
    @PostMapping("any/one/{id}")
    public ResponseStatusVO userGetById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * 小程序端查询单个的服务
     * @param serviceQuery
     * @return
     */
    @PostMapping("any/all-cond")
    public ResponseStatusVO userListAllByCondition(@RequestBody ServiceQuery serviceQuery) {
        return listAllByCondition(serviceQuery);
    }

    @Autowired
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
}
