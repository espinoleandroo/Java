package io.espinoleandroo.java.functional;

import java.util.function.Function;

public class MathFunctions {

	public static void main(String[] args) {
		
		Function<Integer, Integer> square = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};
		
		System.out.println(square.apply(5));
		System.out.println(square.apply(25));
	}
}
