package JDBC.JDBC;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_To_database_DOM {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
			IllegalArgumentException, IllegalAccessException, DOMException, SQLException, ClassNotFoundException {
		ArrayList<Employee11> list = new ArrayList<Employee11>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db
				.parse("C:\\Users\\Admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\employee11.xml");
		NodeList detailsList = document.getElementsByTagName("employee1");
		for (int i = 0; i < detailsList.getLength(); i++) {
			Employee11 pdetails = new Employee11();
			Node node = detailsList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				Class<?> class1 = Employee11.class;
				for (Field field : class1.getDeclaredFields()) {

					field.setAccessible(true);

					String value = field.getName();
					NodeList nodelist = element.getElementsByTagName(value);
					Node node1 = nodelist.item(0);
					Element element1 = (Element) node1;
					if (field.getType() == int.class) {
						field.set(pdetails, Integer.parseInt(element1.getTextContent()));
					} else {
						field.set(pdetails, element1.getTextContent());
					}

				}

			}
			list.add(pdetails);
			System.out.println(pdetails.toString());

		}
		String url = "jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR";
		String user = "postgres";
		String pass = "Sai@123456";
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt = conn
				.prepareStatement("INSERT INTO employee1(\n" + " name,address)\n" + "values(?,?)\n");
		for (Employee11 pd : list) {
			int i = 1;
			Class<?> test = pd.getClass();
			Field[] field = test.getDeclaredFields();
			for (Field filed : field) {
				filed.setAccessible(true);
				if (filed.getType() == int.class) {
					pstmt.setInt(i, filed.getInt(pd));
					i++;
				} else {
					pstmt.setString(i, filed.get(pd).toString());
					i++;
				}
			}
			pstmt.execute();
		}

	}
}
