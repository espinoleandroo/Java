package io.espinoleandroo.java.testing.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriceCalculatorShould {

	PriceCalculator calculator;
	
	@Before
	public void setup() {
		calculator = new PriceCalculator();
	}
	
	
	@Test
	public void total_zero_when_there_arent_prices() {		
		assertThat(calculator.getTotal(), is(0.0));
	}
	
	@Test
	public void total_is_the_sum_if_prices() {
		calculator.addPrice(10.2);
		calculator.addPrice(15.5);

		assertThat(calculator.getTotal(), is(25.7));
	}
	
	@Test
	public void apply_discount_to_prices() {
		calculator.addPrice(10.5);
		calculator.addPrice(9.5);

		calculator.setDiscount(25);
		
		assertThat(calculator.getTotal(), is(15.0));
	}

}
