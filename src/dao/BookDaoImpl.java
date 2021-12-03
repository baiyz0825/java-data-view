package dao;

import bean.Book;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户数据库访问实现
 * @date 2021-12-03 21:23:40
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    /**
     * @param id :
     * @Description: 使用编号查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:25
     * @return: int
     */
    @Override
    public Book searchBookByID(String id) {
        return null;
    }

    /**
     * @param name :
     * @Description: 使用书名查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:30
     * @return: bean.Book
     */
    @Override
    public Book searchBookByName(String name) {
        return null;
    }

    /**
     * @param sortBook :
     * @Description: 使用分类查找图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> searchBookBySort(String sortBook) {
        return null;
    }

    /**
     * @param book :
     * @Description: 更新图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:31
     * @return: int
     */
    @Override
    public int updateBook(Book book) {
        return 0;
    }

    /**
     * @param id :
     * @Description: 删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    @Override
    public int deleteBook(String id) {
        return 0;
    }

    /**
     * @param book :
     * @Description: 添加图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    @Override
    public int addBook(Book book) {
        return 0;
    }
}