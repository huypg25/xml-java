/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ADMIN
 */
public class CatalogHandlerFilter extends DefaultHandler {

    String etitle, eartist, ecountry, ecompany, eprice, eyear;
    boolean btitle = false, bartist = false, bcountry = false, bcompany = false, bprice = false, byear = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("TITLE")) {
            btitle = true;
        }
        if (qName.equals("ARTIST")) {
            bartist = true;
        }
        if (qName.equals("COUNTRY")) {
            bcountry = true;
        }
        if (qName.equals("PRICE")) {
            bprice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("CD")) {
            if (Double.parseDouble(eprice) > 10) {
                System.out.println("------------------------------------");
                System.out.println("Title:"+etitle);
                System.out.println("Artist:"+eartist);
                System.out.println("Country:"+ecountry);
                System.out.println("Price:"+eprice);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if (btitle == true) {
            etitle = data;
            btitle = false;
        }
        if (bartist == true) {
            eartist = data;
            bartist = false;
        }
        if (bcountry == true) {
            ecountry = data;
            bcountry = false;
        }
        if (bprice == true) {
            bprice = false;
            eprice = data;
        }
    }

}
