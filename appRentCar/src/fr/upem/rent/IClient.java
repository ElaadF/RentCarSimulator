package fr.upem.rent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

	public void setCurrentVehicle(Vehicle vehicle) throws RemoteException;
}
