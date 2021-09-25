package io.espinoleandroo.java.testing.util;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
	
	private List<Double> prices = new ArrayList<Double>();
	private double discount = 0.0;

	public Double getTotal() {
		double total = 0.0;
		
		for (Double price : prices) {
			total += price;
		}
		
		total -= total * (discount / 100);
		return total;
	}

	public void addPrice(double price) {
		prices.add(price);
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

}
