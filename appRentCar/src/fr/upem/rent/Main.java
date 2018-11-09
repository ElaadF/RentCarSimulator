package fr.upem.rent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Main {
public static void main(String[] args) {
	try {
		IVehicleDeposit depo = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
		System.out.println(depo.searchByBrand("bmw"));
		Vehicle myVehicle = depo.rent(12L);
		depo.render(myVehicle);
		System.out.println(depo.searchByBrand("bmw"));
	} catch (MalformedURLException | RemoteException | NotBoundException e) {
		System.out.println("Trouble : " + e);
	}
}
}
