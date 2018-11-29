/**
 * ConverterLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ConverterLocator extends org.apache.axis.client.Service implements org.tempuri.Converter {

    public ConverterLocator() {
    }


    public ConverterLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConverterLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConverterSoap
    private java.lang.String ConverterSoap_address = "http://currencyconverter.kowabunga.net/converter.asmx";

    public java.lang.String getConverterSoapAddress() {
        return ConverterSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConverterSoapWSDDServiceName = "ConverterSoap";

    public java.lang.String getConverterSoapWSDDServiceName() {
        return ConverterSoapWSDDServiceName;
    }

    public void setConverterSoapWSDDServiceName(java.lang.String name) {
        ConverterSoapWSDDServiceName = name;
    }

    public org.tempuri.ConverterSoap getConverterSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConverterSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConverterSoap(endpoint);
    }

    public org.tempuri.ConverterSoap getConverterSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.ConverterSoapStub _stub = new org.tempuri.ConverterSoapStub(portAddress, this);
            _stub.setPortName(getConverterSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConverterSoapEndpointAddress(java.lang.String address) {
        ConverterSoap_address = address;
    }


    // Use to get a proxy class for ConverterSoap12
    private java.lang.String ConverterSoap12_address = "http://currencyconverter.kowabunga.net/converter.asmx";

    public java.lang.String getConverterSoap12Address() {
        return ConverterSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConverterSoap12WSDDServiceName = "ConverterSoap12";

    public java.lang.String getConverterSoap12WSDDServiceName() {
        return ConverterSoap12WSDDServiceName;
    }

    public void setConverterSoap12WSDDServiceName(java.lang.String name) {
        ConverterSoap12WSDDServiceName = name;
    }

    public org.tempuri.ConverterSoap getConverterSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConverterSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConverterSoap12(endpoint);
    }

    public org.tempuri.ConverterSoap getConverterSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.ConverterSoap12Stub _stub = new org.tempuri.ConverterSoap12Stub(portAddress, this);
            _stub.setPortName(getConverterSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConverterSoap12EndpointAddress(java.lang.String address) {
        ConverterSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ConverterSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.ConverterSoapStub _stub = new org.tempuri.ConverterSoapStub(new java.net.URL(ConverterSoap_address), this);
                _stub.setPortName(getConverterSoapWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.ConverterSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.ConverterSoap12Stub _stub = new org.tempuri.ConverterSoap12Stub(new java.net.URL(ConverterSoap12_address), this);
                _stub.setPortName(getConverterSoap12WSDDServiceName());
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
        if ("ConverterSoap".equals(inputPortName)) {
            return getConverterSoap();
        }
        else if ("ConverterSoap12".equals(inputPortName)) {
            return getConverterSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Converter");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ConverterSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ConverterSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConverterSoap".equals(portName)) {
            setConverterSoapEndpointAddress(address);
        }
        else 
if ("ConverterSoap12".equals(portName)) {
            setConverterSoap12EndpointAddress(address);
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
