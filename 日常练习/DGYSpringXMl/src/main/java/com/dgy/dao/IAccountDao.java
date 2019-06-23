package com.dgy.dao;

import com.dgy.domain.Account;

import java.util.List;

/**
 * Date: 2019/6/23
 * Time: 15:10
 * Author: vincent-Dou
 * Description：
 */
public interface IAccountDao {
    //查找所有
    List<Account> finAll();
    //查找一个
    Account findOndById(int id);
    //插入
    void insertAccount(Account account);
    //删除一个
    void deleAccount(int id);
    //修改一个
    void updateAccount(Account account);
}
