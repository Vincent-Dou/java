package com.dgy.contorller;
import	java.util.ArrayList;

import com.dgy.pojo.AdminDocViewVO;
import com.dgy.pojo.Administer;
import com.dgy.pojo.Document;
import com.dgy.services.AdministerServices;
import com.dgy.services.DocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Date;
import java.util.List;

/**
 * Date: 2019/7/10
 * Time: 14:24
 * Author: vincent-Dou
 * Description：
 */

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminContorller {

    @Autowired
    AdministerServices administerServices;

    @Autowired
    DocumentServices documentServices;

    //登录
    @RequestMapping("/login")
    public String adminLogin(String adminid, String password, Model model){
        //密码为空时
        if (adminid.trim().equals("") || password.trim().equals("")||adminid==null||password==null){
            return "falied";
        }
        Administer administer = administerServices.findAdminByid(adminid);
        if(administer==null){
            return "failed";
        }
        if (adminid.equals(administer.getAdmin_account()) && password.equals(administer.getAdmin_password())){
            model.addAttribute("admin", administer);
            if(administer.getAdmin_role().equals("人事专员")){
                return "check";   //在这里跳转到专员添加档案的页面
            }
            if(administer.getAdmin_role().equals("部门经理")){
                model.addAttribute("allDocVoList", documentServices.findAllDocVo());
                return "adminview";  //此处的页面为经理去审核档案列表页面
            }
        }
        return "failed";
    }

    //此方法对应修改文档的标签
    @RequestMapping("/updateDocBut")
    public String updateDoc(String docid, Model model){
       model.addAttribute("oneCompleteDoc", documentServices.findOneCompleteDocById(Integer.parseInt(docid)));

        return "update";
        //在此处跳转到档案的详细信息页面
    }

    //此方法对应 明细 的按钮
    @RequestMapping("/oneDocView")
    public String oneDocView(String docid, Model model){
        model.addAttribute("oneCompleteDoc", documentServices.findOneCompleteDocById(Integer.parseInt(docid)));
        return "completeDoc"; //在此处跳转到档案纤细页面；
    }

    //此方法对应 删除 按钮
    @RequestMapping("/delDoc")
    public String delDoc(String docid,String check_status){
//        AtomicReference<Document> tempDocument = new AtomicReference<>(documentServices.findOneCompleteDocById(Integer.parseInt(docid)));
//        if (tempDocument.get().getE_status().equals("暂时删除")){
//            documentServices.delDocById(tempDocument.get().getId());
//            return "success";
//        }else if (tempDocument.get().getE_status().equals("正常")){
//            tempDocument.get().setDoc_status("暂时删除");
//            documentServices.updateDoc(tempDocument.get());
//            return "success";
//        }
        System.out.println("*************************");
        System.out.println("check_status:"+check_status);
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("docid:"+docid);
        System.out.println("*************************");

        if(check_status!=null&&check_status.equals("deleted")){
            documentServices.delDocById(Integer.parseInt(docid));
            return "success";
        }else{
            documentServices.setDocDeleted(Integer.parseInt(docid));
            return "success";
        }

    }
    //此方法为经理在档案的详细信息页面去更改信息
    @RequestMapping("/updateDoc")
    public String AdminUpdateDoc(Document document){
        documentServices.updateDoc(document);
        return "success";
    }
    //添加文档
    @RequestMapping("/addDoc")
    public String addDocument(Document document){
        documentServices.addDoc(document);
        return "success";
    }

    //根据id条件查询
    @RequestMapping("/findDocById")
    public String findDocByid(String docId, Model model){
        AdminDocViewVO oneDocById = documentServices.findOneDocById(Integer.parseInt(docId));
        List<AdminDocViewVO> listOftheOneDoc = new ArrayList<> ();
        listOftheOneDoc.add(oneDocById);
        model.addAttribute("allDocVoList", listOftheOneDoc);
        return "adminview";
    }

    //多条件查询
    @RequestMapping("/findByManyCondition")
    public String findByManyCondition(String doc_check_status, String doc_status, Date start_time, Date  end_time, Model model){
        System.out.println("*************************************************");
        System.out.println(doc_check_status+" doc_check_status");
        System.out.println(doc_status+" doc_status");
        System.out.println(start_time+" start_time");
        System.out.println(end_time+" end_time");
        System.out.println("**************************************************");
        List<AdminDocViewVO> documentsByCondition = documentServices.findByCondition(start_time,end_time,doc_status,doc_check_status);
        System.out.println("*************************************************");
        System.out.println(documentsByCondition);
        System.out.println("*************************************************");
        model.addAttribute("allDocVoList",documentsByCondition);
        return "adminview";
    }
}
