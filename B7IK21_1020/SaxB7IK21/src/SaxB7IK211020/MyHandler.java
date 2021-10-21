package SaxB7IK211020;

import java.util.List;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	private List<Cats> catslist = null;
	private Cats cat = null;
	private StringBuilder data = null;
	
	
	public List<Cats> getCatslist() {
		return catslist;
	}
	
	boolean bname=false;
	boolean bage=false;
	boolean bbreed=false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Cat")) {
			String id=attributes.getValue("id");
			
			cat = new Cats();
			cat.setId(Integer.parseInt(id));
			
			if (catslist == null) 
				catslist = new ArrayList<Cats>();
			} else if (qName.equalsIgnoreCase("name")) {
				bname=true;
			} else if (qName.equalsIgnoreCase("age")) {
				bage=true;
			} else if (qName.equalsIgnoreCase("breed")) {
				bbreed=true;
			}
			data=new StringBuilder();
			
		}
	
	@Override 
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bage) {
			cat.setAge(Integer.parseInt(data.toString()));
			bage=false;
		} else if (bname) {
			cat.setName(data.toString());
			bname=false;
		} else if (bbreed) {
			cat.setBreed(data.toString());
			bbreed=false;
		}
		
		if (qName.equalsIgnoreCase("cat")) {
			catslist.add(cat);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch,start,length));
	}
}
