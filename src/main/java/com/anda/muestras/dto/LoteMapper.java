package com.anda.muestras.dto;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.service.SolicitudAnalisisService;


@Mapper(componentModel = "spring", uses = LoteCalificador.class)
public interface LoteMapper {
	

	// Se crea una instancia que implementa el LoteMapper?
	LoteMapper mapper = Mappers.getMapper(LoteMapper.class);
	SolicitudAnalisisService solicitudAnalisisService = null;
	CustomUserService userService = null;
	
	//@Mapping(source="",target="") en este caso todas las propiedades del Dto son 
	//iguales a la de la entidad entonces no es necesario especificar el Mapping
	@Mapping(source="idSolicitudAnalisis", target="solicitudAnalisis")
	@Mapping(source="customUser",target="customUser")
	LoteDto loteMuestrasToLoteDto(LoteMuestras loteMuestras);
	
	@Mapping(source="fechaRecepcion", target="fechaRecepcion")
	LoteMuestras loteDtoToLoteMuestras(LoteDto loteDto);
	
	/*@Mapping(source = "customerUserId", target = "customUser",qualifiedByName = "obtenerMuestreadorAsignado")
	@Mapping(source = "idSolicitudAnalisis", target = "idSolicitudAnalisis",qualifiedByName = "obtenerSolicitudAnalisisAsignada")
	LoteMuestras loteDtoPostToLoteMuestras(LoteDtoPost loteDtoPost);*/
	
}
