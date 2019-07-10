package com.cskaoyan14th.bean;

import java.util.Arrays;
import java.util.List;

public class CommentList {

    List<CommentData> data;

    int count;

    int currentPage;


    public CommentList() {
    }

    public CommentList(List<CommentData> data, int count, int currentPage) {
        this.data = data;
        this.count = count;
        this.currentPage = currentPage;
    }

    public List<CommentData> getData() {
        return data;
    }

    public void setData(List<CommentData> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "CommentList{" +
                "data=" + data +
                ", count=" + count +
                ", currentPage=" + currentPage +
                '}';
    }
}
