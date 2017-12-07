/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Bilal
 */
public class BankClients  implements Serializable {
    private String FirstName,LastName,Email,Password,SSN,UserName;
    int Balance;  int AccountNumber; //implement AccountNumber
   public static ArrayList<BankClients> RegisteredClients;
    
    public BankClients(String UserName,String Fname,String Lname,String mail,String pass, String SSN,int Balance){
        this.Balance=Balance;
        this.FirstName=Fname; this.LastName=Lname; this.Email=mail; this.Password=pass;this.SSN=SSN;
        this.UserName=UserName;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }
      public static boolean UserExist(String UserName) {
        for (int i = 0; i < RegisteredClients.size(); i++) {
            if (RegisteredClients.get(i).getUserName().equals(UserName)) {
                return true;
            }
        }
        return false;
    }
       public static boolean AccountExist(int accNum) {
         
        for (int i = 0; i < RegisteredClients.size(); i++) {
            if (RegisteredClients.get(i).getAccountNumber()==accNum) {
                return true;
            }
        }
        return false;
    }
}
