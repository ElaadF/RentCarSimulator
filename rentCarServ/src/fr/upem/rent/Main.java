package fr.upem.rent;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) {
		try {
			IVehicleDeposit vd = new VehicleDeposit();
			vd.add(12, "serie1", "bmw", 0, 200, 18);
			Registry regis = LocateRegistry.createRegistry(1099);
			Naming.rebind("vehicleDeposit", vd);
			//Naming.rebind("rmi://localhost:1099/calculator", calculator);
		} catch (Exception e) {
			System.out.println("Trouble : " + e);
		}

	}

}
