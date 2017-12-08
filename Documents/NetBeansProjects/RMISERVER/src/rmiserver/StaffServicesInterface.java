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
public interface StaffServicesInterface  extends Remote{
    
   public Object Loign(Object Param,String username, String password) throws RemoteException;
    
}
