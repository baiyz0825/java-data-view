package test.utilsTest;

import org.junit.jupiter.api.Test;
import utils.WebUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/9
 * @description
 */
class WebUtilsTest {

    @Test
    void gernerateBean() {
    }

    @Test
    void parseIntFromString() {
        System.out.println(WebUtils.parseIntFromString("", 0));
    }
}