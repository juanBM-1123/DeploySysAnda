package com.anda.muestras.dto;
import java.time.LocalDateTime;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.SolicitudAnalisis;

public class LoteDto {

	private boolean estaEnMuestreo;
	private boolean estaDigitalizado;
	private CustomerUserDto customUser;
	private String fechaRecepcion;
	private SolicitudAnalisis solicitudAnalisis;
	
	public LoteDto() {
		
	}
	
	public SolicitudAnalisis getSolicitudAnalisis() {
		return solicitudAnalisis;
	}

	public void setSolicitudAnalisis(SolicitudAnalisis solicitudAnalisis) {
		this.solicitudAnalisis = solicitudAnalisis;
	}
	
	
	public boolean isEstaEnMuestreo() {
		return estaEnMuestreo;
	}
	public void setEstaEnMuestreo(boolean estaEnMuestreo) {
		this.estaEnMuestreo = estaEnMuestreo;
	}
	public boolean isEstaDigitalizado() {
		return estaDigitalizado;
	}
	public void setEstaDigitalizado(boolean estaDigitalizado) {
		this.estaDigitalizado = estaDigitalizado;
	}
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public CustomerUserDto getCustomUser() {
		return customUser;
	}

	public void setCustomUser(CustomerUserDto customUser) {
		this.customUser = customUser;
	}
	
	
	
	
}
