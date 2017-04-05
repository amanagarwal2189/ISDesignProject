package eventAng.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import org.springframework.data.annotation.Id;

@Entity
public class Users {

	@Id @GeneratedValue 
	private int id;
	
	private String name;
	private String email_id;
    
	private String phone;
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String state;
	private int zip;
    private String is_active;
    private Date regd_on;
    private String password;
	public int getId() {
		return id;
	}
	
	public Users() {
		super();
	}

	public Users(int id, String name, String email_id, String phone, String address_line_1, String address_line_2,
			String city, String state, int zip, String is_active, Date regd_on, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.phone = phone;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.is_active = is_active;
		this.regd_on = regd_on;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Date getRegd_on() {
		return regd_on;
	}

	public void setRegd_on(Date regd_on) {
		this.regd_on = regd_on;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    
}
