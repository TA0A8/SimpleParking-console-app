package lt.tadasjogys.parking.app;

import java.io.IOException;
import java.util.Scanner;

import lt.tadasjogys.parking.parkingLotSettup.CarPlateReader;
import lt.tadasjogys.parking.parkingLotSettup.ParkingLot;

public class ParkingLotConfig {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		//////////////////////////////// PARKING LOT CONFIG

		ParkingLot theParkingLot = new ParkingLot();

		System.out.println("--- SETTING-UP CUSTOM PARKING LOT ---");
		System.out.println("please enter valid number of Floors (1-20): ");

		int x = 1;
		do {
			x = scanner.nextInt();
		} while (x <= 0 || x >= 20);

		System.out.println("floors: " + x);

		theParkingLot.setUpPlacesByFloors(x);

		Scanner newScanner = new Scanner(System.in);

		//////////////////////////////////////////////////////// CAR VERIFICATION

		// INFINITE LOOP, SYSTEM IS ALLWAYS READY TO RUN
		while (true) {

			// Enter car plate number
			System.out.print("\nCar is approaching... enter plate number: ");
			String plateNmbr = newScanner.nextLine();
			System.out.println("plate number is: " + plateNmbr);

			CarPlateReader theCarPlateReader = new CarPlateReader();

			// check if car is on the external parking system list
			if (theCarPlateReader.checkIfCarIsOnTheList(plateNmbr) == true) {
				System.out.println("car is on the list, looking for parking spot...");
				String carType = theCarPlateReader.readTypeOfTheCarByNumber(plateNmbr);

				switch (carType) {
				case "electric":
					theParkingLot.placeElectricCar();
					break;
				case "patrol/diesel":
					theParkingLot.placeDiezelOrPatrol();
					break;
				case "van":
					theParkingLot.placeVan();
					break;
				default:
					System.out.println(
							"Sorry, system mistake, can't let you in... call custommer support tel. nr:860109266");
				}

			} else {
				System.out.println("your car is not allowed to park here");
			}

		}

	}


}
