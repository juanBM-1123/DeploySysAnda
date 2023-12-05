package com.anda.muestras.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.model.TipoMuestra;
import com.anda.muestras.service.TipoMuestraService;

@RestController
@RequestMapping("/tipo_muestra/")
public class TipoMuestraRest {

	@Autowired
	private  TipoMuestraService tipoMuestrasService;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<TipoMuestra>> getAllTipoMuestra(){
		
		return ResponseEntity.ok(this.tipoMuestrasService.findAll());
	}
}