package com.example.demo.dao.hibernate.basic.account.api;

import com.example.demo.model.api.account.AccountResultModel;
import com.example.demo.model.auth.RoleModel;
import com.example.demo.model.basic.AccountModel;

import java.util.List;

/**
 * Project Name:springbootdemo
 * File Name:IAccountDao
 * Package Name:com.example.demo.dao.hibernate.basic.account.api
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IAccountDao {

    void saveModel(AccountModel accountModel) throws Exception;

    List<AccountResultModel> queryModels(AccountModel accountModel, RoleModel roleModel) throws Exception;
}
