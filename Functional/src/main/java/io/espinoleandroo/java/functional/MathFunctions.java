package io.espinoleandroo.java.functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {

	public static void main(String[] args) {

		Function<Integer, Integer> square = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};

		System.out.println(square.apply(7));
		System.out.println(square.apply(23));
		
		Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
		System.out.println(isOdd.apply(11));
		
		Predicate<Integer> isEven =  x -> x % 2 == 0;
		System.out.println(isEven.test(16));
		
		Predicate<Student> isApproved = student -> student.getCalificacion() > 6.0;
		Student leandro = new Student(10.0);
		System.out.println(isApproved.test(leandro));
	}
	
	static class Student {
		private double calificacion;

		public Student(double calificacion) {
			super();
			this.calificacion = calificacion;
		}

		public double getCalificacion() {
			return calificacion;
		}
		
	}
}
