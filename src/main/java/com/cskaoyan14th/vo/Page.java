package com.cskaoyan14th.vo;

import java.util.List;

public class Page<T> {
    List<T> items;
    long total;

    public Page() {
    }

    public Page(List<T> items, long total) {
        this.items = items;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Page{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
