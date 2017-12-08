/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Bilal
 */
public class Transactions implements Serializable {
    int SenderAcc, RecipientAcc,Amount;
    String TimeStamp, Type;
    public static ArrayList<Transactions> transactionsList;
  
    int TransactionNumber;
 

    public Transactions(int SenderAcc, int RecipientAcc, int Amount, String Type) {
        this.SenderAcc = SenderAcc;
        this.RecipientAcc = RecipientAcc;
        this.Amount = Amount;
        this.Type = Type;
 
    }
    
    

    public int getSenderAcc() {
        return SenderAcc;
    }

    public int getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(int TransactionNumber) {
        this.TransactionNumber = TransactionNumber;
    }

    public void setSenderAcc(int SenderAcc) {
        this.SenderAcc = SenderAcc;
    }

    public int getRecipientAcc() {
        return RecipientAcc;
    }

    public void setRecipientAcc(int RecipientAcc) {
        this.RecipientAcc = RecipientAcc;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    public static boolean CheckBalance(int SenderAcc , int amount){
        for(int i=0 ; i<BankClients.RegisteredClients.size();i++){
           if( BankClients.RegisteredClients.get(i).getAccountNumber()==SenderAcc)
               if(BankClients.RegisteredClients.get(i).getBalance()>=amount)
                   return true;
               
        }
        return false;
    }
    public  void DeduceAmountFromBalance(int SenderAcc , int amount){
      for(int i=0 ; i<BankClients.RegisteredClients.size();i++){
           if( BankClients.RegisteredClients.get(i).getAccountNumber()==SenderAcc){
               BankClients x=BankClients.RegisteredClients.get(i);
               x.Balance-=amount;
                       }
               
        }
    }
    
    
}
