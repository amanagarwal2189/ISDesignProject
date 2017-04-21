package eventAng.domain;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_event_dtls")
public class Event {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int host_id;
	private String title;
	private Date date;
	private Time time;
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String state;
	private int zip;
	private int num_attendees;
	
	private boolean is_active;
	private String created_by;
	private Date created_on;
	private String category;
	private boolean is_deleted;
	//@Lob
	//private Blob image;
	//@Lob
	//private Blob thumbnail;
	private String fb_link;
	private String eventbrite_link;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getHost_id() {
		return host_id;
	}
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
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
	public int getNum_attendees() {
		return num_attendees;
	}
	public void setNum_attendees(int num_attendees) {
		this.num_attendees = num_attendees;
	}
	public boolean is_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean is_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	/*public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public Blob getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}*/
	public String getFb_link() {
		return fb_link;
	}
	public void setFb_link(String fb_link) {
		this.fb_link = fb_link;
	}
	
	public String getEventbrite_link() {
		return eventbrite_link;
	}
	
	public void setEventbrite_link(String eventbrite_link) {
		this.eventbrite_link = eventbrite_link;
	}
	
	public Event() {
		super();
	}
	public Event(int host_id, String title, Date date, Time time, String address_line_1, String address_line_2,
			String city, String state, int zip, int num_attendees, boolean is_active, String created_by, Date created_on,
			String category, boolean is_deleted, String fb_link, String eventbrite_link) {
		super();
		this.host_id = host_id;
		this.title = title;
		this.date = date;
		this.time = time;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.num_attendees = num_attendees;
		this.is_active = is_active;
		this.created_by = created_by;
		this.created_on = created_on;
		this.category = category;
		this.is_deleted = is_deleted;
	/*	this.image = image;
		this.thumbnail = thumbnail;*/
		this.fb_link = fb_link;
		this.eventbrite_link=eventbrite_link;
		
	}
	
	
	
}