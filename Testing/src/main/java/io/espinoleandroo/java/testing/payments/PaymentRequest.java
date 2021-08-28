package io.espinoleandroo.java.testing.payments;

public class PaymentRequest {

	private double amount;
	
	public PaymentRequest(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
}
