package dao.imp;

import bean.Book;
import dao.BaseDao;
import dao.interfacePackage.BookDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户数据库访问实现
 * 查询的表名称一定要正确，否则找不到sql
 * @date 2021-12-03 21:23:40
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    //这里使用Object类型容纳，因为在查询的过程中需要替换占位符Like时是字符串
    // 但是在替换后面的Limit限制需要是数字，因此使用Object类型存放
    private static List<Object> param = new ArrayList<>();


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
     * @param book :
     * @Description: 搜索模糊匹配期刊个数
     * @Author: BaiYZ
     * @Date: 2021/12/11 18:42
     * @return: int
     */
    @Override
    public int searchBooksConditionCount(Book book) {
        String sql = getSqlFromBean(book, "count(*)", param);
//        System.out.println(sql);
//        System.out.println(param);
        Number count = queryForCount(sql, param.toArray());
        param.clear();
        return count.intValue();
    }

    /**
     * @param book :
     * @Description: 拼接sql 计算需要查询分页的sql语句
     * @Author: BaiYZ
     * @Date: 2021/12/11 18:49
     * @return: java.lang.String
     */
    @Override
    public String getSqlFromBean(Book book, String pattern, List<Object> param) {
        String sql = "select " + pattern + " from `Book` where 1=1";
        if (book.getNumber() != null && !book.getNumber().trim().equals("")) {
            sql += " and number =?";
            param.add(book.getNumber());
            return sql;
        }
        if (book.getName() != null && !book.getName().trim().equals("")) {
            sql += " and name like ?";
            param.add("%" + book.getName() + "%");
        }
        if (book.getAuthor() != null && !book.getAuthor().trim().equals("")) {
            sql += " and author like ?";
            param.add("%" + book.getAuthor() + "%");
        }
        if (book.getPublisher() != null && !book.getPublisher().trim().equals("")) {
            sql += " and publisher like ?";
            param.add("%" + book.getPublisher() + "%");
        }
        if (book.getSortBook() != null && !book.getSortBook().equals("")) {
            sql += " and sortBook like ?";
            param.add("%" + book.getSortBook() + "%");
        }
        return sql;
    }

    /**
     * @param book     :
     * @param pageNo   :
     * @param pageSize :
     * @Description: 查询模糊匹配的图书分页
     * @Author: BaiYZ
     * @Date: 2021/12/11 18:44
     * @return: java.util.List<bean.Book>
     */
    @Override
    public List<Book> searchBooksConditionPages(Book book, int pageNo, int pageSize) {
        String sql = getSqlFromBean(book, "*", param) + " limit ?,?";
        param.add((pageNo - 1) * pageSize);//object传入数字即可
        param.add(pageSize);
        List<Book> ans = queryForList(Book.class, sql, param.toArray());
        param.clear();
        return ans;
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