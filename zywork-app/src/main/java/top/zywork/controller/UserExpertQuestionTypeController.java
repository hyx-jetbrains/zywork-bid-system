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
import top.zywork.dto.UserExpertQuestionTypeDTO;
import top.zywork.query.UserExpertQuestionTypeQuery;
import top.zywork.service.UserExpertQuestionTypeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserExpertQuestionTypeVO;

import java.util.List;

/**
 * UserExpertQuestionTypeController控制器类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/user-experquestion-type")
public class UserExpertQuestionTypeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserExpertQuestionTypeController.class);

    private UserExpertQuestionTypeService userExpertQuestionTypeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserExpertQuestionTypeVO userExpertQuestionTypeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertQuestionTypeService.save(BeanUtils.copy(userExpertQuestionTypeVO, UserExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserExpertQuestionTypeVO> userExpertQuestionTypeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertQuestionTypeService.saveBatch(BeanUtils.copyListObj(userExpertQuestionTypeVOList, UserExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userExpertQuestionTypeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userExpertQuestionTypeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserExpertQuestionTypeVO userExpertQuestionTypeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userExpertQuestionTypeService.update(BeanUtils.copy(userExpertQuestionTypeVO, UserExpertQuestionTypeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserExpertQuestionTypeVO> userExpertQuestionTypeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertQuestionTypeService.updateBatch(BeanUtils.copyListObj(userExpertQuestionTypeVOList, UserExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserExpertQuestionTypeVO userExpertQuestionTypeVO) {
        userExpertQuestionTypeService.update(BeanUtils.copy(userExpertQuestionTypeVO, UserExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserExpertQuestionTypeVO> userExpertQuestionTypeVOList) {
        userExpertQuestionTypeService.updateBatch(BeanUtils.copyListObj(userExpertQuestionTypeVOList, UserExpertQuestionTypeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserExpertQuestionTypeVO userExpertQuestionTypeVO = new UserExpertQuestionTypeVO();
        Object obj = userExpertQuestionTypeService.getById(id);
        if (obj != null) {
            userExpertQuestionTypeVO = BeanUtils.copy(obj, UserExpertQuestionTypeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userExpertQuestionTypeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userExpertQuestionTypeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserExpertQuestionTypeQuery userExpertQuestionTypeQuery) {
        PagerDTO pagerDTO = userExpertQuestionTypeService.listAllByCondition(userExpertQuestionTypeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserExpertQuestionTypeQuery userExpertQuestionTypeQuery) {
        PagerDTO pagerDTO = userExpertQuestionTypeService.listPageByCondition(userExpertQuestionTypeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertQuestionTypeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUserExpertQuestionTypeService(UserExpertQuestionTypeService userExpertQuestionTypeService) {
        this.userExpertQuestionTypeService = userExpertQuestionTypeService;
    }
}
