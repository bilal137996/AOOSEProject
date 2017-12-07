/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bilal
 */
public interface ServicesInterface extends Remote {
     public BankClients Loign(String username, String password) throws RemoteException;
    
    public int Register(String UserName,String Fname,String Lname,String mail,String pass, String SSN,int Balance) throws RemoteException;  
    
    public int Make_A_Transaction(int SenderAcc, int RecipientAcc,
            int Amount,  String Type )  throws RemoteException;  
    
    public int ViewTransactionsHistory(int AccountNum) throws RemoteException;  
    
    public int CheckBalanceAmount(String UserName) throws RemoteException;
     public void ViewExchangeRates() throws RemoteException, Exception;
    

    
}
