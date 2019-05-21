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
import top.zywork.dto.UserExpertDTO;
import top.zywork.query.UserExpertQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserExpertQuestionTypeService;
import top.zywork.service.UserExpertService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserExpertVO;

import java.util.List;

/**
 * UserExpertController控制器类<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/user-expert")
public class UserExpertController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserExpertController.class);

    private UserExpertService userExpertService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserExpertVO userExpertVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertService.save(BeanUtils.copy(userExpertVO, UserExpertDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserExpertVO> userExpertVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertService.saveBatch(BeanUtils.copyListObj(userExpertVOList, UserExpertDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userExpertService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userExpertService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserExpertVO userExpertVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userExpertService.update(BeanUtils.copy(userExpertVO, UserExpertDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserExpertVO> userExpertVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userExpertService.updateBatch(BeanUtils.copyListObj(userExpertVOList, UserExpertDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserExpertVO userExpertVO) {
        userExpertService.update(BeanUtils.copy(userExpertVO, UserExpertDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserExpertVO> userExpertVOList) {
        userExpertService.updateBatch(BeanUtils.copyListObj(userExpertVOList, UserExpertDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserExpertVO userExpertVO = new UserExpertVO();
        Object obj = userExpertService.getById(id);
        if (obj != null) {
            userExpertVO = BeanUtils.copy(obj, UserExpertVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userExpertVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userExpertService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserExpertQuery userExpertQuery) {
        PagerDTO pagerDTO = userExpertService.listAllByCondition(userExpertQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserExpertQuery userExpertQuery) {
        PagerDTO pagerDTO = userExpertService.listPageByCondition(userExpertQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserExpertVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/21
     * Time: 12:03
     * Description: 专家申请
     */
    @PostMapping("user/saveExpert/{questionTypeId}")
    public ResponseStatusVO saveExpert(@RequestBody @Validated UserExpertVO userExpertVO, @PathVariable("questionTypeId") String questionTypeId,
         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }

        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        userExpertVO.setUserId(jwtUser.getUserId());
        userExpertService.saveExpert(userExpertVO, questionTypeId);
        return ResponseStatusVO.ok("添加成功", null);
    }

    /**
     * User: DengMin
     * Date: 2019/05/21
     * Time: 15:28
     * Description: 查询专家申请记录
     */
    @PostMapping("user/getByUserId")
    public ResponseStatusVO getByUserId() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        Object obj = userExpertService.getByUserId(jwtUser.getUserId());
        UserExpertVO userExpertVO = new UserExpertVO();
        if(obj != null) {
            userExpertVO = BeanUtils.copy(obj, UserExpertVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userExpertVO);
    }

    @Autowired
    public void setUserExpertService(UserExpertService userExpertService) {
        this.userExpertService = userExpertService;
    }
}
