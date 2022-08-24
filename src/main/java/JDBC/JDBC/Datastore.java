package JDBC.JDBC;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "datastore")
public class Datastore {
@XmlElement(name = "employee")
private List<Employee> employeeList = new ArrayList<>();
public List<Employee> getEmployeeList(){
	return employeeList;
}
}
