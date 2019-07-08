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
import top.zywork.dto.LabourReqDTO;
import top.zywork.query.LabourReqQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.LabourReqService;
import top.zywork.vo.LabourVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.LabourReqVO;

import java.util.List;

/**
 * LabourReqController控制器类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/labour-req")
public class LabourReqController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LabourReqController.class);

    private LabourReqService labourReqService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated LabourReqVO labourReqVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        labourReqService.save(BeanUtils.copy(labourReqVO, LabourReqDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<LabourReqVO> labourReqVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        labourReqService.saveBatch(BeanUtils.copyListObj(labourReqVOList, LabourReqDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        labourReqService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        labourReqService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated LabourReqVO labourReqVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = labourReqService.update(BeanUtils.copy(labourReqVO, LabourReqDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<LabourReqVO> labourReqVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        labourReqService.updateBatch(BeanUtils.copyListObj(labourReqVOList, LabourReqDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody LabourReqVO labourReqVO) {
        labourReqService.update(BeanUtils.copy(labourReqVO, LabourReqDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<LabourReqVO> labourReqVOList) {
        labourReqService.updateBatch(BeanUtils.copyListObj(labourReqVOList, LabourReqDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        LabourReqVO labourReqVO = new LabourReqVO();
        Object obj = labourReqService.getById(id);
        if (obj != null) {
            labourReqVO = BeanUtils.copy(obj, LabourReqVO.class);
        }
        return ResponseStatusVO.ok("查询成功", labourReqVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = labourReqService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody LabourReqQuery labourReqQuery) {
        PagerDTO pagerDTO = labourReqService.listAllByCondition(labourReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody LabourReqQuery labourReqQuery) {
        PagerDTO pagerDTO = labourReqService.listPageByCondition(labourReqQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LabourReqVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }
    /***
     * @description:  发布劳务招聘信息
     * @param labourReqVO
     * @param bindingResult
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 16:29
     */
    @PostMapping("user/release-labour-req")
    public ResponseStatusVO releaseLabour(@RequestBody @Validated LabourReqVO labourReqVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        labourReqVO.setUserId(jwtUser.getUserId());
        return save(labourReqVO, bindingResult);
    }

    /***
     * @description:  删除我发布的劳务招聘信息
     * @param id
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-07-08 16:29
     */
    @GetMapping("user/delete/{id}")
    public ResponseStatusVO delete(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        return removeById(id);
    }
    @Autowired
    public void setLabourReqService(LabourReqService labourReqService) {
        this.labourReqService = labourReqService;
    }
}
