package JDBC.JDBC;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;


public class Object_To_Xml {

	public static void main(String[] args) throws Exception { 
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("sai");
		emp.setSalary(300000);
		JAXBContext obj = JAXBContext.newInstance(Employee.class);  
		Marshaller obj1 = obj.createMarshaller();
		File f = new File ("C:\\Users\\Admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Employee.xml");
		obj1.marshal(emp, f); 
	}

}
