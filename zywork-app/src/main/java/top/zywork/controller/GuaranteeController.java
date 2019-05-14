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
import top.zywork.dto.GuaranteeDTO;
import top.zywork.query.GuaranteeQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.GuaranteeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GuaranteeVO;

import java.util.List;

/**
 * GuaranteeController控制器类<br/>
 *
 * 创建于2019-04-29<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/guarantee")
public class GuaranteeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GuaranteeController.class);

    private GuaranteeService guaranteeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GuaranteeVO guaranteeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        guaranteeService.save(BeanUtils.copy(guaranteeVO, GuaranteeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GuaranteeVO> guaranteeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        guaranteeService.saveBatch(BeanUtils.copyListObj(guaranteeVOList, GuaranteeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        guaranteeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        guaranteeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GuaranteeVO guaranteeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = guaranteeService.update(BeanUtils.copy(guaranteeVO, GuaranteeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GuaranteeVO> guaranteeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        guaranteeService.updateBatch(BeanUtils.copyListObj(guaranteeVOList, GuaranteeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GuaranteeVO guaranteeVO) {
        guaranteeService.update(BeanUtils.copy(guaranteeVO, GuaranteeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GuaranteeVO> guaranteeVOList) {
        guaranteeService.updateBatch(BeanUtils.copyListObj(guaranteeVOList, GuaranteeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GuaranteeVO guaranteeVO = new GuaranteeVO();
        Object obj = guaranteeService.getById(id);
        if (obj != null) {
            guaranteeVO = BeanUtils.copy(obj, GuaranteeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", guaranteeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = guaranteeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GuaranteeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GuaranteeQuery guaranteeQuery) {
        PagerDTO pagerDTO = guaranteeService.listAllByCondition(guaranteeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GuaranteeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GuaranteeQuery guaranteeQuery) {
        PagerDTO pagerDTO = guaranteeService.listPageByCondition(guaranteeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GuaranteeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 13:44
     * Description: 我的申请保函
     */
    @PostMapping("user/all")
    public ResponseStatusVO listPageByUserId(@RequestBody GuaranteeQuery guaranteeQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        guaranteeQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(guaranteeQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 11:59
     * Description: 保函申请
     */
    @PostMapping("user/release-guarantee")
    public ResponseStatusVO releaseGuarantee(@RequestBody @Validated GuaranteeVO guaranteeVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        guaranteeVO.setUserId(jwtUser.getUserId());
        return save(guaranteeVO, bindingResult);
    }

    @Autowired
    public void setGuaranteeService(GuaranteeService guaranteeService) {
        this.guaranteeService = guaranteeService;
    }
}
