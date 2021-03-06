package com.dgy.domain;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Date: 2019/7/1
 * Time: 9:55
 * Author: vincent-Dou
 * Description：读者实体类
 */
@Component
public class Reader {
    private Integer readerid;
    private String readername;
    private String password;
    private String readerdept;

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReaderdept() {
        return readerdept;
    }

    public void setReaderdept(String readerdept) {
        this.readerdept = readerdept;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerid=" + readerid +
                ", readername='" + readername + '\'' +
                ", password='" + password + '\'' +
                ", readerdept='" + readerdept + '\'' +
                '}';
    }
}
