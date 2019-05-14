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
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ConsultDTO;
import top.zywork.query.ConsultQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ConsultService;
import top.zywork.vo.ExpertSubscribeVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ConsultVO;

import java.util.List;

/**
 * ConsultController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/consult")
public class ConsultController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ConsultController.class);

    private ConsultService consultService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ConsultVO consultVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        consultService.save(BeanUtils.copy(consultVO, ConsultDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ConsultVO> consultVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        consultService.saveBatch(BeanUtils.copyListObj(consultVOList, ConsultDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        consultService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        consultService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ConsultVO consultVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = consultService.update(BeanUtils.copy(consultVO, ConsultDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ConsultVO> consultVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        consultService.updateBatch(BeanUtils.copyListObj(consultVOList, ConsultDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ConsultVO consultVO) {
        consultService.update(BeanUtils.copy(consultVO, ConsultDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ConsultVO> consultVOList) {
        consultService.updateBatch(BeanUtils.copyListObj(consultVOList, ConsultDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ConsultVO consultVO = new ConsultVO();
        Object obj = consultService.getById(id);
        if (obj != null) {
            consultVO = BeanUtils.copy(obj, ConsultVO.class);
        }
        return ResponseStatusVO.ok("查询成功", consultVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = consultService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ConsultVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ConsultQuery consultQuery) {
        PagerDTO pagerDTO = consultService.listAllByCondition(consultQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ConsultVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ConsultQuery consultQuery) {
        PagerDTO pagerDTO = consultService.listPageByCondition(consultQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ConsultVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/replay")
    public ResponseStatusVO replay(@RequestBody @Validated ConsultVO consultVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }
        consultVO.setReplyUserId(jwtUser.getUserId());
        consultVO.setReplyTime(DateUtils.currentDate());
        return update(consultVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:43
     * Description: 创建问题咨询
     */
    @PostMapping("user/save")
    public ResponseStatusVO createConsult(@RequestBody @Validated ConsultVO consultVO, BindingResult bindingResult) {
        return save(consultVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 15:41
     * Description: 我的咨询反馈
     */
    @PostMapping("user/all")
    public ResponseStatusVO listPageByUserId(@RequestBody ConsultQuery consultQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }

        consultQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(consultQuery);
    }

    @Autowired
    public void setConsultService(ConsultService consultService) {
        this.consultService = consultService;
    }
}
