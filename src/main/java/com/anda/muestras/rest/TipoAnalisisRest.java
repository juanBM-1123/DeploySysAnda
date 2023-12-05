package com.anda.muestras.rest;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.model.TipoAnalisis;
import com.anda.muestras.service.TipoAnalisisService;


@RestController
@RequestMapping("/tipoanalisis/")
public class TipoAnalisisRest {
    @Autowired
    private TipoAnalisisService tipoAnalisisService;
    private Log log = LogFactory.getLog(getClass());
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private  ResponseEntity<List<TipoAnalisis>> getAllTipoAnalisis(){
        return ResponseEntity.ok(this.tipoAnalisisService.findAll());
    }
    
}
