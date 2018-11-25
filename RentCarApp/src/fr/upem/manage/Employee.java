package fr.upem.manage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject implements IClient{
	private final Long id;
	private final String name;
	
	public Employee(Long id, String name) throws RemoteException {
		this.id = id;
		this.name = name;
	}
	
}
