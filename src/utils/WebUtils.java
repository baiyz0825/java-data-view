package utils;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 网页工具包
 * @date 2021-12-08 22:59:32
 */
public class WebUtils {
    /**
     * @param keyAValue  :
     * @param beanObject :
     * @Description: 使用commons提供的BeanUtils实现数据在JavaBean的快速封装
     * 使用泛型传入不同类型的JavaBean对象，直接进行返回，在外部不需要再次对其进行new.外部传入Map键值对，一个键对应多个可能是String[]
     * @Author: BaiYZ
     * @Date: 2021/12/8 23:02
     * @return: T
     */
    public static <T> T gernerateBean(Map keyAValue, T beanObject) {
        try {
            BeanUtils.populate(beanObject, keyAValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanObject;
    }

    public static Integer parseIntFromString(String target, Integer defaultInteger) {
        try {
            return Integer.parseInt(target);//字符串不为空能够成功转换就返回
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultInteger;//返回默认值
    }

    /**
     * @Description: 获取随机识别码区
     * @Author: BaiYZ
     * @Date: 2021/12/19 10:10
     * @return: java.lang.String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");//调用java uuid类
    }
}