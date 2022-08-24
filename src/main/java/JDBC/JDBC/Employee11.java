package JDBC.JDBC;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Employee11 {
	private String name;
	private String address;
	 
	public Employee11() {}
	public Employee11(String name,String address) {
		super();
		this.name=name;
		this.address=address;
	}
	@XmlElement 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	@XmlElement 
	public String address() {
		return address;
	}
	public void setaddress(String address) {
		this.address=address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}
}
