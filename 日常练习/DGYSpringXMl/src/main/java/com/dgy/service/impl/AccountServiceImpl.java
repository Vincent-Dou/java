package com.dgy.service.impl;

import com.dgy.dao.impl.AccountDaoImpl;
import com.dgy.domain.Account;
import com.dgy.service.IAccountService;

import java.util.List;

/**
 * Date: 2019/6/23
 * Time: 15:18
 * Author: vincent-Dou
 * Description：
 */
public class AccountServiceImpl implements IAccountService {

    //引入dao层对服务层进行支持
    private AccountDaoImpl accountDao;

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> finAll() {
        return accountDao.finAll();
    }

    public Account findOndById(int id) {
        return accountDao.findOndById(id);
    }

    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void deleAccount(int id) {
        accountDao.deleAccount(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
