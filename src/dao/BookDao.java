package dao;

import bean.Book;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description TODO
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
    public Book searchBookByID(String id);

    /**
     * @param name:
     * @Description: 使用书名查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:30
     * @return: bean.Book
     */
    public Book searchBookByName(String name);

    /**
     * @param sortBook:
     * @Description: 使用分类查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: java.util.List<bean.Book>
     */
    public List<Book> searchBookBySort(String sortBook);

    /**
     * @param book:
     * @Description: 更新图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: int
     */
    public int updateBook(Book book);

    /**
     * @param id:
     * @Description: 删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    public int deleteBook(String id);

    /**
     * @param book:
     * @Description: 添加图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    public int addBook(Book book);
}
