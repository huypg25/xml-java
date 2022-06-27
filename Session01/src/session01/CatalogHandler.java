/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ADMIN
 */
public class CatalogHandler extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Bắt đầu đọc tài liệu");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String id=attributes.getValue(0);
        if(qName.equals("CD"))
            System.out.print("<"+qName+" Id=\""+id+"\">");
        else
            System.out.print("<"+qName+">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data=new String(ch,start, length);
        System.out.print(data);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Đã đọc hết tệp");
    }
    
}
