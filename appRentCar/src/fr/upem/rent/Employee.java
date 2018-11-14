package fr.upem.rent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject implements IClient{
	private final Long id;
	private final String name;
	private Vehicle currentVehicle;
	
	public Employee(Long id, String name) throws RemoteException {
		this.id = id;
		this.name = name;
	}

	public void setCurrentVehicle(Vehicle vehicle) {
		currentVehicle = vehicle;
	}
	
	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}
	
}
