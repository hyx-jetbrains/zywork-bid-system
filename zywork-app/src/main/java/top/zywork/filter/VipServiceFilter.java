package top.zywork.filter;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.zywork.annotation.HasHideProperty;
import top.zywork.annotation.HideProperty;
import top.zywork.common.BeanUtils;
import top.zywork.common.RedisUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.common.StringUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.RedisKeyConstants;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ServiceDTO;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ServiceService;
import top.zywork.service.UserServiceServiceService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.wrapper.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @program: zywork-app
 * @description: vip服务过滤器
 * @author: 危锦辉 http://wjhsmart.vip
 * @create: 2019-05-28 17:45
 */
@Component(value = "myVipServiceFilter")
@WebFilter(filterName="vipServiceFilter", urlPatterns="/*")
public class VipServiceFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(VipServiceFilter.class);

    private ServiceService serviceService;

    private UserServiceServiceService userServiceServiceService;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 所有需要验证的url
     */
    private String[] vipAllUrlArray = {};
    /**
     * 用户购买了的vip服务的url
     */
    private String[] userVipAllUrlArray = {};
    /**
     * 所有需要隐藏属性的url
     */
    private String[] hidePropertyAllUrlArray = {};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("vipServiceFilter启动");
        logger.info("开始初始化需要隐藏字段的url数组");
        StringBuilder tempUrls = new StringBuilder();
        List<Class<?>> classList = ReflectUtils.getClasses("top.zywork.controller", false, HasHideProperty.class);
        for (Class clazz : classList) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(HideProperty.class)) {
                    HideProperty hideProperty = method.getDeclaredAnnotation(HideProperty.class);
                    tempUrls.append(hideProperty.url()).append(",");
                }
            }
        }
        hidePropertyAllUrlArray = tempUrls.toString().split(",");
        logger.info("需要隐藏字段url数组初始化完毕：{}",tempUrls.toString());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (RedisUtils.exists(redisTemplate, RedisKeyConstants.REDIS_CODE_KEY_SERVICE_URL)) {
            Object urlObj = RedisUtils.get(redisTemplate, RedisKeyConstants.REDIS_CODE_KEY_SERVICE_URL);
            String tempUrl = (String) urlObj;
            vipAllUrlArray = tempUrl.split(",");
        } else {
            // 缓存中不存在，则取数据库并重新存缓存
            vipAllUrlArray = serviceService.getAllVipServiceUrl();
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        if (!StringUtils.isInArray(vipAllUrlArray, url)) {
            // 两种情况下会进这里：1、不需要验证的url。2、需要验证的url，但是服务被禁用了。如果是第一种情况，这个设置不会有影响，如果是第二种情况，说明不需要隐藏字段，和用户开通了vip的效果是一样的，所以设置未true
            httpServletRequest.setAttribute(ProjectConstants.VIP_FLAG, true);
            // url 不在需要验证的url中，不做处理，直接过
            chain.doFilter(request, response);
            return;
        }
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (null == jwtUser) {
            httpServletRequest.setAttribute(ProjectConstants.VIP_FLAG, false);
            chain.doFilter(request, response);
            return;
        }
        // 当前请求的url包含在需要验证用户是否开通vip服务，查询当前用户购买的所有服务的url
        userVipAllUrlArray = userServiceServiceService.listAllUserUrls(jwtUser.getUserId());
        if (StringUtils.isInArray(userVipAllUrlArray, url)) {
            // 说明用户有购买当前url的vip服务
            httpServletRequest.setAttribute(ProjectConstants.VIP_FLAG, true);
            chain.doFilter(httpServletRequest, response);
            return;
        }
        // 到了这一步，说明没有购买服务，需要提示或隐藏部分属性
        if (StringUtils.isInArray(hidePropertyAllUrlArray, url)) {
            httpServletRequest.setAttribute(ProjectConstants.VIP_FLAG, false);
            chain.doFilter(httpServletRequest, response);
            return;
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        outResponse(httpServletResponse, ResponseStatusEnum.AUTHENTICATION_TOKEN_ERROR.getCode(), "请先购买相关服务", null);
    }

    private void outResponse(HttpServletResponse response, int responseCode, String responseMsg, Object responseData) throws IOException {
        response.setContentType(ContentTypeEnum.JSON.getValue());
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ResponseStatusVO.error(responseCode, responseMsg, responseData)));
    }

    @Override
    public void destroy() {
        logger.info("vipServiceFilter销毁");
    }

    @Autowired
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @Autowired
    public void setUserServiceServiceService(UserServiceServiceService userServiceServiceService) {
        this.userServiceServiceService = userServiceServiceService;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
