package com.anda.muestras.dto;

import org.mapstruct.Mapper;


public class SolicitudDetalleDto {

	private Long id;
	private String ubicacion;
	private String nombresMuestreador;
	private String apellidosMuestreador;
	private String departamento;
	private String municipio;
	
	
	
	public SolicitudDetalleDto() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getNombresMuestreador() {
		return nombresMuestreador;
	}
	public void setNombresMuestreador(String nombresMuestreador) {
		this.nombresMuestreador = nombresMuestreador;
	}
	public String getApellidosMuestreador() {
		return apellidosMuestreador;
	}
	public void setApellidosMuestreador(String apellidosMuestreador) {
		this.apellidosMuestreador = apellidosMuestreador;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	
	
	
}
