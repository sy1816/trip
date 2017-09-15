package recommend;

public class searchVO {
	private int id;
	private int rank;
	private String tourspot;
	private String area;
	private String address;
	private String image_url1;
	private String image_url2;
	
	searchVO(){
		id = 0;
		rank = 0;
		tourspot = null;
		area = null;
		address = null;
		image_url1 = null;
		image_url2 = null;
	}
	
	searchVO(int id, int rank, String tourspot, String area, String address, String image_url1, String image_url2){
		this.id = id;
		this.rank = rank;
		this.tourspot = tourspot;
		this.area = area;
		this.address = address;
		this.image_url1 = image_url1;
		this.image_url2 = image_url2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTourspot() {
		return tourspot;
	}
	public void setTourspot(String tourspot) {
		this.tourspot = tourspot;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage_url1() {
		return image_url1;
	}
	public void setImage_url1(String image_url1) {
		this.image_url1 = image_url1;
	}
	public String getImage_url2() {
		return image_url2;
	}
	public void setImage_url2(String image_url2) {
		this.image_url2 = image_url2;
	}

}
