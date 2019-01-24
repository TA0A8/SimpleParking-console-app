package lt.tadasjogys.parking.parkingLotSettup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CarPlateReader {

	public boolean isCarOnTheList;
	HashMap<String, String> listOfCars;
	String filePath = "listOfCars";

	public CarPlateReader() throws IOException {
		this.listOfCars = new HashMap<String, String>();
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(":", 2);
			if (parts.length >= 2) {
				String key = parts[0];
				String value = parts[1];
				listOfCars.put(key, value);
			} else {
				System.out.println("ignoring line: " + line);
			}
		}
		reader.close();
	}

	public boolean checkIfCarIsOnTheList(String plateNmb) {
		for (String key : listOfCars.keySet()) {
			if (key.equals(plateNmb)) {
				return true;
			}
		}
		return false;
	}
	
	public String readTypeOfTheCarByNumber (String plateNmb) {
		String type;
		type = listOfCars.get(plateNmb);
		System.out.println("Car " + plateNmb + " is " + type);
		return type;

	}

	public void readListOfRegisteredCars() {
		System.out.println("Here is your full list of cars from system: ");
		for (String key : listOfCars.keySet()) {
			System.out.println(key + ":" + listOfCars.get(key));
		}

	}

}
