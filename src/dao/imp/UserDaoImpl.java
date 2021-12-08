package dao.imp;

import bean.User;
import dao.BaseDao;
import dao.interfacePackage.UserDao;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户数据库访问实现类
 * @date 2021-12-08 21:44:25
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * @param name ：
     * @Description: 使用名字查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:48
     * @return: bean.User
     */
    @Override
    public User searchUserByName(String name) {
        String sql = "select * from `User` where name = ? ";
        return queryForOne(User.class, sql, name); //对象必须需要无参数构造方法，否则报错
    }

    /**
     * @param number：
     * @Description: 使用电话号码查找用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:49
     * @return: bean.User
     */
    @Override
    public User searchUserByNumber(String number) {
        String sql = "select * from `User` where number = ? ";
        return queryForOne(User.class, sql, number);
    }

    /**
     * @param user ：
     * @Description: 添加用户
     * @Author: BaiYZ
     * @Date: 2021/12/8 21:49
     * @return: int
     */
    @Override
    public int addUser(User user) {
        String sql = "insert into `User` (name,password,sex,number) values(?,?,?,?)";
        return update(sql, user.getName(), user.getPassword(), user.getSex(), user.getNumber());
    }
}