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
import top.zywork.dto.ProjectCollectionDTO;
import top.zywork.query.ProjectCollectionQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ProjectCollectionService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ProjectCollectionVO;

import java.util.List;

/**
 * ProjectCollectionController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/projeccollection")
public class ProjectCollectionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectCollectionController.class);

    private ProjectCollectionService projectCollectionService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ProjectCollectionVO projectCollectionVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectCollectionService.save(BeanUtils.copy(projectCollectionVO, ProjectCollectionDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ProjectCollectionVO> projectCollectionVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectCollectionService.saveBatch(BeanUtils.copyListObj(projectCollectionVOList, ProjectCollectionDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        projectCollectionService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        projectCollectionService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ProjectCollectionVO projectCollectionVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = projectCollectionService.update(BeanUtils.copy(projectCollectionVO, ProjectCollectionDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ProjectCollectionVO> projectCollectionVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        projectCollectionService.updateBatch(BeanUtils.copyListObj(projectCollectionVOList, ProjectCollectionDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ProjectCollectionVO projectCollectionVO) {
        projectCollectionService.update(BeanUtils.copy(projectCollectionVO, ProjectCollectionDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ProjectCollectionVO> projectCollectionVOList) {
        projectCollectionService.updateBatch(BeanUtils.copyListObj(projectCollectionVOList, ProjectCollectionDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ProjectCollectionVO projectCollectionVO = new ProjectCollectionVO();
        Object obj = projectCollectionService.getById(id);
        if (obj != null) {
            projectCollectionVO = BeanUtils.copy(obj, ProjectCollectionVO.class);
        }
        return ResponseStatusVO.ok("查询成功", projectCollectionVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectCollectionService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectCollectionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectCollectionQuery projectCollectionQuery) {
        PagerDTO pagerDTO = projectCollectionService.listAllByCondition(projectCollectionQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectCollectionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectCollectionQuery projectCollectionQuery) {
        PagerDTO pagerDTO = projectCollectionService.listPageByCondition(projectCollectionQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectCollectionVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 18:35
     * Description: 创建收藏
     */
    @PostMapping("user/save")
    public ResponseStatusVO createProjectCollection(@RequestBody @Validated ProjectCollectionVO projectCollectionVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        projectCollectionVO.setUserId(jwtUser.getUserId());
        return save(projectCollectionVO, bindingResult);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 19:18
     * Description: 取消收藏
     */
    @GetMapping("user/cancel/{projectId}")
    public ResponseStatusVO cancelProjectCollection(@PathVariable("projectId") Long projectId) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        Object obj = projectCollectionService.getByUserAndProject(jwtUser.getUserId(),projectId);
        if(obj == null) {
            return ResponseStatusVO.dataError("收藏不存在", null);
        }

        ProjectCollectionVO projectCollectionVO = BeanUtils.copy(obj, ProjectCollectionVO.class);
        return removeById(projectCollectionVO.getId());
    }

    @Autowired
    public void setProjectCollectionService(ProjectCollectionService projectCollectionService) {
        this.projectCollectionService = projectCollectionService;
    }
}
