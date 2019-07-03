package com.cskaoyan14th.vo;

import java.util.List;

public class Page<T> {
    List<T> items;
    int total;

    public Page() {
    }

    public Page(List<T> items, int total) {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
