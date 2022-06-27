/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author ADMIN
 */
public class MainFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //tạo ra factory
            SAXParserFactory factory=SAXParserFactory.newInstance();
            //tạo parser
            SAXParser parser=factory.newSAXParser();
            //tạo bộ đọc
            XMLReader reader=parser.getXMLReader();
            //thiết lập trình điều khiển
            reader.setContentHandler(new CatalogHandlerFilter());
            //phân tích
            reader.parse("src/session02/catalog.xml");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Session02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
