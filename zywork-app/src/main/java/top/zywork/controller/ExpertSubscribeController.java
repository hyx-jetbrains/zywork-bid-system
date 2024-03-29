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
import top.zywork.common.DateUtils;
import top.zywork.common.StringUtils;
import top.zywork.constant.ExpertSubscribeConstants;
import top.zywork.constant.NoticeConstants;
import top.zywork.constant.UserMessageConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ExpertSubscribeDTO;
import top.zywork.dto.UserMessageDTO;
import top.zywork.enums.NoticeEnum;
import top.zywork.query.ExpertSubscribeQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ExpertSubscribeService;
import top.zywork.service.UserMessageService;
import top.zywork.service.UserNoticeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ExpertSubscribeVO;
import top.zywork.vo.UserNoticeVO;

import java.util.List;

/**
 * ExpertSubscribeController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/expersubscribe")
public class ExpertSubscribeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpertSubscribeController.class);

    private ExpertSubscribeService expertSubscribeService;

    private UserNoticeService userNoticeService;

    private UserMessageService userMessageService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertSubscribeService.save(BeanUtils.copy(expertSubscribeVO, ExpertSubscribeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ExpertSubscribeVO> expertSubscribeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertSubscribeService.saveBatch(BeanUtils.copyListObj(expertSubscribeVOList, ExpertSubscribeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        expertSubscribeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        expertSubscribeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = expertSubscribeService.update(BeanUtils.copy(expertSubscribeVO, ExpertSubscribeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ExpertSubscribeVO> expertSubscribeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        expertSubscribeService.updateBatch(BeanUtils.copyListObj(expertSubscribeVOList, ExpertSubscribeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ExpertSubscribeVO expertSubscribeVO) {
        expertSubscribeService.update(BeanUtils.copy(expertSubscribeVO, ExpertSubscribeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ExpertSubscribeVO> expertSubscribeVOList) {
        expertSubscribeService.updateBatch(BeanUtils.copyListObj(expertSubscribeVOList, ExpertSubscribeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ExpertSubscribeVO expertSubscribeVO = new ExpertSubscribeVO();
        Object obj = expertSubscribeService.getById(id);
        if (obj != null) {
            expertSubscribeVO = BeanUtils.copy(obj, ExpertSubscribeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", expertSubscribeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = expertSubscribeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertSubscribeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ExpertSubscribeQuery expertSubscribeQuery) {
        PagerDTO pagerDTO = expertSubscribeService.listAllByCondition(expertSubscribeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertSubscribeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ExpertSubscribeQuery expertSubscribeQuery) {
        PagerDTO pagerDTO = expertSubscribeService.listPageByCondition(expertSubscribeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ExpertSubscribeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/replay")
    public ResponseStatusVO replay(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }

        UserNoticeVO userNoticeVO= new UserNoticeVO();
        userNoticeVO.setUserId(expertSubscribeVO.getUserId());
        userNoticeVO.setItemId(expertSubscribeVO.getId());
        userNoticeVO.setPageUrl(NoticeConstants.expertSubscribe);
        userNoticeVO.setTitle("专家预约问题回复");
        userNoticeVO.setMainContent("专家预约问题回复");
        userNoticeVO.setDetailContent("您有一条新的专家回复记录，具体内容可点击《立即查看》按钮前往查看");
        userNoticeVO.setNoticeType(NoticeEnum.APPOINTMENT_EXPERT_MESSAGE.getValue());
        userNoticeService.save(userNoticeVO);

        expertSubscribeVO.setReplyUserId(jwtUser.getUserId());
        expertSubscribeVO.setReplyTime(DateUtils.currentDate());
        expertSubscribeVO.setSubscribeStatus(ExpertSubscribeConstants.SUBSCRIBE_STATUS_YES);
        return update(expertSubscribeVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:32
     * Description: 我的预约
     */
    @PostMapping("user/list-page")
    public ResponseStatusVO listPageByUserId(@RequestBody ExpertSubscribeQuery expertSubscribeQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        expertSubscribeQuery.setUserId(jwtUser.getUserId());
        expertSubscribeQuery.setIsActive((byte)0);
        return listPageByCondition(expertSubscribeQuery);
    }

    @PostMapping("admin/replayPrice")
    public ResponseStatusVO replayPrice(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO, BindingResult bindingResult) {
        return update(expertSubscribeVO, bindingResult);
    }

    @PostMapping("user/save")
    public ResponseStatusVO createConsult(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }
        userMessageService.saveUserMessage(UserMessageConstants.MESSAGE_NOTICE_EXPERT);
        expertSubscribeVO.setUserId(jwtUser.getUserId());
        return save(expertSubscribeVO, bindingResult);
    }

    @Autowired
    public void setExpertSubscribeService(ExpertSubscribeService expertSubscribeService) {
        this.expertSubscribeService = expertSubscribeService;
    }

    @Autowired
    public void setUserNoticeService(UserNoticeService userNoticeService) {
        this.userNoticeService = userNoticeService;
    }

    @Autowired
    public void setUserMessageService(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }
}
