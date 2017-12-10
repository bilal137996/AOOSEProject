/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import com.mongodb.MongoClient; 

/**
 *
 * @author Bilal
 */
public class RMISERVER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*  try {
            ServicesInterface services = new Services();
            
           
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("x", services);
            System.out.println("Server running.");
        } catch (RemoteException | AlreadyBoundException ex) {
        }*/

     // 
      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );     // connects to the mongodb provided the host name and port number
      
      // use the commented part to authenticate, i don't know if this is the verification part in the marking criteria
      /*
      Authentication (Optional)
MongoDB can be run in a secure mode where access to databases is controlled via authentication. When run in this mode, any client application must provide a list of credentials which will be used to authenticate against. In the Java driver, you simply provide the credentials when creating a MongoClient instance:

MongoCredential credential = MongoCredential.createCredential(userName, database, password);
MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));*/

       DB database = mongoClient.getDB("admin");    // to connect to the database, provide its name
       
       DBCollection collection = database.getCollection("SE");      // to connect to the collection in the database, provide its name
       // String UserName, String Fname, String Lname, String mail, String pass, String SSN
       BasicDBObject Client = new BasicDBObject("Username","johny").append("First name","john").append("Last name","locks").append("EMAIL","first@first.com").append("Password","982346rfda");    // make a new record, provide the entity title then the value, and use append to add more entities
       BasicDBObject Client2 = new BasicDBObject("Username","johnson").append("First name","johns").append("Last name","apaller").append("EMAIL","second@second.com").append("Password","dfsfdf46rfda");    // make a new record, provide the entity title then the value, and use append to add more entities
       BasicDBObject Client3 = new BasicDBObject("Username","antony").append("First name","tony").append("Last name","jim").append("EMAIL","third@third.com").append("Password","89euf46rfda");    // make a new record, provide the entity title then the value, and use append to add more entities
       BasicDBObject Client4 = new BasicDBObject("Username","tom").append("First name","tomy").append("Last name","stefson").append("EMAIL","fourth@fourth.com").append("Password","98ujnfds2edd");    // make a new record, provide the entity title then the value, and use append to add more entities
       BasicDBObject Client5 = new BasicDBObject("Username","jerry").append("First name","jojo").append("Last name","kinder").append("EMAIL","fifth@fifth.com").append("Password","he2uien9das");    // make a new record, provide the entity title then the value, and use append to add more entities

        collection.insert(Client);  // to add them into the database
        collection.insert(Client2); 
        collection.insert(Client3); 
        collection.insert(Client4); 
        collection.insert(Client5); 
        /*
        DBObject myDoc = collection.findOne();  // this returns the first made record
        System.out.println(myDoc);  // prints it in json format
        System.out.println(collection.getCount());      // gets how many records are in the database
        //collection.remove(myDoc);     // deletes the record from the database
        */
}
    
}
