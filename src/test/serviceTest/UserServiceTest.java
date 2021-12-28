package test.serviceTest;

import bean.User;
import org.junit.jupiter.api.Test;
import service.imp.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/26
 * @description
 */
class UserServiceTest {
    @Test
    void searchUserNumber() {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.searchUserByName("admin"));
    }

    @Test
    void addUser() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User("ligdfgd", "adghadgh", "男", "18109273851", 0, 0);
        System.out.println(userService.addUser(user));
    }
}