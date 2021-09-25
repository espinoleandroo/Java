package io.espinoleandroo.java.testing.payments;

public class PaymentResponse {

	enum PaymentStatus{
		OK, ERROR
	}
	private PaymentStatus status;
	
	
	
	public PaymentResponse(PaymentStatus status) {
		super();
		this.status = status;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	
	
}
