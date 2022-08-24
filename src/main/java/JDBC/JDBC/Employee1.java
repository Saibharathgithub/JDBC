package JDBC.JDBC;

	public class Employee1 {
		private int id;
		private String name;
		private String position;
		@Override
		public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + "]";
		}
		public int getId() {
		return id;
		}
		public void setId(int id) {
		this.id = id;
		}
		public String getName() {
		return name;
		}
		public void setName(String name) {
		this.name = name;
		}
		public String getposition() {
		return position;
		}
		public void setposition(String position) {
		this.position = position;
		}
	}

