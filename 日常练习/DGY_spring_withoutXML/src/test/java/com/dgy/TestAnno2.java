package com.dgy;

import com.config.AnnoConfig;
import com.dgy.domain.Account;
import com.dgy.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Date: 2019/6/25
 * Time: 20:01
 * Author: vincent-Dou
 * Description：
 */
public class TestAnno2 {
    public static void main(String[] args) {
        ApplicationContext acx = new AnnotationConfigApplicationContext(AnnoConfig.class);
        AccountServiceImpl accountService = acx.getBean(AccountServiceImpl.class);
        List<Account> lists = accountService.finAll();
        for (Account a : lists){
            System.out.println(
                    a
            );
        }
    }
}
