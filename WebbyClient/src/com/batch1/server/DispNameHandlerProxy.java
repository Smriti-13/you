package com.batch1.server;

public class DispNameHandlerProxy implements com.batch1.server.DispNameHandler {
  private String _endpoint = null;
  private com.batch1.server.DispNameHandler dispNameHandler = null;
  
  public DispNameHandlerProxy() {
    _initDispNameHandlerProxy();
  }
  
  public DispNameHandlerProxy(String endpoint) {
    _endpoint = endpoint;
    _initDispNameHandlerProxy();
  }
  
  private void _initDispNameHandlerProxy() {
    try {
      dispNameHandler = (new com.batch1.server.DispNameHandlerServiceLocator()).getDispNameHandler();
      if (dispNameHandler != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dispNameHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dispNameHandler)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dispNameHandler != null)
      ((javax.xml.rpc.Stub)dispNameHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.batch1.server.DispNameHandler getDispNameHandler() {
    if (dispNameHandler == null)
      _initDispNameHandlerProxy();
    return dispNameHandler;
  }
  
  public java.lang.String displayMyName(java.lang.String mn) throws java.rmi.RemoteException{
    if (dispNameHandler == null)
      _initDispNameHandlerProxy();
    return dispNameHandler.displayMyName(mn);
  }
  
  
}