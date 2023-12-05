package com.anda.muestras.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anda.muestras.model.Municipio;
import com.anda.muestras.service.MunicipioService;
@RestController
@RequestMapping("/municipio/")
public class MunicipioRest {
	
	@Autowired
	private MunicipioService municipioService;
	//Metodos creados
	/*
	@GetMapping
	private ResponseEntity<List<Municipio>> getAllMunicipio(){
		return ResponseEntity.ok(municipioService.findAll());
	}
	*/
	@GetMapping("{id}")
	private ResponseEntity<List<Municipio>> getAllMunicipioByDepartamento(@PathVariable("id") long idDepartamento){
		return ResponseEntity.ok(municipioService.findAllByDepartment(idDepartamento));
	}
	
}
