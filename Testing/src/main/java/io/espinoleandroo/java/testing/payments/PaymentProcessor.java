package io.espinoleandroo.java.testing.payments;

import io.espinoleandroo.java.testing.payments.PaymentResponse.PaymentStatus;

public class PaymentProcessor {

	private PaymentGateway paymentGateway;
	
	
	public PaymentProcessor(PaymentGateway paymentGateway) {
		super();
		this.paymentGateway = paymentGateway;
	}



	public boolean makePayment(double amount) {
		PaymentResponse paymentResponse =  paymentGateway.requestPayment(new PaymentRequest(amount));
		if(paymentResponse.getStatus() == PaymentStatus.OK) {
			return true;
		}else {
			return false;
		}
		
	}
}
