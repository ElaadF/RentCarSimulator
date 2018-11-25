/**
 * BuyCarsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.manage;

public interface BuyCarsService extends java.rmi.Remote {
    public void removeFromCart(long idClient, long idVehicle) throws java.rmi.RemoteException;
    public double getPriceByCurrency(java.lang.String currency) throws java.rmi.RemoteException;
    public fr.upem.manage.Vehicle[] showByModels(java.lang.String model) throws java.rmi.RemoteException;
    public fr.upem.manage.Vehicle[] showByBrand(java.lang.String brand) throws java.rmi.RemoteException;
    public boolean addToCart(long idVehicle, long idClient) throws java.rmi.RemoteException;
    public boolean buy(long idClient, java.lang.String currency) throws java.rmi.RemoteException;
}
