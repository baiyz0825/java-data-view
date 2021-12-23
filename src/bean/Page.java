package bean;

import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 分页类，使用泛型方法，在其他的需要产生分页的情况都需要
 * @date 2021-12-09 08:29:42
 */
public class Page<T> {
    public static final int defaultPageNo = 1;
    public static final int defaultPageSize = 6;
    private Integer pageNo;//当前分页号
    private Integer pageSize;//当前分页大小
    private Integer pageCount;//当前页面总数
    private Integer recordCount;//当前总的记录数
    private List<T> pageData;//当前页面数据

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "\npageNo=" + pageNo +
                "\npageSize=" + pageSize +
                "\npageCount=" + pageCount +
                "\nrecordCount=" + recordCount +
                "\npageData=" + pageData +
                "\n}";
    }
}