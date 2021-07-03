package DAO;

import java.util.List;
import org.hibernate.Session;

import Configuration.HibernateUtil;
import Model.FlightFile;


public class FlightFileDao {
	
	//fetching all the flight details file from the database
	public List<FlightFile> getAllFlightFiles() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		session.beginTransaction();
		
		String hqlQuery = "from FlightFile f";
		
		@SuppressWarnings("unchecked")
		List<FlightFile> flightFiles = (List<FlightFile>) (session.createQuery(hqlQuery).list());
		
		session.getTransaction().commit();	
		
		return flightFiles;
	}
	
	
	//saving flight file details in the database
	public void saveFlightFile ( FlightFile newFlightFile ) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
		session.beginTransaction();

		session.save(newFlightFile);

		session.getTransaction().commit();
	}

}
