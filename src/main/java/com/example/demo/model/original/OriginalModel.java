package com.example.demo.model.original;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Project Name:springbootdemo
 * File Name:OriginalModel
 * Package Name:com.example.demo.model.original
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@MappedSuperclass         //该注解表明该类不会再数据库中生成表，但该类的字段会出现在子类的表中
public class OriginalModel implements Serializable{

}
