import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;


/**
 * Auther:vincent-Dou
 * Date: 2019/6/1
 * Time: 12:07
 * Description：
 */
public class testxml {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(testxml.class.getClassLoader().getResource("test.xml"));
        Element rootEle = document.getRootElement();
        getEle(rootEle);
//        List<Element> list = rootEle.elements();
//        System.out.println(list.size());
//        System.out.println(list.get(0).getText());
//        System.out.println(list.get(0).isTextOnly());
//        List<Element> list1 = list.get(0).elements();
//        System.out.println(list1.get(0).isTextOnly());


        //        List<Person> personList = new ArrayList<Person>();
//        Element rootele = document.getRootElement();
//        List<Element> list = rootele.elements("contact");
//        for(Element element : list){
//            Person person = new Person();
//            person.setId(Integer.valueOf(element.attributeValue("id")));
//            person.setName(element.elementText("name"));
//            person.setName(element.elementText("gender"));
//            person.setPhone(element.elementText("phone"));
//            person.setEmil(element.elementText("email"));
//            person.setAddress(element.elementText("address"));
//            personList.add(person);
//        }
//        for(Person person : personList){
//            System.out.println(person);
//        }
    }
    public static void getEle(Element element){
        if(element.isTextOnly()){
            System.out.println(element.getText());
        }else{
            List<Element> list = element.elements();
            for(Element element1 : list){
                if(element1.isTextOnly()){
                    System.out.println(element1.getText());
                }else {
                    getEle(element1);
                }
            }
        }
    }
}
