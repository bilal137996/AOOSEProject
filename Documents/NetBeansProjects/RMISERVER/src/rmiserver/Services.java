/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import com.google.gson.Gson;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Password;

/**
 *
 * @author Bilal
 */
public class Services extends UnicastRemoteObject implements ServicesInterface , StaffServicesInterface {


 
    
    
 // double USDEGP ,USDEUR,USDSAR,USDQAR,USDGBP;
    private Object valVal;
   Random r = new Random();
    ExchangeRates rates;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      
    public Services() throws RemoteException {
        BankClients.RegisteredClients = new ArrayList();
        Transactions.transactionsList= new ArrayList();
        Staff.ExistedStaff= new ArrayList();
      
        
    }
     // @Override
//    public <T> T Loig(T instance, String username, String password) throws RemoteException {
//        if(instance instanceof BankClients){
//            for (int i = 0; i < BankClients.RegisteredClients.size(); i++) {
//            BankClients bankClient = BankClients.RegisteredClients.get(i);
//            if ((bankClient.getUserName().equals(username)) && (bankClient.getPassword().equals(password))) {
//                return bankClient;
//            }}
//    }
//        else if(instance instanceof Staff){
//          for (int i = 0; i < Staff.ExistedStaff.size(); i++) {
//            Staff staff = Staff.ExistedStaff.get(i);
//            if ((staff.getUserName().equals(username)) && (staff.getPassword().equals(password))) {
//                return instance;
//            }
//        }
//    }
//        else
//            return null;
//        return instance;
//    }
//    
 
   @Override
    public Object Loign(Object Param, String username, String password) throws RemoteException {
   
         if(Param instanceof BankClients){
               for (int i = 0; i < BankClients.RegisteredClients.size(); i++) {
            BankClients bankClient = BankClients.RegisteredClients.get(i);
            if ((bankClient.getUserName().equals(username)) && (bankClient.getPassword().equals(password))) {
                return bankClient;
            }
        }
       
        
    }else if(Param instanceof Staff){
          for (int i = 0; i < Staff.ExistedStaff.size(); i++) {
            Staff staff = Staff.ExistedStaff.get(i);
            if ((staff.getUserName().equals(username)) && (staff.getPassword().equals(password))) {
                return staff;
            }
        }
        
    }
         return null;
    }

    
//    @Override
//    public BankClients Loign(String UserName, String Password) throws RemoteException {
//         for (int i = 0; i < BankClients.RegisteredClients.size(); i++) {
//            BankClients bankClient = BankClients.RegisteredClients.get(i);
//            if ((bankClient.getUserName().equals(UserName)) && (bankClient.getPassword().equals(Password))) {
//                return bankClient;
//            }
//        }
//        return null;
//    }

    @Override
    public int Register(String UserName, String Fname, String Lname, String mail, String pass, String SSN) throws RemoteException {
        if (BankClients.UserExist(UserName)) {
            return 0;
        } else {
            BankClients client = new BankClients(UserName, Fname, Lname,mail,pass,SSN);
            client.setBalance(0);
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
    public Transactions ViewTransactionsHistory(int AccountNum) throws RemoteException {
        
       for(int i=0; i<Transactions.transactionsList.size();i++)
       {
           if(Transactions.transactionsList.get(i).getSenderAcc()==AccountNum )
           {
               Transactions x= Transactions.transactionsList.get(i);
//               x.getAmount();
//               x.getRecipientAcc();
//               x.getTimeStamp();
//               x.getTransactionNumber();
//               x.getType();
               return x;
           }
           
       }return null;
    }

    @Override
    public int CheckBalanceAmount(String UserName) throws RemoteException {
        for(int i =0 ; i<BankClients.RegisteredClients.size(); i++){
            if(BankClients.RegisteredClients.get(i).getUserName().equals(UserName))
                return BankClients.RegisteredClients.get(i).getBalance();
        }
        return 1;
    }

    @Override
     public ExchangeRates ViewExchangeRates() throws RemoteException, Exception {
   
            BaseRequest.DoGetMethod("http://apilayer.net/api/live?access_key=24f2628deeb8c12dae4b4d65160b52fa&currencies=EUR,EGP,GBP,SAR,QAR&source=USD&format=1",new RequestCallBack() {
                @Override
                public void success(String response) {
                   RootObject<Quotes> x=  new Gson().fromJson(response,new TypeToken<RootObject<Quotes>>(){}.getType());
                  if(x.getSuccess()==true){
             rates= new ExchangeRates(x.getQuotes().getUSDEGP(), x.getQuotes().getUSDEUR(),  x.getQuotes().getUSDSAR() ,x.getQuotes().getUSDQAR()
                             ,x.getQuotes().getUSDGBP());
         
             
                    
                    
                  } 
//                    System.out.println("Currency from 1 USD To EGP : "+USDEGP);
//                    System.out.println("Currency from 1 USD To Euro : "+USDEUR);
//                    System.out.println("Currency from 1 USD To Sterling Pounds : "+USDGBP);
//                    System.out.println("Currency from 1 USD To Saudi Arabian Ryal : "+USDSAR);
//                    System.out.println("Currency from 1 USD To Qatar Ryal : "+USDQAR);
                    
                    
                }
             

                @Override
                public void error(Exception e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
               return  rates;
    }

  

   
  

  

  
    
}
