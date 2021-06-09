package xml_study;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 获得xml标签属性值
 */
public class Dom4j_case03_Get_label_attribute {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/xml_study/tt.xml");
        Element rootElement = read.getRootElement();
        Element user1 = rootElement.element("user1");
        String id = user1.attributeValue("id");
        System.out.println(id);
    }
}
