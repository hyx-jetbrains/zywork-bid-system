package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateUtils;
import top.zywork.common.RandomUtils;
import top.zywork.constant.CouponConstant;
import top.zywork.dao.*;
import top.zywork.dos.UserRegDO;
import top.zywork.dto.CouponDTO;
import top.zywork.dto.UserCouponDTO;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.query.CouponQuery;
import top.zywork.service.UserRegService;

import java.util.List;

/**
 * 用户注册保存用户信息Service接口实现类<br/>
 *
 * 创建于2018-12-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRegServiceImpl implements UserRegService {

    @Value("${user.share-code.length}")
    private Integer shareCodeLength;

    private UserRegDAO userRegDAO;

    private UserRoleRegDAO userRoleRegDAO;

    private UserInviteDAO userInviteDAO;

    private CouponDAO couponDAO;

    private UserCouponDAO userCouponDAO;

    @Override
    public void saveUser(String email, String password, Long roleId, Long inviteUserId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setEmail(email);
        userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveUser(userRegDO);
        userRegDAO.saveUserWallet(userRegDO.getId());
        userRegDAO.saveShareCode(userRegDO.getId(), generateShareCode());
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
        if (inviteUserId != null) {
            userInviteDAO.saveUserHierarchy(inviteUserId, userRegDO.getId());
        }
    }

    @Override
    public void saveUserMobile(String phone, String password, Long roleId, Long inviteUserId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setPhone(phone);
        userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveUserMobile(userRegDO);
        userRegDAO.saveUserWallet(userRegDO.getId());
        userRegDAO.saveShareCode(userRegDO.getId(), generateShareCode());
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
        if (inviteUserId != null) {
            userInviteDAO.saveUserHierarchy(inviteUserId, userRegDO.getId());
        }
    }

    @Override
    public void saveWeixinUser(String openid, String unionId, String accessToken, String sessionKey, String socialType, String password,
                               String nickname, String headicon, Byte gender, Long roleId, Long inviteUserId) {
        UserRegDO userRegDO = new UserRegDO();
        // userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveWeixinUser(userRegDO);
        userRegDAO.saveWeixinUserDetail(userRegDO.getId(), nickname, headicon, gender, generateShareCode());
        userRegDAO.saveUserWallet(userRegDO.getId());
        userRegDAO.saveWeixinUserSocial(userRegDO.getId(), openid, unionId, accessToken, sessionKey, socialType);
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
        if (inviteUserId != null) {
            userInviteDAO.saveUserHierarchy(inviteUserId, userRegDO.getId());
            // 发放抵用券
            CouponQuery couponQuery = new CouponQuery();
            couponQuery.setIsActive(CouponConstant.IS_ACTIVE_TRUE.byteValue());
            couponQuery.setSortColumn("createTime");
            couponQuery.setSortOrder("desc");
            // 最少还有一张
            couponQuery.setCouponCountMin(1);
            // 有效期大于今天
            couponQuery.setValidTimeMin(DateUtils.currentDate());
            couponQuery.setPageSize(1);
            List<Object> objectList = couponDAO.listPageByCondition(couponQuery);
            if (null == objectList || objectList.size() <= 0) {
                System.err.println("没有可用的抵用券");
                return;
            }
            // 获取到抵用券
            CouponDTO couponDTO = BeanUtils.copy(objectList.get(0), CouponDTO.class);
            int updateRow = couponDAO.updateCouponCount(couponDTO.getId());
            if (updateRow >= 1) {
                // 更新抵用券数量成功
                UserCouponDTO userCouponDTO = new UserCouponDTO();
                userCouponDTO.setUserId(inviteUserId);
                userCouponDTO.setCouponId(couponDTO.getId());
                userCouponDTO.setUseStatus(CouponConstant.COUPON_STATUS_WAIT);
                userCouponDAO.save(userCouponDTO);
            }
        }
    }

    @Override
    public void updateWeixinUserDetail(String openid, String nickname, String headicon, Byte gender) {
        userRegDAO.updateWeixinUserDetail(openid, nickname, headicon, gender);
    }

    @Override
    public void updateWeixinUserSocial(String openid, String accessToken, String sessionKey) {
        userRegDAO.updateWeixinUserSocial(openid, accessToken, sessionKey);
    }

    @Override
    public String getSessionKeyByOpenid(String openid) {
        return userRegDAO.getSessionKeyByOpenid(openid);
    }

    @Override
    public void updateUserPhone(String openid, String phone) {
        userRegDAO.updateUserPhone(openid, phone);
    }

    /**
     * 生成用户分享码
     */
    private String generateShareCode() {
        String shareCode = RandomUtils.randomCode(RandomCodeEnum.MIX_CODE, shareCodeLength);
        if (userRegDAO.getUserIdByShareCode(shareCode) == null) {
            // 如果分享码不存在，则返回生成的分享码
            return shareCode;
        } else {
            // 如果分享码已存在，则继续生成分享码
            return generateShareCode();
        }
    }

    /**
     * 根据分享码获取用户id
     * @param shareCode
     * @return
     */
    @Override
    public Long getUserIdByShareCode(String shareCode) {
        return userRegDAO.getUserIdByShareCode(shareCode);
    }

    @Autowired
    public void setUserRegDAO(UserRegDAO userRegDAO) {
        this.userRegDAO = userRegDAO;
    }

    @Autowired
    public void setUserRoleRegDAO(UserRoleRegDAO userRoleRegDAO) {
        this.userRoleRegDAO = userRoleRegDAO;
    }

    @Autowired
    public void setUserInviteDAO(UserInviteDAO userInviteDAO) {
        this.userInviteDAO = userInviteDAO;
    }

    @Autowired
    public void setCouponDAO(CouponDAO couponDAO) {
        this.couponDAO = couponDAO;
    }

    @Autowired
    public void setUserCouponDAO(UserCouponDAO userCouponDAO) {
        this.userCouponDAO = userCouponDAO;
    }
}
