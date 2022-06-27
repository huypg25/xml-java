/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author chungld-hanam
 */
public class ModifyXML {

    public static void main(String[] args) {
        try {
            //Tạo factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //tạo builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            //parser xml
            Document doc = builder.parse(new FileInputStream(new File("src/session3/Catalog.xml")));
            //thêm một nút mới
            //insert(doc);
            //cập nhật
            //update(doc,"Bản tình ca"); 
            //Xóa
           delete(doc, "Bản tình cuối");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Document doc) {
        Element root = doc.getDocumentElement();

        Element cd = doc.createElement("CD");
        root.appendChild(cd);
        
        cd.setAttribute("Id", "C13");
        
        Element title = doc.createElement("TITLE");
        title.appendChild(doc.createTextNode("Bản tình ca"));
        cd.appendChild(title);

        Element artist = doc.createElement("ARTIST");
        artist.appendChild(doc.createTextNode("Đức Chung"));
        cd.appendChild(artist);

        Element country = doc.createElement("COUNTRY");
        country.appendChild(doc.createTextNode("Việt Nam"));
        cd.appendChild(country);

        Element company = doc.createElement("COMPANY");
        company.appendChild(doc.createTextNode("Hồ Gươm"));
        cd.appendChild(company);

        Element price = doc.createElement("PRICE");
        price.appendChild(doc.createTextNode("10.4"));
        cd.appendChild(price);

        Element year = doc.createElement("YEAR");
        year.appendChild(doc.createTextNode("2000"));
        cd.appendChild(year);

        SaveDOM(doc);
    }

    public static void update(Document doc, String title) {
        NodeList cd = doc.getElementsByTagName("CD");
        for (int i = 0; i < cd.getLength(); i++) {
            NodeList childs = cd.item(i).getChildNodes();
            for (int j = 0; j < childs.getLength(); j++) {
                if (childs.item(j).getTextContent()!= null) {
                    //System.out.println(childs.item(j).getTextContent());
                    if (childs.item(j).getTextContent().equals(title)) {
                        //sửa tiêu đề
                        childs.item(j).setTextContent("Bản tình cuối");
                        break;
                    }
                }
            }
        }
        SaveDOM(doc); 
    }

    public static void delete(Document doc, String title) {
        NodeList cd = doc.getElementsByTagName("CD");
        for (int i = 0; i < cd.getLength(); i++) {
            NodeList childs = cd.item(i).getChildNodes();
            for (int j = 0; j < childs.getLength(); j++) {
                if (childs.item(j).getTextContent()!= null) {
                    System.out.println(childs.item(j).getTextContent());
                    if (childs.item(j).getTextContent().equals(title)) {
                        doc.getDocumentElement().removeChild(cd.item(i));
                        break;
                    }
                }
            }
        }
        SaveDOM(doc);
    }

    public static void SaveDOM(Document doc) {
        try {
            //Tạo tranformer factory
            TransformerFactory tranfac = TransformerFactory.newInstance();
            //tạo tranformer
            Transformer trans = tranfac.newTransformer();
            //tạo dom source
            DOMSource source = new DOMSource(doc);
           // StreamResult result = new StreamResult(System.out);
            //tạo stream
            StreamResult result = new StreamResult(new File("src/session3/Catalog.xml"));
            //lưu
            trans.transform(source, result);
            System.out.println("\nThành công");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
