package fr.upem.manage;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVehicleDeposit extends Remote{

	public Vehicle[] searchByModel(String model) throws RemoteException;

	public Vehicle[] searchByBrand(String brand) throws RemoteException;
	
	public void render(long idVehicle, long idClient) throws RemoteException;
	
	public void render(long idVehicle, long idClient, short mark, String comment) throws RemoteException;
	
	public void add(long id, String model, String brand, int nbRented, double buyPrice, double rentPrice, int ageRequired) throws RemoteException;

	public boolean rent(long idVehicle, long idClient) throws RemoteException;

	public boolean isBuyable(long idVehicle) throws RemoteException;
	
	public Vehicle getVehicleById(long idVehicle) throws RemoteException;
	
	public void removeVehicle(long idVehicle) throws RemoteException;
	
	public Review[] getReviewsById(long idVehicle) throws RemoteException;

	public Vehicle[] getVehicles() throws RemoteException;
}
