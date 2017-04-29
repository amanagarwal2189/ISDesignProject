/**
 * DisplayEventsForSponsor controller for the fetching events for sponsor
 * 
* @author  Aman Agarwal
* @version 1.0
* @since   2017-04-28 
*/

package eventAng.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class DisplayEventsForSponsor {

	@Autowired
	EventDao eventDao;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * fetches events based on the query parameters set on the sponsor page
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/displayEventsForSponsor", method = RequestMethod.GET)
	public List<Event> displayEventsForSponsor(HttpServletRequest request) {
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		List<Event> eventList = jdbcTemplate.query(constructQuery(fromDate, toDate, city, state, zip),
				new EventMapper());
		return eventList;
	}

	/**
	 * shows the detailed page of the event ot the sponsor
	 * @param request
	 * @param eventId
	 * @return
	 */
	@RequestMapping(value = "/displaySelectedEvent", method = RequestMethod.GET)
	public String displaySelectedEvent(HttpServletRequest request, @RequestParam String eventId) {
		return "selectEvent";
	}

	/**
	 * constructs the query based on the param provided in the search query
	 * 
	 * @param eventId
	 * @param request
	 * @return
	 */
	private String constructQuery(String fromDate, String toDate, String city, String state, String zip) {
		String queryString = "";
		StringBuffer query = new StringBuffer("Select * from tb_event_dtls where ");
		if (fromDate != null && !fromDate.isEmpty()) 
			query.append("date >='" + fromDate + "' and ");
		if (toDate != null && !toDate.isEmpty()) 
			query.append("date <='" + toDate + "' and ");
		if (city != null && !city.isEmpty()) 
			query.append("city ='" + city + "' and ");
		if (state != null && !state.equals("---")) 
			query.append("state ='" + state + "' and ");
		if (zip != null && !zip.isEmpty()) 
			query.append("zip=" + zip + " and ");
		query.append(" is_active=true");
		queryString = query.toString();
		return queryString;
	}
}

/**
 * @author Aman
 *
 */
class EventMapper implements RowMapper<Event> {
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event event = new Event();
		event.setId(rs.getLong("id"));
		event.setTitle(rs.getString("title"));
		event.setDate(rs.getDate("date"));
		event.setTime(rs.getTime("time"));
		// set all others
		return event;
	}
}