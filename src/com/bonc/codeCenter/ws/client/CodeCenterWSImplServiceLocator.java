/**
 * CodeCenterWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bonc.codeCenter.ws.client;

public class CodeCenterWSImplServiceLocator extends org.apache.axis.client.Service implements com.bonc.codeCenter.ws.client.CodeCenterWSImplService {

    public CodeCenterWSImplServiceLocator() {
    }


    public CodeCenterWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CodeCenterWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CodeCenterWSImplPort
    private java.lang.String CodeCenterWSImplPort_address = "http://132.35.195.32:8099/codeCenter/codeCenter";

    public java.lang.String getCodeCenterWSImplPortAddress() {
        return CodeCenterWSImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CodeCenterWSImplPortWSDDServiceName = "CodeCenterWSImplPort";

    public java.lang.String getCodeCenterWSImplPortWSDDServiceName() {
        return CodeCenterWSImplPortWSDDServiceName;
    }

    public void setCodeCenterWSImplPortWSDDServiceName(java.lang.String name) {
        CodeCenterWSImplPortWSDDServiceName = name;
    }

    public com.bonc.codeCenter.ws.client.CodeCenterWS getCodeCenterWSImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CodeCenterWSImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCodeCenterWSImplPort(endpoint);
    }

    public com.bonc.codeCenter.ws.client.CodeCenterWS getCodeCenterWSImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bonc.codeCenter.ws.client.CodeCenterWSImplServiceSoapBindingStub _stub = new com.bonc.codeCenter.ws.client.CodeCenterWSImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCodeCenterWSImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCodeCenterWSImplPortEndpointAddress(java.lang.String address) {
        CodeCenterWSImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bonc.codeCenter.ws.client.CodeCenterWS.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bonc.codeCenter.ws.client.CodeCenterWSImplServiceSoapBindingStub _stub = new com.bonc.codeCenter.ws.client.CodeCenterWSImplServiceSoapBindingStub(new java.net.URL(CodeCenterWSImplPort_address), this);
                _stub.setPortName(getCodeCenterWSImplPortWSDDServiceName());
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
        if ("CodeCenterWSImplPort".equals(inputPortName)) {
            return getCodeCenterWSImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://client.ws.bonc.com/", "CodeCenterWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://client.ws.bonc.com/", "CodeCenterWSImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CodeCenterWSImplPort".equals(portName)) {
            setCodeCenterWSImplPortEndpointAddress(address);
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
