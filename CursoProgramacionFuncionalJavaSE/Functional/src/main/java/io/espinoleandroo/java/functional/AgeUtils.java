package io.espinoleandroo.java.functional;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {

	public static void main(String[] args) {

		Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

		TriFuntion<Integer, Integer, Integer, LocalDate> parseDate = (day, month, year) -> LocalDate
				.parse(year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day));

		TriFuntion<Integer, Integer, Integer, Integer> calculateAge = (day, month, year) -> Period
				.between(parseDate.apply(day, month, year), LocalDate.now()).getYears();

		System.out.println(calculateAge.apply(11, 11, 1996));
	}

	@FunctionalInterface
	interface TriFuntion<T, U, V, R> {
		R apply(T t, U u, V v);
	}
}
