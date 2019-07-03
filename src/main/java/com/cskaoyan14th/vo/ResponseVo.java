package com.cskaoyan14th.vo;

public class ResponseVo<T> {
    int errno;
    T data;
    String errmsg;

    public ResponseVo() {
    }

    public ResponseVo(int errno, T data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
