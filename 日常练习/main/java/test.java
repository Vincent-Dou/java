import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;
/**
 * Auther:vincent-Dou
 * Date: 2019/6/1
 * Time: 10:30
 * Description：
 */

/**
 * 1. getRootElement() 获取根节点元素
 * 2. elements("标签名称"); 获取同名标签的元素
 * 3. elements(), 所有标签元素
 *
 */
public class test {
    public static void main(String[] args) throws DocumentException {
        //创建解析器对象
        SAXReader reader =new SAXReader();
        //获取对象
        Document doc = reader.read(test.class.getClassLoader().getResource("test.xml"));
        System.out.println(doc);

        //获取根节点的元素
        Element rooelment = doc.getRootElement();
        System.out.println(rooelment.getName());

        //获取子标签对象
        Element conElem = rooelment.element("contact");
        System.out.println(conElem);
        System.out.println("==================================");
        List<Element> list = rooelment.elements();
        for(Element i : list){
            System.out.println(i);
        }
        System.out.println("=====================");
        //获取所有的子标签对象
        List<Element> list1 = rooelment.elements();
        for(Element i : list){
            System.out.println(i);
        }
//        Element e = doc.getRootElement().element("contavt").element("name");
    }
}
