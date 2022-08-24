package JDBC.JDBC;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class XML_To_Object {

	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR", "postgres",
				"Sai@123456");
		Statement st = con.createStatement();
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Employee2.xml");
		JAXBContext c = JAXBContext.newInstance(Datastore.class);
		Unmarshaller um = c.createUnmarshaller();
		Datastore d = (Datastore) um.unmarshal(f);
		List<Employee> employeeList = d.getEmployeeList();
		for (Employee emp : employeeList) {
			System.out.println(emp.toString());
			Class<?> clap = Employee.class;
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO employee2(");
			for (Field field : clap.getDeclaredFields()) {
				field.setAccessible(true);
				query.append(field.getName()).append(",");

			}
			query.deleteCharAt(query.length() - 1);
			query.append(")VALUES(");
			for (Field field : clap.getDeclaredFields()) {
				field.setAccessible(true);
				query.append("'").append(field.get(emp)).append("'").append(",");
			}
			query.deleteCharAt(query.length() - 1);
			query.append(");");
			System.out.println(query);
			PreparedStatement preparedStatement = con.prepareStatement(query.toString());
			preparedStatement.executeUpdate();

		}
	}
}