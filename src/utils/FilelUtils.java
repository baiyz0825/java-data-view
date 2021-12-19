package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 文件上传类工具包
 * @date 2021-12-19 12:10:51
 */
public class FilelUtils {
    /**
     * @Description: 获取随机识别码区
     * @Author: BaiYZ
     * @Date: 2021/12/19 10:10
     * @return: java.lang.String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");//调用java uuid类
    }

    /**
     * @Description: 获取实际资源存储路径
     * @Author: BaiYZ
     * @Date: 2021/12/19 14:04
     * @return: java.lang.String
     */
    public static String getSavePath() {
        Properties propertiesPath = new Properties();
        InputStream inputStream = FilelUtils.class.getClassLoader().getResourceAsStream("fileUpload.properties");
        try {
            propertiesPath.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesPath.getProperty("path");
    }
}