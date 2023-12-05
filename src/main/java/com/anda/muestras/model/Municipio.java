package com.anda.muestras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="municipio")
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idmunicipio;
	@Column(nullable=false)
	 private String nombre;
	@ManyToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "departamentoid")
	 private Departamento id_departamento;
	

	public Municipio() {
		
	}
	
	public Municipio(String nombre) {
		super();
		this.nombre = nombre;
	}
	public long getIdmunicipio() {
		return idmunicipio;
	}
	public void setIdmunicipio(long idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Departamento getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(Departamento id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
	 
}
