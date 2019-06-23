package com.dgy;

import com.dgy.domain.Account;
import com.dgy.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Date: 2019/6/23
 * Time: 16:11
 * Author: vincent-Dou
 * Description：
 */
public class test {
    ApplicationContext acx;
    IAccountService accountService;
    @Before
    public void before(){
        acx = new ClassPathXmlApplicationContext("spring.xml");
        accountService = acx.getBean(IAccountService.class);
    }
    @Test
    public void testFindAll(){
        List<Account> list = accountService.finAll();
        for(Account account : list){
            System.out.println(account);
        }
    }
    @Test
    public void testInsert(){
        Account a = new Account();
        a.setName("helelo");
        a.setMoney(100.2F);
        accountService.insertAccount(a);
    }
}
