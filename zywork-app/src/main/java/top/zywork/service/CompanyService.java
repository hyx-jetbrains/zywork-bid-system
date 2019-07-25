package top.zywork.service;

import top.zywork.vo.CompanyPythonVO;

import java.util.List;
import java.util.Map;

/**
 * CompanyService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface CompanyService extends BaseService {

    /**
     * 获取分页页码的的文件值
     * @return
     */
    List<CompanyPythonVO> getPageNoFileValue();
}
