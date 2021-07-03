package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.FlightDao;

@Controller
public class LoggedInSearchController {
	
	@Autowired
	private FlightDao flightDao;
	
	@RequestMapping("/loggedinsearch")
	public ModelAndView loggedinSearch(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//getting username from the request
		String userName = request.getParameter("username");
		
		//attaching list of departure and arrival location to the view
		List<String> deptLoc = flightDao.getDepartureLocations();
		List<String> arivLoc = flightDao.getArrivalLocations();
		
		mv.addObject("userName", userName);
		mv.addObject("deptLoc", deptLoc);
		mv.addObject("arivLoc", arivLoc);
		
		mv.setViewName("search");

		return mv;
	}

}
