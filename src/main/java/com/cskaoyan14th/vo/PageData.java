package com.cskaoyan14th.vo;

import java.util.List;

public class PageData<T> {

    List<T> data;
    long count;



    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public PageData() {
    }

    public PageData(List<T> data, long count) {
        this.data = data;
        this.count = count;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "data=" + data +
                ", count=" + count +
                '}';
    }
}
