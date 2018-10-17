package com.mkyong.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Product;
import com.mkyong.Track;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getTrackInJSON() {
		// Scan and get the data
		List<Product> productList = Checkout.getData();
		
		Checkout checkout = new Checkout();
		//get the cost and tax details
		checkout.getCheckoutDetails(productList);
		return productList;

	}
	
}