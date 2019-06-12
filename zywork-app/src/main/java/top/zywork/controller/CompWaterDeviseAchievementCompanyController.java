package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.CompWaterDeviseAchievementCompanyQuery;
import top.zywork.service.CompWaterDeviseAchievementCompanyService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompWaterDeviseAchievementCompanyVO;

/**
 * CompWaterDeviseAchievementCompanyController控制器类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@RestController
@RequestMapping("/CompWaterDeviseAchievementCompany")
public class CompWaterDeviseAchievementCompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompWaterDeviseAchievementCompanyController.class);

    private CompWaterDeviseAchievementCompanyService compWaterDeviseAchievementCompanyService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = compWaterDeviseAchievementCompanyService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = compWaterDeviseAchievementCompanyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompWaterDeviseAchievementCompanyQuery compWaterDeviseAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterDeviseAchievementCompanyService.listAllByCondition(compWaterDeviseAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompWaterDeviseAchievementCompanyQuery compWaterDeviseAchievementCompanyQuery) {
        PagerDTO pagerDTO = compWaterDeviseAchievementCompanyService.listPageByCondition(compWaterDeviseAchievementCompanyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompWaterDeviseAchievementCompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setCompWaterDeviseAchievementCompanyService(CompWaterDeviseAchievementCompanyService compWaterDeviseAchievementCompanyService) {
        this.compWaterDeviseAchievementCompanyService = compWaterDeviseAchievementCompanyService;
    }
}
