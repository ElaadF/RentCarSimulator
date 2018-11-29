/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.bank.account;

public interface Account extends java.rmi.Remote {
    public void deposit(long idClient, double amount) throws java.rmi.RemoteException;
    public boolean withdrawal(long idClient, double amount) throws java.rmi.RemoteException;
    public double accountBalance(long idClient) throws java.rmi.RemoteException;
    public void createAccount(long idClient) throws java.rmi.RemoteException;
}
