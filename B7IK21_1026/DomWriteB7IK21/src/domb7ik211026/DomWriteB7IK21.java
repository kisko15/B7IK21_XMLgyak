package domb7ik211026;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomWriteB7IK21 {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//a dokumentumkészítõ gyárból egy new document builder jön létre.
			
			Document doc = builder.newDocument();
			//a dokumentumkészítõbõl egy új doksit hozunk létre
			
			Element root = doc.createElementNS("domb7ik21", "users");
			doc.appendChild(root);
			//gyökérelem létrehozzása, hozzáadás a dokumentum appendhez
			
			root.appendChild(createUser(doc, "1", "Pal", "Kiss", "programmer"));
			root.appendChild(createUser(doc, "2", "Piroska", "Zold", "writer"));
			root.appendChild(createUser(doc, "3", "Alma", "Gordon", "teacher"));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource scoure = new DOMSource(doc);
			
			File myFile = new File("users1B7IK21.xml");
			
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(myFile);
			
			
			transformer.transform(scoure, console);
			transformer.transform(scoure, file);
	}

	private static Node createUser(Document doc, String id, String firstName, String lastName, String profession) {
		
		Element user = doc.createElement("user");
		
		user.setAttribute("id", id);
		user.appendChild(createUserElement(doc, "firstName", firstName));
		user.appendChild(createUserElement(doc, "lastName", lastName));
		user.appendChild(createUserElement(doc, "profession", profession));
		
		return user;
	}

	private static Node createUserElement(Document doc, String name, String value) {
		
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		
		return node;
	}

}
