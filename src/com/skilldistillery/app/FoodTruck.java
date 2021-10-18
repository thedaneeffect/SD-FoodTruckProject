package com.skilldistillery.app;

public class FoodTruck {

	private static int nextID = 0;
	
	private int id;
	private String name;
	private String foodType;
	private double rating;
	
	public FoodTruck(String name, String foodType, double rating) {
		this.id = nextID++;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getFoodType() {
		return foodType;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodTruck [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", foodType=");
		builder.append(foodType);
		builder.append(", rating=");
		builder.append(rating);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
