/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ADMIN
 */
public class Session03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //tạo factory
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            //tạo documentbuilder
            DocumentBuilder builder=factory.newDocumentBuilder();
            //phân tích
            Document doc=builder.parse("src/session03/catalog.xml");
            //lấy được phần tử gốc
            Node root=doc.getDocumentElement();
            System.out.println("<"+root.getNodeName()+">");
            //lấy tất cả các phần tử cd trong catalog
            NodeList cds=root.getChildNodes();
            for (int i = 0; i < cds.getLength(); i++) {
                //lấy được từng cd
                Node cd=cds.item(i);
                if(!cd.getNodeName().equals("#text"))
                {
                     //lấy attribute
                    String id=cd.getAttributes().item(0).getTextContent();
                    System.out.println("<"+cd.getNodeName()+" id=\""+id+"\">");
                }
                //lấy tất cả phần tử con trong cd
                NodeList childcd=cd.getChildNodes();
                //duyệt qua phần tử con
                for (int j = 0; j < childcd.getLength(); j++) {
                    Node child=childcd.item(j);
                    if(!child.getNodeName().equals("#text"))
                    {
                        System.out.print("\t<"+child.getNodeName()+">");
                        System.out.print(child.getTextContent());
                        System.out.println("</"+child.getNodeName()+">");
                    }
                }
                if(!cd.getNodeName().equals("#text"))
                    System.out.println("</"+cd.getNodeName()+">");
            }
              System.out.println("</"+root.getNodeName()+">");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Session03.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
