package xml_study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * 使用dom4j获取某标签下的所有内容
 */
public class Dom4j_case02_Get_Label_All_content {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/xml_study/tt.xml");
        Element rootElement = read.getRootElement();
        Element user1 = rootElement.element("user1");
        List<Element> elements = user1.elements();//这一步加上了泛型，吊
        for (Element element : elements) {
            String text = element.getText();
            System.out.println(element.getName()+":"+text);
        }
    }
}
