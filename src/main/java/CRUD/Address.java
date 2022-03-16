package CRUD;

public class Address {
	
	private String fistname; 
	private String lastname;
	private String addrees1;
	private String city;
	private String zipcode;
	
	
	public Address(String fistname, String lastname, String addrees1, String city, String zipcode) {

		this.fistname = fistname;
		this.lastname = lastname;
		this.addrees1 = addrees1;
		this.city = city;
		this.zipcode = zipcode;
	}


	public String getFistname() {
		return fistname;
	}


	public void setFistname(String fistname) {
		this.fistname = fistname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getAddrees1() {
		return addrees1;
	}


	public void setAddrees1(String addrees1) {
		this.addrees1 = addrees1;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
