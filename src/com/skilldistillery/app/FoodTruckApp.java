package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		// lights
		FoodTruck[] trucks = new FoodTruck[5];
		int truckCount = 0;

		// camera
		System.out.println("Your stomach begins to gurgle. Without hestiation you reach for your phone");
		System.out.println("and open your Gulp app. It can show you up to 5 of the nearest food trucks.");
		System.out.println();
		System.out.println("Briefly describe what you are seeing in your search results.");

		Scanner in = new Scanner(System.in);

		// action
		while (truckCount < trucks.length) {
			System.out.print("Enter the trucks name (or \"quit\" to continue): ");
			String name = in.nextLine();

			if ("quit".equalsIgnoreCase(name)) {
				if (truckCount == 0) {
					System.out.println("You must enter at least one truck!");
					continue; // puts us back at the beginning of our while loop
				}
				break;
			}

			System.out.print("Enter the trucks numeric rating: ");
			double rating = in.nextDouble();
			in.nextLine(); // consume newlines

			trucks[truckCount] = new FoodTruck(name, rating);
			truckCount++;
		}

		while (true) {
			System.out.println("- Main Menu -");
			System.out.println("\t1) List all existing food trucks");
			System.out.println("\t2) See the average rating of food trucks");
			System.out.println("\t3) Display the highest-rated food truck");
			System.out.println("\t0) Quit the program");
			System.out.print("> ");

			int option = in.nextInt();

			if (option == 1) {
				for (int i = 0; i < truckCount; i++) {
					System.out.println(trucks[i]);
				}
			} else if (option == 2) {
				double sum = 0;
				
				for (int i = 0; i < truckCount; i++) {
					sum += trucks[i].getRating();
				}
				
				System.out.printf("Average rating: %.2f%n", sum / truckCount);
			} else if (option == 3) {
				FoodTruck top = trucks[0];
				
				for (int i = 1; i < truckCount; i++) {
					FoodTruck other = trucks[i];
					
					if (other.getRating() > top.getRating()) {
						top = other;
					}
				}
				
				System.out.printf("The highest rated food truck: %s%n", top);
			} else if (option == 0) {
				break;
			}
		}

		in.close();
		
		System.out.println("Thank you for using Gulp! *gulp noise*");
		System.out.println("The screen shuts off. You know what you must do now.");
	}

}
