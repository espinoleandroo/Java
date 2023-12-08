package io.espinoleandroo.java.functional;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class StringFunctions {

	public static void main(String[] args) {
		UnaryOperator<String> quote = text -> "\"" + text + "\"";
		UnaryOperator<String> addMark = text -> text + "!";

		System.out.println(quote.apply(addMark.apply("Hola Mundo desde Java Funcional")));

		BiFunction<Integer, Integer, Integer> multiplicacion = (x, y) -> x * y;
		System.out.println(multiplicacion.apply(5, 4));

		BiFunction<String, Integer, String> leftPad = (text, number) -> String.format("%" + number + "s", text);
		System.out.println(leftPad.apply("Java", 10));
		
		StringOperation six = () -> 6;
		six.operate("Alumno");
		
		DoOperation operateFive = text -> System.out.println(text);
		operateFive.execute(5, "ESTUDIANTE");
	}
	
	@FunctionalInterface
	interface DoOperation{
		void take(String text);
		
		default void execute(int x, String text) {
			while (x-- > 0) {
				take(text);
			}
		}
	}

	@FunctionalInterface
	interface StringOperation {
		int getAmount();

		default void operate(String text) {
			int x = getAmount();
			while (x-- > 0) {
				System.out.println(text);
			}
		}
	}
}
