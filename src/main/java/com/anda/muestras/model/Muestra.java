package com.anda.muestras.model;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Muestra")
public class Muestra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long idMuestra;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idLoteMuestra", referencedColumnName = "idLoteMuestra", nullable = false)
   private LoteMuestras idLoteMuestra;
	@ManyToOne
	@JoinColumn(name = "idTipoAnalisis", referencedColumnName = "idTipoAnalisis")
   private TipoAnalisis idTipoAnalisis;
	@ManyToOne
	@JoinColumn(name = "idTipoMuestra", referencedColumnName = "idTipoMuestra")
   private TipoMuestra idTipoMuestra;
	@ManyToOne
	@JoinColumn(name = "estadoRecoleccionId", referencedColumnName = "estadoRecoleccionId")
   private EstadoRecolectorDeMuestra idestadoRecoleccion;
   
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
    private LocalDateTime fechaYHoraDeRecoleccion;
	@Column(nullable=true)
    private String claveDeRecoleccion;
	@Column(nullable=false)
    private String direccionExacta;
	
	public Muestra() {
	
	}
	
	
	public Muestra(LocalDateTime fechaYHoraDeRecoleccion, String claveDeRecoleccion, String direccionExacta) {
		super();
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
		this.claveDeRecoleccion = claveDeRecoleccion;
		this.direccionExacta = direccionExacta;
	}
	public long getIdMuestra() {
		return idMuestra;
	}
	public void setIdMuestra(long idMuestra) {
		this.idMuestra = idMuestra;
	}
	public LoteMuestras getIdLoteMuestra() {
		return idLoteMuestra;
	}
	public void setIdLoteMuestra(LoteMuestras idLoteMuestra) {
		this.idLoteMuestra = idLoteMuestra;
	}
	public TipoAnalisis getIdTipoAnalisis() {
		return idTipoAnalisis;
	}
	public void setIdTipoAnalisis(TipoAnalisis idTipoAnalisis) {
		this.idTipoAnalisis = idTipoAnalisis;
	}
	public TipoMuestra getIdTipoMuestra() {
		return idTipoMuestra;
	}
	public void setIdTipoMuestra(TipoMuestra idTipoMuestra) {
		this.idTipoMuestra = idTipoMuestra;
	}
	public EstadoRecolectorDeMuestra getIdestadoRecoleccion() {
		return idestadoRecoleccion;
	}
	public void setIdestadoRecoleccion(EstadoRecolectorDeMuestra idestadoRecoleccion) {
		this.idestadoRecoleccion = idestadoRecoleccion;
	}
	public LocalDateTime getFechaYHoraDeRecoleccion() {
		return fechaYHoraDeRecoleccion;
	}
	public void setFechaYHoraDeRecoleccion(LocalDateTime fechaYHoraDeRecoleccion) {
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
	}
	public String getClaveDeRecoleccion() {
		return claveDeRecoleccion;
	}
	public void setClaveDeRecoleccion(String claveDeRecoleccion) {
		this.claveDeRecoleccion = claveDeRecoleccion;
	}
	public String getDireccionExacta() {
		return direccionExacta;
	}
	public void setDireccionExacta(String direccionExacta) {
		this.direccionExacta = direccionExacta;
	}
	
	
	
}
