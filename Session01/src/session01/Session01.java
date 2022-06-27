/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01;

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
public class Session01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Tạo đối tượng sax factory
            SAXParserFactory factory=SAXParserFactory.newInstance();
            //tạo đối tượng sax parser
            SAXParser parser=factory.newSAXParser();
            //lấy trình đọc trong parser
            XMLReader reader=parser.getXMLReader();
            //thiết lập trình điều khiển đọc cho reader
            reader.setContentHandler(new CatalogHandler());
            //phân tích dữ liệu
            reader.parse("src/session01/catalog.xml");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Session01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
