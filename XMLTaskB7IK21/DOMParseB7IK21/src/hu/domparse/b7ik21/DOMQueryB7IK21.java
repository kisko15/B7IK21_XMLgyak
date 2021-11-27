package hu.domparse.b7ik21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMQueryB7IK21 {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// fájl beolvasása
			Document document = builder.parse(new File("XMLB7IK21.xml"));
			document.getDocumentElement().normalize();
			// Gyökér elem megkeresése
			System.out.println("Root element : " + document.getDocumentElement().getNodeName());
			System.out.println("----------------");

			// Milyen futócipő méretek vannak
			query(document, "fut_meret", "meret");
			System.out.println("----------------");

			// A vásárlók neveinek keresése
			query(document, "vasarlo", "nev");
			System.out.println("----------------");

			// A vásárlók címeinek keresése
			query(document, "vasarlo", "cim");
			System.out.println("----------------");

			// Kilistázza azon címeket, amelyikek a megadott irányítószámnál nagyobbak
			queryVasatloIranyitoszamNagyobb(document, "vasarlo", "iranyitoszam", 3000);
			System.out.println("----------------");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void query(Document document, String elemKeres, String mitKeres) {
		// Aktuális elem meghatározása
		NodeList list = document.getElementsByTagName(elemKeres);

		for (int i = 0; i < list.getLength(); i++) {
			NodeList nodeList = list.item(i).getChildNodes();

			for (int k = 0; k < nodeList.getLength(); k++) {
				Node gye = nodeList.item(k);
				if (gye.getNodeName().compareTo(mitKeres) == 0) {
					System.out.println(gye.getTextContent());
				}
			}

		}
	}

	public static void queryVasatloIranyitoszamNagyobb(Document document, String elemKeres, String irsz, int keresIrsz) {
		// Aktuális elem meghatározása
		NodeList list = document.getElementsByTagName(elemKeres);
		int irszVan;

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			// Vásárló adatainak kiirása
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// Vásárló cím adatainak kiirása
				Node nodecim = list.item(i);
				if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
					Element elementIrsz = (Element) node;
					irszVan = Integer.parseInt(elementIrsz.getElementsByTagName(irsz).item(0).getTextContent());
					if (irszVan > keresIrsz) {
						System.out.println("Irányítószám: "
								+ elementIrsz.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println(
								"Város: " + elementIrsz.getElementsByTagName("varos").item(0).getTextContent());
						System.out
								.println("Utca: " + elementIrsz.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println();
					}
				}
			}
		}
	}

}
