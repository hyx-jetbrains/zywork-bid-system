package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserNoticeDAO;
import top.zywork.dos.UserNoticeDO;
import top.zywork.dto.UserNoticeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserNoticeService;

import javax.annotation.PostConstruct;

/**
 * UserNoticeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userNoticeService")
public class UserNoticeServiceImpl extends AbstractBaseService implements UserNoticeService {

    private UserNoticeDAO userNoticeDAO;

    @Autowired
    public void setUserNoticeDAO(UserNoticeDAO userNoticeDAO) {
        super.setBaseDAO(userNoticeDAO);
        this.userNoticeDAO = userNoticeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserNoticeDO.class, UserNoticeDTO.class);
    }

    @Override
    public Long clearNoReadMessage(Long userId, Integer noticeType) {
        return userNoticeDAO.clearNoReadMessage(userId, noticeType);
    }
}
