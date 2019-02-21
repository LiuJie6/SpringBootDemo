package com.example.demo.service.basic.account.impl;

import com.example.demo.dao.auth.accountrole.AccountRoleRepository;
import com.example.demo.dao.auth.role.RoleRepository;
import com.example.demo.dao.basic.account.AccountRepository;
import com.example.demo.model.auth.AccountRoleModel;
import com.example.demo.model.auth.RoleModel;
import com.example.demo.model.basic.AccountModel;
import com.example.demo.service.basic.account.api.IAccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    @Resource(name = "roleRepository")
    private RoleRepository roleRepository;


    @Resource(name = "accountRoleRepository")
    private AccountRoleRepository accountRoleRepository;

    @Override
    public AccountModel findById(int id) throws Exception {
        return this.accountRepository.findById(id);
    }

    @Override
    public AccountModel queryModel(int id, String accountName) {
        return this.accountRepository.queryModel(id, accountName);
    }

    @Override
    public AccountModel save(String accountName, String accountPassword, long roleId) throws Exception {

        RoleModel roleModel = this.roleRepository.findByRoleId(roleId);
        if (roleModel == null) {
            throw new Exception("角色不存在");
        }

        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(accountName);
        accountModel.setAccountPassword(accountPassword);
        accountModel.setCreateTime(Timestamp.from(Instant.now()));
        accountModel.setUpdateTime(Timestamp.from(Instant.now()));

        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountModel(accountModel);
        accountRoleModel.setRoleModel(roleModel);
        accountRoleModel.setCreateTime(Timestamp.from(Instant.now()));
        accountRoleModel.setUpdateTime(Timestamp.from(Instant.now()));
        this.accountRoleRepository.save(accountRoleModel);

        //return this.accountRepository.save(accountModel);
        return accountModel;
    }

    @Override
    public List<AccountModel> queryModels(String accountName, String roleName, int pageIndex, int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize, Sort.Direction.DESC);

        Specification<AccountRoleModel> specification = new Specification<AccountRoleModel>() {
            @Override
            public Predicate toPredicate(Root<AccountRoleModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(accountName)) {
                    Join<AccountModel, AccountRoleModel> join = root.join("accountModel", JoinType.LEFT);
                    list.add(criteriaBuilder.like(join.<AccountModel>get("accountModel").get("accountName").as(String.class), "%" + accountName + "%"));
                }
                if (StringUtils.isNotBlank(roleName)) {
                    Join<RoleModel, AccountRoleModel> join = root.join("roleModel", JoinType.LEFT);
                    list.add(criteriaBuilder.like(join.<RoleModel>get("roleModel").get("roleName").as(String.class), "%" + roleName + "%"));
                }
                Predicate[] pre = new Predicate[list.size()];
                criteriaQuery.where(list.toArray(pre));
                return criteriaBuilder.and(list.toArray(pre));
            }
        };
        Page<AccountRoleModel> accountRoleModels = this.accountRoleRepository.findAll(specification, pageable);
        List<AccountModel> accountModelList = new ArrayList<>();
        for (AccountRoleModel accountRoleModel : accountRoleModels) {
            accountModelList.add(accountRoleModel.getAccountModel());
        }
        return accountModelList;
    }


}
