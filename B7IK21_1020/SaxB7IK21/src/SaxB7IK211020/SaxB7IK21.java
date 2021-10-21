package SaxB7IK211020;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxB7IK21 {
	
	public static void main(String[] args) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new File("macskakB7IK21.xml"),handler);
			
			List<Cats> cats = handler.getCatslist();
			System.out.println("cats start");
			for(int i=0; i<cats.size(); i++) {
				System.out.println("\t cat, {id:"+cats.get(i).getId()+"} start");
				System.out.println("\t\t name start");
				System.out.println("\t\t   "+cats.get(i).getName());
				System.out.println("\t\t name end");
				System.out.println("\t\t age start");
				System.out.println("\t\t   "+cats.get(i).getAge());
				System.out.println("\t\t age end");
				System.out.println("\t\t breed start");
				System.out.println("\t\t   "+cats.get(i).getBreed());
				System.out.println("\t\t breed end");
				System.out.println("\t cat, {id:"+cats.get(i).getId()+"} end");
			}
			System.out.println("cats end");
		} catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
	}
}
