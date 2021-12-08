package service.imp;

import bean.User;
import dao.imp.UserDaoImpl;
import service.UserService;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description UserServlet接口实现类
 * @date 2021-12-08 22:29:25
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * @param name :
     * @Description: 使用姓名查询用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:27
     * @return: bean.User
     */
    @Override
    public User searchUserByName(String name) {
        return userDao.searchUserByName(name);
    }

    /**
     * @param number :
     * @Description: 使用number查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:27
     * @return: bean.User
     */
    @Override
    public User searchUserByNumber(String number) {
        return userDao.searchUserByNumber(number);
    }

    /**
     * @param user :
     * @Description: 添加用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:28
     * @return: int
     */
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}