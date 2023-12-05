package com.anda.muestras.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.service.SolicitudAnalisisService;

@Mapper(componentModel = "spring")
public abstract class LoteMapperAbstracta {
	@Autowired
	protected CustomUserService customUserService;
	@Autowired
	protected SolicitudAnalisisService solicitudAnalisisService;
	
	@Mapping(source = ".", target = "customUser",qualifiedByName = "obtenerMuestreadorAsignado")
	@Mapping(source = ".", target = "idSolicitudAnalisis",qualifiedByName = "obtenerSolicitudAnalisisAsignada")
	@Mapping(source="estaEnMuestreo",target="estaEnMuestreo")
	@Mapping(source="estaDigitalizado",target="estaDigitalizado")
	@Mapping(source="idLote",target="idLoteMuestra") 
	@Mapping(source=".",target="fechaRecepcion", qualifiedByName = "obtenerFecha")
	public abstract LoteMuestras loteDtoPostToLoteMuestras(LoteDtoPost loteDtoPost);
	
	@Named("obtenerMuestreadorAsignado")
	CustomUser obtenerMuestreadorAsignado(LoteDtoPost loteDtoPost) {
		return this.customUserService.getById(loteDtoPost.getCustomerUserId());
	}
	@Named("obtenerSolicitudAnalisisAsignada")
	SolicitudAnalisis obtenerSolicitudAnalisisAsignada(LoteDtoPost loteDtoPost) {
		SolicitudAnalisis tempOptionalSolicitud = this.solicitudAnalisisService.getById(loteDtoPost.getIdSolicitudAnalisis());
		
		return tempOptionalSolicitud;
	}
	@Named("obtenerFecha")
	LocalDateTime obtenerFecha(LoteDtoPost loteDtoPost) {
		if(loteDtoPost.getFechaRecepcion()!=null) {
			LocalDateTime hora = LocalDateTime.now();
			 LocalDateTime localDateTimeFecha = loteDtoPost.getFechaRecepcion().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		        // Combinar las partes de fecha y hora
		        localDateTimeFecha = localDateTimeFecha.withHour(hora.getHour())
		                                             .withMinute(hora.getMinute())
		                                             .withSecond(hora.getSecond())
		                                             .withNano(hora.getNano());

		        return localDateTimeFecha;
		}
		
		return null;
	}
	
}
