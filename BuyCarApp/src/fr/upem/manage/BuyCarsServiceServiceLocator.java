/**
 * BuyCarsServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.manage;

public class BuyCarsServiceServiceLocator extends org.apache.axis.client.Service implements fr.upem.manage.BuyCarsServiceService {

    public BuyCarsServiceServiceLocator() {
    }


    public BuyCarsServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BuyCarsServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BuyCarsService
    private java.lang.String BuyCarsService_address = "http://localhost:8080/UpemBuyService/services/BuyCarsService";

    public java.lang.String getBuyCarsServiceAddress() {
        return BuyCarsService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BuyCarsServiceWSDDServiceName = "BuyCarsService";

    public java.lang.String getBuyCarsServiceWSDDServiceName() {
        return BuyCarsServiceWSDDServiceName;
    }

    public void setBuyCarsServiceWSDDServiceName(java.lang.String name) {
        BuyCarsServiceWSDDServiceName = name;
    }

    public fr.upem.manage.BuyCarsService getBuyCarsService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BuyCarsService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBuyCarsService(endpoint);
    }

    public fr.upem.manage.BuyCarsService getBuyCarsService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.upem.manage.BuyCarsServiceSoapBindingStub _stub = new fr.upem.manage.BuyCarsServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBuyCarsServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBuyCarsServiceEndpointAddress(java.lang.String address) {
        BuyCarsService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.upem.manage.BuyCarsService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.upem.manage.BuyCarsServiceSoapBindingStub _stub = new fr.upem.manage.BuyCarsServiceSoapBindingStub(new java.net.URL(BuyCarsService_address), this);
                _stub.setPortName(getBuyCarsServiceWSDDServiceName());
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
        if ("BuyCarsService".equals(inputPortName)) {
            return getBuyCarsService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://manage.upem.fr", "BuyCarsServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://manage.upem.fr", "BuyCarsService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BuyCarsService".equals(portName)) {
            setBuyCarsServiceEndpointAddress(address);
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
