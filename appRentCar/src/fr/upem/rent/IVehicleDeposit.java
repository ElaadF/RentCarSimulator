package fr.upem.rent;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface IVehicleDeposit extends Remote{

	public List<Vehicle> searchByModel(String model) throws RemoteException;

	public List<Vehicle> searchByBrand(String brand) throws RemoteException;
	
	public void render(Vehicle vehicle, IClient client) throws RemoteException;
	
	public void render(Vehicle vehicle, IClient client, short mark, String comment) throws RemoteException;
	
	public void add(long id, String model, String brand, int nbRented, double price, int ageRequired) throws RemoteException;

	public void rent(Vehicle vehicle, IClient client) throws RemoteException;

}
