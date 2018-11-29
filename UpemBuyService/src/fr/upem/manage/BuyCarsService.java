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
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;

import org.tempuri.ConverterLocator;
import org.tempuri.ConverterSoap;

import fr.bank.account.Account;
import fr.bank.account.AccountServiceLocator;
import fr.bank.account.AccountSoapBindingStub;

public class BuyCarsService {
	public HashMap<Long, List<Vehicle>> carts = new HashMap<>();
	public double price;
	
	public BuyCarsService() {
	}

	public Vehicle[] getCartContent(long idClient) throws RemoteException, NullPointerException{
		List<Vehicle> c = carts.get(idClient);
		int i=0;
		Vehicle[] v = new Vehicle[c.size()];
		for (Vehicle vehicle : c) {
			v[i] = vehicle;
			i++;
		}
		return v;
	}
	
	public void removeFromCart(long idClient, long idVehicle) throws NullPointerException {	
		List<Vehicle> newVehicles = carts.get(idClient);
		for (Vehicle vehicle : newVehicles) {
			if(vehicle.getId() == idVehicle)
				this.price = this.price - vehicle.getBuyPrice();
				newVehicles.remove(vehicle);
				
		}
		carts.replace(idClient, newVehicles);

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
		
		if(this.price == 0)
			return false;
		
		if(service.withdrawal(idClient, price)) {
			for (Vehicle vehicle : Vehicles) {
				System.out.println(vehicle.toString());
				((IVehicleDeposit) Naming.lookup("vehicleDeposit")).removeVehicle(vehicle.getId());				
			}
			this.price = 0;
			carts.get(idClient).clear();
			return true;
		}

		return false;
	}
	
	public  Vehicle[] showVehicles() throws RemoteException, MalformedURLException, NotBoundException {
		return ((IVehicleDeposit) Naming.lookup("vehicleDeposit")).getVehicles();
	}

	public  Vehicle[] showByModels(String model) throws RemoteException, MalformedURLException, NotBoundException {
		return ((IVehicleDeposit) Naming.lookup("vehicleDeposit")).searchByModel(model);
	}

	public  Review[] showReviewsById(long idVehicle) throws RemoteException, MalformedURLException, NotBoundException, NullPointerException {
		return ((IVehicleDeposit) Naming.lookup("vehicleDeposit")).getReviewsById(idVehicle);
	}
	
	public  Vehicle[] showByBrand(String brand) throws RemoteException, MalformedURLException, NotBoundException {
		return ((IVehicleDeposit) Naming.lookup("vehicleDeposit")).searchByModel(brand);
	}

	public boolean addToCart(long idVehicle, long idClient) throws NullPointerException, MalformedURLException, RemoteException, NotBoundException {
		if (((IVehicleDeposit) Naming.lookup("vehicleDeposit")).isBuyable(idVehicle)){
			List<Vehicle> a = carts.putIfAbsent(idClient, new ArrayList<>());
			carts.get(idClient).add(((IVehicleDeposit) Naming.lookup("vehicleDeposit")).getVehicleById(idVehicle));
			price = price + ((IVehicleDeposit) Naming.lookup("vehicleDeposit")).getVehicleById(idVehicle).getBuyPrice();
			System.out.println("BuyCars - fonction add : " + carts);
			return true;
		}
		return false;
	}

}
