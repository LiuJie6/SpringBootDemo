package com.example.demo.service.basic.account.api;

import com.example.demo.model.basic.AccountModel;

/**
 * Project Name:springbootdemo
 * File Name:IAccountService
 * Package Name:com.example.demo.service.basic.account.api
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IAccountService {

    AccountModel findById(int id) throws Exception;

    AccountModel queryModel(int id, String accountName) throws Exception;

    AccountModel save(String accountName, String accountPassword) throws Exception;
}
