/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 

/**
 *
 * @author Bilal
 */
public class BaseRequest {

	   
public static void DoGetMethod(final String url , final RequestCallBack callBack) throws Exception {
    // String url = "http://apilayer.net/api/live?access_key=24f2628deeb8c12dae4b4d65160b52fa&currencies=EUR,EGP,GBP,SAR,QAR&source=USD&format=1";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
    // System.out.println(response.toString());
       if (response!=null){ callBack.success(response.toString()); }
                else callBack.error(new Exception());
  
    
   }
}
