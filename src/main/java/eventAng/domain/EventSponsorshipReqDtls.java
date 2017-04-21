package eventAng.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sponsor_req_dtls")
public class EventSponsorshipReqDtls {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long event_id;
	private String sponsorship_type;
	private BigDecimal sponsorship_amt;
	private boolean is_partial_allowed;
	private boolean is_fully_funded;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public String getSponsorship_type() {
		return sponsorship_type;
	}
	public void setSponsorship_type(String sponsorship_type) {
		this.sponsorship_type = sponsorship_type;
	}
	public BigDecimal getSponsorship_amt() {
		return sponsorship_amt;
	}
	public void setSponsorship_amt(BigDecimal sponsorship_amt) {
		this.sponsorship_amt = sponsorship_amt;
	}
	public boolean isIs_partial_allowed() {
		return is_partial_allowed;
	}
	public void setIs_partial_allowed(boolean is_partial_allowed) {
		this.is_partial_allowed = is_partial_allowed;
	}
	public boolean isIs_fully_funded() {
		return is_fully_funded;
	}
	public void setIs_fully_funded(boolean is_fully_funded) {
		this.is_fully_funded = is_fully_funded;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event_id == null) ? 0 : event_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (is_fully_funded ? 1231 : 1237);
		result = prime * result + (is_partial_allowed ? 1231 : 1237);
		result = prime * result + ((sponsorship_amt == null) ? 0 : sponsorship_amt.hashCode());
		result = prime * result + ((sponsorship_type == null) ? 0 : sponsorship_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventSponsorshipReqDtls other = (EventSponsorshipReqDtls) obj;
		if (event_id == null) {
			if (other.event_id != null)
				return false;
		} else if (!event_id.equals(other.event_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_fully_funded != other.is_fully_funded)
			return false;
		if (is_partial_allowed != other.is_partial_allowed)
			return false;
		if (sponsorship_amt == null) {
			if (other.sponsorship_amt != null)
				return false;
		} else if (!sponsorship_amt.equals(other.sponsorship_amt))
			return false;
		if (sponsorship_type == null) {
			if (other.sponsorship_type != null)
				return false;
		} else if (!sponsorship_type.equals(other.sponsorship_type))
			return false;
		return true;
	}
	
}
