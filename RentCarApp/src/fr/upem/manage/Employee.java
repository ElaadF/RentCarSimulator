package fr.upem.manage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject{
	private final long id;
	private final String name;
	
	public Employee(long id, String name) throws RemoteException {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
