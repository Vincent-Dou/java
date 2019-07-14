package com.dgy.dao;

/**
 * Date: 2019/7/11
 * Time: 16:19
 * Author: vincent-Dou
 * Description：
 */


import com.dgy.pojo.AdminDocViewVO;
import com.dgy.pojo.Document;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

@Repository
public interface DocumentDao {
    /**
     * 查询所有的档案
     * @return
     */
    @Select("select id,e_name,e_sex,e_sector_name,e_position,e_register_date, doc_check_status,doc_status from shixun.document")
    List<AdminDocViewVO> findAllDocument();

    /**
     * 查询完整的档案
     */
    @Select("select * from shixun.document where id=#{id}")
    Document findCompleteDocument(Integer id);

    /**
     * 根据id查询document
     * @param id
     * @return
     */
    @Select("select id,e_name,e_sex,e_sector_name,e_position,e_register_date, doc_check_status,doc_status from shixun.document where id =#{id}")
    AdminDocViewVO findDocumentById(Integer id);


    /**
     * 根据审核状态，档案状态，建档时间查询记录
     */
    @Select("select id,e_name,e_sex,e_sector_name,e_position,e_register_date, doc_check_status,doc_status from shixun.document WHERE e_register_date BETWEEN #{left_date} AND #{right_date} and doc_status=#{doc_status} and doc_check_status=#{doc_check_status}")
    List<AdminDocViewVO> findDocumentByCondition(@Param("left_date") Date left_date, @Param("right_date") Date right_date, @Param("doc_status") String doc_status, @Param("doc_check_status") String doc_check_status);


    /**
     * 插入document
     * @param document
     */
    @Insert("INSERT INTO `shixun`.`document` (`id`, `e_name`, `e_sex`, `e_mail`, `sec_no`, `vocation_no`, `e_phone`, `e_address`, `e_id`, `e_census`, `e_status`, `e_social_cardid`, `e_gradual_college`, `e_education_background`, `e_specialty`, `e_salary`, `e_bank`, `e_account`, `e_registrant`, `e_register_date`, `e_experience`, `e_relation_background`, `e_remark`, `e_picture`, `e_accessory_path`, `e_sector_name`, `e_position`, `doc_no`, `doc_status`, `doc_check_status`) " +
            "VALUES (#{id}, #{e_name}, #{e_sex}, #{e_mail}, #{sec_no}, #{vocation_no}, #{e_phone}, #{e_address}, #{e_id}, #{e_census}, #{e_status}, #{e_social_cardid}, #{e_gradual_college}, #{e_education_background}, #{e_specialty}, #{e_salary}, #{e_bank}, #{e_account}, #{e_registrant}, #{e_register_date}, #{e_experience}, #{e_relation_background}, #{e_remark}, #{e_picture}, #{e_accessory_path}, #{e_sector_name}, #{e_position}, #{doc_no}, #{doc_status}, #{doc_check_status});")
    void insertDocument(Document document);

    /**
     * 删除document
     * @param id
     */

    @Delete("delete from shixun.document where id=#{id}")
    void deleteDocumentById(int id);

    /**
     * 更新document记录
     * @param document
     */
    @Update("update shixun.document set id=#{id}, e_name=#{e_name}, e_sex=#{e_sex}, e_mail=#{e_mail}, sec_no=#{sec_no}, vocation_no=#{vocation_no}, e_phone=#{e_phone}, e_address=#{e_address}, e_id=#{e_id},e_census=#{e_census}, e_status=#{e_status}, e_social_cardid=#{e_social_cardid}, e_gradual_college=#{e_gradual_college}, e_education_background=#{e_education_background}, e_specialty=#{e_specialty},e_salary=#{e_salary}, e_bank=#{e_bank}, e_account=#{e_account}, e_registrant=#{e_registrant}, e_register_date=#{e_register_date}, e_experience=#{e_experience}, e_relation_background=#{e_relation_background}, e_remark=#{e_remark}, e_picture=#{e_picture},e_accessory_path=#{e_accessory_path}, e_sector_name=#{e_sector_name}, e_position=#{e_position}, doc_no=#{doc_no}, doc_status=#{doc_status}, doc_check_status=#{doc_check_status}  where id=#{id}")
    void updateDocument(Document document);
    /**
     *设置档案检查转态为“删除”
     */
    @Update("update shixun.document set doc_check_status='deleted'  where id=#{id}")
    void setDocDeleted(Integer id);


}

