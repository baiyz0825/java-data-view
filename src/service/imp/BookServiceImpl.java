package service.imp;

import bean.Book;
import bean.Page;
import dao.imp.BookDaoImpl;
import service.BookService;

import java.util.ArrayList;
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
     * @param pageNo   :
     * @param pageSize :
     * @Description: 提供page方法查询分页，并返回page对象
     * @Author: BaiYZ
     * @Date: 2021/12/9 8:54
     * @return: bean.Page<bean.Book>
     */
    @Override
    public Page<Book> pages(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int recordCount = bookDao.searchAllCountBookRecord();
        page.setRecordCount(recordCount);
        int pageCount = recordCount / pageSize;//可能存在余数，图书还得一页
        if ((recordCount % pageSize) != 0)//判断是否整除，不整除说明其还需要一页
            pageCount++;
        page.setPageCount(pageCount);
        List<Book> books = bookDao.booksForOnePages(pageNo, pageSize);//查询分页列表
        page.setPageData(books);
        return page;
    }

    /**
     * @param book     :
     * @param pageNo   :
     * @param pageSize :
     * @Description: 实现图书分类检索
     * @Author: BaiYZ
     * @Date: 2021/12/11 18:38
     * @return: bean.Page<bean.Book>
     */
    @Override
    public Page<Book> searchBookPage(Book book, Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int recordCount = bookDao.searchBooksConditionCount(book);
        page.setRecordCount(recordCount);
        int pageCount = recordCount / pageSize;//可能存在余数，图书还得一页
        if (recordCount % pageSize != 0)
            pageCount++;
        page.setPageCount(pageCount);
        List<Book> books = bookDao.searchBooksConditionPages(book, pageNo, pageSize);//查询分页列表
        page.setPageData(books);
        return page;
    }

    /**
     * @param number :
     * @Description: 获取N个随机的图书
     * @Author: BaiYZ
     * @Date: 2021/12/19 8:43
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> getRandomBooks(int number) {
        return bookDao.getRandomBookFromList(number);
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
     * @Description: 更新图书照片信息
     * @Author: BaiYZ
     * @Date: 2021/12/5 17:03
     * @return: int
     */
    @Override
    public int updateBookImg(String ImgPath, String number) {
        return bookDao.updateBookImg(ImgPath, number);
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