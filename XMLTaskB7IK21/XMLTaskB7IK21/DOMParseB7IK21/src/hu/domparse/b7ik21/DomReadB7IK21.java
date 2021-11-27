package hu.domparse.b7ik21;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadB7IK21 {

	public static void main(String[] args) {
		NodeList list;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// fájl beolvasása
			Document document = builder.parse(new File("XMLB7IK21.xml"));
			document.getDocumentElement().normalize();
			// Gyökér elem megkeresése
			System.out.println("Root element : " + document.getDocumentElement().getNodeName());
			System.out.println("----------------");
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("sportuzlet");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Sportüzlet adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Sportüzlet id: " + element.getAttribute("sportuzletid"));
					System.out.println("Futócipő id: " + element.getAttribute("futocipoid"));

					System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(
							"Nyitvatartás: " + element.getElementsByTagName("nyitvatartas").item(0).getTextContent());

					// Sportüzleten belüli elérhetőség adatok kiirása
					Node elerhetoseg = list.item(i);
					if (elerhetoseg.getNodeType() == Node.ELEMENT_NODE) {
						Element elementelerhetoseg = (Element) node;
						System.out.println("Weboldal: "
								+ elementelerhetoseg.getElementsByTagName("weboldal").item(0).getTextContent());
						System.out.println("Telefonszám: "
								+ elementelerhetoseg.getElementsByTagName("telefonszam").item(0).getTextContent());
					}
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("futocipo");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Futócipő id: " + element.getAttribute("futocipoid"));
					System.out.println("Vásárló id: " + element.getAttribute("vasarloid"));

					System.out.println(
							"Futócipő név: " + element.getElementsByTagName("futocipo_nev").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("fut_szin");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Futócipő id: " + element.getAttribute("futocipoid"));

					System.out.println("Szín: " + element.getElementsByTagName("szin").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("fut_meret");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Futócipő id: " + element.getAttribute("futocipoid"));

					System.out.println("Méret: " + element.getElementsByTagName("meret").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("vasarlo");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Vásárló adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Vásárló id: " + element.getAttribute("vasarloid"));
					System.out.println("Futócipő id: " + element.getAttribute("futocipoid"));

					System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(
							"Telefonszám: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
					// Vásárló cím adatainak kiirása
					Node nodecim = list.item(i);
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println("Irányítószám: "
								+ elementcim.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out
								.println("Város: " + elementcim.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println("Utca: " + elementcim.getElementsByTagName("utca").item(0).getTextContent());
					}
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("bankkartya");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Bankkártya adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Kártyaszám: " + element.getAttribute("kartyaszam"));
					System.out.println("Vásárló id: " + element.getAttribute("vasarloid"));

					System.out.println("Lejárati dátum: "
							+ element.getElementsByTagName("lejarati_datum").item(0).getTextContent());
					System.out.println("Bank: " + element.getElementsByTagName("bank").item(0).getTextContent());
					System.out.println("Típus: " + element.getElementsByTagName("tipus").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("beszallitas");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Bszállítás adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Baszállító id: " + element.getAttribute("beszallitoid"));
					System.out.println("Sportüzlet id: " + element.getAttribute("sportuzletid"));

					System.out.println("Dátum: " + element.getElementsByTagName("datum").item(0).getTextContent());
					System.out.println(
							"Futócipők: " + element.getElementsByTagName("futocipok").item(0).getTextContent());
				}
			}

			// Aktuális elem meghatározása
			list = document.getElementsByTagName("beszallito");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Beszállító adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Beszállító id: " + element.getAttribute("beszallitoid"));

					System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Cím: " + element.getElementsByTagName("cim").item(0).getTextContent());
					// Vásárló cím adatainak kiirása
					Node nodeelerhetoseg = list.item(i);
					if (nodeelerhetoseg.getNodeType() == Node.ELEMENT_NODE) {
						Element elementelerhetoseg = (Element) node;
						System.out.println("Irányítószám: "
								+ elementelerhetoseg.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println(
								"Város: " + elementelerhetoseg.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println(
								"Utca: " + elementelerhetoseg.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println("Házszám: "
								+ elementelerhetoseg.getElementsByTagName("hazszam").item(0).getTextContent());
					}
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("kiszallito");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Kiszállító adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Kiszállító id: " + element.getAttribute("kiszallitoid"));
					System.out.println("Sportüzlet id: " + element.getAttribute("sportuzletid"));

					System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(
							"Telefonszám: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
