package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		//setting all view object as null
		mv.addObject("userName", null);
		mv.addObject("fromAirportCodes", null);
		mv.addObject("toAirportCodes", null);
		mv.addObject("searchResult", null);
		mv.setViewName("login");
		
		return mv;
	}
}
