package com.cskaoyan14th.bean.shiro;

import java.util.List;

public class AuthorDataThree {
    private String id;
    private String label;
    List<AuthorFour> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<AuthorFour> getChildren() {
        return children;
    }

    public void setChildren(List<AuthorFour> children) {
        this.children = children;
    }
}
