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
			//DocumentumBuilder létrehozása
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("studentB7IK21.xml");
			doc.getDocumentElement().normalize();
			
			//XPath készítése
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az elérési útvonalat és csomópont listát
			String expression = "class";
			
			//1) Válassza ki az összes student element, amely a class gyermekei.
			String expression2 = "class/student";
			
			//2) Válassza ki azt a student elemet, amely rendelkezik "id" attribútummal és értéke "01".
			String expression3 = "class/student[@id='01']";
			
			//3) Kiválasztja az összes student elemet, függetlenül attól, hogy hol vannak a dokumentumban.
			String expression4 = "//student";
			
			//4) Válassza ki a második student element, amely a class elem gyermeke.
			String expression5 = "class/student[position()=2]";
			
			//5) Válassza ki a utolsó student elemet, amely a class elem gyermeke
			String expression6 = "class/student[last()]";
			
			//6) Válassza ki a utolsó elõtti student elemet, amely a class elem gyermeke
			String expression7 = "class/student[last()-1]";
			
			//7) Válassza ki az elsõ két student elemet, amelyek a class elem gyermekei
			String expression8 = "class/student[position()=1 or position()=2]";
			
			//8) Válassza ki class elem összes gyermek elemét
			String expression9 = "class/*";
			
			//9) Válassza ki az összes student elemet, amely rendelkezik legalább egy bármilyen attribútummal.
			String expression10 = "class/student[@*]";
			
			//10) Válassza ki a dokumentum összes elemét.
			String expression11 = "descendant-or-self::*";
			
			//11) Válassza ki a class elem összes student elemét, amelynél a kor>20
			String expression12 = "class/student[number(kor) > 20]";
			
			//12) Válassza ki az összes student elem összes keresztnev és vezeteknev csommópontot
			String expression13 = "//student[name(keresztnev) and name(vezeteknev)]";
			
			//Listakészítés és kiértékelés
			NodeList nodeList = (NodeList) xPath.compile(expression13).evaluate(doc, XPathConstants.NODESET);
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktuális elem: " + node.getNodeName());
				
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			
			e.printStackTrace();
		}
	}

}
