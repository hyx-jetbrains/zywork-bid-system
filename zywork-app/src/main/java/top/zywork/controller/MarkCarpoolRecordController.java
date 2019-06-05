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
import top.zywork.dto.MarkCarpoolDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.MarkCarpoolRecordDTO;
import top.zywork.enums.NoticeEnum;
import top.zywork.query.MarkCarpoolRecordQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.MarkCarpoolRecordService;
import top.zywork.service.MarkCarpoolService;
import top.zywork.service.UserNoticeService;
import top.zywork.vo.*;

import java.util.List;

/**
 * MarkCarpoolRecordController控制器类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/mark-carpool-record")
public class MarkCarpoolRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MarkCarpoolRecordController.class);

    private MarkCarpoolRecordService markCarpoolRecordService;

    private MarkCarpoolService markCarpoolService;

    private UserNoticeService userNoticeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated MarkCarpoolRecordVO markCarpoolRecordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolRecordService.save(BeanUtils.copy(markCarpoolRecordVO, MarkCarpoolRecordDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<MarkCarpoolRecordVO> markCarpoolRecordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolRecordService.saveBatch(BeanUtils.copyListObj(markCarpoolRecordVOList, MarkCarpoolRecordDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        markCarpoolRecordService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        markCarpoolRecordService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated MarkCarpoolRecordVO markCarpoolRecordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = markCarpoolRecordService.update(BeanUtils.copy(markCarpoolRecordVO, MarkCarpoolRecordDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<MarkCarpoolRecordVO> markCarpoolRecordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolRecordService.updateBatch(BeanUtils.copyListObj(markCarpoolRecordVOList, MarkCarpoolRecordDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody MarkCarpoolRecordVO markCarpoolRecordVO) {
        markCarpoolRecordService.update(BeanUtils.copy(markCarpoolRecordVO, MarkCarpoolRecordDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<MarkCarpoolRecordVO> markCarpoolRecordVOList) {
        markCarpoolRecordService.updateBatch(BeanUtils.copyListObj(markCarpoolRecordVOList, MarkCarpoolRecordDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        MarkCarpoolRecordVO markCarpoolRecordVO = new MarkCarpoolRecordVO();
        Object obj = markCarpoolRecordService.getById(id);
        if (obj != null) {
            markCarpoolRecordVO = BeanUtils.copy(obj, MarkCarpoolRecordVO.class);
        }
        return ResponseStatusVO.ok("查询成功", markCarpoolRecordVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = markCarpoolRecordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody MarkCarpoolRecordQuery markCarpoolRecordQuery) {
        PagerDTO pagerDTO = markCarpoolRecordService.listAllByCondition(markCarpoolRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody MarkCarpoolRecordQuery markCarpoolRecordQuery) {
        PagerDTO pagerDTO = markCarpoolRecordService.listPageByCondition(markCarpoolRecordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolRecordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /***
     * @description: 我要拼车-保存拼车记录
     * @param carpoolId 拼车编号
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 10:37
     */
    @GetMapping("any/save-carpool-record/{carpoolId}")
    public ResponseStatusVO saveCarpoolRecord(@PathVariable("carpoolId") Long carpoolId) {
        if (null == carpoolId || 0 == carpoolId) {
            return ResponseStatusVO.error("拼车失败，请刷新重试", null);
        }
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.error("拼车失败", null);
        }
        MarkCarpoolVO markCarpoolVO = BeanUtils.copy(markCarpoolService.getById(carpoolId), MarkCarpoolVO.class);
        if (null == markCarpoolVO) {
            return ResponseStatusVO.error("拼车失败", null);
        }
        long userId = jwtUser.getUserId();
        long tempUserId = markCarpoolVO.getUserId();
        if (userId == tempUserId) {
            return ResponseStatusVO.error("拼车失败,不能拼自己发布的拼车信息", null);
        }
        MarkCarpoolRecordDTO markCarpoolRecordDTO = markCarpoolRecordService.getByUserIdAndCarpoolId(userId, carpoolId);
        if (markCarpoolRecordDTO != null) {
            return ResponseStatusVO.error("拼车失败，已经拼过该车了", null);
        }
        int recordCount = markCarpoolVO.getRecordCount();
        markCarpoolVO.setRecordCount(++recordCount);
        markCarpoolService.update(BeanUtils.copy(markCarpoolVO, MarkCarpoolDTO.class));
        MarkCarpoolRecordVO markCarpoolRecordVO = new MarkCarpoolRecordVO();
        markCarpoolRecordVO.setUserId(userId);
        markCarpoolRecordVO.setMarkCarpoolId(carpoolId);
        markCarpoolRecordService.save(BeanUtils.copy(markCarpoolRecordVO, MarkCarpoolRecordDTO.class));

        UserNoticeVO userNoticeVO= new UserNoticeVO();
        userNoticeVO.setUserId(markCarpoolVO.getUserId());
        userNoticeVO.setItemId(markCarpoolVO.getId());
        userNoticeVO.setPageUrl("publish-carpool-detail/publish-carpool-detail");
        userNoticeVO.setTitle("开标拼车'"+markCarpoolVO.getStartCity()+ "' - '"+ markCarpoolVO.getEndCity()+"'申请记录");
        userNoticeVO.setMainContent("您发起的开标拼车由'"+markCarpoolVO.getStartCity()+ "' - '"+ markCarpoolVO.getEndCity()+"'有一条新的申请记录");
        userNoticeVO.setDetailContent("您发起的开标拼车由'"+markCarpoolVO.getStartCity()+"/"+markCarpoolVO.getStartAddr()+ "' - '"+ markCarpoolVO.getEndCity()+"/"+markCarpoolVO.getEndAddr()+"'有一条新的申请记录，具体内容可前往"+ userNoticeVO.getPageUrl()+"查看");
        userNoticeVO.setNoticeType(NoticeEnum.MARKCARPOOL_MESSAGE.getValue());
        userNoticeService.save(userNoticeVO);
        return ResponseStatusVO.ok("拼车成功", null);
    }

    @Autowired
    public void setMarkCarpoolRecordService(MarkCarpoolRecordService markCarpoolRecordService) {
        this.markCarpoolRecordService = markCarpoolRecordService;
    }

    @Autowired
    public void setMarkCarpoolService(MarkCarpoolService markCarpoolService) {
        this.markCarpoolService = markCarpoolService;
    }

    @Autowired
    public void setUserNoticeService(UserNoticeService userNoticeService) {
        this.userNoticeService = userNoticeService;
    }
}
