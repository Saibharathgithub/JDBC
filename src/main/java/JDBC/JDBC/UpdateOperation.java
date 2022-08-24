package JDBC.JDBC;   

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR";
		  String user="postgres";
		  String pass= "Sai@123456";
		  Class.forName("org.postgresql.Driver");
		  Connection con = DriverManager.getConnection(url, user, pass);
		  Statement state=con.createStatement();
		  String qurey="update employee set empname='RAMA' where empid=103";
		  int r=state.executeUpdate(qurey);
		  System.out.println("sucessfully executed...");
		  con.close();
	}

}
