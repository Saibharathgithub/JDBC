package JDBC.JDBC;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
public class Employee {
private int id;
private String name;
private int  salary;
 
public Employee() {}
public Employee(int id,String name,int salary) {
	super();
	this.name=name;
	this.salary=salary;
}
@XmlAttribute
public int getId() {
	return id;
}
public void setId(int id) {
	this.id= id;
}
@XmlElement 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name=name;
}
@XmlElement 
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary=salary;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
}
}
