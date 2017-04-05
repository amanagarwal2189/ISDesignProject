package eventAng.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {

	@ResponseBody
	@RequestMapping(value = "/submitEvent", method = RequestMethod.POST)
	public boolean createEvent(HttpServletRequest request) {
			
		int userId=(Integer) request.getSession().getAttribute("userId");
		String title=request.getParameter("title");
		
		try {
			Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			Time time = (Time) new SimpleDateFormat("HH:mm").parse(request.getParameter("time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String adLine1= request.getParameter("address-line1");
		String adLine2=request.getParameter("address-line1");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String numAttendess = request.getParameter("num_attendees");
		String isActive = request.getParameter("isActive");//converttoboolean
		String createdBy = request.getParameter("crtd_by");
		request.getParameter("crtd_on");
		request.getParameter("category");
		request.getParameter("isDeleted");
		request.getParameter("image");
		request.getParameter("thumbnail");
		request.getParameter("fb_link");
		request.getParameter("eb_link");
		
		return true;
	}
}
