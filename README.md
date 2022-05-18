> gitee现在图床存在问题，需要预览图片请去/xxxIMage文件夹查看
# 项目说明

&emsp;使用JavaWeb开发的数据库显示界面的课程设计，支持数据分页查询以及期刊的模糊搜索，首页采用动态二维码生成进行校验，支持上传图片，用户密码采用md5加密，支持期刊的分页显示。
<br/>
**[报告链接](https://gitee.com/mw521/java-data-view/blob/master/报告/基于JavaWeb开发的期刊管理系统.md)**
<br/>
 **使用方法** ：<br/>
这里说明一下：大致的使用方法<br/>
1、get clone 我的这个项目git<br/>
2、使用idea打开项目目录<br/>
3、导入sql数据库文件（默认账号密码在工程里有一个excle存储）<br/>
4、在项目结构中配置相应的lib路径<br/>
5、配置jdk版本17<br/>
6、修改数据库properties文件，改为你的数据库链接配置<br/>
7、配置你的tomcat（idea右上角添加运行配置，导入你的tomcat，然后idea会提示修正项目，修正即可，之后，上面会显示工程访问路径，点击就可以访问）<br/>
8、进行访问即可<br/>
# 项目界面

![项目首页UI图1](StoreFile/DiscribeImgQQ%E6%88%AA%E5%9B%BE20220128014615.png)
<br/><br/><br/>
![项目首页UI图1](StoreFile/DiscribeImgQQ%E6%88%AA%E5%9B%BE20220128014638.png)

# 项目采用技术

## 后端

1. Junit测试
2. JDK17 进行开发
3. 采用Jar包
   1. Druid数据库连接池
   2. QueryRunner
   3. commons beanUtils
   4. commons dbUtils
   5. commons fileUpload
   6. commons codec
   7. commons io
   8. java.utils.UUID
   9. Gson(google json包)
4. MySql数据库进行存储
5. 使用Tomcat服务部署
6. Json数据传输

## 前端

1. jsp
2. js
3. css
4. Ajax请求（请求Json）

# 项目结构

## 页面结构

> 每个页面详情已经注明在每个页面目录下的README.md文件之中！

## 服务结构

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
15. 完成首页的设计以及测试
16. 完成登陆权限检查（权限设置目录逻辑暂时未设置）
17. 完成用户密码MD5加密
18. 重构Book数据库增加src图片路径
19. 重构User数据库增加管理员权限以及其用户类型
20. 新增动态首页跳转功能（filter过滤器实现）以及单独点击期刊详情页面
21. 匹配后端随机生成图片信息，以及期刊封面文件的上传
22. 设置UUID信息生成唯一图片识别码
23. 修改管理员搜索结果页以及图片上传返回页面
24. 增加按钮删除添加触发跳转
25. 注销跳转设置使用Ajax
26. 完成整体基本功能页面联调
27. 完成同步删除图片功能
28. 增加已存在照片信息进行覆盖上传
29. 修改管理员期刊信息修改详情页面

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
14. 测试权限检查的Filter
15. 测试MD5加密
16. 测试重构后用户信息插入
17. 测试动态首页跳转功能
18. 测试图片跳转详情页
19. 测试修改图书信息
20. 测试图片上传按钮
21. 页面跳转调试
22. 注销功能完成
23. 测试同步删除图片
24. 测试图片覆盖上传
25. 测试期刊详情修改页面


# 已修复

1.修复跳转无图片问题，原因为：filter过滤器默认不过滤内部请求转发 2.修复分页页面数量 修改pageCount/pageSize 为pageCount%pageSize来判断其是否整除 2.修复期刊信息更新时带来的图片丢失问题

# 注意

BookImg 挂载到 StoreFile/Img/Book 但是实际存盘路径为\\StoreFile 文件存储根目录！！！

# 详情页面展示

## 用户登陆界面

![登陆界面](StoreFile/DiscribeImgQQ%E6%88%AA%E5%9B%BE20220128014723.png)

## 管理界面

![管理界面](StoreFile/DiscribeImgQQ%E6%88%AA%E5%9B%BE20220128014739.png)

## 修改界面

![修改界面](StoreFile/DiscribeImgQQ%E6%88%AA%E5%9B%BE20220128014816.png)