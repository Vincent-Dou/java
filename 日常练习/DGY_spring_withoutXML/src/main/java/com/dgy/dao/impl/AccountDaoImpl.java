package com.dgy.dao.impl;

import com.dgy.dao.IAccountDao;
import com.dgy.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Date: 2019/6/23
 * Time: 15:11
 * Author: vincent-Dou
 * Description：
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    QueryRunner qr;

//    public void setQr(QueryRunner qr) {
//        this.qr = qr;
//    }

    public List<Account> finAll() {
        try {
            return qr.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Account findOndById(int id) {
        try {
            return qr.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void insertAccount(Account account) {
        try {
            qr.update("insert into account(name, money)values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleAccount(int id) {
        try {
            qr.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            qr.update("update account set name = ?, moner = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
