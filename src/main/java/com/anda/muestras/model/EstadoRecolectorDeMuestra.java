package com.anda.muestras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estadoRecoleccionMuestra")
public class EstadoRecolectorDeMuestra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long estadoRecoleccionId;
	@Column(nullable=false)
	private String nombreEstadoRecoleccion;
	
	public EstadoRecolectorDeMuestra() {
		
	}
	
	
	public EstadoRecolectorDeMuestra(String nombreEstadoRecoleccion) {
		super();
		this.nombreEstadoRecoleccion = nombreEstadoRecoleccion;
	}
	public long getEstadoRecoleccionId() {
		return estadoRecoleccionId;
	}
	public void setEstadoRecoleccionId(long estadoRecoleccionId) {
		this.estadoRecoleccionId = estadoRecoleccionId;
	}
	public String getNombreEstadoRecoleccion() {
		return nombreEstadoRecoleccion;
	}
	public void setNombreEstadoRecoleccion(String nombreEstadoRecoleccion) {
		this.nombreEstadoRecoleccion = nombreEstadoRecoleccion;
	}
	
	
	
}
