package com.zxy.mall.entities;

import java.util.List;

public class EntityPage<T> {
    private List<T> list;//当前页数据
    private int startPage;//当前第几页
    private int pageSize;//分页的大小
    private long total;//总数据个数
    private boolean isNext;//是否有下一页

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isNext() {
        return isNext;
    }

    public void setNext(boolean next) {
        isNext = next;
    }

    @Override
    public String toString() {
        return "EntityPage{" +
                "list=" + list +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", isNext=" + isNext +
                '}';
    }
}
