package com.anda.muestras.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.Muestra;
import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.repository.LoteMuestrasRepository;
import com.anda.muestras.dto.LoteDetallesDto;
import com.anda.muestras.dto.LoteDto;
import com.anda.muestras.dto.LoteMapper;

@Service
public class LoteMuestraService implements LoteMuestrasRepository {
	
	@Autowired
	private LoteMuestrasRepository loteMuestraRepository;

	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends LoteMuestras> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<LoteMuestras> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoteMuestras getOne(Long id) {
		Optional<LoteMuestras> tempLoteMuestra = this.loteMuestraRepository.findById(id);
		if(tempLoteMuestra.isPresent()) {
			return tempLoteMuestra.get();
		}
		return null;
	}

	@Override
	public LoteMuestras getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoteMuestras getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoteMuestras> findAll() {
		
		
		return this.loteMuestraRepository.findAll();
	}

	@Override
	public List<LoteMuestras> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoteMuestras save(LoteMuestras loteMuestras) {
		LoteMuestras tempLoteMuestras = this.loteMuestraRepository.save(loteMuestras);
		return tempLoteMuestras;
	}
	

	@Override
	public Optional<LoteMuestras> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LoteMuestras entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends LoteMuestras> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoteMuestras> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LoteMuestras> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends LoteMuestras> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoteMuestras> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends LoteMuestras> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends LoteMuestras, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<LoteMuestras> findByIdLoteMuestra(long id) {
		List<LoteMuestras> lotemuestraRespuesta = new ArrayList<>();
	    List<LoteMuestras> lotemuestras=loteMuestraRepository.findAll();
	    for(int i = 0; i < lotemuestras.size(); i++) {
	    	
	        if(lotemuestras.get(i).getIdSolicitudAnalisis().getIdSolicitud() == id) {
	        	lotemuestraRespuesta.add(lotemuestras.get(i));
	        }
	    }
	    return lotemuestraRespuesta;
	}
	
	public List<LoteDto> obtenerLotesDelSistema(){
		List<LoteMuestras> loteMuestras  = this.loteMuestraRepository.findAll();
		List<LoteDto> loteMuestrasDto = loteMuestras.stream().map(
				loteMuestra -> LoteMapper.mapper.loteMuestrasToLoteDto(loteMuestra)).collect(Collectors.toList());
		return loteMuestrasDto;
	}
	
	public List<LoteMuestras> obtenerLoteMuestras(){
		return this.loteMuestraRepository.findAll();
	}
	

	
	public LoteMuestras obtenerLoteMuestrasByIdSolicitud(SolicitudAnalisis solicitudAnalisis) {
		LoteMuestras loteMuestras =  this.loteMuestraRepository.findByIdSolicitudAnalisis(solicitudAnalisis);
		return loteMuestras;
	}
	
	public LoteDto obtenerLoteDto(LoteMuestras loteMuestras) {
		return LoteMapper.mapper.loteMuestrasToLoteDto(loteMuestras);
	}

	@Override
	public LoteMuestras findByIdSolicitudAnalisis(SolicitudAnalisis solicitudAnalisis) {
		LoteMuestras loteMuestra = this.loteMuestraRepository.findByIdSolicitudAnalisis(solicitudAnalisis);
		return loteMuestra;
	}

	@Override
	public List<LoteMuestras> findByCustomUser(CustomUser customUser) {
		List<LoteMuestras> temLotes = new ArrayList<>();
		System.out.print("llegamos al metodo");
		//la linea de abajo es la que esta dando el problema
		List<LoteMuestras> loteMuestras = this.loteMuestraRepository.findAll();
		
		for(LoteMuestras m:loteMuestras) {
			if(m.getCustomUser().getId() == customUser.getId()) {
				temLotes.add(m);
			}
		}
		return temLotes;
	}
	
	public LoteMuestras obtenerLotePorSolicitud(long idSolicitud) {
		List<LoteMuestras> loteMuestras = this.loteMuestraRepository.findAll();
		LoteMuestras loteMuestra = new LoteMuestras();
	    for(LoteMuestras lote : loteMuestras)
	    {
	    	if(lote.getIdSolicitudAnalisis().getIdSolicitud() == idSolicitud)
	    		loteMuestra = lote;
	    }
		return loteMuestra;
	}


	
}
