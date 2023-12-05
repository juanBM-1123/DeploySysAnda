package com.anda.muestras.dto;

public class SolicitudDtoDetalles {
	private long idSolicitud;
	private String ubicacion;
	private String muestreador;
	private String estado;
	
	public SolicitudDtoDetalles() {
		
	}
	
	public long getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getMuestreador() {
		return muestreador;
	}
	public void setMuestreador(String muestreador) {
		this.muestreador = muestreador;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}



