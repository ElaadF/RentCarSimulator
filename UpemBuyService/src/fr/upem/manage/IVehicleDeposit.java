package fr.upem.manage;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVehicleDeposit extends Remote{

	public List<Vehicle> searchByModel(String model) throws RemoteException;

	public List<Vehicle> searchByBrand(String brand) throws RemoteException;
	
	public void render(long idVehicle, IClient client) throws RemoteException;
	
	public void render(long idVehicle, IClient client, short mark, String comment) throws RemoteException;
	
	public void add(long id, String model, String brand, int nbRented, double buyPrice, double rentPrice, int ageRequired) throws RemoteException;

	public void rent(long idVehicle, IClient client) throws RemoteException;

	public boolean isBuyable(long idVehicle) throws RemoteException;
	
	public Vehicle getVehicleById(long idVehicle) throws RemoteException;
	
	public void removeVehicle(long idVehicle) throws RemoteException;

	public List<Review> getReviewsById(long idVehicle) throws RemoteException;
}
