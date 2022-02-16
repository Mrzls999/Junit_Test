package xml_study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j获取某标签下的某个内容
 */
public class Dom4j_case01_Get_Label_Content {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();//创建一个对象，用来读取xml文档，dom4j已经对dom和sax方式进行了优化
        Document read = saxReader.read("src/xml_study/tt.xml");
        Element rootElement = read.getRootElement();//得到根对象
        Element user1 = rootElement.element("user1");//得到user1
        Element user1_name = user1.element("name");
        String text = user1_name.getText();//得到name里边的值
        System.out.println(text);//输出name里的值
    }

}
