package com.anda.muestras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TipoAnalisis")
public class TipoAnalisis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  idTipoAnalisis;
	@Column(nullable=false)
	private String nombreTipoAnalisis;
	
	public TipoAnalisis() {
		
	}
	
	
	public TipoAnalisis(String nombreTipoMuestra) {
		super();
		this.nombreTipoAnalisis = nombreTipoMuestra;
	}
	public long getIdTipoAnalisis() {
		return idTipoAnalisis;
	}
	public void setIdTipoAnalisis(long idTipoAnalisis) {
		this.idTipoAnalisis = idTipoAnalisis;
	}
	public String getNombreTipoMuestra() {
		return nombreTipoAnalisis;
	}
	public void setNombreTipoMuestra(String nombreTipoMuestra) {
		this.nombreTipoAnalisis = nombreTipoMuestra;
	}


	public String getNombreTipoAnalisis() {
		return nombreTipoAnalisis;
	}


	public void setNombreTipoAnalisis(String nombreTipoAnalisis) {
		this.nombreTipoAnalisis = nombreTipoAnalisis;
	}
	
	
	
}
