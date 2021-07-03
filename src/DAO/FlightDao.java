package DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Configuration.HibernateUtil;
import Model.Flight;

public class FlightDao {
	
	//saving flight details in database
	public void saveFlight(Flight flight) {
		
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {            
            transaction = session.beginTransaction();            
            session.save(flight);           
            transaction.commit();
            
        } catch (Exception e){            
            e.printStackTrace();
        }
	}	
	

	//searching for the available flights as pre user inputs
	public  List<Flight> getFlights ( String dept , String ariv , Date datetime , String flightClass ){
		
		//making sql statement to fetch the suitable flights data
		Session session = HibernateUtil.getSessionFactory().openSession();				
		session.beginTransaction();
		
		String hqlQuery = "from Flight as F where F.flightDeparture='"
				+ dept + "' and F.flightArrival='" + ariv
				+ "' and F.flightClass like '%" + flightClass
				+ "%' and F.validTill>='" + datetime
				+ "' and F.seatAvailability=" + true ;
		
		@SuppressWarnings("unchecked")
		List<Flight> flights = (List<Flight>) (session.createQuery(hqlQuery).list());
		
		session.getTransaction().commit();
		
		//increasing fare for business class
		if(flightClass.equals("B"))
		{
			for(Flight f : flights)
			{
				Double fare = f.getFlightFare();
				fare = fare + (fare*40/100) ; //increasing fare for business class
				f.setFlightFare(fare);
			}
		}
		
		return flights;
	}
	
	
	//fetching all the available distinct arrival location from the database
	public List<String> getArrivalLocations() {	

		Session session = HibernateUtil.getSessionFactory().openSession();		
		session.beginTransaction();
		
		String hqlQuery = "select distinct F.flightArrival from Flight F";
		
		@SuppressWarnings("unchecked")
		List<String> arrivalLocations = (List<String>) (session.createQuery(hqlQuery).list());
		
		session.getTransaction().commit();
	
		return arrivalLocations;
	}
	
	
	//fetching all the available distinct departure location from the database
	public List<String> getDepartureLocations() {		

		Session session = HibernateUtil.getSessionFactory().openSession();		
		session.beginTransaction();
		
		String hqlQuery = "select distinct F.flightDeparture from Flight F";
		
		@SuppressWarnings("unchecked")
		List<String> departLocations = (List<String>) (session.createQuery(hqlQuery).list());
		
		session.getTransaction().commit();

		return departLocations;	
	}
	
}
