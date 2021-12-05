package service.imp;

import bean.Book;
import dao.imp.BookDaoImpl;
import service.BookService;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description TODO
 * @date 2021-12-05 17:01:41
 */
public class BookServiceImpl implements BookService {
    private final BookDaoImpl bookDao = new BookDaoImpl();

    /**
     * @param id :
     * @Description: 使用ID查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 16:42
     * @return: bean.Book
     */
    @Override
    public Book searchBookById(String id) {
        return bookDao.searchBookByID(id);
    }

    /**
     * @param name :
     * @Description: 使用名称查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: bean.Book
     */
    @Override
    public Book searchBookByName(String name) {
        return bookDao.searchBookByName(name);
    }

    /**
     * @Description: 查询全部图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:12
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> searchBookAll() {
        return bookDao.searchBookAll();
    }

    /**
     * @param sortBook :
     * @Description: 使用分类查询图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> searchBookBySort(String sortBook) {
        return bookDao.searchBookBySort(sortBook);
    }

    /**
     * @param id :
     * @Description: 使用ID删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:02
     * @return: int
     */
    @Override
    public int deleteBookById(String id) {
        return bookDao.deleteBookById(id);
    }

    /**
     * @param name :
     * @Description: 使用名称删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     * @return: int
     */
    @Override
    public int deleteBookByName(String name) {
        return bookDao.deleteBookByName(name);
    }

    /**
     * @param book :
     * @Description: 更新图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     * @return: int
     */
    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    /**
     * @param book :
     * @Description: 添加图书信息
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     */
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }
}