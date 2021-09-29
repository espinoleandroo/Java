package io.espinoleandroo.java.Spring.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	private String id;
	
	private String nombre;
	
	private String apellidos;
	
	private String celular;
	
	private String direccion;
	
	@Column(name = "correo_electronico")
	private String correoElectronico;
}
