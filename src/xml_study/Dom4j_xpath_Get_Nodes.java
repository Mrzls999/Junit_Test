package xml_study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * 得到所有有name属性的属性值
 */
public class Dom4j_xpath_Get_Nodes {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/xml_study/tt.xml");
        List<Node> name_Nodes = read.selectNodes("//name");//注意此处的泛型
        for (Node name_node : name_Nodes) {
            String text = name_node.getText();
            System.out.println(text);
        }
    }
}
