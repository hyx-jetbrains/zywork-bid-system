package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.HasHideProperty;
import top.zywork.annotation.HideProperty;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.common.StringUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.CompAptitudeDTO;
import top.zywork.query.CompAptitudeQuery;
import top.zywork.service.CompAptitudeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompAptitudeVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * CompAptitudeController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/comp-aptitude")
@HasHideProperty
public class CompAptitudeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompAptitudeController.class);

    private CompAptitudeService compAptitudeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompAptitudeVO compAptitudeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compAptitudeService.save(BeanUtils.copy(compAptitudeVO, CompAptitudeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompAptitudeVO> compAptitudeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compAptitudeService.saveBatch(BeanUtils.copyListObj(compAptitudeVOList, CompAptitudeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        compAptitudeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        compAptitudeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompAptitudeVO compAptitudeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = compAptitudeService.update(BeanUtils.copy(compAptitudeVO, CompAptitudeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompAptitudeVO> compAptitudeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        compAptitudeService.updateBatch(BeanUtils.copyListObj(compAptitudeVOList, CompAptitudeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompAptitudeVO compAptitudeVO) {
        compAptitudeService.update(BeanUtils.copy(compAptitudeVO, CompAptitudeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompAptitudeVO> compAptitudeVOList) {
        compAptitudeService.updateBatch(BeanUtils.copyListObj(compAptitudeVOList, CompAptitudeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompAptitudeVO compAptitudeVO = new CompAptitudeVO();
        Object obj = compAptitudeService.getById(id);
        if (obj != null) {
            compAptitudeVO = BeanUtils.copy(obj, CompAptitudeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", compAptitudeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compAptitudeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompAptitudeQuery compAptitudeQuery) {
        PagerDTO pagerDTO = compAptitudeService.listAllByCondition(compAptitudeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompAptitudeQuery compAptitudeQuery) {
        PagerDTO pagerDTO = compAptitudeService.listPageByCondition(compAptitudeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompAptitudeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/comp-aptitude/user/pager-cond", properties = {"certificateNum","certificateDetail"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompAptitudeQuery compAptitudeQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(compAptitudeQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @Autowired
    public void setCompAptitudeService(CompAptitudeService compAptitudeService) {
        this.compAptitudeService = compAptitudeService;
    }
}
