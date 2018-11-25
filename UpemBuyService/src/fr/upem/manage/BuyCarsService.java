package fr.upem.manage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.tempuri.ConverterLocator;
import org.tempuri.ConverterSoap;

import fr.bank.account.Account;
import fr.bank.account.AccountServiceLocator;
import fr.bank.account.AccountSoapBindingStub;

public class BuyCarsService {
	private HashMap<Long, List<Vehicle>> carts = new HashMap<>();
	private IVehicleDeposit deposit;
	private double price;

	public void removeFromCart(long idClient, long idVehicle) {	
		List<Vehicle> newVehicles = carts.get(idClient);
		for (Vehicle vehicle : newVehicles) {
			if(vehicle.getId() == idVehicle)
				newVehicles.remove(vehicle);
		}
		carts.replace(idClient, newVehicles);

	}

	public BuyCarsService() {
	}


	public double getPriceByCurrency(String currency) {
		ConverterSoap converter;
		try {
			converter = new ConverterLocator().getConverterSoap();
			BigDecimal newTotalPrice = converter.getConversionAmount("EUR", currency, converter.getLastUpdateDate(), new BigDecimal(price, MathContext.DECIMAL64));
			return newTotalPrice.doubleValue();
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public boolean buy(long idClient, String currency) throws ServiceException, RemoteException, MalformedURLException, NotBoundException {
		Account service = new AccountServiceLocator().getAccount();
		((AccountSoapBindingStub)service).setMaintainSession(true);
		System.out.println("BuyCars - fonction buy : " + carts);
		List<Vehicle> Vehicles = carts.get(idClient);
		deposit = (IVehicleDeposit) Naming.lookup("vehicleDeposit");


		if(service.withdrawal(idClient, price)) {
			for (Vehicle vehicle : Vehicles) {
				deposit.removeVehicle(vehicle.getId());				
			}
			return true;
		}

		return false;
	}

	public  Vehicle[] showByModels(String model) throws RemoteException, MalformedURLException, NotBoundException {
		deposit = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
		List<Vehicle> vehicles = deposit.searchByBrand(model);
		Vehicle[] v = new Vehicle[vehicles.size()];
		for(int i =0; i< vehicles.size(); i++) {
			v[i] = vehicles.get(i);
		}
		return v;
	}

	public  Review[] showReviewsById(long idVehicle) throws RemoteException, MalformedURLException, NotBoundException {
		deposit = (IVehicleDeposit) Naming.lookup("vehicleDeposit");

		List<Review> reviews = deposit.getReviewsById(idVehicle);
		Review[] r = new Review[reviews.size()];
		for(int i =0; i< reviews.size(); i++) {
			r[i] = reviews.get(i);
		}
		return r;
	}
	
	public  Vehicle[] showByBrand(String brand) throws RemoteException, MalformedURLException, NotBoundException {
		deposit = (IVehicleDeposit) Naming.lookup("vehicleDeposit");

		List<Vehicle> vehicles = deposit.searchByBrand(brand);
		Vehicle[] v = new Vehicle[vehicles.size()];
		for(int i =0; i< vehicles.size(); i++) {
			v[i] = vehicles.get(i);
		}
		return v;
	}

	public boolean addToCart(long idVehicle, long idClient) throws MalformedURLException, RemoteException, NotBoundException {
		deposit = (IVehicleDeposit) Naming.lookup("vehicleDeposit");
		if (deposit.isBuyable(idVehicle)){
			List<Vehicle> a = carts.putIfAbsent(idClient, new ArrayList<>());
			carts.get(idClient).add(deposit.getVehicleById(idVehicle));
			price = price + deposit.getVehicleById(idVehicle).getBuyPrice();
			System.out.println("BuyCars - fonction add : " + carts);
			if(a==null)
				return false;
			return true;
		}
		return false;
	}

}
