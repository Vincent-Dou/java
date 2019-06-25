package com.dgy;

import com.dgy.domain.Account;
import com.dgy.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Date: 2019/6/25
 * Time: 12:54
 * Author: vincent-Dou
 * Description：
 */
public class TestAccount {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) acx.getBean("accountServiceImpl");
//        AccountServiceImpl accountService = acx.getBean(AccountServiceImpl.class);
        List<Account> list = accountService.finAll();
        for(Account a : list){
            System.out.println(a);
        }
    }
}
