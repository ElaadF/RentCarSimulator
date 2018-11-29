package fr.bank.account;

public class AccountProxy implements fr.bank.account.Account {
  private String _endpoint = null;
  private fr.bank.account.Account account = null;
  
  public AccountProxy() {
    _initAccountProxy();
  }
  
  public AccountProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountProxy();
  }
  
  private void _initAccountProxy() {
    try {
      account = (new fr.bank.account.AccountServiceLocator()).getAccount();
      if (account != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)account)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)account)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (account != null)
      ((javax.xml.rpc.Stub)account)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.bank.account.Account getAccount() {
    if (account == null)
      _initAccountProxy();
    return account;
  }
  
  public void deposit(long idClient, double amount) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    account.deposit(idClient, amount);
  }
  
  public boolean withdrawal(long idClient, double amount) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    return account.withdrawal(idClient, amount);
  }
  
  public double accountBalance(long idClient) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    return account.accountBalance(idClient);
  }
  
  public void createAccount(long idClient) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    account.createAccount(idClient);
  }
  
  
}