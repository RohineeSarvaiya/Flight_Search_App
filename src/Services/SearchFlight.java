package Services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import DAO.FlightDao;
import Model.Flight;

public class SearchFlight {
	
	@Autowired
	private FlightDao flightDao;
	
	//searching for the available files as per user inputs
	public List<Flight> search ( String deptLoc, String arivLoc, String date,String flightClass ) {
		List<Flight> availableFlights;		
		Timestamp flightDate = null;
		
		try {
			flightDate = new Timestamp((new SimpleDateFormat("yyyy-MM-dd").parse(date)).getTime());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		availableFlights = flightDao.getFlights(deptLoc, arivLoc, flightDate, flightClass);

		return availableFlights;
	}
	
	
	//sorting result list as per user output preference
	public void sort ( List<Flight> availableFlights , String preference ) {
		
	 	Collections.sort(availableFlights, new Comparator<Flight>() {  
		       
	        public int compare(Flight o1, Flight o2) {  
	            int fareComp = Double.compare(o1.getFlightFare(), o2.getFlightFare());  
	            if(preference.equals("both")) {
	             if (fareComp != 0) {  
	                 return fareComp;  
	             }  
	             int durComp = Double.compare(o1.getFlightDuration(), o2.getFlightDuration());
	             return durComp;
	            } 
	            return fareComp; 
	        }  
	    });		
	}

}
