package com.example.demo.dao.auth.accountrole;

import com.example.demo.model.auth.AccountRoleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springbootdemo
 * File Name:AccountRoleRepository
 * Package Name:com.example.demo.dao.auth.accountrole
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("accountRoleRepository")
public interface AccountRoleRepository extends JpaRepository<AccountRoleModel,Integer>{

    AccountRoleModel save(AccountRoleModel accountRoleModel);

    Page<AccountRoleModel> findAll(Specification<AccountRoleModel> specification, Pageable pageable);
}
