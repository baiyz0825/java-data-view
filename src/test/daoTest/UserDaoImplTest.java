package test.daoTest;

import bean.User;
import dao.imp.UserDaoImpl;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/8
 * @description UserDao测试类
 */
class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    void searchUserByzName() {
        String name = "小王";
        User user = userDao.searchUserByName(name);
        System.out.println(user);
    }

    @Test
    void searchUserByNumber() {
        String number = "15686253002";
        User user = userDao.searchUserByNumber(number);
        System.out.println(user);
    }

    @Test
    void addUser() {
        User user = new User("li", "adghadgh", "男", "18109273856");
        userDao.addUser(user);
    }
}