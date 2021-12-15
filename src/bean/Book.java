package bean;

import java.sql.Date;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 图书的JavaBean封装
 * @date 2021-12-03 19:50:03
 */
public class Book {
    private String number;//期刊编号
    private String sortBook;//期刊分类
    private String publisher;//出版社
    private String name; //期刊名称
    private String author;//作者
    private Double prices;//价格
    private Integer remainNumber;//剩余库存数量
    private Date publishData;//精确到天 出版时间
    private String src;//图书照片

    public Book(String number, String sortBook, String publisher, String name, String author, Double prices, Integer remainNumber, Date publishData, String src) {
        this.number = number;
        this.sortBook = sortBook;
        this.publisher = publisher;
        this.name = name;
        this.author = author;
        this.prices = prices;
        this.remainNumber = remainNumber;
        this.publishData = publishData;
        this.src = src;
    }

    /**
     * @Description: 必须提供空参构造方法，否则QueryRunner无法创建对象，并且注入属性
     * @Author: BaiYZ
     * @Date: 2021/12/4 10:08
     * @return: null
     */
    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "number='" + number + '\'' +
                ", sortBook='" + sortBook + '\'' +
                ", publisher='" + publisher + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", prices=" + prices +
                ", remainNumber=" + remainNumber +
                ", publishData=" + publishData +
                ", src='" + src + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSortBook() {
        return sortBook;
    }

    public void setSortBook(String sortBook) {
        this.sortBook = sortBook;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Integer getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(Integer remainNumber) {
        this.remainNumber = remainNumber;
    }

    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}