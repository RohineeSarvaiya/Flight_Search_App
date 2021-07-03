package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.FlightDao;
import DAO.UserDao;


@Controller
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@RequestMapping("/login")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//getting username and password from the request
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		//validate login info
		if(!userDao.validate(userName, password))
		{
			mv.setViewName("login-fail");
			return mv;
		}
		
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
