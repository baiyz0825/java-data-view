package dao.interfacePackage;

import bean.Book;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 定义BookDao基本功能（接口方法默认Public）
 * @date 2021-12-03 21:23:29
 */
public interface BookDao {
    /**
     * @param id:
     * @Description: 使用编号查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:25
     * @return: int
     */
    Book searchBookByID(String id);

    /**
     * @param name:
     * @Description: 使用书名查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:30
     * @return: bean.Book
     */
    Book searchBookByName(String name);

    /**
     * @param sortBook:
     * @Description: 使用分类查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: java.util.List<bean.Book>
     */
    List<Book> searchBookBySort(String sortBook);

    /**
     * @Description: 查询全部图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:11
     * @return: java.util.List<bean.Book>
     */
    List<Book> searchBookAll();

    /**
     * @param book:
     * @Description: 更新图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: int
     */
    int updateBook(Book book);

    /**
     * @param id:
     * @Description: 删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    int deleteBookById(String id);

    /**
     * @param name:
     * @Description: 使用图书名删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/4 9:03
     * @return: int
     */
    int deleteBookByName(String name);

    /**
     * @param book:
     * @Description: 添加图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    int addBook(Book book);

    /**
     * @Description: 搜索聚合类函数，查询数据库获取其总共地记录数
     * @Author: BaiYZ
     * @Date: 2021/12/9 9:00
     * @return: int
     */
    int searchAllCountBookRecord();

    /**
     * @param pageNo:
     * @param pageSize:
     * @Description: 按照其分页页码以及分页大小查询符合的分页中包含的图书
     * @Author: BaiYZ
     * @Date: 2021/12/9 9:02
     * @return: java.util.List<bean.Book>
     */
    List<Book> booksForOnePages(int pageNo, int pageSize);
}
