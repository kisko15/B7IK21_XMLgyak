package domb7ik211026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadB7IK21 {

	public static void main(String[] args) {
		
		try {
			File file = new File("usersB7IK21.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(file);
			dom.getDocumentElement().normalize();
			Element rootElement = dom.getDocumentElement();
			System.out.println("Root element: " + rootElement.getNodeName());
			NodeList childNodes = rootElement.getChildNodes();
			
			for(int i =0; i<childNodes.getLength();i++) {
				Node node = childNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					String id = element.getAttribute("id");
					String cur = element.getNodeName();
					System.out.println("Current element: "+ cur);
					System.out.println("User id: "+ id);
					Node actualNode = element.getFirstChild();
					while(actualNode != null) {
						if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
							Element actualElement = (Element)actualNode;
							System.out.println(" " + actualElement.getNodeName()+ ":" +actualElement.getTextContent());
						}
						actualNode = actualNode.getNextSibling();	
					}
					System.out.println();
				}
			}		
		} catch (ParserConfigurationException p) {
			System.out.println(p);
		} catch (SAXException e) {
			System.out.println(e);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
