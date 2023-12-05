package com.anda.muestras.dto;

public class LoteDetallesDto {
	private Long idLote;
	private int numeroDeMuestrasLote;
	private int numeroMuestrasRecolectadas;
	private float porcentajeAvance;
	private String areaDeRecoleccion;
	public Long getIdLote() {
		return idLote;
	}
	public void setIdLote(Long idLote) {
		this.idLote = idLote;
	}
	public int getNumeroDeMuestrasLote() {
		return numeroDeMuestrasLote;
	}
	public void setNumeroDeMuestrasLote(int numeroDeMuestrasLote) {
		this.numeroDeMuestrasLote = numeroDeMuestrasLote;
	}
	public int getNumeroMuestrasRecolectadas() {
		return numeroMuestrasRecolectadas;
	}
	public void setNumeroMuestrasRecolectadas(int numeroMuestrasRecolectadas) {
		this.numeroMuestrasRecolectadas = numeroMuestrasRecolectadas;
	}
	public float getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(float porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	public String getAreaDeRecoleccion() {
		return areaDeRecoleccion;
	}
	public void setAreaDeRecoleccion(String areaDeRecoleccion) {
		this.areaDeRecoleccion = areaDeRecoleccion;
	}
	
	
}
