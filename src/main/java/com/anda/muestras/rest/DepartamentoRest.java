package com.anda.muestras.rest;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

//para revisar salidas por la consola de Spring Boot
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anda.muestras.service.DepartamentoService;
import com.anda.muestras.model.Departamento;

@RestController
@RequestMapping("/departamentos/")
public class DepartamentoRest {
	@Autowired
	private DepartamentoService departamentoService;
	private Log log = LogFactory.getLog(getClass());
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Departamento>> getAllDepartamentos(){
		return ResponseEntity.ok(this.departamentoService.findAll());
	}
	
	//Ejemplo de servicio POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Departamento> store (@RequestBody Departamento departamento) throws ServerException {
		log.info("La información que se encuentra en el RequestBody es: ");
		log.info(departamento);
		Departamento tempDepartamento = this.departamentoService.save(departamento);
		if(tempDepartamento == null){
			throw new ServerException(null);
		}
		else {
			return new ResponseEntity<>(tempDepartamento,HttpStatus.CREATED);
		}
	}
	
	@GetMapping("{id}")
	private ResponseEntity<Departamento> show(@PathVariable("id") Long id) throws ServerException{
		log.info("EL valor del id de la url es:");
		log.debug(id);
		Departamento departamento = this.departamentoService.getById(id);
		log.info("El valor del departamento es: ");
		log.info(departamento);
		if(departamento== null) {
			throw new ServerException(null);
		}
		return new ResponseEntity<>(departamento,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	private ResponseEntity<String>update(@PathVariable Long id){
		if(id == null) {
			return new ResponseEntity<>("El parametro no se resivio",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El parametro es: "+String.valueOf(id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> delete(@PathVariable Long id){
		
		return null;
	}
	
}
