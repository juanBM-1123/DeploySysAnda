package com.anda.muestras.dto;

public class MuestraMuestreadaDto {
	private Long idMuestra;
	private String claveDeRecoleccion;
	private String direccionExacta;
	
	public MuestraMuestreadaDto() {
		
	}

	public Long getIdMuestra() {
		return idMuestra;
	}

	public void setIdMuestra(Long idMuestra) {
		this.idMuestra = idMuestra;
	}


	public String getDireccionExacta() {
		return direccionExacta;
	}

	public void setDireccionExacta(String direccionExacta) {
		this.direccionExacta = direccionExacta;
	}

	public String getClaveDeRecoleccion() {
		return claveDeRecoleccion;
	}

	public void setClaveDeRecoleccion(String claveDeRecoleccion) {
		this.claveDeRecoleccion = claveDeRecoleccion;
	}
	
	
	
	
	
}
