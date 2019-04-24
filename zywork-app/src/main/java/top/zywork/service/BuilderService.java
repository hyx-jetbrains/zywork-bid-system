package top.zywork.service;

import top.zywork.vo.BuilderVO;

/**
 * BuilderService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface BuilderService extends BaseService {

    /***
     * @description: 保存建造师，顺便保存建造师资源
     * @param builderVO
     * @return: int
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-24 16:12
     */
    int saveBuilder(BuilderVO builderVO);
}
