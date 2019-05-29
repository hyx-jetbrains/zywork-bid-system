package top.zywork.annotation;

import java.lang.annotation.*;

/**
 * 隐藏指定的属性，用于controller中的方法，返回的数据中把指定的字段隐藏<br/>
 * 创建于2019-01-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HideProperty {

    /**
     * 当前方法的url
     * @return
     */
    String url() default "";

    /**
     * 需要隐藏的属性数组
     * @return
     */
    String[] properties() default {};

}
