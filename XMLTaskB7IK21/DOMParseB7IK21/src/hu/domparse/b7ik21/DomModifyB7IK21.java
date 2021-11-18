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
			// f�jl beolvas�sa
			Document document = builder.parse(new File("XMLB7IK21.xml"));
			document.getDocumentElement().normalize();

			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("vasarlo");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// V�s�rl� adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					// V�s�rl�id elt�rol�sa egy stringbe
					String id = element.getAttribute("vasarloid");

					System.out.println("V�s�rl� id: " + element.getAttribute("vasarloid"));
					System.out.println("Fut�cip� id: " + element.getAttribute("futocipoid"));

					System.out.println("N�v: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(
							"Telefonsz�m: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
					// V�s�rl� c�m adatok kiir�sa
					Node nodecim = list.item(i);
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elemcim = (Element) node;
						// id vizsg�lata �s ha megegyezzik vas1-el akkor ir�ny�t�sz�m m�dos�t�s
						if (id.equals("vas1")) {
							elemcim.getElementsByTagName("iranyitoszam").item(0).setTextContent("3333");
							elemcim.getElementsByTagName("varos").item(0).setTextContent("Miskolc");
							elemcim.getElementsByTagName("utca").item(0).setTextContent("�j utca 33.");
						}
						System.out.println("Ir�ny�t�sz�m: "
								+ elemcim.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println("V�ros: " + elemcim.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println("Utca: " + elemcim.getElementsByTagName("utca").item(0).getTextContent());
					}

				}
			}

			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("bankkartya");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Bankk�rtya adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elementBankkartya = (Element) node;

					// K�rtyasz�m elt�rol�sa egy stringbe
					String id = elementBankkartya.getAttribute("kartyaszam");

					if (id.equals("11224545")) {
						elementBankkartya.getElementsByTagName("lejarati_datum").item(0).setTextContent("2025.05.05");
						elementBankkartya.getElementsByTagName("bank").item(0).setTextContent("Budapest Bank");
						elementBankkartya.getElementsByTagName("tipus").item(0).setTextContent("Mastercard World");
					}

					System.out.println("K�rtyasz�m: " + elementBankkartya.getAttribute("kartyaszam"));
					System.out.println("V�s�rl� id: " + elementBankkartya.getAttribute("vasarloid"));

					System.out.println("Lej�rati d�tum: "
							+ elementBankkartya.getElementsByTagName("lejarati_datum").item(0).getTextContent());
					System.out.println(
							"Bank: " + elementBankkartya.getElementsByTagName("bank").item(0).getTextContent());
					System.out.println(
							"T�pus: " + elementBankkartya.getElementsByTagName("tipus").item(0).getTextContent());
				}
			}

			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("fut_szin");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elementFutMeret = (Element) node;

					// Fut�cip� ID elt�rol�sa egy stringbe
					String id = elementFutMeret.getAttribute("futocipoid");

					if (id.equals("f1")) {
						elementFutMeret.getElementsByTagName("szin").item(0).setTextContent("Z�ld");
					}

					if (id.equals("f2")) {
						elementFutMeret.getElementsByTagName("szin").item(0).setTextContent("Lila");
					}

					System.out.println("Fut�cip� id: " + elementFutMeret.getAttribute("futocipoid"));

					System.out
							.println("Sz�n: " + elementFutMeret.getElementsByTagName("szin").item(0).getTextContent());
				}
			}

			// l�tehozza az xml f�jt m�dos�tva
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
