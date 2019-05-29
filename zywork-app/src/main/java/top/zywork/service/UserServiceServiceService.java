package top.zywork.service;

/**
 * UserServiceServiceService服务接口<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface UserServiceServiceService extends BaseService {

    /***
     * @description:  根据用户id查询指定用户购买的所有正常的服务url
     * @param userId 用户id
     * @return: java.lang.String[]
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-29 10:17
     */
    String[] listAllUserUrls(Long userId);
}
