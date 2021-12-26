package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.UUID;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 文件上传类工具包
 * @date 2021-12-19 12:10:51
 */
public class FilelUtils {
    private static Map<String, String> fileSortMaps;
    private static String rootPath;

    static {
        Properties propertiesPath = new Properties();
        InputStream inputStream = FilelUtils.class.getClassLoader().getResourceAsStream("fileUploadPath.properties");
        try {
            propertiesPath.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rootPath = propertiesPath.getProperty("path");
        fileSortMaps = new TreeMap<>();
        fileSortMaps.put("ImgBook", rootPath + "\\Img\\Book");
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

    /**
     * @Description: 获取实际资源存储路径
     * @Author: BaiYZ
     * @Date: 2021/12/19 14:04
     * @return: java.lang.String
     */
    public static String getSavePath(String fileSort) {
        return fileSortMaps.get(fileSort);
    }

    /**
     * @param path:
     * @Description: 删除服务器文件
     * @Author: BaiYZ
     * @Date: 2021/12/24 11:13
     * @return: boolean
     */
    public static boolean deleteFile(String path, String fileSort) {
        String realPath = fileSortMaps.get(fileSort) + "\\" + path.substring(path.indexOf("/") + 1);
        try {
            File file = new File(realPath);
            if (file.exists())
                return file.delete();
            else
                return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        return false;
    }
}