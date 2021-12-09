package dao.imp;

import bean.Book;
import dao.BaseDao;
import dao.interfacePackage.BookDao;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户数据库访问实现
 * 查询的表名称一定要正确，否则找不到sql
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
     * @Description: 搜索聚合类函数，查询数据库获取其总共的记录数
     * @Author: BaiYZ
     * @Date: 2021/12/9 9:00
     * @return: int
     */
    @Override
    public int searchAllCountBookRecord() {
        String sql = "select count(*) from `Book`";
        Number count = queryForCount(sql);
        return count.intValue();
    }

    /**
     * @param pageNo   :
     * @param pageSize :
     * @Description: 按照其分页页码以及分页大小查询符合的分页中包含的图书(sql查询分页)
     * @Author: BaiYZ
     * @Date: 2021/12/9 9:02
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> booksForOnePages(int pageNo, int pageSize) {
        String sql = "select * from `Book` limit ?,?";
        return queryForList(Book.class, sql, (pageNo - 1) * pageSize, pageSize);
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