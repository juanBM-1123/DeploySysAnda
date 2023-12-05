package com.anda.muestras.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.dto.LoteDetallesDto;
import com.anda.muestras.dto.LoteDto;
import com.anda.muestras.dto.LoteDtoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.Muestra;
import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.service.LoteMuestraService;
import com.anda.muestras.service.MuestraService;
import com.anda.muestras.service.SolicitudAnalisisService;
import com.anda.muestras.dto.LoteMapper;
import com.anda.muestras.dto.LoteMapperAbstracta;


@RestController
@RequestMapping("/lote_muestras") //nos da la url base para acceder a este servicio
public class LoteMuestrasRest {
	@Autowired
	private LoteMuestraService loteMuestrasService;
	@Autowired
	private LoteMapperAbstracta loteMapperAbstract;
	@Autowired
	private CustomUserService customUserService;
	@Autowired
	private MuestraService muestraService;
	@Autowired
	private SolicitudAnalisisService solicitudService;
	
	public LoteMuestrasRest(LoteMuestraService loteMuestrasService) {
		this.loteMuestrasService = loteMuestrasService;
	}
	
	@GetMapping("/obtener_lotes_dto")
	public ResponseEntity<List<LoteDto>> obtenerLotes(){
		return ResponseEntity.ok(loteMuestrasService.obtenerLotesDelSistema());
	}
	
	
	
	@GetMapping("/obtener_lotes")
	public ResponseEntity<List<LoteMuestras>> obtenerLotesClase(){
		return ResponseEntity.ok(loteMuestrasService.obtenerLoteMuestras());
	}
	
	@GetMapping("/{idSolicitud}")
	private ResponseEntity<List<LoteMuestras>> getAllBySolictud(@PathVariable("idSolicitud") long idSolictud){
		return ResponseEntity.ok(loteMuestrasService.findByIdLoteMuestra(idSolictud));
	}
	
	
	//Voy a modificar el loteMapperAbstract 1 
	@PostMapping()
	private ResponseEntity<LoteMuestras> guardarLoteMuestra(@RequestBody LoteDtoPost loteDtoPost){
		LoteMuestras tempLotemMuestra = loteMapperAbstract.loteDtoPostToLoteMuestras(loteDtoPost);
		System.out.println(tempLotemMuestra.getIdLoteMuestra());
		tempLotemMuestra = this.loteMuestrasService.save(tempLotemMuestra);
		LoteDto loteDto = this.loteMuestrasService.obtenerLoteDto(tempLotemMuestra);
		return ResponseEntity.ok(tempLotemMuestra);
	}
	
	@PutMapping()
	public ResponseEntity<LoteMuestras> editarLoteMuestras(@RequestBody LoteDtoPost loteDtoPost){
		List<LoteMuestras> loteMuestras = this.loteMuestrasService.findByIdLoteMuestra(loteDtoPost.getIdSolicitudAnalisis());
		LoteMuestras loteMuestra = loteMuestras.get(0);
		loteDtoPost.setIdLote(loteMuestra.getIdLoteMuestra());
		LoteMuestras tempLoteMuestra = loteMapperAbstract.loteDtoPostToLoteMuestras(loteDtoPost);
		tempLoteMuestra = this.loteMuestrasService.save(tempLoteMuestra);
		return ResponseEntity.ok(tempLoteMuestra);
	}
	
	@GetMapping("/detalles_lote")
	public ResponseEntity<List<LoteDetallesDto>> obtenerDetallesLote(){
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		System.out.print(userDetail.getUsername());
		Optional<CustomUser> user = this.customUserService.findByUsername(userDetail.getUsername());
		Long idMuestreador = user.get().getId();
		List<LoteDetallesDto> loteDetalles = this.obtenerDetallesLotes(idMuestreador);
		return ResponseEntity.ok(loteDetalles);
	}
	
	public List<LoteDetallesDto> obtenerDetallesLotes(Long idMuestreador) {
		   int numeroDeMuestrasRecolectadas;
		   List<LoteDetallesDto> listaDetallesLote = new ArrayList<>();
		   Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
		   	UserDetails userDetail = (UserDetails) auth.getPrincipal();
		   	System.out.println("Llegamos hasta aqui");
		   	Optional<CustomUser> user = this.customUserService.findByUsername(userDetail.getUsername());
		   	System.out.println("Llegamos hasta aqui 1");
		   	List<LoteMuestras> loteMuestrasAsignados = this.loteMuestrasService.findByCustomUser(user.get());
		   	System.out.println("Llegamos hasta aqui 2");
		   	for(LoteMuestras lote:loteMuestrasAsignados) {
		   		numeroDeMuestrasRecolectadas = 0;
		   		System.out.println("Llegamos a este for");
		   		List<Muestra> muestras = this.muestraService.findMuestraByIdSolicitAnalisis(lote.getIdSolicitudAnalisis().getIdSolicitud());
		   		for(Muestra m:muestras) {
		   			if(m.getIdestadoRecoleccion().getEstadoRecoleccionId() == 2)
		   			{
		   				numeroDeMuestrasRecolectadas++;
		   			}
		   		}
		   		LoteDetallesDto detallesLote = new LoteDetallesDto();
		   		detallesLote.setIdLote(lote.getIdLoteMuestra());
				detallesLote.setNumeroDeMuestrasLote(muestras.size());
				detallesLote.setNumeroMuestrasRecolectadas(numeroDeMuestrasRecolectadas);
				try {
					detallesLote.setPorcentajeAvance((float)numeroDeMuestrasRecolectadas/muestras.size() * 100);
				}
				catch(ArithmeticException e) {
					detallesLote.setPorcentajeAvance((float)0);
					System.out.println("No se puede devidir entre cero");
				}
				detallesLote.setAreaDeRecoleccion(lote.getIdSolicitudAnalisis().getDireccionExacta()+" "+lote.getIdSolicitudAnalisis().getId_municipio().getNombre()+" "+lote.getIdSolicitudAnalisis().getId_municipio().getId_departamento().getNombre());
				listaDetallesLote.add(detallesLote);
		   	}
			/*
			detallesLote.setIdLote(x.getIdLoteMuestra());
			detallesLote.setNumeroDeMuestrasLote(listaMuestras.size());
			detallesLote.setNumeroMuestrasRecolectadas(numeroDeMuestrasRecolectadas);
			detallesLote.setPorcentajeAvance((numeroDeMuestrasRecolectadas/listaMuestras.size())*100);
			detallesLote.setAreaDeRecoleccion(solicitudAnalisis.getDireccionExacta()+" "+solicitudAnalisis.getId_municipio().getNombre()+" "+solicitudAnalisis.getId_municipio().getId_departamento().getNombre());
			listaDetallesLote.add(detallesLote);*/
		//}
		
		
		return listaDetallesLote;
	}
}
