package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.RandomUtils;
import top.zywork.dao.UserDAO;
import top.zywork.dao.UserRegDAO;
import top.zywork.dos.UserDO;
import top.zywork.dto.UserDTO;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserService;

import javax.annotation.PostConstruct;

/**
 * UserServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userService")
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Value("${user.share-code.length}")
    private Integer shareCodeLength;

    private UserDAO userDAO;

    private UserRegDAO userRegDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        super.setBaseDAO(userDAO);
        this.userDAO = userDAO;
    }

    @Override
    public int save(Object obj) {
        UserDTO userDTO = BeanUtils.copy(obj, UserDTO.class);
        int saveRow = userDAO.save(userDTO);
        userRegDAO.saveUserWallet(userDTO.getId());
        userRegDAO.saveShareCode(userDTO.getId(), generateShareCode());
        return saveRow;
    }

    @PostConstruct
    public void init() {
        super.init(UserDO.class, UserDTO.class);
    }

    @Autowired
    public void setUserRegDAO(UserRegDAO userRegDAO) {
        this.userRegDAO = userRegDAO;
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
}
