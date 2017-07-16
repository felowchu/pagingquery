package club.bestchu.utils;

import java.util.List;

/**
 * Created by bestchu on 2017/7/16.
 */
public class PageBean<T> {
    private int currentPage = 1;
    private int pageCount = 4;
    private int totalCount;
    private int totalPage;
    private List<T> pageDate;

    public int getTotalPage(){
        if(totalCount % pageCount == 0)
            totalPage = totalCount/pageCount;
        else
            totalPage = totalCount/pageCount + 1;
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageDate() {
        return pageDate;
    }

    public void setPageDate(List<T> pageDate) {
        this.pageDate = pageDate;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }
}
