# 项目说明

使用JavaWeb开发的数据库显示界面的课程设计

# 项目采用技术

## 后端

1. Junit测试
2. JDK17 进行开发
3. 采用Jar包
    1. Druid数据库连接池
    2. QueryRunner
4. MySql数据库进行存储
5. 使用Tomcat服务部署

## 前端

1. jsp
2. js
3. css

# 项目进展

## 编写

1. 完成数据库建立
2. 完成BookDao
3. 完成BookService
4. 完成JSP初始界面
5. 完成期刊删除以及首页展示
6. 编写WebUtils类，转化注入Bean对象（封装BeanUtils）
7. 完成用户数据库建立
8. 完成用户类Servlet
9. 完成登录功能
10. 完成期刊增加，修改功能
11. 完成期刊查询分页显示功能
12. 实现模糊分页搜索功能后端编写
13. 完成注册密码强度校验以及注册相应
14. 完成登陆页面设计

## 测试

1. 完成数据库连接测试
2. 完成BookDao测试
3. 完成BookService测试
4. 完成JSP初始界面测试
5. 完成期刊删除以及首页展示测试
6. 完成用户数据库测试
7. 完成登录测试
8. 完成期刊分页测试
9. 完成期刊增加，修改功能
10. 测试模糊匹配Dao测试
11. 测试模糊匹配Service层测试
12. 测试注册
13. 完成登陆页面设计

# 存在问题，无法检索时间匹配的期刊信息

`JDBC format [yyyy-MM-dd] to create a java.sql.Date`
