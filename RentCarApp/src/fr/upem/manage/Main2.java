package fr.upem.manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;


public class Main2 {
	public static void main(String[] args) {
		try {
			IVehicleDeposit depo = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
			Employee employee = new Employee(2L,"raph");
			long current_id = -1;
			Vehicle[] vehicles = depo.getVehicles();
			short mark = 0;
			
			Scanner sc = new Scanner(System.in);

			System.out.println("1 : Louer une voiture \n2 : Rendre la voiture \n3 : Rendre la voiture et noter \n4 : Voir la liste des voitures \n0 : Quitter");

			int i = sc.nextInt();

			while(i != 0) {				
				if(i == 1) {
					System.out.println("quelle voiture voulez-vous louée ? ");
					current_id = sc.nextLong();		
					
					if(depo.rent(current_id, employee.getId()))
						System.out.println("voiture louée");
					else
						System.out.println("Vous louez déjà une voiture");
				}

				if(i == 2) {
					if(current_id == -1) {
						System.out.println("Aucune voiture louée");
					}
					else {
						depo.render(current_id, employee.getId());
						current_id = -1;
						System.out.println("voiture rendue");
					}
				}

				if(i == 3) {
					if(current_id == -1) {
						System.out.println("Aucune voiture louée");
					}
					else {
						do{
							System.out.println("noter l'état de la voiture (0 à 5) : ");
							try {
								mark = sc.nextShort();
							} catch (Exception e) {
								System.out.println("Note incorrecte");
							}
						}while(mark > 5 || mark < 0);
						System.out.println("commentez l'état de la voiture : ");
						String comment = sc.next();
						depo.render(current_id, employee.getId(), mark, comment);
						current_id = -1;
						System.out.println("voiture rendue");
					}

				}

				if(i == 4) {
					vehicles = depo.getVehicles();
					for (Vehicle vehicle : vehicles) {
						System.out.println("id : "+vehicle.getId() + ", marque : " + vehicle.getBrand() + ", modèle : " + vehicle.getModel() + 
								", nb de fois louée : " + vehicle.getNbRented() + ", prix de location : " + vehicle.getRentPrice() + 
								", prix d'achat " + vehicle.getBuyPrice() + ", âge requis : " + vehicle.getAgeRequired());
					}
					
				}

				System.out.println("1 : Louer une voiture \n2 : Rendre la voiture \n3 : Rendre la voiture et noter \n4 : Voir la liste des voitures \n0 : Quitter");
				i = sc.nextInt();
			}

			System.out.println("Quitter");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("Trouble : " + e);
		}
	}
}
