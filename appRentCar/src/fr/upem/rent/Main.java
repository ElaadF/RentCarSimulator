package fr.upem.rent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


public class Main {
public static void main(String[] args) {
	try {
		IVehicleDeposit depo = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
		List<Vehicle> vehicles = depo.searchByBrand("bmw");
		Employee employee = new Employee(1L,"olive");
		depo.rent(vehicles.get(0), employee);
		System.out.println(employee.getCurrentVehicle());
		depo.render(); 
		
		System.out.println(depo.searchByBrand("bmw"));
	} catch (MalformedURLException | RemoteException | NotBoundException e) {
		System.out.println("Trouble : " + e);
	}
}
}
