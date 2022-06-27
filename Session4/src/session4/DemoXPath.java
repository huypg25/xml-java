/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author chungld-hanam
 */
public class DemoXPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           
            //Bắt đầu load DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/session4/Catalog.xml");
            
            //Khởi tạo XPath
            XPath xPath = XPathFactory.newInstance().newXPath();
//            //Tạo chuỗi XPath
           String expression = "/CATALOG/CD/TITLE";
//            //In chuỗi
//            System.out.println(expression);
//          
//            //Compile biểu thức
//            NodeList titleNodes = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
//            //duyệt các nút và in kết quả
//            for (int i = 0; i < titleNodes.getLength(); i++) {
//                System.out.println(titleNodes.item(i).getFirstChild().getNodeValue());
//            }
            
             //Tạo chuỗi XPath khác
          //  expression = "/CATALOG/CD[contains(@Id,'1')]/TITLE";
         //  expression = "//*[contains(TITLE,'H')]/TITLE";
//          expression = "/CATALOG/CD[PRICE='10.20' and YEAR<1991]";
          expression = "/CATALOG/CD";
//
//             //In chuỗi
          System.out.println(expression);
//            //Compile biểu thức
          NodeList cdnodes = (NodeList) xPath.compile(expression).evaluate(doc.getDocumentElement(), XPathConstants.NODESET);
//            //duyệt các nút và in kết quả
            for (int i = 0; i < cdnodes.getLength(); i++) {
               Node cd=cdnodes.item(i);
                System.out.println("------------------------");
                for (int j = 0; j < cd.getChildNodes().getLength(); j++) {
                    if(cd.getChildNodes().item(j).getNodeName()!="#text")
                    {
                        System.out.println(cd.getChildNodes().item(j).getTextContent());
                    }
                }
            }
//            
//            expression = "concat(TITLE,ARTIST)";
//            System.out.println(expression);
//            for (int i = 0; i < doc.getDocumentElement().getChildNodes().getLength(); i++) {
//                String result = (String) xPath.compile(expression).evaluate(doc.getDocumentElement().getChildNodes().item(i),XPathConstants.STRING);
//                System.out.println(result);
//            }
            
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            Logger.getLogger(DemoXPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
