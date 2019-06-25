package com.dgy;

import com.config.AnnoConfig;
import com.dgy.domain.Account;
import com.dgy.service.impl.AccountServiceImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Date: 2019/6/25
 * Time: 14:21
 * Author: vincent-Dou
 * Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnoConfig.class)
public class TestAnn {
    @Autowired
    private AccountServiceImpl accountService = null;

    @Test
    public void test1(){
        List<Account> list = accountService.finAll();
        for (Account a : list){
            System.out.println(a);
        }
    }
}
