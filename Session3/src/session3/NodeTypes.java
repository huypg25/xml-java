/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author chungld-hanam
 */
public class NodeTypes {

    public static void printNodes(Document n) {
        printElement((Node) n, "");
    }
    private static void printElement(Node n, String indent) {
        int type = n.getNodeType();
        switch (type) {
            case Node.CDATA_SECTION_NODE:
                System.out.println(indent + "CDATA_SECTION_NODE");
                break;
            case Node.COMMENT_NODE:
                System.out.println(indent + "COMMENT_NODE");
                break;
            case Node.DOCUMENT_FRAGMENT_NODE:
                System.out.println(indent + "DOCUMENT_FRAGMENT_NODE");
                break;
            case Node.DOCUMENT_NODE:
                System.out.println(indent + "DOCUMENT_NODE");
                break;
            case Node.DOCUMENT_TYPE_NODE:
                System.out.println(indent + "DOCUMENT_TYPE_NODE");
                break;
            case Node.ELEMENT_NODE:
                System.out.println(indent + "ELEMENT_NODE");
                break;
            case Node.ENTITY_NODE:
                System.out.println(indent + "ENTITY_NODE");
                break;
            case Node.ENTITY_REFERENCE_NODE:
                System.out.println(indent + "ENTITY_REFERENCE_NODE");
                break;
            case Node.NOTATION_NODE:
                System.out.println(indent + "NOTATION_NODE");
                break;
            case Node.PROCESSING_INSTRUCTION_NODE:
                System.out.println(indent + "PROCESSING_INSTRUCTION_NODE");
                break;
            case Node.TEXT_NODE:
                System.out.println(indent + "TEXT_NODE");
                break;
            default:
                System.out.println(indent + "Unknown node");
                break;
        }
        // Retrieve the list of nodes for the parent node
        NodeList list = n.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            printElement(list.item(i), indent + " ");
        }
    }
}
