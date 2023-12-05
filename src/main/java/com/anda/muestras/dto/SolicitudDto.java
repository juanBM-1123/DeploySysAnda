package com.anda.muestras.dto;
import java.util.Date;

import com.anda.muestras.model.Municipio;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SolicitudDto {
	private long idSolicitud;
	private String direccionExacta;
	private Long id_municipio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaSolicitud;
	
	public long getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getDireccionExacta() {
		return direccionExacta;
	}
	public void setDireccionExacta(String direccionExacta) {
		this.direccionExacta = direccionExacta;
	}
	
	public Long getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(Long id_municipio) {
		this.id_municipio = id_municipio;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	
	
}
