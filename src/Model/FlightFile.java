package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Files")
public class FlightFile {
	
	@Id
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "fileRows")
	private int rows;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public boolean equals(Object obj) {
		FlightFile flightFile = (FlightFile) obj;
		return this.getFileName().equals(flightFile.getFileName());
	}
}

