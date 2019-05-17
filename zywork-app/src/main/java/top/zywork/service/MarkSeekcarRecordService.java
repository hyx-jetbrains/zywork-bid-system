package top.zywork.service;

import top.zywork.dto.MarkSeekcarRecordDTO;

/**
 * MarkSeekcarRecordService服务接口<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public interface MarkSeekcarRecordService extends BaseService {

    /***
     * @description: 根据用户id和拼车id查询拼车记录，用于区分该用户是否有拼过该车
     * @param userId 用户id
     * @param markSeekcarId 拼车id
     * @return: top.zywork.dto.MarkSeekcarRecordDTO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 11:26
     */
    MarkSeekcarRecordDTO getByUserIdAndSeekcarId(Long userId, Long markSeekcarId);

}
