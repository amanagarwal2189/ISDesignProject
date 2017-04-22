package eventAng.services;

import eventAng.domain.Sponsor;
import eventAng.model.SponsorDao;

public class SponsorRegister {

	public String sponsorRegistration(SponsorDao sponsorDao, String name,String email_id,String newPassword, String confPassword){  
		Sponsor sponsor= new Sponsor();
		sponsor.setName(name);
		sponsor.setPassword(newPassword);
		sponsor.setRegd_on(new java.sql.Date(new java.util.Date().getTime()));
		sponsor.setEmailId(email_id);
		sponsor.setIs_active(true);
		sponsor.setAddress_line_1("");
		sponsor.setAddress_line_2("");
		sponsor.setCity("");
		sponsor.setPhone("");
		sponsor.setState("");
		sponsor.setZip(0);
		
		sponsorDao.save(sponsor);
		String sponsorId = String.valueOf(sponsor.getId());
		System.out.println("Event id created is : "+ sponsorId );
		return "successInsert";
	}  
}
