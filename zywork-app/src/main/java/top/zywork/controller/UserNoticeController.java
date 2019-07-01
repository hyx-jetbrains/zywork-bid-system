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
import top.zywork.constant.UserMessageConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserMessageDTO;
import top.zywork.dto.UserNoticeDTO;
import top.zywork.query.UserNoticeQuery;
import top.zywork.query.UserUserMessageQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserNoticeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserNoticeVO;

import java.util.List;

/**
 * UserNoticeController控制器类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/user-notice")
public class UserNoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserNoticeController.class);

    private UserNoticeService userNoticeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserNoticeVO userNoticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userNoticeService.save(BeanUtils.copy(userNoticeVO, UserNoticeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserNoticeVO> userNoticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userNoticeService.saveBatch(BeanUtils.copyListObj(userNoticeVOList, UserNoticeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userNoticeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userNoticeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserNoticeVO userNoticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userNoticeService.update(BeanUtils.copy(userNoticeVO, UserNoticeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserNoticeVO> userNoticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userNoticeService.updateBatch(BeanUtils.copyListObj(userNoticeVOList, UserNoticeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserNoticeVO userNoticeVO) {
        userNoticeService.update(BeanUtils.copy(userNoticeVO, UserNoticeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserNoticeVO> userNoticeVOList) {
        userNoticeService.updateBatch(BeanUtils.copyListObj(userNoticeVOList, UserNoticeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserNoticeVO userNoticeVO = new UserNoticeVO();
        Object obj = userNoticeService.getById(id);
        if (obj != null) {
            userNoticeVO = BeanUtils.copy(obj, UserNoticeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userNoticeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userNoticeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserNoticeQuery userNoticeQuery) {
        PagerDTO pagerDTO = userNoticeService.listAllByCondition(userNoticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserNoticeQuery userNoticeQuery) {
        PagerDTO pagerDTO = userNoticeService.listPageByCondition(userNoticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserNoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户查询消息
     * @param userNoticeQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody UserNoticeQuery userNoticeQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        userNoticeQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(userNoticeQuery);
    }

    @GetMapping("user/read/{id}")
    public ResponseStatusVO readMessage(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        Object obj = userNoticeService.getById(id);
        if (obj == null ) {
            return ResponseStatusVO.error("读取失败，消息不存在", null);
        }
        UserNoticeDTO userNoticeDTO = new UserNoticeDTO();
        userNoticeDTO = BeanUtils.copy(obj, UserNoticeDTO.class);
        userNoticeDTO.setIsRead(UserMessageConstants.MESSAGE_IS_READ_TRUE.byteValue());
        int updateRows = userNoticeService.update(userNoticeDTO);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("读取成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @GetMapping("user/clear-msg/{type}")
    public ResponseStatusVO clearUserMessage(@PathVariable("type") Integer type) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (null == type || type > 5) {
            // 目前消息类型只有6种：0-6
            return ResponseStatusVO.error("清除类型错误", null);
        }
        Long updateRow = userNoticeService.clearNoReadMessage(jwtUser.getUserId(), type);
        if (updateRow > 0) {
            return ResponseStatusVO.ok("清除成功", null);
        } else {
            return ResponseStatusVO.error("没有未读消息", null);
        }
    }

    @Autowired
    public void setUserNoticeService(UserNoticeService userNoticeService) {
        this.userNoticeService = userNoticeService;
    }
}
