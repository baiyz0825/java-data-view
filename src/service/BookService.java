package service;

import bean.Book;
import bean.Page;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description TODO
 * @date 2021-12-05 16:33:14
 */
public interface BookService {
    /**
     * @Description: 使用ID查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 16:42
     * @return: bean.Book
     */
    Book searchBookById(String id);

    /**
     * @param name:
     * @Description: 使用名称查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: bean.Book
     */
    Book searchBookByName(String name);

    /**
     * @Description: 查询全部图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:12
     * @return: java.util.List<bean.Book>
     */
    List<Book> searchBookAll();

    /**
     * @param sortBook:
     * @Description: 使用分类查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: java.util.List<bean.Book>
     */
    public List<Book> searchBookBySort(String sortBook);

    /**
     * @param id:
     * @Description: 使用ID删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: int
     */
    int deleteBookById(String id);

    /**
     * @param name:
     * @Description: 使用名称删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     * @return: int
     */
    int deleteBookByName(String name);

    /**
     * @param book:
     * @Description: 更新图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     * @return: int
     */
    int updateBook(Book book);

    /**
     * @param book:
     * @Description: 添加图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     */
    int addBook(Book book);

    /**
     * @param pageNo:
     * @param pageSize:
     * @Description: 提供page方法查询分页，并返回page对象
     * @Author: BaiYZ
     * @Date: 2021/12/9 8:54
     * @return: bean.Page<bean.Book>
     */
    Page<Book> pages(Integer pageNo, Integer pageSize);

    /**
     * @param book:
     * @param pageNo:
     * @param pageSize:
     * @Description: 实现期刊分类检索
     * @Author: BaiYZ
     * @Date: 2021/12/11 18:38
     * @return: bean.Page<bean.Book>
     */
    Page<Book> searchBookPage(Book book, Integer pageNo, Integer pageSize);
}
