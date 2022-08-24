package JDBC.JDBC;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_To_Database {
	public static void main(String[] args) throws SQLException, SAXException, IOException, ParserConfigurationException{ 
	try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR", "postgres", "Sai@123456");
	Statement st=con.createStatement();
	
	
	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	Document doc = docBuilder.parse (new File("C:\\Users\\Admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\employee11.xml"));
	doc.getDocumentElement().normalize();
	System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
	
	
	NodeList listOfPersons = doc.getElementsByTagName("employee1");
	for(int s=0; s<listOfPersons.getLength(); s++){
	Node firstPersonNode = listOfPersons.item(s);
	if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){
	Element firstPersonElement = (Element)firstPersonNode;
	NodeList nameList = firstPersonElement.getElementsByTagName("name");
	Element nameElement =(Element)nameList.item(0);

	NodeList textFNList = nameElement.getChildNodes();
	String name=((Node)textFNList.item(0)).getNodeValue().trim();

	NodeList addressList = firstPersonElement.getElementsByTagName("address");
	Element addressElement =(Element)addressList.item(0);

	NodeList textLNList = addressElement.getChildNodes();
	String address= ((Node)textLNList.item(0)).getNodeValue().trim();

	int i=st.executeUpdate("insert into public.employee1(name,address) values('"+name+"','"+address+"')");
	}
	}
	System.out.println("Data is successfully inserted!");
	}catch (Exception err) {
	System.out.println(" " + err.getMessage ());
	}
	}
	}


