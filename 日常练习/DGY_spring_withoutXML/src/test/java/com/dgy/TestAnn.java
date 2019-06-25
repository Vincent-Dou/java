package com.dgy;

import com.config.AnnoConfig;
import com.dgy.domain.Account;
import com.dgy.service.impl.AccountServiceImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Date: 2019/6/25
 * Time: 14:21
 * Author: vincent-Dou
 * Description：
 */
public class TestAnn {
    public static void main(String[] args) {
        ApplicationContext acx = new AnnotationConfigApplicationContext(AnnoConfig.class);
        AccountServiceImpl accountService = (AccountServiceImpl) acx.getBean("accountServiceImpl");
        List<Account> list = accountService.finAll();
        for(Account a : list){
            System.out.println(a);
        }
        Account account = new Account();
        account.setName("brige");
        account.setMoney(56f);
        accountService.insertAccount(account);
        System.out.println("成功");
    }

    @Test
    public void test1(){
        ApplicationContext acx = new AnnotationConfigApplicationContext(AnnoConfig.class);
        QueryRunner queryRunner1 = acx.getBean(QueryRunner.class);
        QueryRunner queryRunner2 = acx.getBean(QueryRunner.class);
        System.out.println(queryRunner1 == queryRunner2);
    }
}
