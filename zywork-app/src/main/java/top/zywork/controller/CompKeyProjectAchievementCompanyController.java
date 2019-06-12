package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.CompKeyProjectAchievementCompanyQuery;
import top.zywork.service.CompKeyProjectAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompKeyProjectAchievementCompanyVO;

/**
 * CompKeyProjectAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompKeyProjectAchievementCompany")
public class CompKeyProjectAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompKeyProjectAchievementCompanyController.class);

    private CompKeyProjectAchievementCompanyService compKeyProjectAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompKeyProjectAchievementCompanyQuery compKeyProjectAchievementCompanyQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listAllByCondition(compKeyProjectAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompKeyProjectAchievementCompanyQuery compKeyProjectAchievementCompanyQuery) {
        PagerDTO pagerDTO = compKeyProjectAchievementCompanyService.listPageByCondition(compKeyProjectAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompKeyProjectAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setCompKeyProjectAchievementCompanyService(CompKeyProjectAchievementCompanyService compKeyProjectAchievementCompanyService) {
        this.compKeyProjectAchievementCompanyService = compKeyProjectAchievementCompanyService;
    }
}
