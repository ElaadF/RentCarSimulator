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


	private HashMap<Long, BlockingQueue<Long>> deposit = new HashMap<>();
	private HashMap<Long, Vehicle> vehicles = new HashMap<>();
	private List<Long> currentClient = new ArrayList<>();
	
	private HashMap<Long, List<Review>> reviews = new HashMap<>();

	protected VehicleDeposit() throws RemoteException {
		super();
	}
	
	public boolean isBuyable(long idVehicle) {
		return vehicles.get(idVehicle).getNbRented() >= 0 && deposit.get(idVehicle).isEmpty();
	}

	public Vehicle getVehicleById(long idVehicle) {
		return vehicles.get(idVehicle);
	}
	
	public void removeVehicle(long idVehicle) {
		vehicles.remove(idVehicle);
		deposit.remove(idVehicle);
	}
	
	@Override
	public void render(long idVehicle, long idClient, short mark, String comment) throws RemoteException {

		long tmp = deposit.get(idVehicle).peek();
		if (tmp == idClient) {
			try {
				currentClient.remove(idClient);
				deposit.get(idVehicle).take();
				vehicles.get(idVehicle).setNbRented(vehicles.get(idVehicle).getNbRented() + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			reviews.get(idVehicle).add(new Review(idClient, idVehicle, mark, comment));
		}
	}

	@Override
	public void render(long idVehicle, long idClient) throws RemoteException {

		long tmp = deposit.get(idVehicle).peek();
		if (tmp == idClient) {
			try {
				currentClient.remove(idClient);
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
	public boolean rent(long idVehicle, long idClient) throws RemoteException {
		try {
			deposit.get(idVehicle).put(idClient);
			if(!currentClient.contains(idClient)) {
				currentClient.add(idClient);
				return true;
			}
			else
				return false;
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vehicle[] getVehicles() throws RemoteException {
		Vehicle[] v = new Vehicle[vehicles.size()];
		int i =0;
		for (Entry <Long,Vehicle> entry : vehicles.entrySet()) {
			Vehicle vehicle = entry.getValue();
			v[i] = vehicle;
			i++;
		}
		return v;
	}
	

	@Override
	public Vehicle[] searchByBrand(String brand) throws RemoteException {
		Vehicle[] v = new Vehicle[vehicles.size()];
		int i =0;
		for (Entry <Long,Vehicle> entry : vehicles.entrySet()) {
			Vehicle vehicle = entry.getValue();
			if (vehicle.getBrand().equals(brand)) {
				v[i] = vehicle;
				i++;
			}			
		}
		return v;
	}

	@Override
	public Vehicle[] searchByModel(String model) throws RemoteException {
		Vehicle[] v = new Vehicle[vehicles.size()];
		int i =0;
		for (Entry <Long,Vehicle> entry : vehicles.entrySet()) {
			Vehicle vehicle = entry.getValue();
			if (vehicle.getModel().equals(model)) {
				v[i] = vehicle;
				i++;
			}			
		}
		return v;
	}
	
	@Override
	public Review[] getReviewsById(long idVehicle) throws RemoteException {
		for (Entry <Long,List<Review>> entry : reviews.entrySet()) {
			List<Review> review = entry.getValue();
			if(entry.getKey() == idVehicle) {
				Review[] r = new Review[entry.getValue().size()];
				for(int i=0; i < entry.getValue().size(); i++) {
					r[i] = entry.getValue().get(i);	
				}
				return r;
			}
		}
	return null;	
	}

}


