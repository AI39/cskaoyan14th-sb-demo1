package com.cskaoyan14th.vo;

import com.cskaoyan14th.bean.Topic;

import java.util.Arrays;

public class TopicDetail {

    Topic topic;

    String[] goods;

    public TopicDetail() {
    }

    public TopicDetail(Topic topic, String[] goods) {
        this.topic = topic;
        this.goods = goods;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "TopicDetail{" +
                "topic=" + topic +
                ", goods=" + Arrays.toString(goods) +
                '}';
    }
}
