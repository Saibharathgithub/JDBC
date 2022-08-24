package JDBC.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectOperation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:postgresql://localhost:5432/SAI BHARATH KUMAR";
        String user = "postgres";
        String pass ="Sai@123456";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement state=con.createStatement();
        String query="select * from employee where empid=102";
        ResultSet rs= state.executeQuery(query);
        rs.next();
        String name = rs.getString("empname");
        System.out.println(name);
        state.close();
        
	}

}
