package com.cskaoyan14th.bean.shiro;

import java.util.List;

public class AuthorDataOne {
    private List<AuthorDataTwo> systemPermissions;
    private List<String> assignedPermissions;

    public List<AuthorDataTwo> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<AuthorDataTwo> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }

    public List<String> getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List<String> assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }
}
