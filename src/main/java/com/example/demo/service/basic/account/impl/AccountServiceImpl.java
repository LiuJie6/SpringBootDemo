package com.example.demo.service.basic.account.impl;

import com.example.demo.dao.basic.account.AccountRepository;
import com.example.demo.model.basic.AccountModel;
import com.example.demo.service.basic.account.api.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Project Name:springbootdemo
 * File Name:AccountServiceImpl
 * Package Name:com.example.demo.service.basic.account.impl
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountRepository")
    private AccountRepository accountRepository;

    @Override
    public AccountModel findById(int id) throws Exception {
        return this.accountRepository.findById(id);
    }

    @Override
    public AccountModel queryModel(int id, String accountName) {
        return this.accountRepository.queryModel(id, accountName);
    }

    @Override
    public AccountModel save(String accountName, String accountPassword) throws Exception {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(accountName);
        accountModel.setAccountPassword(accountPassword);
        accountModel.setCreateTime(Timestamp.from(Instant.now()));
        accountModel.setUpdateTime(Timestamp.from(Instant.now()));
        return this.accountRepository.save(accountModel);
    }


}
