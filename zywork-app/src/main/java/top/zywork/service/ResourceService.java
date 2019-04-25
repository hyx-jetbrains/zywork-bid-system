package top.zywork.service;

import org.springframework.web.multipart.MultipartFile;
import top.zywork.dto.ResourceDTO;
import top.zywork.security.JwtUser;
import top.zywork.vo.ResponseStatusVO;

/**
 * ResourceService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface ResourceService extends BaseService {

    /***
     * @description: 保存用户资源信息，直接返回响应状态
     * @param jwtUser 用户信息
     * @param file 资源文件
     * @param resourceType 资源类别，区别是图片资源还是文档资源
     * @param resourceExts 资源扩展名，用于判断资源上传是否正确
     * @param resourceSize 资源最大大小
     * @return: top.zywork.vo.ResponseStatusVO
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-25 09:43
     */
    ResponseStatusVO saveResource(JwtUser jwtUser, MultipartFile file, String resourceType, String resourceExts, Long resourceSize);
}
