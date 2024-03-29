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
import top.zywork.dto.ResumeDTO;
import top.zywork.query.ResumeQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ResumeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResumeVO;

import java.util.List;

/**
 * ResumeController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/resume")
public class ResumeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

    private ResumeService resumeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ResumeVO resumeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        resumeService.save(BeanUtils.copy(resumeVO, ResumeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ResumeVO> resumeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        resumeService.saveBatch(BeanUtils.copyListObj(resumeVOList, ResumeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        resumeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        resumeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ResumeVO resumeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = resumeService.update(BeanUtils.copy(resumeVO, ResumeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ResumeVO> resumeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        resumeService.updateBatch(BeanUtils.copyListObj(resumeVOList, ResumeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ResumeVO resumeVO) {
        resumeService.update(BeanUtils.copy(resumeVO, ResumeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ResumeVO> resumeVOList) {
        resumeService.updateBatch(BeanUtils.copyListObj(resumeVOList, ResumeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ResumeVO resumeVO = new ResumeVO();
        Object obj = resumeService.getById(id);
        if (obj != null) {
            resumeVO = BeanUtils.copy(obj, ResumeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", resumeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = resumeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ResumeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ResumeQuery resumeQuery) {
        PagerDTO pagerDTO = resumeService.listAllByCondition(resumeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ResumeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ResumeQuery resumeQuery) {
        PagerDTO pagerDTO = resumeService.listPageByCondition(resumeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ResumeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 16:10
     * Description: 我的简历查询
     */
    @PostMapping("user/getByUserId")
    public ResponseStatusVO getByUserId() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        ResumeVO resumeVO = new ResumeVO();
        Object obj = resumeService.getByUserId(jwtUser.getUserId());
        if(obj != null) {
            resumeVO = BeanUtils.copy(obj, ResumeVO.class);
        }

        return ResponseStatusVO.ok("查询成功", resumeVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 16:04
     * Description: 我的简历新增/修改
     */
    @PostMapping("user/save")
    public ResponseStatusVO createResume(@RequestBody @Validated ResumeVO resumeVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        Object obj = resumeService.getByUserId(jwtUser.getUserId());
        if(obj != null) {
            ResumeVO re = BeanUtils.copy(obj, ResumeVO.class);
            if(re != null) {
                resumeVO.setId(re.getId());
                return update(resumeVO, bindingResult);
            }
        }
        resumeVO.setUserId(jwtUser.getUserId());
        return save(resumeVO, bindingResult);
    }

    @Autowired
    public void setResumeService(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
}
