/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Bilal
 */
public class Services implements ServicesInterface {
 
   Random r = new Random();
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
    public Services() throws RemoteException {
        BankClients.RegisteredClients = new ArrayList();
        Transactions.transactionsList= new ArrayList();
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
            client.setAccountNumber(100000 + (int)(r.nextFloat() * 899900));
            BankClients.RegisteredClients.add(client);
            return 1;
        }
    }
    

    @Override
    public int Make_A_Transaction(int SenderAcc, int RecipientAcc, int Amount, String Type) throws RemoteException {
        if(BankClients.AccountExist(RecipientAcc)){
            return 0;
        }
        else { 
            
            if(!Transactions.CheckBalance(SenderAcc, Amount)){
            return 0;
            }
            else {
            Transactions newTransaction= new Transactions(SenderAcc,RecipientAcc,Amount,Type);
        newTransaction.setTransactionNumber(100000 + (int)(r.nextFloat() * 899900));
        newTransaction.setTimeStamp(sdf.format(date));
        newTransaction.DeduceAmountFromBalance(SenderAcc,Amount);
        Transactions.transactionsList.add(newTransaction);
        return 1;}}
     
    }

    @Override
    public int ViewTransactionsHistory(int AccountNum) throws RemoteException {
        
       for(int i=0; i<Transactions.transactionsList.size();i++)
       {
           if(Transactions.transactionsList.get(i).getSenderAcc()==AccountNum )
           {
               Transactions x= Transactions.transactionsList.get(i);
               x.getAmount();
               x.getRecipientAcc();
               x.getTimeStamp();
               x.getTransactionNumber();
               x.getType();
               return 1;
               
           }
           
       }return 0;
    }
    
}
