package com.example.demo.model.auth;

import com.example.demo.model.basic.AccountModel;
import com.example.demo.model.original.OriginalModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:springbootdemo
 * File Name:AccountRoleModel
 * Package Name:com.example.demo.model.auth
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "account_role")
public class AccountRoleModel extends OriginalModel{

    private long accountRoleId;
    private AccountModel accountModel;
    private RoleModel roleModel;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_role_id")
    public long getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(long accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AccountRoleModel{" +
                "accountRoleId=" + accountRoleId +
                ", accountModel=" + accountModel +
                ", roleModel=" + roleModel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
