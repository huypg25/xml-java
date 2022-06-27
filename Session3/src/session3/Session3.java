/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author chungld-hanam
 */
public class Session3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Tạo factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //tạo builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            //parser xml
            Document doc = builder.parse(new FileInputStream(new File("src/session3/Catalog.xml")));
            //duyệt toàn bộ tài liệu và in ra loại node
            //NodeTypes.printNodes(doc);
           
            //thao tác với nút
            System.out.println("<" + doc.getDocumentElement().getNodeName() +">");
            NodeList cds = doc.getElementsByTagName("CD");
            for (int i = 0; i < cds.getLength(); i++) {
                NodeList items = cds.item(i).getChildNodes();
                 //đọc thuộc tính
                String attrs=" ";
                NamedNodeMap a=cds.item(i).getAttributes();
                for (int j = 0; j < a.getLength(); j++) {
                    attrs+= a.item(j).getNodeName()+"=\""+ a.item(j).getTextContent() +"\"";
                }
                System.out.println("\t<" + cds.item(i).getNodeName() + attrs +">");
                for (int j = 0; j < items.getLength(); j++) {
                    if (!items.item(j).getNodeName().equals("#text")) {
                        System.out.println("\t\t<" + items.item(j).getNodeName() + ">" + items.item(j).getTextContent() + "</" + items.item(j).getNodeName() + ">");
                    } 
                }
                System.out.println("\t</" + cds.item(i).getNodeName() + ">");
            }
             System.out.println("</" + doc.getDocumentElement().getNodeName() +">");
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
