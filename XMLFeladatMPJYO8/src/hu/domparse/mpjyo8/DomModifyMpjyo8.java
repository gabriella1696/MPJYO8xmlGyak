package hu.domparse.mpjyo8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DomModifyMpjyo8 {
    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

       //get input file
        File inputFile = new File("C:\\Users\\Gabriella\\Desktop\\XMLFeladatMPJYO8\\XMLMPJYO8.xml");

        //document builder
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(inputFile);

        //init root element
        Element root = doc.getDocumentElement();
        root.normalize();

        //rewrite the 2nd (so the third) post to "kisfonok"
        Node beosztas = doc.getElementsByTagName("beosztas").item(2);

        beosztas.setTextContent("kisfonok");

        Transformer transformer = TransformerFactory
                .newInstance()
                .newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(inputFile);
        transformer.transform(source, result);

        //if the modification is done this lets us know
        System.out.println("kesz");
    }
}
