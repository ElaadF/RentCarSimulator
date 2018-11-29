package fr.upem.client;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.rpc.ServiceException;

import fr.bank.account.Account;
import fr.bank.account.AccountServiceLocator;
import fr.bank.account.AccountSoapBindingStub;
import fr.upem.manage.BuyCarsService;
import fr.upem.manage.BuyCarsServiceServiceLocator;
import fr.upem.manage.BuyCarsServiceSoapBindingStub;
import fr.upem.manage.Review;
import fr.upem.manage.Vehicle;

public class Main {
	public static void main(String[] args) throws RemoteException, ServiceException {
		try {

			BuyCarsService buyService = new BuyCarsServiceServiceLocator().getBuyCarsService();
			((BuyCarsServiceSoapBindingStub)buyService).setMaintainSession(true);
			Account accountService = new AccountServiceLocator().getAccount();
			((AccountSoapBindingStub)accountService).setMaintainSession(true);
			accountService.createAccount(42L);

			Scanner sc = new Scanner(System.in);

			System.out.println("\n1 : Déposer de l'argent sur son compte \n2 : Ajouter au panier \n3 : Acheter panier \n4 : Afficher le prix du panier en fonction de la currency \n5 : Voir la liste des reviews d'une voiture \n6 : Voir la liste des voitures \n7 : Contenue du panier \n8 : Consulter solde du compte \n0 : Quitter");

			int i = sc.nextInt();

			while(i != 0) {

				if(i == 1) {
					System.out.println("Montant que vous voulez déposer : ");
					double amount = sc.nextDouble();
					accountService.deposit(42L, amount);
					System.out.println(amount + " déposer avec succès");
				}

				if(i == 2) {
					System.out.println("Id de la voiture que vous voulez ajouter au panier : ");
					long id = sc.nextLong();
					try {
						buyService.addToCart(id, 42L);
						System.out.println("voiture ajouter au panier");
					} catch (Exception e) {
						System.out.println("La voiture n'existe pas");
					}
				}

				if(i == 3) {
					try {
						if(!buyService.buy(42L, "USD")) {
							System.out.println("Panier vide !");
						}
						else
							System.out.println("Voiture(s) achetée(s)");
					} catch(Exception e) {
						System.out.println("Voiture(s) non disponible(s)");
					}
				}

				if(i == 4) {
					System.out.println("Devise pour laquelle vous voulez une conversion : ");
					String currency = sc.next();
					System.out.println(buyService.getPriceByCurrency(currency));
				}

				if(i == 5) {
					System.out.println("Id de la voiture dont vous voulez voir les reviews : ");
					int id = sc.nextInt();
					try {
						Review[] r = buyService.showReviewsById(id);
						for (Review review : r) {
							System.out.println("Note : " + review.getMark() + ", Commentaire : " + review.getComment());
						}
					} catch (Exception e) {
						System.out.println("Aucune review pour cette voiture : " + id);
					}

				}

				if(i == 6) {
					Vehicle[] vehicles = buyService.showVehicles();
					for (Vehicle vehicle : vehicles) {
						System.out.println("id : "+vehicle.getId() + ", marque : " + vehicle.getBrand() + ", modèle : " + vehicle.getModel() + 
								", nb de fois louée : " + vehicle.getNbRented() + ", prix de location : " + vehicle.getRentPrice() + 
								", prix d'achat " + vehicle.getBuyPrice() + ", âge requis : " + vehicle.getAgeRequired());
					}
				}

				if(i == 7) {
					try {
						Vehicle[] vehicles = buyService.getCartContent(42L);
						System.out.println("Panier actuel : ");
						for (Vehicle vehicle : vehicles) {
							System.out.println("id : "+vehicle.getId() + ", marque : " + vehicle.getBrand() + ", modèle : " + vehicle.getModel() + 
									", nb de fois louée : " + vehicle.getNbRented() + ", prix de location : " + vehicle.getRentPrice() + 
									", prix d'achat " + vehicle.getBuyPrice() + ", âge requis : " + vehicle.getAgeRequired());
						}
					}catch(Exception e) {
						System.out.println("Panier vide");
					}
				}

				if(i == 8) {
					System.out.println("solde actuel : " + accountService.accountBalance(42L));;
				}

				System.out.println("\n1 : Déposer de l'argent sur son compte \n2 : Ajouter au panier \n3 : Acheter panier \n4 : Afficher le prix du panier en fonction de la currency \n5 : Voir la liste des reviews d'une voiture \n6 : Voir la liste des voitures \n7 : Contenue du panier \n8 : Consulter solde du compte \n0 : Quitter");

				i = sc.nextInt();
			}

			System.out.println("Quitter");

		} catch (RemoteException e) {
			System.out.println("Trouble : " + e);
		}
	}
}
