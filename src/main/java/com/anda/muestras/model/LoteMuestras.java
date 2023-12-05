package com.anda.muestras.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name="LoteMuestras")
public class LoteMuestras {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLoteMuestra;
	@Column(nullable=false)
	private boolean estaEnMuestreo = false;
	@Column(nullable=false)
	private boolean estaDigitalizado = false;
	@ManyToOne
	@JoinColumn(name="id_muestreador", referencedColumnName = "id")
	private CustomUser customUser;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private LocalDateTime fechaRecepcion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud")
	private SolicitudAnalisis idSolicitudAnalisis;
	@OneToMany(mappedBy = "idLoteMuestra", cascade = CascadeType.REMOVE)
	private List<Muestra> muestra;
	
	public LoteMuestras() {
		
	}

	public CustomUser getCustomUser() {
		return customUser;
	}

	public void setCustomUser(CustomUser customUser) {
		this.customUser = customUser;
	}
	
	public LoteMuestras(boolean estaEnMuestreo, boolean estaDigitalizado, LocalDateTime fechaRecepcion,
			SolicitudAnalisis idSolicitudAnalisis) {
		super();
		this.estaEnMuestreo = estaEnMuestreo;
		this.estaDigitalizado = estaDigitalizado;
		this.fechaRecepcion = fechaRecepcion;
		this.idSolicitudAnalisis = idSolicitudAnalisis;
	}
	
	public long getIdLoteMuestra() {
		return idLoteMuestra;
	}
	public void setIdLoteMuestra(long idLoteMuestra) {
		this.idLoteMuestra = idLoteMuestra;
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
	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public SolicitudAnalisis getIdSolicitudAnalisis() {
		return idSolicitudAnalisis;
	}
	public void setIdSolicitudAnalisis(SolicitudAnalisis idSolicitudAnalisis) {
		this.idSolicitudAnalisis = idSolicitudAnalisis;
	}
	
//	
	
}
