package fr.upem.rent;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Vehicle implements Serializable{
	
	private final long id;
	private final String model;
	private final String brand;
	private int nbRented;
	private final double price;
	private final int ageRequired;

	public Vehicle(long id, String model, String brand, int nbRented, double price, int ageRequired) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.nbRented = nbRented;
		this.price = price;
		this.ageRequired = ageRequired;
	}


	public int getNbRented() {
		return nbRented;
	}


	public void setNbRented(int nbRented) {
		this.nbRented = nbRented;
	}


	public long getId() {
		return id;
	}


	public String getModel() {
		return model;
	}


	public String getBrand() {
		return brand;
	}


	public double getPrice() {
		return price;
	}


	public int getAgeRequired() {
		return ageRequired;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", brand=" + brand + ", nbRented=" + nbRented + ", price="
				+ price + ", ageRequired=" + ageRequired + "]";
	}
	
	
	
}
