package DispatcherConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import DAO.FlightDao;
import DAO.FlightFileDao;
import DAO.UserDao;
import Services.FlightLoader;
import Services.SearchFlight;


@Configuration
@EnableScheduling
public class AppConfig {
	
	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}
	
	@Bean
	public FlightDao getFlightDao() {
		return new FlightDao();
	}

	@Bean
	public FlightFileDao getFlightFileDao() {
		return new FlightFileDao();
	}
	
	@Bean
	public FlightLoader getFlightLoader() {
		return new FlightLoader();
	}
	
	@Bean
	public SearchFlight getSearchFlight(){
		return new SearchFlight();
	}
}
