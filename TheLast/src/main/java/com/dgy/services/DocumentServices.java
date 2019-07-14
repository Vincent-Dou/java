package com.dgy.services;

import com.dgy.dao.DocumentDao;
import com.dgy.pojo.AdminDocViewVO;
import com.dgy.pojo.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Date: 2019/7/11
 * Time: 14:18
 * Author: vincent-Dou
 * Description：
 */

@Service
public class DocumentServices {

    @Autowired
    DocumentDao documentDao;

    public AdminDocViewVO findOneDocById(int docid) {
        return documentDao.findDocumentById( docid);
    }

    public void delDocById(int docid) {
        documentDao.deleteDocumentById(docid);
    }

    public void updateDoc(Document document) {
        documentDao.updateDocument(document);
    }

    public List<AdminDocViewVO> findAllDocVo() {
        return documentDao.findAllDocument();
    }

    public void addDoc(Document document) {
        documentDao.insertDocument(document);
    }

    public Document findOneCompleteDocById(int parseInt) {
        return    documentDao.findCompleteDocument(parseInt);
    }
    public List<AdminDocViewVO> findByCondition(Date left_date, Date right_date, String doc_status, String doc_check_status){
        System.out.println("*************************************************");
        System.out.println(left_date+" left_date");
        System.out.println(right_date+" right_date");
        System.out.println(doc_status+" doc_status");
        System.out.println(doc_check_status+" doc_check_status");
        System.out.println("**************************************************");

           return documentDao.findDocumentByCondition(left_date,right_date,doc_status,doc_check_status);
    }
    public void setDocDeleted(int docid){
        documentDao.setDocDeleted(docid);
    }

}
