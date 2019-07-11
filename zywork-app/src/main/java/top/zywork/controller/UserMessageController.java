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
import top.zywork.dto.MessageDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserMessageDTO;
import top.zywork.dto.UserUserMessageDTO;
import top.zywork.query.UserMessageQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserMessageService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserMessageVO;

import java.util.List;

/**
 * UserMessageController控制器类<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/user-message")
public class UserMessageController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserMessageController.class);

    private UserMessageService userMessageService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserMessageVO userMessageVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userMessageService.save(BeanUtils.copy(userMessageVO, UserMessageDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserMessageVO> userMessageVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userMessageService.saveBatch(BeanUtils.copyListObj(userMessageVOList, UserMessageDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userMessageService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userMessageService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserMessageVO userMessageVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userMessageService.update(BeanUtils.copy(userMessageVO, UserMessageDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserMessageVO> userMessageVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userMessageService.updateBatch(BeanUtils.copyListObj(userMessageVOList, UserMessageDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserMessageVO userMessageVO) {
        userMessageService.update(BeanUtils.copy(userMessageVO, UserMessageDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserMessageVO> userMessageVOList) {
        userMessageService.updateBatch(BeanUtils.copyListObj(userMessageVOList, UserMessageDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserMessageVO userMessageVO = new UserMessageVO();
        Object obj = userMessageService.getById(id);
        if (obj != null) {
            userMessageVO = BeanUtils.copy(obj, UserMessageVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userMessageVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userMessageService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMessageVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserMessageQuery userMessageQuery) {
        PagerDTO pagerDTO = userMessageService.listAllByCondition(userMessageQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMessageVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserMessageQuery userMessageQuery) {
        PagerDTO pagerDTO = userMessageService.listPageByCondition(userMessageQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserMessageVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("user/read/{id}")
    public ResponseStatusVO readMessage(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        Object obj = userMessageService.getById(id);
        if (obj == null ) {
            return ResponseStatusVO.error("读取失败，消息不存在", null);
        }
        UserMessageDTO userMessageDTO = new UserMessageDTO();
        userMessageDTO = BeanUtils.copy(obj, UserMessageDTO.class);
        userMessageDTO.setIsRead(UserMessageConstants.MESSAGE_IS_READ_TRUE.byteValue());
        int updateRows = userMessageService.update(userMessageDTO);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("读取成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    /**
     * 获取后台用户的消息
     * @param userMessageQuery
     * @return
     */
    @PostMapping("admin/user-message")
    public ResponseStatusVO getAdminMessage(@RequestBody UserMessageQuery userMessageQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        userMessageQuery.setUserId(jwtUser.getUserId());
        return listAllByCondition(userMessageQuery);
    }

    /**
     * 读取后台用户指定消息的所有未读消息
     * @param messageId
     * @return
     */
    @GetMapping("admin/read-user-message/{messageId}")
    public ResponseStatusVO readAdminMessage(@PathVariable("messageId") Long messageId) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        Long updateRow = userMessageService.readAdminMsgByMsgId(jwtUser.getUserId(), messageId);
        if (updateRow > 0) {
            return ResponseStatusVO.ok("读取成功", null);
        } else {
            return ResponseStatusVO.error("没有未读消息",null);
        }
    }

    @Autowired
    public void setUserMessageService(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }
}
