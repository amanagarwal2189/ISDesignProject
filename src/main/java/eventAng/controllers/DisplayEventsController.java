package eventAng.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eventAng.domain.Event;
import eventAng.model.EventDao;
//import eventAng.services.DisplayEvent;

@Controller
@Scope("session")
public class DisplayEventsController {

	@Autowired
	EventDao eventDao;
	
	@Autowired
	private HttpSession httpSession;
	
	/**
	 * 
	 * Display Events on the landing page: index
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/displayEvents", method = RequestMethod.GET)
    public List<Event> displayEvents() {
		//List<Object> eventList = new ArrayList<Object>();
		System.out.println("Success");
		List<Event> eventList = new ArrayList<Event>();
		eventList= eventDao.findTop4ByOrderByTitleDesc();
		System.out.println("Success");
        /*DisplayEvent dspEvent = new DisplayEvent();
        eventList = dspEvent.displayEventForLanding(eventDao);
        //String json = (new JSONArray(eventList)).toString();
*/        return eventList;
	      
    }

	/**
	 * Shows the event on the organizer page when the organizer logs in
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/displayEventsForOrganizer", method = RequestMethod.GET)
	public List<Event> displayEvents(HttpServletRequest request) {
		List<Event> eventListForOrg = new ArrayList<Event>();
		// HttpSession session=request.getSession();
		String userId= (String) request.getSession().getAttribute("user_id");
		String userEmailId= (String) request.getSession().getAttribute("user_emailId");
		System.out.println("Host is : " + userId);
		System.out.println("Host email is : " + userEmailId);
		if (null != userId) {
			Long host_id = Long.valueOf(userId);
			//System.out.println("Host : " + host_id);
			eventListForOrg=eventDao.getEventByHostId(host_id);
			/*DisplayEvent dspEvent1 = new DisplayEvent();
			eventListForOrg = dspEvent1.displayEventForOrganizer(eventDao, new Long(hostId));*/
		}
		return eventListForOrg;
	}
	
	
	
	/**
	 * Show the detailed page for an event
	 * @param eventId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/organizerViewEvent", method = RequestMethod.GET)
    public Event displayOneEvent(HttpServletRequest request) {
		String eventId= (String) request.getSession().getAttribute("eventId");
		Event event=eventDao.getById(Long.parseLong(eventId));
		System.out.println("event id is: "+eventId);
        return event;
	      
    }
	
	@RequestMapping(value = "/displayEvent", method = RequestMethod.GET)
    public String displayEvent(@RequestParam String eventId, HttpServletRequest request) {
		httpSession.setAttribute("eventId", eventId);
        return "displayEvent";
    }

}
