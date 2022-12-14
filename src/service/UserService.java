package service;

import bean.User;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 处理用户的服务
 * @date 2021-12-04 18:31:57
 */
public interface UserService {

    /**
     * @param name:
     * @Description: 使用姓名查询用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:27
     * @return: bean.User
     */
    User searchUserByName(String name);

    /**
     * @param number:
     * @Description: 使用number查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:27
     * @return: bean.User
     */
    User searchUserByNumber(String number);

    /**
     * @param user:
     * @Description: 添加用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:28
     * @return: int
     */
    int addUser(User user);
}
