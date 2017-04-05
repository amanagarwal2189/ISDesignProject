package eventAng.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eventAng.databaseconn.DisplayEvent;

@Controller
public class DisplayEventsController {

	@ResponseBody
	@RequestMapping(value = "/displayEvents", method = RequestMethod.GET)
    public List<Object> displayEvents() {
		List<Object> eventList = new ArrayList<Object>();
		System.out.println("Success");
        DisplayEvent dspEvent = new DisplayEvent();
        eventList = dspEvent.displayEventForLanding();
        //String json = (new JSONArray(eventList)).toString();
        return eventList;
	      
    }
}
