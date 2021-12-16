package org.liujiazhen.poi.entity;

import java.util.List;

public class JsonRootBean {

    private int pageSize;
    private int currentPage;
    private int pageCount;
    private int startIndex;
    private int endIndex;
    private int priviousPage;
    private int nextPage;
    private int count;
    private boolean isPriviousPage;
    private boolean isNextPage;
    private List<SalaryModel> list;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setPriviousPage(int priviousPage) {
        this.priviousPage = priviousPage;
    }

    public int getPriviousPage() {
        return priviousPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setIsPriviousPage(boolean isPriviousPage) {
        this.isPriviousPage = isPriviousPage;
    }

    public boolean getIsPriviousPage() {
        return isPriviousPage;
    }

    public void setIsNextPage(boolean isNextPage) {
        this.isNextPage = isNextPage;
    }

    public boolean getIsNextPage() {
        return isNextPage;
    }

    public void setList(List<SalaryModel> list) {
        this.list = list;
    }

    public List<SalaryModel> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", priviousPage=" + priviousPage +
                ", nextPage=" + nextPage +
                ", count=" + count +
                ", isPriviousPage=" + isPriviousPage +
                ", isNextPage=" + isNextPage +
                ", list=" + list +
                '}';
    }
}