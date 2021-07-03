package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.Flight;
import Services.SearchFlight;


@Controller
public class SearchController {

	@Autowired
	private SearchFlight searchFlight;
	

	@RequestMapping("/search")
	public ModelAndView searchFlights(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//fetching flight search info
		String dept= request.getParameter("dept").toString();
		String ariv = request.getParameter("ariv").toString();
		String date = request.getParameter("date").toString();
		String flightClass = request.getParameter("fclass").toString();
		String sortBy = request.getParameter("preference");
		
		//searching fro the available flights and attaching result list with view
		List<Flight> availableFlights = searchFlight.search(dept, ariv, date, flightClass);
		searchFlight.sort(availableFlights,sortBy);		
		
		mv.addObject("availableFlights", availableFlights);
		mv.setViewName("result");
		
		return mv;
	}

}
