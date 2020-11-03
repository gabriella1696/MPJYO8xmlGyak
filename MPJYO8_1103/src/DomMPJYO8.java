import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomMPJYO8 {

    public static void main(String[] args) {

        try {
            File inputFile = new File("szemelyek.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("szemelyek.xml");
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("szemelyek");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id : "
                            + eElement.getAttribute("id"));
                    System.out.println("nev : "
                            + eElement
                            .getElementsByTagName("nev")
                            .item(0)
                            .getTextContent());
                    System.out.println("kor : "
                            + eElement
                            .getElementsByTagName("kor")
                            .item(0)
                            .getTextContent());
                    System.out.println("varos : "
                            + eElement
                            .getElementsByTagName("varos")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
