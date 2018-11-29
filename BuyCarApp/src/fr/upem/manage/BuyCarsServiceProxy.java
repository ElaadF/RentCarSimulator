package fr.upem.manage;

public class BuyCarsServiceProxy implements fr.upem.manage.BuyCarsService {
  private String _endpoint = null;
  private fr.upem.manage.BuyCarsService buyCarsService = null;
  
  public BuyCarsServiceProxy() {
    _initBuyCarsServiceProxy();
  }
  
  public BuyCarsServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBuyCarsServiceProxy();
  }
  
  private void _initBuyCarsServiceProxy() {
    try {
      buyCarsService = (new fr.upem.manage.BuyCarsServiceServiceLocator()).getBuyCarsService();
      if (buyCarsService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)buyCarsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)buyCarsService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (buyCarsService != null)
      ((javax.xml.rpc.Stub)buyCarsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.upem.manage.BuyCarsService getBuyCarsService() {
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService;
  }
  
  public void removeFromCart(long idClient, long idVehicle) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    buyCarsService.removeFromCart(idClient, idVehicle);
  }
  
  public double getPriceByCurrency(java.lang.String currency) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.getPriceByCurrency(currency);
  }
  
  public fr.upem.manage.Review[] showReviewsById(long idVehicle) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.showReviewsById(idVehicle);
  }
  
  public fr.upem.manage.Vehicle[] showByBrand(java.lang.String brand) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.showByBrand(brand);
  }
  
  public fr.upem.manage.Vehicle[] showByModels(java.lang.String model) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.showByModels(model);
  }
  
  public fr.upem.manage.Vehicle[] getCartContent(long idClient) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.getCartContent(idClient);
  }
  
  public fr.upem.manage.Vehicle[] showVehicles() throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.showVehicles();
  }
  
  public boolean addToCart(long idVehicle, long idClient) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.addToCart(idVehicle, idClient);
  }
  
  public boolean buy(long idClient, java.lang.String currency) throws java.rmi.RemoteException{
    if (buyCarsService == null)
      _initBuyCarsServiceProxy();
    return buyCarsService.buy(idClient, currency);
  }
  
  
}