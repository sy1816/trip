package recommend;

public class tourVO{
	private int id;
	private String name;
	private double quotient;
	private String address;
	private String img_url1;
	
	tourVO(){
		id = -1;
		name = null;
		quotient = 0.0;
		address = null;
		img_url1 = null;
	}
	
	tourVO(int id, String name, String address, String img_1){
		this.id = id;
		this.name = name;
		this.quotient = 0.0;
		this.address = address;
		this.img_url1 = img_1;
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

	public String getImg_url1() {
		return img_url1;
	}

	public void setImg_url1(String img_url1) {
		this.img_url1 = img_url1;
	}
	

	@Override
	public String toString() {
		return "tourVO [id=" + id + ", name=" + name + ", quotient=" + quotient + ", address=" + address + "]";
	}

}
