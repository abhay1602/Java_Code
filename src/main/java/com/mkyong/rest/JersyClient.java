package com.mkyong.rest;


//import javax.ws.rs.client.Client;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyClient {

	public void getData() throws JsonParseException, JsonMappingException, IOException{
		
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get/");

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Product> productList = mapper.readValue(
				output,
	            mapper.getTypeFactory().constructCollectionType(
	                    List.class, Product.class));
		double totalCost=0.0;
		double totalTax=0.0;
		Iterator itr = productList.iterator();
		while(itr.hasNext()){	
			Product product = (Product) itr.next();
			System.out.println("Product Name "+product.getProductName() +"  Cost  "+ product.getCost() +" Tax  "+product.getTax()+"\n");
			totalCost = totalCost+product.getCost();
			totalTax = totalTax+product.getTax();
		}
		System.out.println("Total Cost  "+totalCost);
		System.out.println("Total Tax  "+totalTax);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JersyClient cl = new JersyClient();
		try {
			cl.getData();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
