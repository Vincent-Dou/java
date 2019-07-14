package com.dgy.services;

import com.dgy.dao.AdministerDao;
import com.dgy.pojo.Administer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 2019/7/11
 * Time: 14:18
 * Author: vincent-Dou
 * Description：
 */
@Service
public class AdministerServices {

    @Autowired
    AdministerDao administerDao;

    public Administer findAdminByid(String adminid) {
        return administerDao.findAdministerByAccount(adminid);
    }
}
