package com.anda.muestras.dto;

public class MuestraDtoPost {
	
	private Long idLoteMuestra;
	private Long idTipoMuestra;
	private Long idTipoAnalisis;
	private Long idEstadoRecoleccion;
	private String direccionExacta;
	
	public MuestraDtoPost() {
		
	}
	
	public Long getIdLoteMuestra() {
		return idLoteMuestra;
	}
	public void setIdLoteMuestra(Long idLoteMuestra) {
		this.idLoteMuestra = idLoteMuestra;
	}
	public Long getIdTipoMuestra() {
		return idTipoMuestra;
	}
	public void setIdTipoMuestra(Long idTipoMuestra) {
		this.idTipoMuestra = idTipoMuestra;
	}
	public Long getIdTipoAnalisis() {
		return idTipoAnalisis;
	}
	public void setIdTipoAnalisis(Long idTipoAnalisis) {
		this.idTipoAnalisis = idTipoAnalisis;
	}
	public Long getIdEstadoRecoleccion() {
		return idEstadoRecoleccion;
	}
	public void setIdEstadoRecoleccion(Long idEstadoRecoleccion) {
		this.idEstadoRecoleccion = idEstadoRecoleccion;
	}
	public String getDireccionExacta() {
		return direccionExacta;
	}
	public void setDireccionExacta(String direccionExacta) {
		this.direccionExacta = direccionExacta;
	}
	
	
	
}
