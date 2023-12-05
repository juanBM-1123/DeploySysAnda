package com.anda.muestras.dto;

public class MuestraDto {
	private long idMuestra;
	private String tipoMuestra;
	private String tipoAnalisis;
	private String estado;
	
	public MuestraDto() {
		
	}
	
	
	public long getIdMuestra() {
		return idMuestra;
	}


	public void setIdMuestra(long idMuestra) {
		this.idMuestra = idMuestra;
	}


	public String getTipoMuestra() {
		return tipoMuestra;
	}
	public void setTipoMuestra(String tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}
	public String getTipoAnalisis() {
		return tipoAnalisis;
	}
	public void setTipoAnalisis(String tipoAnalisis) {
		this.tipoAnalisis = tipoAnalisis;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
