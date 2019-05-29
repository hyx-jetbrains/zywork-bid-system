package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateUtils;
import top.zywork.dao.UserServiceServiceDAO;
import top.zywork.dos.UserServiceServiceDO;
import top.zywork.dto.UserServiceServiceDTO;
import top.zywork.query.UserServiceServiceQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserServiceServiceService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * UserServiceServiceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userServiceServiceService")
public class UserServiceServiceServiceImpl extends AbstractBaseService implements UserServiceServiceService {

    private UserServiceServiceDAO userServiceServiceDAO;

    @Autowired
    public void setUserServiceServiceDAO(UserServiceServiceDAO userServiceServiceDAO) {
        super.setBaseDAO(userServiceServiceDAO);
        this.userServiceServiceDAO = userServiceServiceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserServiceServiceDO.class, UserServiceServiceDTO.class);
    }

    @Override
    public String[] listAllUserUrls(Long userId) {
        UserServiceServiceQuery userServiceServiceQuery = new UserServiceServiceQuery();
        userServiceServiceQuery.setUserServiceUserId(userId);
        List<Object> objectList = userServiceServiceDAO.listAllByCondition(userServiceServiceQuery);
        List<UserServiceServiceDTO> userServiceServiceDTOList = BeanUtils.copy(objectList, UserServiceServiceDTO.class);
        StringBuilder urls = new StringBuilder();
        Long currDateTime = DateUtils.currentTimeMillis();
        for (UserServiceServiceDTO userServiceServiceDTO : userServiceServiceDTOList) {
            Long endDateTime = DateUtils.millis(userServiceServiceDTO.getUserServiceEndDate());
            if (endDateTime >= currDateTime) {
                // 失效日期大于当前时间，则说明还有这个服务的权限
                String tempUrls = userServiceServiceDTO.getServiceUrls();
                urls.append(tempUrls).append(",");
            }
        }
        return urls.toString().split(",");
    }
}
