/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.google.gson.Gson;


/**
 *
 * @author Bilal
 */
public class RMISERVER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            ServicesInterface services = new Services();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("services", services);
            System.out.println("Server running.");
          
        } catch (Exception ex) {
        }
    }
    
}
