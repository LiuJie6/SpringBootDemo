package com.example.demo.controller.basic;

import com.example.demo.model.basic.AccountModel;
import com.example.demo.model.response.ResponseResult;
import com.example.demo.model.state.State;
import com.example.demo.service.basic.account.api.IAccountService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Project Name:springbootdemo
 * File Name:AccountManageController
 * Package Name:com.example.demo.controller.basic
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController("accountManageController")
@EnableAutoConfiguration
@RequestMapping("api/manage/account")
public class AccountManageController {

    @Resource(name = "accountService")
    private IAccountService accountService;

    @GetMapping("create")
    public Object createAccount(@RequestParam(value = "accountName") String accountName,
                                @RequestParam(value = "accountPassword") String accountPassword,
                                long roleId) throws Exception {
        try {
            AccountModel accountModel = this.accountService.save(accountName, accountPassword,roleId);
            Map<String, Object> map = new HashMap<>();
            map.put("accountModel", accountModel);
            return new ResponseResult(true, State.SUCCESS.getCode(), "", map);
        } catch (Exception e) {
            return new ResponseResult(false, State.FAILURE.getCode(), "");
        }
    }

    @PostMapping("query")
    public Object queryModel(@RequestParam(value = "accountId") int id,
                             @RequestParam(value = "accountName") String accountName) throws Exception {
        try {
            AccountModel accountModel = this.accountService.queryModel(id, accountName);
            Map<String, Object> map = new HashMap<>();
            map.put("accountModel", accountModel);
            return new ResponseResult(true, State.SUCCESS.getCode(), "", map);
        } catch (Exception e) {
            return new ResponseResult(false, State.FAILURE.getCode(), "");
        }
    }
}
