package top.zywork.service;

import top.zywork.vo.UserExpertVO;

/**
 * UserExpertService服务接口<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface UserExpertService extends BaseService {

    void saveExpert(UserExpertVO userExpertVO, String questionTypeId);

    Object getByUserId(Long userId);
}
