package com.anda.muestras.model;
import jakarta.persistence.*;

@Entity
@Table(name="departamentos")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departamentoid;
	@Column(nullable=false)
	private String nombre;
	
	
	public Departamento() {
		
	}
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//No poseia los get y set para el ID
	public Long getDepartamentoId() {
		return departamentoid;
	}
	public void setDepartamentoId(long departamentoid) {
		this.departamentoid =  departamentoid;
	}
	
}
