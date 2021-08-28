package io.espinoleandroo.java.testing.payments;

public interface PaymentGateway {
	
	PaymentResponse requestPayment(PaymentRequest request);

}
