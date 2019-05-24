package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.ProjectResourceResourceQuery;
import top.zywork.service.ProjectResourceResourceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ProjectResourceResourceVO;

/**
 * ProjectResourceResourceController控制器类<br/>
 *
 * 创建于2019-05-24<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/ProjectResourceResource")
public class ProjectResourceResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectResourceResourceController.class);

    private ProjectResourceResourceService projectResourceResourceService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = projectResourceResourceService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = projectResourceResourceService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ProjectResourceResourceQuery projectResourceResourceQuery) {
        PagerDTO pagerDTO = projectResourceResourceService.listAllByCondition(projectResourceResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ProjectResourceResourceQuery projectResourceResourceQuery) {
        PagerDTO pagerDTO = projectResourceResourceService.listPageByCondition(projectResourceResourceQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ProjectResourceResourceVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/all-cond")
    public ResponseStatusVO userListAllByCondition(@RequestBody ProjectResourceResourceQuery projectResourceResourceQuery) {
        return listAllByCondition(projectResourceResourceQuery);
    }

    @Autowired
    public void setProjectResourceResourceService(ProjectResourceResourceService projectResourceResourceService) {
        this.projectResourceResourceService = projectResourceResourceService;
    }
}
