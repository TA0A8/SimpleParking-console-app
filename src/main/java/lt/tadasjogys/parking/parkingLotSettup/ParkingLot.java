package lt.tadasjogys.parking.parkingLotSettup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ParkingLot {

	Scanner scan = new Scanner(System.in);

	private int[] placesByFloor;
	private int[] floors;
	private int lowestFloor;

	public ParkingLot() {

	}

	public int getLowestFloor() {
		return lowestFloor;
	}

	public void setLowestFloor(int lowestFloor) {
		this.lowestFloor = lowestFloor;
	}

	public int[] getPlacesByFloor() {
		return placesByFloor;
	}

	public void setPlacesByFloor(int[] placesByFloor) {
		this.placesByFloor = placesByFloor;
	}

	public void setUpPlacesByFloors(int x) {
		setUpFloorsNumbers();
		int places;
		this.placesByFloor = new int[x];
		for (int i = 0; i < x; i++) {
			System.out.println("enter parking places at: " + (lowestFloor + i) + " floor");
			places = scan.nextInt();
			this.placesByFloor[i] = places;
		}
		printParkingConfiguration(placesByFloor);
	}

	public void setUpFloorsNumbers() {
		int temp;
		System.out.println("type lowest floor to start from:");
		int low = scan.nextInt();
		setLowestFloor(low); // MIND THIS LATER!
	}

	private void printParkingConfiguration(int[] places) {
		System.out.println("your parking lot schema (floor , places):");
		System.out.println(Arrays.toString(placesByFloor));
	}

	public void placeElectricCar() {
		if (this.placesByFloor[(placesByFloor.length - 1)] > 0) {
			this.placesByFloor[(placesByFloor.length - 1)] -= 1;
			System.out
					.println("Empty spot for car at: " + (this.lowestFloor + this.placesByFloor.length - 1) + " floor");
		} else if ((this.placesByFloor.length > 1) && (this.placesByFloor[(placesByFloor.length - 2)] > 0)) {
			this.placesByFloor[(placesByFloor.length - 2)] -= 1;
			System.out
					.println("Empty spot for car at: " + (this.lowestFloor + this.placesByFloor.length - 2) + " floor");
		} else {
			System.out.println("Parking is full!");
		}
		System.out.println("Current parkin lot status: " + Arrays.toString(placesByFloor));
	}

	
	
	public void placeVan() {
		if (this.placesByFloor[0] > 0) {
			this.placesByFloor[0] -= 1;
			System.out.println("Empty spot for car at: " + (this.lowestFloor) + " floor");
		} else if ((this.placesByFloor.length > 1) && (this.placesByFloor[1] > 0)) {
			this.placesByFloor[1] -= 1;
			System.out.println("Empty spot for car at: " + (this.lowestFloor + 1) + " floor");
		} else {
			System.out.println("Parking is full!");
		}
		System.out.println("Current parkin lot status: " + Arrays.toString(placesByFloor));
	}

	public void placeDiezelOrPatrol() {
		// randomizing indexes, excluding those already taken
		ArrayList<Integer> list = new ArrayList<Integer>(this.placesByFloor.length - 1);
		for (int i = 0; i < placesByFloor.length; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int y = 0; y < this.placesByFloor.length; y++) {
			System.out.println(list.get(y));
			if (this.placesByFloor[list.get(y)] > 0) {
				System.out.println("Empty spot for car at: " + (this.lowestFloor + list.get(y)) + " floor");
				this.placesByFloor[list.get(y)] -= 1;
				break;
			} else {
				System.out.println("Parking is full!");
			}
		}
		System.out.println("Current parkin lot status: " + Arrays.toString(placesByFloor));
	}

}
