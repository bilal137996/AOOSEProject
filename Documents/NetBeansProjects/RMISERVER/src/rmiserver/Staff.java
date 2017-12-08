/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.util.ArrayList;
import static rmiserver.BankClients.RegisteredClients;

/**
 *
 * @author Bilal
 */
public class Staff {
     private String FirstName,LastName,Email,Password,UserName;

public static ArrayList<Staff> ExistedStaff;

    public Staff() {
    }
     
    public Staff(String FirstName, String LastName, String Email, String Password, String UserName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }

    public String getFirstName() {
        return FirstName;
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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
        public static boolean UserExist(String UserName) {
        for (int i = 0; i < ExistedStaff.size(); i++) {
            if (ExistedStaff.get(i).getUserName().equals(UserName)) {
                return true;
            }
        }
        return false;
    }
     
}
