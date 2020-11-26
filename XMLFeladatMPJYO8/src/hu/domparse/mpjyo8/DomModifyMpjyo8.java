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
        File inputFile = new File("C:\\Users\\Gabriella\\Desktop\\XMLFeladatMPJYO8\\XMLMPJYO8.xml");

        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(inputFile);

        Element root = doc.getDocumentElement();
        root.normalize();

        Node beosztas = doc.getElementsByTagName("beosztas").item(2);

        beosztas.setTextContent("kisfonok");

        Transformer transformer = TransformerFactory
                .newInstance()
                .newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(inputFile);
        transformer.transform(source, result);

        System.out.println("kesz");
    }
}
