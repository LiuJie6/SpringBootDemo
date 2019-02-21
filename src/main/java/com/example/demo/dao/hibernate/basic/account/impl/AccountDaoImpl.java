package com.example.demo.dao.hibernate.basic.account.impl;

import com.example.demo.dao.hibernate.basic.account.api.IAccountDao;
import com.example.demo.model.api.account.AccountResultModel;
import com.example.demo.model.auth.RoleModel;
import com.example.demo.model.basic.AccountModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:springbootdemo
 * File Name:AccountDaoImpl
 * Package Name:com.example.demo.dao.hibernate.basic.account.impl
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("accountDao")
@Transactional
public class AccountDaoImpl implements IAccountDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void saveModel(AccountModel accountModel) throws Exception {
        try {
            Session session = this.getSession();
            session.save(accountModel);
            session.flush();
            session.clear();
        } catch (Exception e) {
            throw new Exception("实体对象保存错误");
        }
    }

    @Override
    public List<AccountResultModel> queryModels(AccountModel accountModel, RoleModel roleModel) throws Exception {
        Session session = this.getSession();
        try {
            Query query = session.createQuery(this.getSelect(accountModel, roleModel));
            List list = query.list();
            List<AccountResultModel> accountResultModelList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Object o = list.get(i);
                Object[] values = (Object[]) o;
                accountResultModelList.add(new AccountResultModel((Long) values[0],
                        values[1].toString(),
                        (Long) values[2],
                        values[3].toString(),
                        (Long) values[4]));
            }
            return accountResultModelList;
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
    }

    private String getSelect(AccountModel accountModel, RoleModel roleModel) {
        String hql = "select model1.accountId,model1.accountName,model2.roleId,model2.roleName,model3.accountRoleId from" +
                " AccountModel model1,RoleModel model2,AccountRoleModel model3 where model1.accountId = model3.accountModel.accountId" +
                " and model2.roleId=model3.roleModel.roleId";
        if (accountModel == null && roleModel == null) {
            return hql;
        } else {
            if (accountModel != null) {
                if (accountModel.getAccountName() != null && !accountModel.getAccountName().isEmpty()) {
                    hql += " and model1.accountName like '%" + accountModel.getAccountName() + "%'";
                }
            }
            if (roleModel != null) {
                if (roleModel.getRoleName() != null && !roleModel.getRoleName().isEmpty()) {
                    hql += " and model2.roleName like '%" + roleModel.getRoleName() + "%'";
                }
            }
            return hql;
        }
    }

    /**
     * 获取hibernate session
     *
     * @return 获取的session
     */
    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
