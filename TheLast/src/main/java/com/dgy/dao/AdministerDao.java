package com.dgy.dao;

/**
 * Date: 2019/7/11
 * Time: 16:36
 * Author: vincent-Dou
 * Description：
 */
import com.dgy.pojo.Administer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Date: 2019/7/1
 * Time: 10:21
 * Author: vincent-Dou
 * Description：
 */
@Repository
public interface AdministerDao {
    /**
     * 由账号查出Administer
     * @return
     */
    @Select("select * from administer where admin_account=#{bookid}")
    Administer findAdministerByAccount(String account);
}
