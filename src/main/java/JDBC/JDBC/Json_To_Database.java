package JDBC.JDBC;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Json_To_Database {
		public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException,
		IllegalArgumentException, IllegalAccessException {
		String url = "jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR";
		String user = "postgres";
		String pass = "Sai@123456";
		ObjectMapper maper = new ObjectMapper();
		File jsonfile = new File("C:\\Users\\Admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Details.json");
		List<Employee1> employeelist = maper.readValue(jsonfile, new TypeReference<List<Employee1>>() { });
		          System.out.println(employeelist);
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String query ="INSERT INTO employeedetails(\n" + " id,name,position)\n" + "values(?, ?, ?)\n" ;
		PreparedStatement pstmt = conn.prepareStatement(query);


		for (Employee1 employee1 : employeelist) {
		int i = 1;
		Class<?> test = employee1.getClass();
		Field[] field = test.getDeclaredFields();
		for (Field filed : field) {
		filed.setAccessible(true);
		if (filed.getType() == int.class) {
		pstmt.setInt(i, filed.getInt(employee1));
		i++;
		} else {
		pstmt.setString(i, filed.get(employee1).toString());
		i++;
		}
		}
		pstmt.execute();
		}
		}
		}
