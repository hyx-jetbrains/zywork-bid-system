package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.CompBuilderCompanyQuery;
import top.zywork.service.CompBuilderCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompBuilderCompanyVO;

/**
 * CompBuilderCompanyController控制器类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompBuilderCompany")
public class CompBuilderCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompBuilderCompanyController.class);

    private CompBuilderCompanyService compBuilderCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compBuilderCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compBuilderCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompBuilderCompanyQuery compBuilderCompanyQuery) {
        PagerDTO pagerDTO = compBuilderCompanyService.listAllByCondition(compBuilderCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompBuilderCompanyQuery compBuilderCompanyQuery) {
        PagerDTO pagerDTO = compBuilderCompanyService.listPageByCondition(compBuilderCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompBuilderCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("any/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody CompBuilderCompanyQuery compBuilderCompanyQuery) {
        return listPageByCondition(compBuilderCompanyQuery);
    }

    @Autowired
    public void setCompBuilderCompanyService(CompBuilderCompanyService compBuilderCompanyService) {
        this.compBuilderCompanyService = compBuilderCompanyService;
    }
}
