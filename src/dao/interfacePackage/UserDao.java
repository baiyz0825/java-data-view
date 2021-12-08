package dao.interfacePackage;

import bean.User;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 定义用户数据库类的基本操作方法
 * @date 2021-12-08 21:44:04
 */
public interface UserDao {
    /**
     * @Description: 使用名字查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:48
     * @return: bean.User
     */
    User searchUserByName(String name);

    /**
     * @Description: 使用电话号码查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:49
     * @return: bean.User
     */
    User searchUserByNumber(String number);

    /**
     * @Description: 添加用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:49
     * @return: int
     */
    int addUser(User user);
}
