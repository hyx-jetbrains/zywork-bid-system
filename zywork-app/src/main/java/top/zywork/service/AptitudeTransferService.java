package top.zywork.service;

import top.zywork.vo.AptitudeTransferVO;
import top.zywork.vo.BuilderVO;

/**
 * AptitudeTransferService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public interface AptitudeTransferService extends BaseService {

    /***
     * @description: 保存资质转让信息，并保存附件
     * @param aptitudeTransferVO 资质转让信息
     * @return: int
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-25 10:33
     */
    int saveAptitudeTransfer(AptitudeTransferVO aptitudeTransferVO);
}
