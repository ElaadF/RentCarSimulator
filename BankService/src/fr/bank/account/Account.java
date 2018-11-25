package fr.bank.account;

import java.util.HashMap;

public class Account {
	
	private HashMap<Long, Double> clients = new HashMap<>();
	
	public void createAccount(long idClient) {
		clients.putIfAbsent(idClient, 0.0);
	}
	
	public void deposit(long idClient, double amount) {
		System.out.println("bank depo : " + clients);
		clients.put(idClient, clients.get(idClient) + amount);
	}
	
	public boolean withdrawal(long idClient, double amount) {
		if(clients.get(idClient) < amount)
			return false;
		clients.put(idClient, clients.get(idClient) - amount);
		return true;
	}
	
	public Double accountBalance(long idClient) {
		return clients.get(idClient);
	}
}
