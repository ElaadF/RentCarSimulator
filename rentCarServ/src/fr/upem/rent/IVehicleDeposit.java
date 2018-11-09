package fr.upem.rent;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVehicleDeposit extends Remote{
	
	public Vehicle rent(Long id) throws RemoteException;

	public List<Vehicle> searchByModel(String model) throws RemoteException;

	public List<Vehicle> searchByBrand(String brand) throws RemoteException;

	public void render(Vehicle vehicle) throws RemoteException;
	
	public void add(long id, String model, String brand, int nbRented, double price, int ageRequired) throws RemoteException;

}
