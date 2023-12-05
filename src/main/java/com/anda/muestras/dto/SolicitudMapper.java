package com.anda.muestras.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.Municipio;
import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.service.LoteMuestraService;
import com.anda.muestras.service.MunicipioService;

@Mapper(componentModel = "spring")
public abstract class SolicitudMapper {
 @Autowired
 protected MunicipioService municipioService;
 @Autowired
 protected LoteMuestraService loteService;
 @Mapping(source="idSolicitud",target="idSolicitud")
 @Mapping(source=".",target="id_municipio", qualifiedByName = "obtenerMunicipio")
 @Mapping(source=".",target="fechaSolicitud", qualifiedByName = "obtenerFechaSolicitud")
 @Mapping(source="direccionExacta",target="direccionExacta")
 public abstract SolicitudAnalisis solicitudAnalisisDtoToSolicitudAnalisis(SolicitudDto solicitudDto);
 
 @Mapping(source="idSolicitud", target = "idSolicitud")
 @Mapping(source=".",target = "ubicacion", qualifiedByName="obtenerUbicacion")
 @Mapping(source=".",target = "muestreador",qualifiedByName= "obtenerMuestreador")
 @Mapping(source=".", target = "estado", qualifiedByName = "obtenerEstadoSolicitud")
 public abstract SolicitudDtoDetalles solicitudAnalisisToSolicitudDtoDetalle(SolicitudAnalisis solicitudAnalisis);
 
 @Named("obtenerMunicipio")
 Municipio obtenerMunicipio(SolicitudDto solicitudDto) {
	 Optional<Municipio> tempMunicipio = this.municipioService.findById(solicitudDto.getId_municipio());
	 if(tempMunicipio.isPresent()) {
		 return tempMunicipio.get();
	 }
	 return null;
 }
 
 @Named("obtenerFechaSolicitud")
 LocalDateTime obtenerFechaSolicitud(SolicitudDto solicitudDto) {
	 LocalDateTime hora = LocalDateTime.now();
	 hora.withMonth(solicitudDto.getFechaSolicitud().getMonth());
	 hora.withDayOfMonth(solicitudDto.getFechaSolicitud().getDay());
	 hora.withYear(solicitudDto.getFechaSolicitud().getYear());
	 return hora;
 }
 
 @Named("obtenerUbicacion")
 String obtenerUbicacion(SolicitudAnalisis solicitudAnalisis) {
	 String ubicacioCompleta = "";
	 ubicacioCompleta = solicitudAnalisis.getDireccionExacta()+" ".concat(solicitudAnalisis.getId_municipio().getNombre()+" ".concat(solicitudAnalisis.getId_municipio().getId_departamento().getNombre()));
	 return ubicacioCompleta;
 }
 
 @Named("obtenerMuestreador")
 String obtenerMuestreador(SolicitudAnalisis solicitudAnalisis) {
	 String nombreMuestreador = "";
	 LoteMuestras loteMuestras = this.loteService.obtenerLotePorSolicitud(solicitudAnalisis.getIdSolicitud());
	 nombreMuestreador = loteMuestras.getCustomUser().getNombres().concat(" ".concat(loteMuestras.getCustomUser().getApellidos()));
	 return nombreMuestreador;
 }
 
 @Named("obtenerEstadoSolicitud")
 String obtenerEstdoSolicitud(SolicitudAnalisis solicitudAnalisis) {
	 String estadoSolicitudAnalisis = "Muestras Digitalizadas";
	 LoteMuestras loteMuestra = this.loteService.obtenerLotePorSolicitud(solicitudAnalisis.getIdSolicitud());
	 if(loteMuestra.isEstaEnMuestreo()) {
		 estadoSolicitudAnalisis = "En Proceso";
	 }
	 return estadoSolicitudAnalisis;
 }
 
}
