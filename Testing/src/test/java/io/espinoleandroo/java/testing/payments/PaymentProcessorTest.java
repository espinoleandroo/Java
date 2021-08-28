package io.espinoleandroo.java.testing.payments;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentProcessorTest {

	PaymentGateway paymentGateway;
	PaymentProcessor paymentProcessor;

	@Before
	public void setup() {
		paymentGateway = Mockito.mock(PaymentGateway.class);
		paymentProcessor = new PaymentProcessor(paymentGateway);
	}

	@Test
	public void payment_is_correct() {

		Mockito.when(paymentGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

		boolean result = paymentProcessor.makePayment(1000);

		assertTrue(result);
	}

	@Test
	public void payment_is_wrong() {

		Mockito.when(paymentGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

		boolean result = paymentProcessor.makePayment(1000);

		assertFalse(result);
	}

}
