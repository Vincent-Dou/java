package com.dgy.pojo;

import java.sql.Date;

/**
 * Date: 2019/7/11
 * Time: 15:28
 * Author: vincent-Dou
 * Description：
 */
public class AdminDocViewVO {
    private Integer id;
    private String e_name;
    private String e_sex;
    private String e_sector_name;
    private String e_position;
    private Date e_register_date;
    private String doc_check_status;
    private String doc_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public String getE_sector_name() {
        return e_sector_name;
    }

    public void setE_sector_name(String e_sector_name) {
        this.e_sector_name = e_sector_name;
    }

    public String getE_position() {
        return e_position;
    }

    public void setE_position(String e_position) {
        this.e_position = e_position;
    }

    public Date getE_register_date() {
        return e_register_date;
    }

    public void setE_register_date(Date e_register_date) {
        this.e_register_date = e_register_date;
    }

    public String getDoc_check_status() {
        return doc_check_status;
    }

    public void setDoc_check_status(String doc_check_status) {
        this.doc_check_status = doc_check_status;
    }

    public String getDoc_status() {
        return doc_status;
    }

    public void setDoc_status(String doc_status) {
        this.doc_status = doc_status;
    }

    @Override
    public String toString() {
        return "AdminDocViewVO{" +
                "id=" + id +
                ", e_name='" + e_name + '\'' +
                ", e_sex='" + e_sex + '\'' +
                ", e_sector_name='" + e_sector_name + '\'' +
                ", e_position='" + e_position + '\'' +
                ", e_register_date=" + e_register_date +
                ", doc_check_status='" + doc_check_status + '\'' +
                ", doc_status='" + doc_status + '\'' +
                '}';
    }
}
