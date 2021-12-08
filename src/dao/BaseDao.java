package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 制造数据库基本操作方法
 * @date 2021-12-03 21:32:48
 */
public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * @param sql:sql语句
     * @param params:   传入的sql替换的属性列值（更新那一列就是哪个，对于任意列都成立）
     * @Description: 封装update方法
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:39
     * @return: int -1失败
     */
    public int update(String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, params);//返回大于零为查找到
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return -1;
    }

    /**
     * @param classType:
     * @param sql:
     * @param params:
     * @Description: 封装查询对象的方法
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:54
     * @return: T
     */
    public <T> T queryForOne(Class<T> classType, String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<>(classType), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }

    /**
     * @param classType:
     * @param sql:
     * @param params:
     * @Description: 封装查询对象集合
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:55
     * @return: java.util.List<T>
     */
    public <T> List<T> queryForList(Class<T> classType, String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(classType), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }

    /**
     * @param classType:
     * @param sql:
     * @param params:
     * @Description: 查询聚合函数的值 比如统计数量
     * @Author: BaiYZ
     * @Date: 2021/12/3 22:00
     * @return: java.lang.Number
     */
    public <T> Number queryForCount(Class<T> classType, String sql, Object params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }
}