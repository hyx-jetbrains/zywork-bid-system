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
import top.zywork.dto.RecruitDTO;
import top.zywork.query.RecruitQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.RecruitService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.RecruitVO;

import java.util.List;

/**
 * RecruitController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RecruitController.class);

    private RecruitService recruitService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated RecruitVO recruitVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        recruitService.save(BeanUtils.copy(recruitVO, RecruitDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<RecruitVO> recruitVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        recruitService.saveBatch(BeanUtils.copyListObj(recruitVOList, RecruitDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        recruitService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        recruitService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated RecruitVO recruitVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = recruitService.update(BeanUtils.copy(recruitVO, RecruitDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<RecruitVO> recruitVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        recruitService.updateBatch(BeanUtils.copyListObj(recruitVOList, RecruitDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody RecruitVO recruitVO) {
        recruitService.update(BeanUtils.copy(recruitVO, RecruitDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<RecruitVO> recruitVOList) {
        recruitService.updateBatch(BeanUtils.copyListObj(recruitVOList, RecruitDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        RecruitVO recruitVO = new RecruitVO();
        Object obj = recruitService.getById(id);
        if (obj != null) {
            recruitVO = BeanUtils.copy(obj, RecruitVO.class);
        }
        return ResponseStatusVO.ok("查询成功", recruitVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = recruitService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), RecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody RecruitQuery recruitQuery) {
        PagerDTO pagerDTO = recruitService.listAllByCondition(recruitQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), RecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody RecruitQuery recruitQuery) {
        PagerDTO pagerDTO = recruitService.listPageByCondition(recruitQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), RecruitVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 10:30
     * Description: 根据ID查询详情
     */
    @GetMapping("any/getRecruitById/{id}")
    public ResponseStatusVO getRecruitById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 11:52
     * Description: 发布岗位招聘
     */
    @PostMapping("user/release-recruit")
    public ResponseStatusVO releaseRecruit(@RequestBody @Validated RecruitVO recruitVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        recruitVO.setUserId(jwtUser.getUserId());
        return save(recruitVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/20
     * Time: 10:03
     * Description: 删除我发布的岗位招聘
     */
    @GetMapping("user/delete/{id}")
    public ResponseStatusVO delete(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        return removeById(id);
    }

    @Autowired
    public void setRecruitService(RecruitService recruitService) {
        this.recruitService = recruitService;
    }
}
