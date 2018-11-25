package fr.upem.manage;

import java.io.Serializable;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String model;
	private String brand;
	private int nbRented;
	private double buyPrice;
	private double rentPrice;
	private int ageRequired;
	
	public Vehicle() {
	}

	public Vehicle(long id, String model, String brand, int nbRented, double buyPrice, double rentPrice, int ageRequired) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.nbRented = nbRented;
		this.buyPrice = buyPrice;
		this.rentPrice = rentPrice;
		this.ageRequired = ageRequired;
	}


	public double getBuyPrice() {
		return buyPrice;
	}


	public double getRentPrice() {
		return rentPrice;
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

	public int getAgeRequired() {
		return ageRequired;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", brand=" + brand + ", nbRented=" + nbRented + ", buy price = " + buyPrice + ", rent price="
				+ rentPrice + ", ageRequired=" + ageRequired + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (id == ((Vehicle) obj).getId() 
				&& model.equals(((Vehicle) obj).getModel()) 
				&& brand.equals(((Vehicle) obj).getBrand()) 
				&& buyPrice == ((Vehicle) obj).getBuyPrice() 
				&& rentPrice == ((Vehicle) obj).getRentPrice() 
				&& nbRented == ((Vehicle) obj).getNbRented() 
				&& ageRequired == ((Vehicle) obj).getAgeRequired()) {
			return true;
		}
		return false;
	}
}
