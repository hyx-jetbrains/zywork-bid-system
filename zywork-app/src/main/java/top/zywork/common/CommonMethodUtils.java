package top.zywork.common;

import org.springframework.beans.factory.annotation.Value;
import top.zywork.constant.PythonConstants;

/**
 * @program: zywork-app
 * @description: 公共方法工具类
 * @author: 危锦辉 http://wjhsmart.vip
 * @create: 2019-06-21 17:30
 */
public class CommonMethodUtils {

    /**
     * 生成静态html代码
     * @param fileName 文件名称
     * @param projectDetail 详细内容
     * @param location 地址
     */
    public static void generatorHtmlCode(String fileName, String projectDetail, String location) {
        String head = PythonConstants.HTML_HEAD;
        String foot = PythonConstants.HTML_FOOT;
        IOUtils.writeText(head + projectDetail + foot, location + "/" + fileName);
    }
}
