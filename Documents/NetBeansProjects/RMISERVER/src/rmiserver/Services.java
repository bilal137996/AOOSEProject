/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Bilal
 */
public class Services implements ServicesInterface {
 

    public Services() throws RemoteException {
        BankClients.RegisteredClients = new ArrayList();
    }
    @Override
    public BankClients Loign(String UserName, String Password) throws RemoteException {
         for (int i = 0; i < BankClients.RegisteredClients.size(); i++) {
            BankClients bankClient = BankClients.RegisteredClients.get(i);
            if ((bankClient.getUserName().equals(UserName)) && (bankClient.getPassword().equals(Password))) {
                return bankClient;
            }
        }
        return null;
    }

    @Override
    public int Register(String UserName, String Fname, String Lname, String mail, String pass, String SSN, int Balance) throws RemoteException {
        if (BankClients.UserExist(UserName)) {
            return 0;
        } else {
            BankClients client = new BankClients(UserName, Fname, Lname,mail,pass,SSN,0);
            BankClients.RegisteredClients.add(client);
            return 1;
        }
    }
    
}
