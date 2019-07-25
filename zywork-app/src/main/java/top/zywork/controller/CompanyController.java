package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.HasHideProperty;
import top.zywork.annotation.HideProperty;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.common.StringUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.PythonConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.CompanyDTO;
import top.zywork.python.CompanyPythonService;
import top.zywork.query.CompanyQuery;
import top.zywork.service.CompanyService;
import top.zywork.vo.CompanyPythonVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.CompanyVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * CompanyController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/company")
@HasHideProperty
public class CompanyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    private CompanyService companyService;

    private CompanyPythonService companyPythonService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated CompanyVO companyVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        companyService.save(BeanUtils.copy(companyVO, CompanyDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<CompanyVO> companyVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        companyService.saveBatch(BeanUtils.copyListObj(companyVOList, CompanyDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        companyService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        companyService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated CompanyVO companyVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = companyService.update(BeanUtils.copy(companyVO, CompanyDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<CompanyVO> companyVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        companyService.updateBatch(BeanUtils.copyListObj(companyVOList, CompanyDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody CompanyVO companyVO) {
        companyService.update(BeanUtils.copy(companyVO, CompanyDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<CompanyVO> companyVOList) {
        companyService.updateBatch(BeanUtils.copyListObj(companyVOList, CompanyDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        CompanyVO companyVO = new CompanyVO();
        Object obj = companyService.getById(id);
        if (obj != null) {
            companyVO = BeanUtils.copy(obj, CompanyVO.class);
        }
        return ResponseStatusVO.ok("查询成功", companyVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = companyService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody CompanyQuery companyQuery) {
        PagerDTO pagerDTO = companyService.listAllByCondition(companyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody CompanyQuery companyQuery) {
        PagerDTO pagerDTO = companyService.listPageByCondition(companyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), CompanyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("user/pager-cond")
    @HideProperty(url = "/company/user/pager-cond", properties = {"legalPersonPhone","responsiblePhone","compPhone"})
    public ResponseStatusVO userListPageByCondition(HttpServletRequest request, @RequestBody CompanyQuery companyQuery) {
        ResponseStatusVO responseStatusVO = listPageByCondition(companyQuery);
        Object vipFlag = request.getAttribute(ProjectConstants.VIP_FLAG);
        if (vipFlag != null && ((Boolean) vipFlag)) {
            return responseStatusVO;
        }
        return ReflectUtils.hideProperty(this.getClass().getDeclaredMethods(), "userListPageByCondition",
                responseStatusVO, ProjectConstants.VIP_TEXT_TIP);
    }

    @PostMapping("admin/python")
    public ResponseStatusVO pythonCompanyInfo(@RequestBody CompanyQuery companyQuery) {
        if (null == companyQuery.getPageNo()) {
            return ResponseStatusVO.error("请输入页码", null);
        }
        if (null == companyQuery.getPageSize()) {
            return ResponseStatusVO.error("请输入个数", null);
        }
        if (org.apache.commons.lang.StringUtils.isEmpty(companyQuery.getCompType())) {
            return ResponseStatusVO.error("请选择企业类型", null);
        }
        if (org.apache.commons.lang.StringUtils.isEmpty(companyQuery.getIndustryType())) {
            return ResponseStatusVO.error("请选择行业类型", null);
        }
        String type = companyQuery.getCompType();
        String compType = companyQuery.getIndustryType();
        String pageNo = String.valueOf(companyQuery.getPageNo());
        String pageSize = String.valueOf(companyQuery.getPageSize());
        boolean isUpdate = companyQuery.getCompName().equals(PythonConstants.IS_UPDATE_FLAG_STR);
        try {
            companyPythonService.getCompanyInfo(type, compType, pageNo, pageSize, isUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseStatusVO.ok("后台更新中", null);
    }

    @GetMapping("any/one/{id}")
    public ResponseStatusVO userGetById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * 获取python爬取企业信息的爬取情况，获取每个文件当前的页面
     * @return
     */
    @GetMapping("admin/python-data")
    public ResponseStatusVO getPythonData() {
        List<CompanyPythonVO> companyPythonVOList = companyService.getPageNoFileValue();
        return ResponseStatusVO.ok("查询成功", companyPythonVOList);
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }
}
