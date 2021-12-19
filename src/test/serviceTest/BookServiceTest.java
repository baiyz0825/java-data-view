package test.serviceTest;

import bean.Book;
import bean.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import service.imp.BookServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author BaiYZ
 * @version 1.0
 * @date 2021/12/8
 * @description
 */
class BookServiceTest {

    @Test
    void searchBookAll() {
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> books = bookService.searchBookAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void searchBookById() {
    }

    @Test
    void searchBookByName() {
    }

    @Test
    void testSearchBookAll() {
    }

    @Test
    void searchBookBySort() {
    }

    @Test
    void deleteBookById() {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.deleteBookById("98745632");

    }

    @Test
    void deleteBookByName() {
    }

    @Test
    void updateBook() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date utilsDate = null;
        try {
            utilsDate = format.parse("2018-10-2");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(utilsDate.getTime());
        Book book = new Book("22626", "BCD", "ad", "双方都是", "对方是否的", 266.1, 3, date, "");
        book.setSrc("sfd/fsdfd/ads/");
        System.out.println(book.getSrc());
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.updateBook(book);
    }

    @Test
    void addBook() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date utilsDate = null;
        try {
            utilsDate = format.parse("2018-10-2");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(utilsDate.getTime());
        Book book = new Book("22626", "BCD", "ad", "我叫小黄", "零一二萨尼", 266.1, 3, date, "");
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.addBook(book);
    }

    @Test
    void pages() {
        BookServiceImpl bookService = new BookServiceImpl();
        Page<Book> page = bookService.pages(1, Page.defaultPageSize);
        System.out.println(page);
    }

    @Test
    void searchBookPage() {
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = new Book("", "科", "社", "", "", 1.0, 2, null, "");
        System.out.println(bookService.searchBookPage(book, 1, 1).getPageData());
        System.out.println("----------");
        System.out.println(bookService.searchBookPage(book, 2, 1).getPageData());
    }
}