package fr.upem.rent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class VehicleDeposit extends UnicastRemoteObject implements IVehicleDeposit{
	
	private HashMap<Vehicle, BlockingQueue<IClient>> deposit = new HashMap<>();
	private List<Review> reviews = new ArrayList<>();
	
	protected VehicleDeposit() throws RemoteException {
		super();
	}

	@Override
	//TODO mettre l'employe en argument pour crée la review et pour verifier qu'il loue vraiment vehicle
	public void render(Vehicle vehicle, IClient client, short mark, String comment) throws RemoteException {
		
		try {
			IClient tmp = deposit.get(vehicle).peek();
			if (tmp.equals(client)) {
				deposit.get(vehicle).take();
				reviews.add(new Review(client, vehicle.getId(), mark, comment));
				//deposit.get(vehicle.getId()).setNbRented(vehicle.getNbRented() + 1);
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void render(Vehicle vehicle, IClient client) throws RemoteException {
		
		try {
			IClient tmp = deposit.get(vehicle).peek();
			if (tmp.equals(client)) {
				deposit.get(vehicle).take();
				//deposit.get(vehicle.getId()).setNbRented(vehicle.getNbRented() + 1);
			}		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void add(long id, String model, String brand, int nbRented, double price, int ageRequired) throws RemoteException {
		Vehicle vehicle = new Vehicle(id, model, brand, nbRented, price, ageRequired);
		deposit.putIfAbsent(vehicle, new LinkedBlockingQueue<>());
	}

	@Override
	public void rent(Vehicle vehicle, IClient client) throws RemoteException {
		//int nbClients = deposit.get(idVehicle).getNbClients();
		int nbClients = deposit.get(vehicle).size();
		try {
			deposit.get(vehicle).put(client);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*if (nbClients == 0) {
			deposit.get(idVehicle).setNbClients(nbClients + 1);
			
		}else {
			while(true) {
				try {
					deposit.get(idVehicle).getClients().put(client);
					deposit.get(idVehicle).setNbClients(nbClients + 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}*/
		
	}


	@Override
	public List<Vehicle> searchByBrand(String brand) throws RemoteException {
		return deposit.keySet().stream().filter(vehicle -> vehicle.getBrand().equals(brand)).collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> searchByModel(String model) throws RemoteException {
		return deposit.keySet().stream().filter(vehicle -> vehicle.getModel().equals(model)).collect(Collectors.toList());
	}
	
}
	
	
