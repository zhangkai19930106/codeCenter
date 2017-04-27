package com.bonc.codeCenter.ws.client;

public class CodeCenterWSProxy implements com.bonc.codeCenter.ws.client.CodeCenterWS {
  private String _endpoint = null;
  private com.bonc.codeCenter.ws.client.CodeCenterWS codeCenterWS = null;
  
  public CodeCenterWSProxy() {
    _initCodeCenterWSProxy();
  }
  
  public CodeCenterWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initCodeCenterWSProxy();
  }
  
  private void _initCodeCenterWSProxy() {
    try {
      codeCenterWS = (new com.bonc.codeCenter.ws.client.CodeCenterWSImplServiceLocator()).getCodeCenterWSImplPort();
      if (codeCenterWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)codeCenterWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)codeCenterWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (codeCenterWS != null)
      ((javax.xml.rpc.Stub)codeCenterWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bonc.codeCenter.ws.client.CodeCenterWS getCodeCenterWS() {
    if (codeCenterWS == null)
      _initCodeCenterWSProxy();
    return codeCenterWS;
  }
  
  public java.lang.String CCService(java.lang.String request) throws java.rmi.RemoteException{
    if (codeCenterWS == null)
      _initCodeCenterWSProxy();
    return codeCenterWS.CCService(request);
  }
  
  
}