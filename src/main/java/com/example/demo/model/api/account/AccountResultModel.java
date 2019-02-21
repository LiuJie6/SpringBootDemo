package com.example.demo.model.api.account;

/**
 * Project Name:springbootdemo
 * File Name:AccountResultModel
 * Package Name:com.example.demo.model.api.account
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class AccountResultModel {

    private long accountId;

    private String accountName;

    private long roleId;

    private String roleName;

    private long accountRoleId;

    public AccountResultModel() {
    }

    public AccountResultModel(long accountId, String accountName, long roleId, String roleName, long accountRoleId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.accountRoleId = accountRoleId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(long accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    @Override
    public String toString() {
        return "AccountResultModel{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", accountRoleId=" + accountRoleId +
                '}';
    }
}
