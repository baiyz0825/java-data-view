package test.normalTest;

import org.junit.jupiter.api.Test;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 测试分页计算的计算公式
 * @date 2021-12-24 11:57:27
 */
public class pagesTest {
    @Test
    public void pages() {
        int recordCount = 12;
        int pageSize = 5;
        int pageCount = recordCount / pageSize;//可能存在余数，图书还得一页
        System.out.println(pageCount);
        if ((recordCount % pageSize) != 0)
            pageCount++;
        System.out.println(pageCount);
    }
}