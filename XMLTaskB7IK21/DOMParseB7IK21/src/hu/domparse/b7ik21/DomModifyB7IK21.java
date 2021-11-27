package hu.domparse.b7ik21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyB7IK21 {

	public static void main(String[] args) {
		NodeList list;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// fájl beolvasása
			Document document = builder.parse(new File("XMLB7IK21.xml"));
			document.getDocumentElement().normalize();

			// Aktuális elem meghatározása
			list = document.getElementsByTagName("vasarlo");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Vásárló adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					// Vásárlóid eltárolása egy stringbe
					String id = element.getAttribute("vasarloid");

					System.out.println("Vásárló id: " + element.getAttribute("vasarloid"));
					System.out.println("Futócipõ id: " + element.getAttribute("futocipoid"));

					System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(
							"Telefonszám: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
					// Vásárló cím adatok kiirása
					Node nodecim = list.item(i);
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elemcim = (Element) node;
						// id vizsgálata és ha megegyezzik vas1-el akkor irányítószám módosítás
						if (id.equals("vas1")) {
							elemcim.getElementsByTagName("iranyitoszam").item(0).setTextContent("3333");
							elemcim.getElementsByTagName("varos").item(0).setTextContent("Miskolc");
							elemcim.getElementsByTagName("utca").item(0).setTextContent("Új utca 33.");
						}
						System.out.println("Irányítószám: "
								+ elemcim.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println("Város: " + elemcim.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println("Utca: " + elemcim.getElementsByTagName("utca").item(0).getTextContent());
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
					Element elementBankkartya = (Element) node;

					// Kártyaszám eltárolása egy stringbe
					String id = elementBankkartya.getAttribute("kartyaszam");

					if (id.equals("11224545")) {
						elementBankkartya.getElementsByTagName("lejarati_datum").item(0).setTextContent("2025.05.05");
						elementBankkartya.getElementsByTagName("bank").item(0).setTextContent("Budapest Bank");
						elementBankkartya.getElementsByTagName("tipus").item(0).setTextContent("Mastercard World");
					}

					System.out.println("Kártyaszám: " + elementBankkartya.getAttribute("kartyaszam"));
					System.out.println("Vásárló id: " + elementBankkartya.getAttribute("vasarloid"));

					System.out.println("Lejárati dátum: "
							+ elementBankkartya.getElementsByTagName("lejarati_datum").item(0).getTextContent());
					System.out.println(
							"Bank: " + elementBankkartya.getElementsByTagName("bank").item(0).getTextContent());
					System.out.println(
							"Típus: " + elementBankkartya.getElementsByTagName("tipus").item(0).getTextContent());
				}
			}

			// Aktuális elem meghatározása
			list = document.getElementsByTagName("fut_szin");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elementFutMeret = (Element) node;

					// Futócipõ ID eltárolása egy stringbe
					String id = elementFutMeret.getAttribute("futocipoid");

					if (id.equals("f1")) {
						elementFutMeret.getElementsByTagName("szin").item(0).setTextContent("Zöld");
					}

					if (id.equals("f2")) {
						elementFutMeret.getElementsByTagName("szin").item(0).setTextContent("Lila");
					}

					System.out.println("Futócipõ id: " + elementFutMeret.getAttribute("futocipoid"));

					System.out
							.println("Szín: " + elementFutMeret.getElementsByTagName("szin").item(0).getTextContent());
				}
			}

			// létehozza az xml fájt módosítva
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(new File("XMLB7IK21Modify.xml"));
			transformer.transform(input, output);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
