package tetrispsswsservice;

import javax.xml.ws.Endpoint;

public class Publisher {
	 public static void main(String[] args) {  
	       Endpoint.publish("http://localhost:8200/ws/PSS", new PSSWSServiceImpl());  
     }  
}
