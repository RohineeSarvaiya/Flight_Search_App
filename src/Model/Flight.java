package Model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightID")
	private int flightID; 
	
	@Column(name = "flightNumber")
	private String flightNumber;
	
	@Column(name = "flightDeparture")
	private String flightDeparture;
	
	@Column(name = "flightArrival")
	private String flightArrival;
	
	@Column(name = "validTill")
	private Timestamp validTill;
	
	@Column(name = "flightTime")
	private String flightTime;
	
	@Column(name = "flightDuration")
	private Double flightDuration;
	
	@Column(name = "flightFare")
	private Double flightFare;
	
	@Column(name = "seatAvailability")
	private Boolean seatAvailability;
	
	@Column(name = "flightClass")
	private String flightClass;

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDeparture() {
		return flightDeparture;
	}

	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	public String getFlightArrival() {
		return flightArrival;
	}

	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}

	public String getValidTill() {
		String date = String.valueOf(validTill);
		date = date.substring(0, date.indexOf(" "));
		return date;
	}

	public void setValidTill(Timestamp validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	
	public Double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public Double getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(Double flightFare) {
		this.flightFare = flightFare;
	}

	public Boolean getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(Boolean seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	
	public static Flight getInstance(String data[] ) {
		Flight flight = new Flight();
		
		flight.setFlightNumber(data[0]);
		flight.setFlightDeparture(data[1]);
		flight.setFlightArrival(data[2]);
		
		try {
			flight.setValidTill(new Timestamp((new SimpleDateFormat("dd-MM-yyyy").parse(data[3])).getTime()));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		flight.setFlightTime(data[4]);
		flight.setFlightDuration(Double.parseDouble(data[5]));
		flight.setFlightFare(Double.parseDouble(data[6]));
		
		if (data[7].equalsIgnoreCase("Y")) {
			flight.setSeatAvailability(true);
		} else {
			flight.setSeatAvailability(false);
		}
		
		flight.setFlightClass(data[8]);
		
		return flight;

	}
	
	
	// Just to print in console it will convert it in a string
	public String toString() {
		  return flightNumber + " | " 
		    + flightDeparture + " | " 
		    + flightArrival + " | " 
		    + validTill + " | " 
		    + flightTime + " | " 
		    + flightDuration + " | "
		    + flightFare ;
	}
	
}

