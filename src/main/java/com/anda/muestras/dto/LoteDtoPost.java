package com.anda.muestras.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LoteDtoPost {

	private Long idLote;
	private boolean estaEnMuestreo;
	private boolean estaDigitalizado;
	private Long customerUserId;
	private Long idSolicitudAnalisis;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaRecepcion;
	
	
	public LoteDtoPost() {
		
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
	public Long getCustomerUserId() {
		return customerUserId;
	}
	public void setCustomerUserId(Long customerUserId) {
		this.customerUserId = customerUserId;
	}
	public Long getIdSolicitudAnalisis() {
		return idSolicitudAnalisis;
	}
	public void setIdSolicitudAnalisis(Long idSolicitudAnalisis) {
		this.idSolicitudAnalisis = idSolicitudAnalisis;
	}

	public Long getIdLote() {
		return idLote;
	}

	public void setIdLote(Long idLote) {
		this.idLote = idLote;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
	
	
}
