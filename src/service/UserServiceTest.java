package service;

import bean.User;
import org.junit.jupiter.api.Test;
import service.imp.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/8
 * @description
 */
class UserServiceTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    void searchUserByName() {
        System.out.println(userService.searchUserByName("小王"));
    }

    @Test
    void searchUserByNumber() {
        System.out.println(userService.searchUserByNumber("15686253002"));
    }

    @Test
    void addUser() {
        User user = new User("zhanga", "11212143", "女", "183274829", 0, 1);
        System.out.println(userService.addUser(user));
    }
}