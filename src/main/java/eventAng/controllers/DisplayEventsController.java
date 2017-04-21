package eventAng.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eventAng.domain.Event;
import eventAng.domain.User;
import eventAng.model.EventDao;
import eventAng.services.DisplayEvent;

@Controller
public class DisplayEventsController {

	@Autowired
	EventDao eventDao;
	
	@ResponseBody
	@RequestMapping(value = "/displayEvents", method = RequestMethod.GET)
    public List<Object> displayEvents() {
		List<Object> eventList = new ArrayList<Object>();
		System.out.println("Success");
        DisplayEvent dspEvent = new DisplayEvent();
        eventList = dspEvent.displayEventForLanding(eventDao);
        //String json = (new JSONArray(eventList)).toString();
        return eventList;
	      
    }

	@ResponseBody
	@RequestMapping(value = "/displayEventsForOrganizer", method = RequestMethod.GET)
	public List<Object> displayEvents(HttpServletRequest request) {
		List<Object> eventListForOrg = new ArrayList<Object>();
		// HttpSession session=request.getSession();
		User user = (User) request.getSession().getAttribute("users");
		if (null != user) {
			int hostId = user.getId();
			System.out.println("Host : " + hostId);
			DisplayEvent dspEvent1 = new DisplayEvent();
			eventListForOrg = dspEvent1.displayEventForOrganizer(eventDao, new Long(hostId));
		}
		return eventListForOrg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/event", method = RequestMethod.GET)
    public String displayOneEvent(@RequestParam String eventId, HttpServletRequest request) {
		Event event=eventDao.getById(Long.parseLong(eventId));
        return "displayEvent";
	      
    }

}
