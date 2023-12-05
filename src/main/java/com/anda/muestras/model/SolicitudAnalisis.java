package com.anda.muestras.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Entity
@Table(name="SolictudAnalisis")
public class SolicitudAnalisis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSolicitud;
	@Column(nullable=false)
	private Date fechaSolicitud;
	@Column(nullable=false)
	private String direccionExacta;
	@ManyToOne
	@JoinColumn(name = "id_municipio", referencedColumnName = "idmunicipio")
	private Municipio id_municipio;
	@OneToOne(mappedBy = "idSolicitudAnalisis", cascade = CascadeType.REMOVE)
	private LoteMuestras loteMuestras;

	
	public SolicitudAnalisis() {
	}
	
	public SolicitudAnalisis(Date fechSolicitud, String direccionExacta) {
		super();
		this.fechaSolicitud = fechSolicitud;
		this.direccionExacta = direccionExacta;
	}
	
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
	public Municipio getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(Municipio id_municipio) {
		this.id_municipio = id_municipio;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	
	
}
