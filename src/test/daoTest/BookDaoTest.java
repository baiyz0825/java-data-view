package test.daoTest;

import bean.Book;
import bean.Page;
import dao.imp.BookDaoImpl;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/4
 * @description 测试BookDao功能
 */
class BookDaoTest {
    private BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    void searchBookByID() {
        System.out.println(bookDao.searchBookByID("22165"));
    }

    @Test
    void searchBookByName() {
        System.out.println(bookDao.searchBookByName("C语言周报"));
    }

    @Test
    void searchBookBySort() {
        for (Book book : bookDao.searchBookBySort("文学")) {
            System.out.println(book);
        }
    }

    @Test
    void updateBook() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilsDate = format.parse("2012-12-2");
            java.sql.Date date = new java.sql.Date(utilsDate.getTime());
            Book book = new Book("201585", "科普", "机械出版社", "科学中国", "刘子欣", 99.9, 100, date, null);
            System.out.println(bookDao.updateBook(book));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteBookById() {
        System.out.println(bookDao.deleteBookById("201585"));
    }

    @Test
    void deleteBookByName() {
        System.out.println(bookDao.deleteBookByName("易经"));
    }

   @Test
    void addBook() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date utilsDate = format.parse("2018-10-2");
            java.sql.Date date = new java.sql.Date(utilsDate.getTime());
            Book book = new Book("25147", "科普", "机械出版社", "量子宇宙第一期", "刘子欣", 99.9, 100, date, null);
            System.out.println(bookDao.addBook(book));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void searchAllCountBookRecord() {
        System.out.println(bookDao.searchAllCountBookRecord());
    }

    @Test
    void booksForOnePages() {
        for (Book book : bookDao.booksForOnePages(1, 4)) {
            System.out.println(book);
        }
        System.out.println("-------------------------------");
        for (Book book : bookDao.booksForOnePages(2, 4)) {
            System.out.println(book);
        }
    }

    @Test
    void getSqlFromBean() {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Object> param = new ArrayList<>();
        Book book = new Book("", "文学", "中国出啊版社", "今天", "", 1.0, 2, null, null);
        System.out.println(bookDao.getSqlFromBean(book, "*", param));
        System.out.println(param);
    }

    @Test
    void searchBooksConditionCount() {
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book("", "科", "社", "", "", 1.0, 2, null, null);
        System.out.println(bookDao.searchBooksConditionCount(book));
    }

    @Test
    void searchBooksConditionPages() {
        BookDaoImpl bookDao = new BookDaoImpl();
        int pageSize = 1;
        int pageNo = 1;
        Book book = new Book("", "科", "社", "", "", 1.0, 2, null, null);
        List<Book> books1 = bookDao.searchBooksConditionPages(book, pageNo, pageSize);
        List<Book> books2 = bookDao.searchBooksConditionPages(book, pageNo + 1, pageSize);
        System.out.println(books1);
        System.out.println("---------");
        System.out.println(books2);
    }

    @Test
    void getRandomBookFromList() {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> randomBookFromList = bookDao.getRandomBookFromList(5);
        System.out.println(randomBookFromList);
    }
}