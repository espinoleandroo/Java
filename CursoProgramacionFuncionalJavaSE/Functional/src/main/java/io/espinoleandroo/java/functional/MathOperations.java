package io.espinoleandroo.java.functional;

import java.util.function.Function;

public class MathOperations {

	public static void main(String[] args) {
		Function<Integer, Integer> multiplyBy3 = x ->{
			System.out.println("Multiplicando x: " + x + " por 3");
			return x * 3;
		};
		
		Function<Integer, Integer> addOneMultiplyBy3 =
				multiplyBy3.compose(y -> {
					System.out.println("Le agregaremos 1 a: " + y);
					return y + 1;
				});
		
		Function<Integer, Integer> andSquare =
				addOneMultiplyBy3.andThen(x ->{
					System.out.println("Estoy elevando al cuadrado: " + x);
					return x * x;
				});
		
		
		System.out.println(multiplyBy3.apply(5));
		System.out.println(addOneMultiplyBy3.apply(5));
		System.out.println(andSquare.apply(5));
	}
}
