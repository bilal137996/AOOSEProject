/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bilal
 */
public class RMICLIENT {
   private static ServicesInterface services; // Our remote object
     private static ClientGUI loginGUI;
   // private static RegisterGUI registerGUI;
    private static ClientHomePage Homepage;
    private static Register registerGUI;
    private static ViewExchangeRates viewrates;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        initLoginGUI();
        initRegisterGUI();
        initHomePage();
        initViewratesGUI();
        loginGUI.setVisible(true);
        
          // and grab the remote auth object
        try {
            Registry r = LocateRegistry.getRegistry(1099);
            services = (ServicesInterface) r.lookup("x");
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
    }
      private static void initHomePage() {
        Homepage = new ClientHomePage();
        Homepage.setLocationRelativeTo(null); // center the screen
    }
private static void initViewratesGUI() {
       try {
           viewrates= new ViewExchangeRates();
           viewrates.setLocationRelativeTo(null);
           //NRG3 Leha tany 3ashan nzbt gui el ablo wl b3do :D just finish then copy paste ur work :D :D
            ExchangeRates rates = services.ViewExchangeRates();
            viewrates.setUSDEGP(rates.getUSDEGP());
             viewrates.setUSDEUR(rates.getUSDEUR());
              viewrates.setUSDSAR(rates.getUSDSAR());
               viewrates.setUSDQAR(rates.getUSDQAR());
                viewrates.setUSDGBP(rates.getUSDGBP());
            
           
       } catch (Exception ex) {
         
            System.out.println("Exception " + ex.toString());
       }
           
}
    
    private static void initLoginGUI(){
        
     loginGUI = new ClientGUI();
        loginGUI.setLocationRelativeTo(null); // center the screen
        // Register the action listeners
        loginGUI.getLoginButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
               try {
                //   if(loginGUI.Getclient().isSelected()){
                String username = loginGUI.getUserName();
                String password = loginGUI.getPassword();
                BankClients client = services.Loign(username, password);
                if (client == null) {
                    JOptionPane.showMessageDialog(null, "Wrong username/password. Please try again");
                } else {
                    JOptionPane.showMessageDialog(null, "Logged in successfully!");
                    loginGUI.dispose();
                    initLoginGUI();
                    Homepage.setUsername(client.getUserName());
                    Homepage.setAccnum(client.getAccountNumber());
                    Homepage.setVisible(true);
                }
                   //}
                 //  else if(loginGUI.GetAdmin().isSelected()){//Admin Login
                  // }
                   
               
               } catch (Exception ex) {
                System.out.println("exception " + ex.toString());
            }
         }
     } );
       
  loginGUI.getRegisterButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
                   
             loginGUI.dispose();
             initLoginGUI();
             registerGUI.setVisible(true);
         }
     });
    

    }

    
    
    private static void initRegisterGUI() {
        registerGUI = new Register();
        registerGUI.setLocationRelativeTo(null); //center the screen
        // Register the action listeners
        registerGUI.RegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                String username = registerGUI.getUsername();
                String password = registerGUI.getPassword();
                String Fname = registerGUI.getFname();
                String Lname=registerGUI.getLname();
                String ssn=registerGUI.Getssn();
                String email=registerGUI.getEmail();
                

                int newUser = services.Register(username, Fname, Lname,email,password,ssn);

                if (newUser == 0) {
                    JOptionPane.showMessageDialog(null, "Username already exists, please try another one");
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Registed successfully! ");
                    registerGUI.dispose();
                    initRegisterGUI();
                    loginGUI.setVisible(true);
                }

            } catch (Exception ex) {
                   
            }
            }
        });
         registerGUI.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    registerGUI.dispose();
                   initRegisterGUI();
                    loginGUI.setVisible(true);
            }
        });
                 
    }
}
