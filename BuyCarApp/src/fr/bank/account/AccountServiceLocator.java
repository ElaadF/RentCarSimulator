/**
 * AccountServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.bank.account;

public class AccountServiceLocator extends org.apache.axis.client.Service implements fr.bank.account.AccountService {

    public AccountServiceLocator() {
    }


    public AccountServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Account
    private java.lang.String Account_address = "http://localhost:8080/BankService/services/Account";

    public java.lang.String getAccountAddress() {
        return Account_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AccountWSDDServiceName = "Account";

    public java.lang.String getAccountWSDDServiceName() {
        return AccountWSDDServiceName;
    }

    public void setAccountWSDDServiceName(java.lang.String name) {
        AccountWSDDServiceName = name;
    }

    public fr.bank.account.Account getAccount() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Account_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAccount(endpoint);
    }

    public fr.bank.account.Account getAccount(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.bank.account.AccountSoapBindingStub _stub = new fr.bank.account.AccountSoapBindingStub(portAddress, this);
            _stub.setPortName(getAccountWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAccountEndpointAddress(java.lang.String address) {
        Account_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.bank.account.Account.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.bank.account.AccountSoapBindingStub _stub = new fr.bank.account.AccountSoapBindingStub(new java.net.URL(Account_address), this);
                _stub.setPortName(getAccountWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Account".equals(inputPortName)) {
            return getAccount();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://account.bank.fr", "AccountService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://account.bank.fr", "Account"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Account".equals(portName)) {
            setAccountEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
