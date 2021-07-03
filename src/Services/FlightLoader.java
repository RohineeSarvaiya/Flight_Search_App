package Services;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import DAO.FlightDao;
import DAO.FlightFileDao;
import Model.Flight;
import Model.FlightFile;

public class FlightLoader {
	
	@Autowired
	FlightFileDao flightFileDao;

	@Autowired
	FlightDao flightDao;
	
	private File folder = new File("C:/Users/rohineebasarvaiya/workspace1/FlightSearchApplication/CSVFiles");
	private File[] files;
	private List<FlightFile> allFiles;
	private FileReader fileReader;
	private CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	private CSVReader csvReader;
	
	
	//this file will run automatically after fixedrate and check for new available files in the given folder
	@Scheduled(fixedRate = 7000, initialDelay = 5000)
	public void flightLoader() {	
		allFiles = flightFileDao.getAllFlightFiles();
		files = folder.listFiles();

		newFilesEntry();		
	}
	
	
	//checking for new files in the given folder
	private void newFilesEntry() {
		for (File file : files)
		{
			FlightFile flightFile = new FlightFile();
			flightFile.setFileName(file.getName());
			
			if (!allFiles.contains(flightFile)) 
			{
				fileReader ( flightFile, file );
			} 
		}
	}
	
	
	//reading data from the CSV file and adding flight details in the database by making Flight class object
	private void fileReader ( FlightFile flightFile, File file ) {		
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			
			List<String[]> data = csvReader.readAll();
			int totalEntries = data.size() - 1;

			for (int rowNumber = 1; rowNumber <= totalEntries; rowNumber++)
			{
				Flight newFlight = Flight.getInstance(data.get(rowNumber));
				//System.out.println(rowNumber+"*");
				flightDao.saveFlight(newFlight);
			}
			
			flightFile.setRows(totalEntries);
			flightFileDao.saveFlightFile(flightFile);

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
