package recommend;

public class tourVO{
	private int id;
	private String name;
	private double quotient;
	private String address;
	
	tourVO(){
		id = -1;
		name = null;
		quotient = 0.0;
		address = null;
	}
	
	tourVO(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.quotient = 0.0;
		this.address = address;
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
	public double getQuotient() {
		return quotient;
	}
	public void setQuotient(double quotient) {
		this.quotient = quotient;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "tourVO [id=" + id + ", name=" + name + ", quotient=" + quotient + ", address=" + address + "]";
	}
	
}
