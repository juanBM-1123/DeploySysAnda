package com.anda.muestras.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.anda.muestras.model.EstadoRecolectorDeMuestra;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.Muestra;
import com.anda.muestras.model.TipoAnalisis;
import com.anda.muestras.model.TipoMuestra;
import com.anda.muestras.service.EstadoRecolectorDeMuestraService;
import com.anda.muestras.service.LoteMuestraService;
import com.anda.muestras.service.TipoAnalisisService;
import com.anda.muestras.service.TipoMuestraService;

@Mapper(componentModel = "spring")
public abstract class MuestraMapper {
 
	@Autowired
	protected LoteMuestraService loteMuestraService;
	@Autowired
	protected TipoAnalisisService tipoAnalisisService;
	@Autowired
	protected TipoMuestraService tipoMuestraService;
	@Autowired
	protected EstadoRecolectorDeMuestraService estadoMuestraService;
	
	
	@Mapping(source=".",target="idLoteMuestra",qualifiedByName="obtenerLoteAsignado")
	@Mapping(source=".",target="idTipoAnalisis",qualifiedByName="obtenerTipoAnalisisAsignado")
	@Mapping(source=".",target="idTipoMuestra",qualifiedByName="obtenerTipoMuestraAsignado")
	@Mapping(source=".",target = "idestadoRecoleccion", qualifiedByName = "obtenerEstadoDeRecoleccion")
	@Mapping(source="direccionExacta",target="direccionExacta")
	public abstract Muestra muestraDtoToMuestra(MuestraDtoPost muestraDtoPost);
	
	@Named("obtenerLoteAsignado")
	LoteMuestras obtenerLoteAsignado(MuestraDtoPost muestraDtoPost) {
		LoteMuestras tempLoteMuestras = this.loteMuestraService.getOne(muestraDtoPost.getIdLoteMuestra());
		return tempLoteMuestras;
	}
	
	@Named("obtenerTipoAnalisisAsignado")
	TipoAnalisis obtenerAnlisisAsignado(MuestraDtoPost muestraDtoPost) {
		TipoAnalisis tipoAnalisis = this.tipoAnalisisService.getOne(muestraDtoPost.getIdTipoMuestra());
		return tipoAnalisis;
	}
	
	@Named("obtenerTipoMuestraAsignado")
	TipoMuestra obtenerTipoMuestraAsignado(MuestraDtoPost muestraDtoPost) {
		TipoMuestra tipoMuestra = this.tipoMuestraService.getOne(muestraDtoPost.getIdTipoMuestra());
		return tipoMuestra;
	}
	
	@Named("obtenerEstadoDeRecoleccion")
	EstadoRecolectorDeMuestra obtenerEstadoDeRecoleccion(MuestraDtoPost muestraDtoPost) {
		EstadoRecolectorDeMuestra tempEstadoMuestra = this.estadoMuestraService.getOne(muestraDtoPost.getIdEstadoRecoleccion());
		return tempEstadoMuestra;
	}
	
	@Mapping(source="idMuestra",target="idMuestra")
	@Mapping(source="idTipoMuestra.nombreTipoMuestra",target="tipoMuestra")
	@Mapping(source="idTipoAnalisis.nombreTipoAnalisis",target="tipoAnalisis")
	@Mapping(source="idestadoRecoleccion.nombreEstadoRecoleccion",target="estado")
	public abstract MuestraDto muetraToDtoMuestra(Muestra muestra);
	
}
