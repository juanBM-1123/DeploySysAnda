package com.anda.muestras.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.model.Muestra;
import com.anda.muestras.service.EstadoRecolectorDeMuestraService;
import com.anda.muestras.service.MuestraService;
import com.anda.muestras.dto.MuestraMapper;
import com.anda.muestras.dto.MuestraMuestreadaDto;
import com.anda.muestras.dto.ListaMuestrasDto;
import com.anda.muestras.dto.MuestraDto;
import com.anda.muestras.dto.MuestraDtoPost;

@RestController
@RequestMapping("/muestras")
public class MuestraRest {

	@Autowired
	private MuestraService muestraService;
	@Autowired
	private MuestraMapper muestraMapper;
	@Autowired
	private EstadoRecolectorDeMuestraService estadoMuestraService;
	@GetMapping("/{id}")
	private ResponseEntity<List<Muestra>> getAllMuestraBysolicittud(@PathVariable("id") long id){
		return ResponseEntity.ok(muestraService.findMuestraByIdSolicitAnalisis(id));
	
	  }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarMuestra(@PathVariable Long id) {   
		muestraService.deleteById(id);  
		return ResponseEntity.ok("Muestra eliminada con éxito");
	}
	
	@PostMapping()
	public ResponseEntity<List<Muestra>> guardarListaMuestrasByLote(@RequestBody ListaMuestrasDto muestrasDtoPost) {
		List<Muestra> listaMuestras = new ArrayList<>();
		/*muestrasDtoPost.getMuestras().forEach((muestraDtoPost)->{
			Muestra tempMuestra = this.muestraService.save(this.muestraMapper.muestraDtoToMuestra(muestraDtoPost));
			listaMuestras.add(tempMuestra);
		});*/
		for(MuestraDtoPost m:muestrasDtoPost.getMuestras()) {
			Muestra tempMuestra = this.muestraService.save(this.muestraMapper.muestraDtoToMuestra(m));
			listaMuestras.add(tempMuestra);
		}
		//Muestra tempMuestra = this.muestraMapper.muestraDtoToMuestra(muestraDtoPost);
		return ResponseEntity.ok(listaMuestras);
	}
	
	@GetMapping("/detalle_muestras/{idLote}")
	public ResponseEntity<List<MuestraDto>> obtenerMuestrasByLote(@PathVariable Long idLote ){
		List<MuestraDto> muestrasDto = new ArrayList<>();
		this.muestraService.obtenerMuestrasByLoteId(idLote).forEach((muestra)->{
			muestrasDto.add(this.muestraService.obtenerMuestrasDto(muestra));
		});
		return new ResponseEntity<>(muestrasDto,HttpStatus.OK);
	}
	
	@PutMapping("/muestra")
	public ResponseEntity<String> muestrarMuestra(@RequestBody MuestraMuestreadaDto muestraDto) {
		Optional<Muestra> tempMuestra = this.muestraService.findById(muestraDto.getIdMuestra());
		if(tempMuestra.isPresent()) {
			Muestra muestra = tempMuestra.get();
			muestra.setClaveDeRecoleccion(muestraDto.getClaveDeRecoleccion());
			muestra.setIdestadoRecoleccion(this.estadoMuestraService.findByNombreEstadoRecoleccion("Muestreada"));
			muestra.setFechaYHoraDeRecoleccion(LocalDateTime.now());
			muestra.setDireccionExacta(muestraDto.getDireccionExacta());
			this.muestraService.save(muestra);
			return new ResponseEntity<>("Se guardaron los datos con exito",HttpStatus.OK);
		}
		return new ResponseEntity<>("El registro que desea editar no existe",HttpStatus.BAD_REQUEST);
		
	}
	
	public LocalDateTime obtenerFechaDeMuestreo(String fecha) {
		DateTimeFormatter  formateador = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
		LocalDateTime fechaYHora = LocalDateTime.parse(fecha,formateador);
		return fechaYHora;
	}
	
	@PostMapping("muestra")
	public ResponseEntity<Muestra> agregarMuestraALote(@RequestBody MuestraDtoPost muestraDtoPost) {
		Muestra muestra = this.muestraMapper.muestraDtoToMuestra(muestraDtoPost);
		muestra = this.muestraService.save(muestra);
		return new ResponseEntity<>(muestra,HttpStatus.OK);
	}
	
	

}