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
import top.zywork.dto.UserWorkDTO;
import top.zywork.query.UserWorkQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserWorkService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserWorkVO;

import java.util.List;

/**
 * UserWorkController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/user-work")
public class UserWorkController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserWorkController.class);

    private UserWorkService userWorkService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserWorkVO userWorkVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userWorkService.save(BeanUtils.copy(userWorkVO, UserWorkDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserWorkVO> userWorkVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userWorkService.saveBatch(BeanUtils.copyListObj(userWorkVOList, UserWorkDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userWorkService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userWorkService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserWorkVO userWorkVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userWorkService.update(BeanUtils.copy(userWorkVO, UserWorkDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserWorkVO> userWorkVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userWorkService.updateBatch(BeanUtils.copyListObj(userWorkVOList, UserWorkDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserWorkVO userWorkVO) {
        userWorkService.update(BeanUtils.copy(userWorkVO, UserWorkDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserWorkVO> userWorkVOList) {
        userWorkService.updateBatch(BeanUtils.copyListObj(userWorkVOList, UserWorkDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserWorkVO userWorkVO = new UserWorkVO();
        Object obj = userWorkService.getById(id);
        if (obj != null) {
            userWorkVO = BeanUtils.copy(obj, UserWorkVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userWorkVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userWorkService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserWorkVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserWorkQuery userWorkQuery) {
        PagerDTO pagerDTO = userWorkService.listAllByCondition(userWorkQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserWorkVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserWorkQuery userWorkQuery) {
        PagerDTO pagerDTO = userWorkService.listPageByCondition(userWorkQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserWorkVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/getByUserId")
    public ResponseStatusVO getByUserId() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        UserWorkVO userWorkVO = new UserWorkVO();
        Object obj = userWorkService.getByUserId(jwtUser.getUserId());
        if(obj != null) {
            userWorkVO = BeanUtils.copy(obj, UserWorkVO.class);
        }

        return ResponseStatusVO.ok("查询成功", userWorkVO);
    }

    @PostMapping("user/update")
    public ResponseStatusVO userWorkUpdate(@RequestBody @Validated UserWorkVO userWorkVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        Object obj = userWorkService.getByUserId(jwtUser.getUserId());
        if(obj != null) {
            UserWorkVO uworkVO = BeanUtils.copy(obj, UserWorkVO.class);
            userWorkVO.setId(uworkVO.getId());
            return update(userWorkVO, bindingResult);
        } else {
            userWorkVO.setUserId(jwtUser.getUserId());
            return save(userWorkVO, bindingResult);
        }
    }

    @Autowired
    public void setUserWorkService(UserWorkService userWorkService) {
        this.userWorkService = userWorkService;
    }
}
