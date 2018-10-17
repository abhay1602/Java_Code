package com.mkyong.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mkyong.Product;

public class Checkout {

	
	public Checkout(){
		
	}
	
	public void getCheckoutDetails(List<Product> prod) {
		double totalCost=0.0;
		double totalTax=0.0;
		Iterator itr = prod.iterator();
		while (itr.hasNext()) {
			Product product = (Product) itr.next();
			if (product.getCategory().equals("A")) {
				double tax = product.getPrice() * 0.10;
				double cost = tax + product.getPrice();
				product.setTax(tax);
				product.setCost(cost);
				totalCost = totalCost + cost;
				totalTax = totalTax + tax;
			} else if (product.getCategory().equals("B")) {
				double tax = product.getPrice() * 0.20;
				double cost = tax + product.getPrice();
				product.setTax(tax);
				product.setCost(cost);
				totalCost = totalCost + cost;
				totalTax = totalTax + tax;
			} else {
				double tax = 0.0;
				double cost = product.getPrice();
				product.setTax(tax);
				product.setCost(cost);
				totalCost = totalCost + cost;
			}
		}
		
	}

	public static List<Product> getData(){
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product();
		product1.setCategory("A");
		product1.setPrice(100);
		product1.setProductName("Nivia");
		Product product2 = new Product();
		product2.setCategory("B");
		product2.setPrice(100);
		product2.setProductName("Denim");
		Product product3 = new Product();
		product3.setCategory("C");
		product3.setPrice(100);
		product3.setProductName("Rox");
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> productList = Checkout.getData();
		Checkout checkout = new Checkout();
		checkout.getCheckoutDetails(productList);	
		Iterator itr = productList.iterator();
		while(itr.hasNext()){
			Product product = (Product) itr.next();
			System.out.println("Product Name "+product.getProductName() +"  Cost  "+ product.getCost() +" Tax  "+product.getTax()+"\n");
		}
		
		
	}

}
