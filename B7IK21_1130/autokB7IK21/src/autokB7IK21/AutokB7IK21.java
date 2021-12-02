package autokB7IK21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AutokB7IK21 {
	
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String TEST_XML_STRING = null;

	public static void main(String[] args) {
		
		kettesFeladat();
		harmasFeladat();
		negyesFeladat();
		
	}
	
	public static void negyesFeladat() {
		try {
			File file = new File("XMLB7IK21.xml");
			FileInputStream fin = new FileInputStream(file);
			byte[] xmlData = new byte[(int) file.length()];
			fin.read(xmlData);
			fin.close();
			TEST_XML_STRING = new String(xmlData, "UTF-8");
			
			JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);

			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			persistToJSON2(jsonPrettyPrintString);
			
		} catch (JSONException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}
	
	public static void harmasFeladat() {
		try {
			File file = new File("JSONB7IK21.xml");
			FileInputStream fin = new FileInputStream(file);
			byte[] xmlData = new byte[(int) file.length()];
			fin.read(xmlData);
			fin.close();
			TEST_XML_STRING = new String(xmlData, "UTF-8");
			
			JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);

			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			System.out.println("**********Kettes feladat A része**********");
			System.out.println(jsonPrettyPrintString);
			
			ArrayList<String> listdata = new ArrayList<String>();
			JSONArray jArray = new JSONArray();
			jArray.put(xmlJSONObj);
			if (jArray != null) { 
			   for (int i=0;i<jArray.length();i++){ 
				   listdata.add(i, jsonPrettyPrintString);
			   } 
			} 
			System.out.println("**********Kettes feladat B része**********");
			System.out.println(jArray);
			
		} catch (JSONException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}
	
	public static void kettesFeladat() {
		try {
			File file = new File("autokB7IK21.xml");
			FileInputStream fin = new FileInputStream(file);
			byte[] xmlData = new byte[(int) file.length()];
			fin.read(xmlData);
			fin.close();
			TEST_XML_STRING = new String(xmlData, "UTF-8");
			
			JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);

			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			System.out.println(jsonPrettyPrintString);

			persistToJSON(jsonPrettyPrintString);
			
			System.out.println("**********Convert JSON to Java object**********");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> obj = mapper.readValue(jsonPrettyPrintString, new TypeReference<Map<String, Object>>() {
			});

			System.out.println("**********Convert Java objects to YAML**********");
			DumperOptions opts = new DumperOptions();
			opts.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
			String yaml = new Yaml(opts).dump(obj);
			System.out.println(yaml);
			
			persistToYAML(yaml);
			
		} catch (JSONException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

	public static void persistToJSON(String document) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("autokB7IK21.json"));
			out.write(document);
			out.flush();
		} catch (IOException e) {

		}
		System.out.println("Done JSON");
	}
	
	public static void persistToJSON2(String document) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("JSONB7IK21.json"));
			out.write(document);
			out.flush();
		} catch (IOException e) {

		}
		System.out.println("Done JSON");
	}
	
	public static void persistToYAML(String yaml) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("autokB7IK21.yml"));
			out.write(yaml);
			out.flush();
		} catch (IOException e) {

		}
		System.out.println("Done YAML");
	}

}
