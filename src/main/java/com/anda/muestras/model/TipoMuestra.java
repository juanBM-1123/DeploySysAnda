package com.anda.muestras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TipoMuestra")
public class TipoMuestra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoMuestra;
	@Column(nullable=false)
	private String nombreTipoMuestra;
	
	public TipoMuestra() {
		
	}
	
	
	public TipoMuestra(String nombreTipoMuestra) {
		super();
		this.nombreTipoMuestra = nombreTipoMuestra;
	}
	public long getIdTipoMuestra() {
		return idTipoMuestra;
	}
	public void setIdTipoMuestra(long idTipoMuestra) {
		this.idTipoMuestra = idTipoMuestra;
	}
	public String getNombreTipoMuestra() {
		return nombreTipoMuestra;
	}
	public void setNombreTipoMuestra(String nombreTipoMuestra) {
		this.nombreTipoMuestra = nombreTipoMuestra;
	}
	
	
	
}
