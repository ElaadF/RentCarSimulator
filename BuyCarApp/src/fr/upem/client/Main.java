package fr.upem.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

import fr.bank.account.Account;
import fr.bank.account.AccountServiceLocator;
import fr.bank.account.AccountSoapBindingStub;
import fr.upem.manage.BuyCarsService;
import fr.upem.manage.BuyCarsServiceServiceLocator;
import fr.upem.manage.BuyCarsServiceSoapBindingStub;
import fr.upem.manage.IVehicleDeposit;


public class Main {
	public static void main(String[] args) throws RemoteException, ServiceException {
		try {
			
			BuyCarsService buyService = new BuyCarsServiceServiceLocator().getBuyCarsService();
			((BuyCarsServiceSoapBindingStub)buyService).setMaintainSession(true);
			Account accountService = new AccountServiceLocator().getAccount();
			((AccountSoapBindingStub)accountService).setMaintainSession(true);
			accountService.createAccount(42);
		
			IVehicleDeposit depo = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
			
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("1 : Déposer de l'argent sur son compte \n2 : Ajouter au panier \n3 : Acheter panier \n4 : Afficher le prix du panier en fonction de la currency \n5 : Voir la liste des reviews d'une voiture \n 6 : Voir la liste des voitures \n0 : Quitter");
	
			int i = sc.nextInt();
			
			while(i != 0) {
				if(i == 1) {
					System.out.println("Montant que vous voulez déposer : ");
					int id = sc.nextInt();
					accountService.deposit(42, id);
				}
				
				if(i == 2) {
					System.out.println("Id de la voiture que vous voulez ajouter au panier : ");
					int id = sc.nextInt();
					buyService.addToCart(id, 42);
				}
				
				if(i == 3) {
					buyService.buy(42, "USD");
					System.out.println("Voiture(s) achetée(s)");
				}
				
				if(i == 4) {
					System.out.println("Devise pour laquelle vous voulez une conversion : ");
					String currency = sc.next();
					buyService.getPriceByCurrency(currency);
				}
				
				if(i == 5) {
					System.out.println("Id de la voiture dont vous voulez voir les reviews : ");
					int id = sc.nextInt();
					System.out.println(depo.getReviewsById(id));	
				}
				
				if(i == 6) {
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
