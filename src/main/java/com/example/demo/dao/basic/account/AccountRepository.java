package com.example.demo.dao.basic.account;

import com.example.demo.model.basic.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name:springbootdemo
 * File Name:AccountRepository
 * Package Name:com.example.demo.dao.basic.account
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    @Query(value = "SELECT model from AccountModel model where accountId=:accountId")
    AccountModel findById(int accountId);

    @Query(value = "SELECT model from AccountModel model where accountName=:accountName and accountId=:accountId")
    AccountModel queryModel(@Param("accountId") int id, @Param("accountName") String accountName);

    AccountModel save(AccountModel accountModel);
}
