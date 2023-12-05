package com.anda.muestras.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.SolicitudAnalisis;

@Mapper
public interface SolicitudAnalisisDetalleDtoMapper {
	
	SolicitudAnalisisDetalleDtoMapper mapper = Mappers.getMapper(SolicitudAnalisisDetalleDtoMapper.class);
	
	@Mapping(target="id", source="solicitudAnalisis.idSolicitud")
	@Mapping(target="ubicacion",source="solicitudAnalisis.direccionExacta")
	@Mapping(target="nombresMuestreador",source="loteMuestra.customUser.nombres")
	@Mapping(target="apellidosMuestreador",source="loteMuestra.customUser.apellidos")
	@Mapping(target="departamento",source="solicitudAnalisis.id_municipio.id_departamento.nombre")
	@Mapping(target="municipio",source="solicitudAnalisis.id_municipio.nombre")
	SolicitudDetalleDto detalleSolicitudAnalisisToSolicitudDetalleDto(
			SolicitudAnalisis solicitudAnalisis, LoteMuestras loteMuestra);
}
