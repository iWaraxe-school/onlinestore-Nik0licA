package bg.coherent.store;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class XmlParser {

    public static HashMap<String, String> getConfig() {

        HashMap<String, String> sortMap = new LinkedHashMap<>();
        File xmlFile = new File("C:\\Users\\AleksandarNikolic\\onlinestore-Nik0licA\\store\\resources\\config.xml");

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList sortingNodeList = document.getElementsByTagName("sort").item(0).getChildNodes();

            for (int i = sortingNodeList.getLength()-1; i >= 0 ; i--) {
                if (sortingNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    sortMap.put(sortingNodeList.item(i).getNodeName(), sortingNodeList.item(i).getTextContent());
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return sortMap;
    }


}
