package com.cskaoyan14th.vo;

import java.util.HashMap;
import java.util.Map;

public class ResponseMapVo {

    int errno;

    Map<String, Object> data = new HashMap<>();

    String errmsg;

    public ResponseMapVo() {
    }

    public ResponseMapVo(int errno, Map<String, Object> data, String errmsg) {
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
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

        return "ResponseMapVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
