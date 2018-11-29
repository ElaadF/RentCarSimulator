package fr.upem.manage;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) {
		try {
			IVehicleDeposit vd = new VehicleDeposit();
			vd.add(1, "serie1", "bmw", 0, 16500,200, 18);
			vd.add(2, "megane", "renault", 0, 20000,300, 18);
			vd.add(3, "clio", "renault", 0, 15000,150, 18);
			vd.add(4, "A1", "audi", 0, 18000,250, 18);
			vd.add(5, "A3", "audi", 0, 25000,400, 25);
			System.out.println("Serveur ");
			Registry regis = LocateRegistry.createRegistry(1099);
			Naming.rebind("vehicleDeposit", vd);
		} catch (Exception e) {
			System.out.println("Trouble : " + e);
		}

	}

}
