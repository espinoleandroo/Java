package io.espinoleandroo.java.functional;

public class Chaining {

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Hola")
					.append(" mundo")
					.append(" desde")
					.append(" Java");
		
		Chainer chainer = new Chainer();
		chainer.sayHi().sayBye();
	}
	
	static class Chainer {
		public Chainer sayHi() {
			System.out.println("Hola");
			return this;
		}
		
		public Chainer sayBye() {
			System.out.println("Adios");
			return this;
		}
		
		
	}
}
