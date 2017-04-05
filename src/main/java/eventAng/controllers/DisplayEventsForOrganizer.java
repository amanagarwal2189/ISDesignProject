package eventAng.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eventAng.databaseconn.DisplayEvent;
import eventAng.domain.Users;

@Controller
public class DisplayEventsForOrganizer {

	@ResponseBody
	@RequestMapping(value = "/displayEventsForOrganizer", method = RequestMethod.GET)
	public List<Object> displayEvents(HttpServletRequest request) {
		List<Object> eventListForOrg = new ArrayList<Object>();
		// HttpSession session=request.getSession();
		Users usersList = (Users) request.getSession().getAttribute("users");
		if (null != usersList) {
			int hostId = usersList.getId();
			System.out.println("Host : " + hostId);
			DisplayEvent dspEvent1 = new DisplayEvent();
			eventListForOrg = dspEvent1.displayEventForOrganizer(hostId);
		}
		return eventListForOrg;

	}
}
