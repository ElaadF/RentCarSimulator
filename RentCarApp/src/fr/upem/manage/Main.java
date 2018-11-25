package fr.upem.manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;


public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			IVehicleDeposit depo = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
			Employee employee = new Employee(1L,"olive");
			List<Vehicle> vehicles = depo.searchByBrand("");

			Scanner sc = new Scanner(System.in);

			System.out.println("1 : Louer une voiture \n2 : Rendre la voiture \n3 : Rendre la voiture et noter \n4 : Voir la liste des voitures \n0 : Quitter");

			int i = sc.nextInt();

			while(i != 0) {				
				if(i == 1) {
					System.out.println("quelle voiture voulez-vous louée ? ");
					String str = sc.next();

					vehicles = depo.searchByBrand(str);

					depo.rent(vehicles.get(0).getId(), employee);
					System.out.println("voiture louée");
				}

				if(i == 2) {
					depo.render(vehicles.get(0).getId(), employee);
					System.out.println("voiture rendue");
				}

				if(i == 3) {
					System.out.println("noter l'état de la voiture (0 à 5) : ");
					short mark = sc.nextShort();
					System.out.println("commentez l'état de la voiture : ");
					String comment = sc.next();
					depo.render(vehicles.get(0).getId(), employee, mark, comment);
					System.out.println("voiture rendue");
				}

				if(i == 4) {
					System.out.println(depo.searchByBrand("bmw"));
					System.out.println(depo.searchByBrand("renault"));
					System.out.println(depo.searchByBrand("audi"));
				}

				i = sc.nextInt();
			}

			System.out.println("Quitter");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("Trouble : " + e);
		}
	}
}
