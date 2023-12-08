package io.espinoleandroo.java.testing.util;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class DateUtilLeapYearShould {

	@Test
	public void return_true_when_year_is_divisible_by_400() {
		
		assertThat(DateUtil.isLeapYear(1600), is(true));
		assertThat(DateUtil.isLeapYear(2000), is(true));
		assertThat(DateUtil.isLeapYear(2400), is(true));
	}

	@Test
	public void return_false_when_year_is_divible_by_100_but_not_by_400() {
		assertThat(DateUtil.isLeapYear(1700), is(false));
		assertThat(DateUtil.isLeapYear(1800), is(false));
		assertThat(DateUtil.isLeapYear(1900), is(false));
	}
	
	@Test
	public void return_true_when_year_is_divisible_by_4_but_not_by_100() {
		assertThat(DateUtil.isLeapYear(1996), is(true));
		assertThat(DateUtil.isLeapYear(2004), is(true));
		assertThat(DateUtil.isLeapYear(2008), is(true));
	}
	
	@Test
	public void return_false_when_year_is_not_divisible_by_4() {
		assertThat(DateUtil.isLeapYear(2017), is(false));
		assertThat(DateUtil.isLeapYear(2018), is(false));
		assertThat(DateUtil.isLeapYear(2019), is(false));
	}
	
}
