package top.zywork.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.ali.AliyunSmsConfig;
import top.zywork.ali.AliyunSmsConstants;
import top.zywork.ali.AliyunSmsUtils;
import top.zywork.common.*;
import top.zywork.constant.SmsConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserDTO;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.query.UserQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.security.mobile.SmsCodeRedisUtils;
import top.zywork.service.SysConfigService;
import top.zywork.service.UserService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserVO;

import java.util.List;

/**
 * UserController控制器类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${verify.sms-code.expiration}")
    private Integer smsCodeExpiration;

    private UserService userService;

    private SmsCodeRedisUtils smsCodeRedisUtils;

    private SysConfigService sysConfigService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserVO userVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userVO.setPassword(new BCryptPasswordEncoder().encode(userVO.getPassword()));
        userService.save(BeanUtils.copy(userVO, UserDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserVO> userVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userService.saveBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserVO userVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        if (!org.apache.commons.lang.StringUtils.isEmpty(userVO.getPassword())) {
            userVO.setPassword(new BCryptPasswordEncoder().encode(userVO.getPassword()));
        }
        int updateRows = userService.update(BeanUtils.copy(userVO, UserDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserVO> userVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userService.updateBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserVO userVO) {
        userService.update(BeanUtils.copy(userVO, UserDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserVO> userVOList) {
        userService.updateBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserVO userVO = new UserVO();
        Object obj = userService.getById(id);
        if (obj != null) {
            userVO = BeanUtils.copy(obj, UserVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userVO);
    }

    /**
     * 用户获取基本信息
     * @return
     */
    @GetMapping("user/one")
    public ResponseStatusVO userGetById() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserVO userVO = new UserVO();
        Object obj = userService.getById(jwtUser.getUserId());
        if (obj != null) {
            userVO = BeanUtils.copy(obj, UserVO.class);
            userVO.setPassword(null);
        }
        return ResponseStatusVO.ok("查询成功", userVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserQuery userQuery) {
        PagerDTO pagerDTO = userService.listAllByCondition(userQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserQuery userQuery) {
        PagerDTO pagerDTO = userService.listPageByCondition(userQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 发送手机验证码
     *
     * @param phone
     */
    @PostMapping("user/sms-code")
    public ResponseStatusVO sendSmsCode(String phone) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(phone) || !RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            return ResponseStatusVO.dataError("错误的手机号", null);
        }
        if (smsCodeRedisUtils.existsCode(SmsCodeRedisUtils.SMS_CODE_UPDATE_PHONE_PREFIX, phone)) {
            return ResponseStatusVO.error("已获取过手机验证码，请稍候再获取", null);
        }
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        // 是平台用户，准备发送手机验证码，此code用于发送短信
        String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
        try {
            JSONObject templateParam = new JSONObject();
            templateParam.put("code", code);
            AliyunSmsConfig aliyunSmsConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
            SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phone, SmsConstants.SMS_NOTICE_TEMPLATE_CODE_UPDATE_PHONE, templateParam.toJSONString(), null);
            if (smsResponse.getCode() != null && AliyunSmsConstants.ALIYUN_SMS_OK.equals(smsResponse.getCode())) {
                smsCodeRedisUtils.storeCode(SmsCodeRedisUtils.SMS_CODE_UPDATE_PHONE_PREFIX, phone, code);
                return ResponseStatusVO.ok("短信发送成功", smsCodeExpiration);
            } else {
                logger.error("短信发送失败：{}", smsResponse.getMessage());
                return ResponseStatusVO.error("短信发送失败", null);
            }
        } catch (ClientException e) {
            logger.error("短信发送失败：{}", e.getMessage());
            return ResponseStatusVO.error("短信发送失败", null);
        }
    }

    /**
     * 用户修改手机号码
     * @param phone
     * @param smsCode
     * @return
     */
    @PostMapping("user/update-phone")
    public ResponseStatusVO updatePhone(String phone, String smsCode) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(phone) || !RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            return ResponseStatusVO.dataError("错误的手机号", null);
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(smsCode) || !smsCode.equals(smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_UPDATE_PHONE_PREFIX, phone))) {
            return ResponseStatusVO.dataError("手机验证码不正确", null);
        }
        Object obj = userService.getById(SecurityUtils.getJwtUser().getUserId());
        UserDTO userDTO = BeanUtils.copy(obj, UserDTO.class);
        userDTO.setPhone(phone);
        userService.update(userDTO);
        return ResponseStatusVO.ok("更新成功", null);
    }

    @Autowired
    public void setSmsCodeRedisUtils(SmsCodeRedisUtils smsCodeRedisUtils) {
        this.smsCodeRedisUtils = smsCodeRedisUtils;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
