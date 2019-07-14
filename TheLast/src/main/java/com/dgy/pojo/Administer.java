package com.dgy.pojo;

/**
 * Date: 2019/7/9
 * Time: 10:03
 * Author: vincent-Dou
 * Description：
 */
public class Administer {
    private String admin_account;
    private String admin_password;
    private String admin_role;
    public String getAdmin_account() {
        return admin_account;
    }
    public void setAdmin_account(String admin_account) {
        this.admin_account = admin_account;
    }
    public String getAdmin_password() {
        return admin_password;
    }
    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    public String getAdmin_role() {
        return admin_role;
    }
    public void setAdmin_role(String admin_role) {
        this.admin_role = admin_role;
    }

    @Override
    public String toString() {
        return "Administer{" +
                "admin_account='" + admin_account + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_role='" + admin_role + '\'' +
                '}';
    }
}
