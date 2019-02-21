package com.example.demo.service.basic.account.api;

import com.example.demo.model.basic.AccountModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    AccountModel save(String accountName, String accountPassword, long roleId) throws Exception;

    Page<AccountModel> queryModels(String accountName, String roleName, int pageIndex, int pageSize);
}
