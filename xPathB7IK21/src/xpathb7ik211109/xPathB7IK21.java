package xpathb7ik211109;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xPathB7IK21 {

	public static void main(String[] args) {
		
		try {
			//DocumentumBuilder l�trehoz�sa
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("studentB7IK21.xml");
			doc.getDocumentElement().normalize();
			
			//XPath k�sz�t�se
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az el�r�si �tvonalat �s csom�pont list�t
			String expression = "class";
			
			//1) V�lassza ki az �sszes student element, amely a class gyermekei.
			String expression2 = "class/student";
			
			//2) V�lassza ki azt a student elemet, amely rendelkezik "id" attrib�tummal �s �rt�ke "01".
			String expression3 = "class/student[@id='01']";
			
			//3) Kiv�lasztja az �sszes student elemet, f�ggetlen�l att�l, hogy hol vannak a dokumentumban.
			String expression4 = "//student";
			
			//4) V�lassza ki a m�sodik student element, amely a class elem gyermeke.
			String expression5 = "class/student[position()=2]";
			
			//5) V�lassza ki a utols� student elemet, amely a class elem gyermeke
			String expression6 = "class/student[last()]";
			
			//6) V�lassza ki a utols� el�tti student elemet, amely a class elem gyermeke
			String expression7 = "class/student[last()-1]";
			
			//7) V�lassza ki az els� k�t student elemet, amelyek a class elem gyermekei
			String expression8 = "class/student[position()=1 or position()=2]";
			
			//8) V�lassza ki class elem �sszes gyermek elem�t
			String expression9 = "class/*";
			
			//9) V�lassza ki az �sszes student elemet, amely rendelkezik legal�bb egy b�rmilyen attrib�tummal.
			String expression10 = "class/student[@*]";
			
			//10) V�lassza ki a dokumentum �sszes elem�t.
			String expression11 = "descendant-or-self::*";
			
			//11) V�lassza ki a class elem �sszes student elem�t, amelyn�l a kor>20
			String expression12 = "class/student[number(kor) > 20]";
			
			//12) V�lassza ki az �sszes student elem �sszes keresztnev �s vezeteknev csomm�pontot
			String expression13 = "//student[name(keresztnev) and name(vezeteknev)]";
			
			//Listak�sz�t�s �s ki�rt�kel�s
			NodeList nodeList = (NodeList) xPath.compile(expression13).evaluate(doc, XPathConstants.NODESET);
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktu�lis elem: " + node.getNodeName());
				
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					System.out.println("Hallgat� ID: " + element.getAttribute("id"));
					
					System.out.println("Keresztn�v: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Vezet�kn�v: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Becen�v: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			
			e.printStackTrace();
		}
	}

}
