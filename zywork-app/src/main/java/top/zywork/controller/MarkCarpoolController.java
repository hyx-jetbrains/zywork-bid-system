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
import top.zywork.dto.MarkCarpoolDTO;
import top.zywork.query.MarkCarpoolQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.MarkCarpoolService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.MarkCarpoolVO;

import java.util.List;

/**
 * MarkCarpoolController控制器类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/mark-carpool")
public class MarkCarpoolController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MarkCarpoolController.class);

    private MarkCarpoolService markCarpoolService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated MarkCarpoolVO markCarpoolVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            return ResponseStatusVO.authenticationError();
        }
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolVO.setUserId(jwtUser.getUserId());
        markCarpoolService.save(BeanUtils.copy(markCarpoolVO, MarkCarpoolDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<MarkCarpoolVO> markCarpoolVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolService.saveBatch(BeanUtils.copyListObj(markCarpoolVOList, MarkCarpoolDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        markCarpoolService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        markCarpoolService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated MarkCarpoolVO markCarpoolVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = markCarpoolService.update(BeanUtils.copy(markCarpoolVO, MarkCarpoolDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<MarkCarpoolVO> markCarpoolVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        markCarpoolService.updateBatch(BeanUtils.copyListObj(markCarpoolVOList, MarkCarpoolDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody MarkCarpoolVO markCarpoolVO) {
        markCarpoolService.update(BeanUtils.copy(markCarpoolVO, MarkCarpoolDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<MarkCarpoolVO> markCarpoolVOList) {
        markCarpoolService.updateBatch(BeanUtils.copyListObj(markCarpoolVOList, MarkCarpoolDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        MarkCarpoolVO markCarpoolVO = new MarkCarpoolVO();
        Object obj = markCarpoolService.getById(id);
        if (obj != null) {
            markCarpoolVO = BeanUtils.copy(obj, MarkCarpoolVO.class);
        }
        return ResponseStatusVO.ok("查询成功", markCarpoolVO);
    }

    @GetMapping("user/getByProjectId/{id}")
    public ResponseStatusVO getByProjectId(@PathVariable("id") Long id) {
        MarkCarpoolVO markCarpoolVO = new MarkCarpoolVO();
        Object obj = markCarpoolService.getByprojectId(id);
        if (obj != null) {
            markCarpoolVO = BeanUtils.copy(obj, MarkCarpoolVO.class);
        }
        return ResponseStatusVO.ok("查询成功", markCarpoolVO);
    }



    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = markCarpoolService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody MarkCarpoolQuery markCarpoolQuery) {
        PagerDTO pagerDTO = markCarpoolService.listAllByCondition(markCarpoolQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody MarkCarpoolQuery markCarpoolQuery) {
        PagerDTO pagerDTO = markCarpoolService.listPageByCondition(markCarpoolQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), MarkCarpoolVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setMarkCarpoolService(MarkCarpoolService markCarpoolService) {
        this.markCarpoolService = markCarpoolService;
    }
}
