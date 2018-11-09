package fr.upem.rent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleDeposit extends UnicastRemoteObject implements IVehicleDeposit{
	
	private HashMap<Long, Vehicle> deposit = new HashMap<>();

	protected VehicleDeposit() throws RemoteException {
		super();
	}

	@Override
	public void render(Vehicle vehicle) throws RemoteException {
		vehicle.setNbRented(vehicle.getNbRented() + 1);
		deposit.putIfAbsent(vehicle.getId(), vehicle);
	}
	
	public void add(long id, String model, String brand, int nbRented, double price, int ageRequired) throws RemoteException {
		Vehicle vehicle = new Vehicle(id, model, brand, nbRented, price, ageRequired);
		deposit.putIfAbsent(vehicle.getId(), vehicle);
	}

	@Override
	public Vehicle rent(Long id) throws RemoteException {
		return deposit.remove(id);
		
	}


	@Override
	public List<Vehicle> searchByBrand(String brand) throws RemoteException {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		deposit.forEach((key,vehicle) -> {
			if (vehicle.getBrand().equals(brand)) {
				vehicles.add(vehicle);
			}
		});
		return vehicles;
	}

	@Override
	public List<Vehicle> searchByModel(String model) throws RemoteException {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		deposit.forEach((key,vehicle) -> {
			if (vehicle.getModel().equals(model)) {
				vehicles.add(vehicle);
			}
		});
		return vehicles;
	}
	
}
	
	
