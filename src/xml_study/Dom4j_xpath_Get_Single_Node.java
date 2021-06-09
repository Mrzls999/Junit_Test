package xml_study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4j_xpath_Get_Single_Node {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/xml_study/tt.xml");
        Node node = read.selectSingleNode("//name[@id='user1_name_Id']");
        String text = node.getText();
        System.out.println(text);
    }
}
