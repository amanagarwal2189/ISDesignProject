package eventAng.services;

import eventAng.domain.Host;
import eventAng.model.HostDao;

public class HostRegister {

	public String hostRegistration(HostDao hostDao, String name, String email_id, String newPassword, String confPassword) {

		Host host = new Host();
		host.setName(name);
		host.setPassword(newPassword);
		host.setRegd_on(new java.sql.Date(new java.util.Date().getTime()));
		host.setEmail_id(email_id);
		host.setIs_active(true);
		host.setAddress_line_1("");
		host.setAddress_line_2("");
		host.setCity("");
		host.setPhone("");
		host.setState("");
		host.setZip(0);

		hostDao.save(host);
		String hostId = String.valueOf(host.getId());
		System.out.println("Event id created is : " + hostId);
		return "successInsert";

	}
}