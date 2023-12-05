package com.anda.muestras.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anda.muestras.service.SolicitudAnalisisService;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.SolicitudAnalisis;
import java.util.Optional;

@Component
@Mapper
public class LoteCalificador {
	private SolicitudAnalisisService solicitudAnalisisService;
	private CustomUserService customUserService;
	
	@Autowired
	public LoteCalificador(SolicitudAnalisisService solicitudService, CustomUserService userService) {
		this.solicitudAnalisisService = solicitudService;
		this.customUserService = userService;
	}
	public LoteCalificador() {
		
	}

	@Named("obtenerMuetreadorAsignado")
	public CustomUser obtenerMuestreadorAsignado(Long id) {
		return this.customUserService.getOne(id);
	}
	
	@Named("obtenerSolicitudAsociada")
	public SolicitudAnalisis obtenerSolicitudAnalisisAsignada(Long id) {
		Optional <SolicitudAnalisis> optionalSolicitud = this.solicitudAnalisisService.findById(id);
		if(optionalSolicitud.isPresent()) {
			return optionalSolicitud.get();
		}
		return null;
	}
}
