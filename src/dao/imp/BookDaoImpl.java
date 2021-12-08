package dao.imp;

import bean.Book;
import dao.BaseDao;
import dao.interfacePackage.BookDao;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户数据库访问实现
 *查询的表名称一定要正确，否则找不到sql
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
        String sql = "select `number`,`name`,`sortBook`,`publisher`,`author`,`prices`,`remainNumber`,`publishData` from Book where number = ?";
        return queryForOne(Book.class, sql, id);
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
        String sql = "select number,name,sortBook,publisher,author,prices,remainNumber,publishData from `Book` where name =?";
        return queryForOne(Book.class, sql, name);
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
        String sql = "select number,name,sortBook,publisher,author,prices,remainNumber,publishData from `Book` where sortBook =?";
        return queryForList(Book.class, sql, sortBook);
    }

    @Override
    public List<Book> searchBookAll() {
        String sql = "select  number,name,sortBook,publisher,author,prices,remainNumber,publishData from `Book`";
        return queryForList(Book.class, sql);
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
        String sql = "update `Book` set name=?,sortBook=?,publisher=?,author=?,prices=?,remainNumber=?,publishData=? where number = ?";
        return update(sql, book.getName(), book.getSortBook(), book.getPublisher(), book.getAuthor(), book.getPrices(), book.getRemainNumber(), book.getPublishData(), book.getNumber());
    }

    /**
     * @param id :
     * @Description: 删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/3 21:32
     * @return: int
     */
    @Override
    public int deleteBookById(String id) {
        String sql = "delete from `Book` where number=?";
        return update(sql, id);
    }

    /**
     * @param name :
     * @Description: 使用图书名删除图书
     * @Author: BaiYZ
     * @Date: 2021/12/4 9:03
     * @return: int
     */
    @Override
    public int deleteBookByName(String name) {
        String sql = "delete from `Book` where name=?";
        return update(sql, name);
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
        String sql = "insert into `Book` (number,name,sortBook,publisher,author,prices,remainNumber,publishData) values (?,?,?,?,?,?,?,?)";
        return update(sql, book.getNumber(), book.getName(), book.getSortBook(), book.getPublisher(), book.getAuthor(), book.getPrices(), book.getRemainNumber(), book.getPublishData());
    }
}