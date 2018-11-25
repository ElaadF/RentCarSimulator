package fr.upem.manage;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class VehicleDeposit extends UnicastRemoteObject implements IVehicleDeposit{


	private HashMap<Long, BlockingQueue<IClient>> deposit = new HashMap<>();
	private HashMap<Long, Vehicle> vehicles = new HashMap<>();
	
	private HashMap<Long, List<Review>> reviews = new HashMap<>();

	protected VehicleDeposit() throws RemoteException {
		super();
	}
	
	public boolean isBuyable(long idVehicle) {
		return vehicles.get(idVehicle).getNbRented() > 0 && deposit.get(idVehicle).isEmpty();
	}

	public Vehicle getVehicleById(long idVehicle) {
		return vehicles.get(idVehicle);
	}
	
	public void removeVehicle(long idVehicle) {
		vehicles.remove(idVehicle);
		deposit.remove(idVehicle);
	}
	
	@Override
	public void render(long idVehicle, IClient client, short mark, String comment) throws RemoteException {

		IClient tmp = deposit.get(idVehicle).peek();
		if (tmp.equals(client)) {
			try {
				deposit.get(idVehicle).take();
				vehicles.get(idVehicle).setNbRented(vehicles.get(idVehicle).getNbRented() + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			reviews.get(idVehicle).add(new Review(client, idVehicle, mark, comment));
		}
	}

	@Override
	public void render(long idVehicle, IClient client) throws RemoteException {

		IClient tmp = deposit.get(idVehicle).peek();
		if (tmp.equals(client)) {
			try {
				deposit.get(idVehicle).take();
				vehicles.get(idVehicle).setNbRented(vehicles.get(idVehicle).getNbRented() + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void add(long id, String model, String brand, int nbRented, double buyPrice, double rentPrice, int ageRequired) throws RemoteException {
		Vehicle vehicle = new Vehicle(id, model, brand, nbRented, buyPrice ,rentPrice, ageRequired);
		vehicles.put(id, vehicle);
		deposit.put(id, new LinkedBlockingQueue<>());
		reviews.put(id, new ArrayList<>());
	}

	@Override
	public void rent(long idVehicle, IClient client) throws RemoteException {
		try {
			deposit.get(idVehicle).put(client);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Vehicle> searchByBrand(String brand) throws RemoteException {
		ArrayList<Vehicle> vehiclesTab = new ArrayList<>();
		for (Entry <Long,Vehicle> entry : vehicles.entrySet()) {
			Vehicle vehicle = entry.getValue();
			if (vehicle.getBrand().equals(brand)) {
				vehiclesTab.add(vehicle);
			}			
		}
		return vehiclesTab;
	}

	@Override
	public List<Vehicle> searchByModel(String model) throws RemoteException {
		ArrayList<Vehicle> vehiclesTab = new ArrayList<>();
		for (Entry <Long,Vehicle> entry : vehicles.entrySet()) {
			Vehicle vehicle = entry.getValue();
			if (vehicle.getModel().equals(model)) {
				vehiclesTab.add(vehicle);
			}			
		}
		return vehiclesTab;
	}
	
	@Override
	public List<Review> getReviewsById(long idVehicle) throws RemoteException {
		return reviews.get(idVehicle);
	}

}


