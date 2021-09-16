package io.espinoleandroo.java.functional.lambda;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import io.espinoleandroo.java.functional.NombresUtils;

public class Sintaxis {

	public static void main(String[] args) {
		List<String> cursos = NombresUtils.getList("POO", "Testing", "Functional");

		cursos.forEach(curso -> System.out.println(curso));

		useZero(() -> 2);

		usePredicate(text -> text.isEmpty());

		usarBiFunction((x, y) -> x * y);

		usarBiFunction((x, y) -> {
			System.out.println("x: " + x + ", y: " + y);
			return x - y;
		});

		usarNada(()->{
			System.out.println("No hago nada");
		});
	}

	static void useZero(ZeroArguments zeroArguments) {

	}

	static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion) {

	}
	
	static void usarNada(nada OperarNada) {
		
	}

	static void usePredicate(Predicate<String> predicado) {

	}

	@FunctionalInterface
	interface ZeroArguments {
		int get();
	}
	
	@FunctionalInterface
	interface nada {
		void nada();
	}

}
