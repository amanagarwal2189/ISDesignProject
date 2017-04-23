package eventAng.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eventAng.domain.Event;
import eventAng.domain.EventSponsorshipReqDtls;
import eventAng.model.EventDao;
import eventAng.model.EventSponsorshipReqDtlsDao;

@Controller
@Scope("session")
public class EventController {
	
	 @Autowired
	  private EventDao eventDao;
	

	 @Autowired
	 private HttpSession httpSession;
	 
	 @Autowired
	  private EventSponsorshipReqDtlsDao eventSponsorshipReqDtlsDao;
	
	 @RequestMapping(value = "/organizerProfile", method = RequestMethod.GET)
		public String switchToProfile(HttpServletRequest request) {
			return "organizerProfile";
	 
	 }
	 
	 
	@RequestMapping(value = "/submitEvent", method = RequestMethod.POST)
	public String createEvent(HttpServletRequest request) {
		
		String user_id= (String) request.getSession().getAttribute("user_id");
		String userEmailId= (String) request.getSession().getAttribute("user_emailId");
		Event event = new Event();
		Long userId = Long.valueOf(user_id);
		event.setHost_id(userId);
		//event.setHost_id((Integer) request.getSession().getAttribute("userId"));
		event.setTitle(request.getParameter("title"));
		try {
			event.setDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")).getTime()));
			//change this back non-hardcoded
			//event.setTime(new Time(0));
			System.out.println(request.getParameter("time"));
			event.setTime(new Time( new SimpleDateFormat("HH:mm").parse(request.getParameter("time")).getTime()));
			//change this back to created_on
			event.setCreated_on(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		event.setAddress_line_1(request.getParameter("address_line_1"));
		event.setAddress_line_2(request.getParameter("address_line_2"));
		event.setCity(request.getParameter("city"));
		event.setState(request.getParameter("state"));
		event.setZip(Integer.parseInt(request.getParameter("zip")));
		event.setNum_attendees(Integer.parseInt(request.getParameter("num_attendees")));
		event.setIs_active(false);//request.getParameter("is_active").equals("true")?true:false);//converttoboolean
		event.setCreated_by(request.getParameter("created_by"));
		
		event.setCategory(request.getParameter("category"));
		event.setIs_deleted(false);//request.getParameter("is_deleted").equals("true")?true:false);//converttoboolean
		//Blob image = (Blob) request.getParameter("image");
		//String thumbnail=  request.getParameter("thumbnail");
		event.setFb_link(request.getParameter("fb_link"));
		event.setEventbrite_link(request.getParameter("eventbrite_link"));
		
		eventDao.save(event);
		if(event.getId()!=null||event.getId()!=0){
		storeSponsorDetails(event.getId(), request);
		String eventId = String.valueOf(event.getId());
		System.out.println("Event id created is : "+ eventId );
		}
		return "dashboard";
		
	}

	/**
	 * Method to store the sponsorship details in the database
	 * This method will create the entries in the "tb_sponsor_req_dtls" table
	 * @param eventId
	 * @param request
	 */
	private void storeSponsorDetails(Long eventId, HttpServletRequest request) { 
		EventSponsorshipReqDtls eventSponsorshipReqDtls_1=new EventSponsorshipReqDtls();
		EventSponsorshipReqDtls eventSponsorshipReqDtls_2=new EventSponsorshipReqDtls();
		EventSponsorshipReqDtls eventSponsorshipReqDtls_3=new EventSponsorshipReqDtls();
		
		if (request.getParameter("sponsorship_type1") != null && !request.getParameter("sponsorship_type1").equals("")
				&& request.getParameter("sponsorship_amt1") != null
				&& !request.getParameter("sponsorship_amt1").equals("")) {
			eventSponsorshipReqDtls_1.setEvent_id(eventId);
			eventSponsorshipReqDtls_1.setSponsorship_type(request.getParameter("sponsorship_type1"));
			eventSponsorshipReqDtls_1.setSponsorship_amt(new BigDecimal(request.getParameter("sponsorship_amt1")));
			eventSponsorshipReqDtls_1.setIs_partial_allowed(request.getParameter("is_partial_allowed1").equals("Y")
					|| request.getParameter("is_partial_allowed1").equals("y") ? true : false);
			eventSponsorshipReqDtls_1.setIs_fully_funded(false);
			eventSponsorshipReqDtlsDao.save(eventSponsorshipReqDtls_1);
		}
		
		if (request.getParameter("sponsorship_type2") != null && !request.getParameter("sponsorship_type2").equals("")
				&& request.getParameter("sponsorship_amt2") != null
				&& !request.getParameter("sponsorship_amt2").equals("")) {
			eventSponsorshipReqDtls_2.setEvent_id(eventId);
			eventSponsorshipReqDtls_2.setSponsorship_type(request.getParameter("sponsorship_type2"));
			eventSponsorshipReqDtls_2.setSponsorship_amt(new BigDecimal(request.getParameter("sponsorship_amt2")));
			eventSponsorshipReqDtls_2.setIs_partial_allowed(request.getParameter("is_partial_allowed2").equals("Y")
					|| request.getParameter("is_partial_allowed2").equals("y") ? true : false);
			eventSponsorshipReqDtls_2.setIs_fully_funded(false);
			eventSponsorshipReqDtlsDao.save(eventSponsorshipReqDtls_2);
		}
		
		if (request.getParameter("sponsorship_type3") != null && !request.getParameter("sponsorship_type3").equals("")
				&& request.getParameter("sponsorship_amt3") != null
				&& !request.getParameter("sponsorship_amt3").equals("")) {
			eventSponsorshipReqDtls_3.setEvent_id(eventId);
			eventSponsorshipReqDtls_3.setSponsorship_type(request.getParameter("sponsorship_type3"));
			eventSponsorshipReqDtls_3.setSponsorship_amt(new BigDecimal(request.getParameter("sponsorship_amt3")));
			eventSponsorshipReqDtls_3.setIs_partial_allowed(request.getParameter("is_partial_allowed3").equals("Y")
					|| request.getParameter("is_partial_allowed3").equals("y") ? true : false);
			eventSponsorshipReqDtls_3.setIs_fully_funded(false);
			eventSponsorshipReqDtlsDao.save(eventSponsorshipReqDtls_3);
		}
	}
}
