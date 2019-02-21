package com.example.demo.dao.auth.role;

import com.example.demo.model.auth.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springbootdemo
 * File Name:RoleRepository
 * Package Name:com.example.demo.dao.auth.role
 * Date:2019/2/21
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleModel,Integer>{

    @Query(value = "select model from RoleModel model where roleId=:roleId")
    RoleModel findByRoleId(@Param("roleId") long roleId);

    RoleModel save(RoleModel roleModel);
}
