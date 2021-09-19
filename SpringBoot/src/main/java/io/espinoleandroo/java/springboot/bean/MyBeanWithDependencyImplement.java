package io.espinoleandroo.java.springboot.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

	Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
	
	private MyOperation myOperation;
	
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}
	
	@Override
	public void printWithDependency() {
		LOGGER.info("Ingreso a: printWithDependency");
		int numero = 1;
		LOGGER.debug("numero = " + numero );
		System.out.println(myOperation.sum(numero));;
		System.out.println("Hola desde la implementacion de un bean con dependencia");
		
	}

}
