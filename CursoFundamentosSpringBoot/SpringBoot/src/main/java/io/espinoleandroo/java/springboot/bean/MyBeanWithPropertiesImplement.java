package io.espinoleandroo.java.springboot.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

	private String nombre;
	private String apellido;
	
	public MyBeanWithPropertiesImplement(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public String function() {
		return nombre + " " + apellido;
	}

}
