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
import top.zywork.dto.SeekDataDTO;
import top.zywork.query.SeekDataQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.SeekDataService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.SeekDataVO;

import java.util.List;

/**
 * SeekDataController控制器类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/seek-data")
public class SeekDataController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SeekDataController.class);

    private SeekDataService seekDataService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated SeekDataVO seekDataVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        seekDataService.save(BeanUtils.copy(seekDataVO, SeekDataDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SeekDataVO> seekDataVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        seekDataService.saveBatch(BeanUtils.copyListObj(seekDataVOList, SeekDataDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        seekDataService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        seekDataService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated SeekDataVO seekDataVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = seekDataService.update(BeanUtils.copy(seekDataVO, SeekDataDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SeekDataVO> seekDataVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        seekDataService.updateBatch(BeanUtils.copyListObj(seekDataVOList, SeekDataDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody SeekDataVO seekDataVO) {
        seekDataService.update(BeanUtils.copy(seekDataVO, SeekDataDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SeekDataVO> seekDataVOList) {
        seekDataService.updateBatch(BeanUtils.copyListObj(seekDataVOList, SeekDataDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        SeekDataVO seekDataVO = new SeekDataVO();
        Object obj = seekDataService.getById(id);
        if (obj != null) {
            seekDataVO = BeanUtils.copy(obj, SeekDataVO.class);
        }
        return ResponseStatusVO.ok("查询成功", seekDataVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = seekDataService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody SeekDataQuery seekDataQuery) {
        PagerDTO pagerDTO = seekDataService.listAllByCondition(seekDataQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SeekDataQuery seekDataQuery) {
        PagerDTO pagerDTO = seekDataService.listPageByCondition(seekDataQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SeekDataVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:48
     * Description: 信息共享 -- 求带资料
     */
    @PostMapping("any/list-page")
    public ResponseStatusVO listPage(@RequestBody SeekDataQuery seekDataQuery) {
        return listPageByCondition(seekDataQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 10:27
     * Description: 根据ID查询详情
     */
    @GetMapping("any/getSeekDataById/{id}")
    public ResponseStatusVO getSeekDataById(@PathVariable("id") Long id) {
        return getById(id);
    }

    /**
     * User: DengMin
     * Date: 2019/05/13
     * Time: 11:48
     * Description: 我的求带资料
     */
    @PostMapping("user/all")
    public ResponseStatusVO listPageByUserId(@RequestBody SeekDataQuery seekDataQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        seekDataQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(seekDataQuery);
    }

    /**
     * User: DengMin
     * Date: 2019/05/14
     * Time: 11:56
     * Description: 发布求带资料
     */
    @PostMapping("user/release-seekData")
    public ResponseStatusVO releaseSeekData(@RequestBody @Validated SeekDataVO seekDataVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        seekDataVO.setUserId(jwtUser.getUserId());
        return save(seekDataVO, bindingResult);
    }

    @Autowired
    public void setSeekDataService(SeekDataService seekDataService) {
        this.seekDataService = seekDataService;
    }
}
