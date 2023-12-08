package io.espinoleandroo.java.functional;

import java.util.List;

public class Inferencia {
	
	public static void main(String[] args) {				
		List<String> alumnos = NombresUtils.getList("Leandro", "Leandroo", "Leandrooo");
		
		alumnos.forEach((String name) -> System.out.println(name));
		alumnos.forEach(name -> System.out.println(name));
		alumnos.forEach(System.out::println);
	}

}
