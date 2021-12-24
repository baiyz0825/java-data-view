package test.utilsTest;

import org.junit.jupiter.api.Test;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 测试数据库中路径转化为实际路径的字符串分割
 * @date 2021-12-24 11:24:32
 */
public class testString {
    @Test
    public void stringTest() {
        String path = "big/sdfsfd.jpg";
        String ans = path.substring(path.indexOf("/") + 1);
        System.out.println(ans);
    }
}