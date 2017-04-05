package eventAng.controllers;

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
		
		return true;
	}
}
