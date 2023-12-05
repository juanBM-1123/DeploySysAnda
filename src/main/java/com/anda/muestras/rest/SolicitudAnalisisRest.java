package com.anda.muestras.rest;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.service.SolicitudAnalisisService;
import com.anda.muestras.dto.SolicitudDetalleDto;
import com.anda.muestras.dto.SolicitudDto;
import com.anda.muestras.dto.SolicitudDtoDetalles;
import com.anda.muestras.dto.SolicitudMapper;

@RestController
@RequestMapping ("/solicitud_analisis/")
public class SolicitudAnalisisRest {
	private SolicitudAnalisisService solicitudAnalisisService;
	private SolicitudMapper solicitudMapper;
	private SolicitudAnalisisRest(SolicitudAnalisisService solicitudAnalisisService,SolicitudMapper solicitudMapper) {
			this.solicitudAnalisisService = solicitudAnalisisService;
			this.solicitudMapper = solicitudMapper;
	}
	
	@GetMapping("/detalles_solicitudes")
	public ResponseEntity<List<SolicitudDtoDetalles>> obtenerDetallesSolicitudesAnalisis(){
		
		return ResponseEntity.ok(this.solicitudAnalisisService.obtenerDetallesSolicitudesDeAnalisis());
	}
	
	@GetMapping("/{idSolicitud}")
	private ResponseEntity<SolicitudAnalisis> getSolicitudAnalisisById (@PathVariable("idSolicitud")long idSolicitud){	
		SolicitudAnalisis solicitud = this.solicitudAnalisisService.findById(idSolicitud);

	    if (solicitud != null) {
	        return ResponseEntity.ok(solicitud);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<SolicitudAnalisis> store(@RequestBody SolicitudAnalisis solicitud) throws ServerException {
 
    //    SolicitudAnalisis tempSolicitud = solicitudAnalisisService.save(solicitud);
	//	return new ResponseEntity<>(tempSolicitud, HttpStatus.CREATED);
    //}
	
	@PutMapping("/{idSolicitud}")
	public ResponseEntity<SolicitudAnalisis> editarSolicitudDeAnalisis(@PathVariable Long idSolicitud , @RequestBody SolicitudDto solicitudAnalisis) {
		SolicitudAnalisis solicitud = solicitudMapper.solicitudAnalisisDtoToSolicitudAnalisis(solicitudAnalisis);
		SolicitudAnalisis tempSolicitud  = this.solicitudAnalisisService.save(solicitud);
	
		return new ResponseEntity<SolicitudAnalisis>(tempSolicitud, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<SolicitudAnalisis> guardarSolicitudAnalisis(@RequestBody SolicitudDto solicitudDto){
		SolicitudAnalisis solicitudAnalisis = this.solicitudMapper.solicitudAnalisisDtoToSolicitudAnalisis(solicitudDto);
		solicitudAnalisis = this.solicitudAnalisisService.save(solicitudAnalisis);
		System.out.println("Entramos aqui 1");
		System.out.println(solicitudAnalisis.getIdSolicitud());
		return ResponseEntity.ok(solicitudAnalisis);
	}
	
	@DeleteMapping("/solicitud/{idSolicitud}")
	public ResponseEntity<String> eliminarSolicitudDeAnalisis(@PathVariable long idSolicitud) {      
		this.solicitudAnalisisService.deleteById(idSolicitud);      
		return ResponseEntity.ok("Solicitud y entidades relacionadas eliminadas correctamente.");	
	}
	
}

