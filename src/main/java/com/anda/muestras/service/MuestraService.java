package com.anda.muestras.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.anda.muestras.model.Muestra;
import com.anda.muestras.repository.MuestraRepository;
import com.anda.muestras.dto.MuestraDto;
import com.anda.muestras.dto.MuestraMapper;

@Service
public class MuestraService implements MuestraRepository {
	
	@Autowired
	private MuestraRepository muestraRepository;
	@Autowired
	private MuestraMapper muestraMapper;

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	public List<Muestra> findMuestraByIdSolicitAnalisis(long idSolicitudAnalisis) {
		List<Muestra> muestraRespuesta = new ArrayList<>();
	    List<Muestra> muestras=muestraRepository.findAll();
	    for(int i = 0; i < muestras.size(); i++) {
	    	
	        if(muestras.get(i).getIdLoteMuestra().getIdSolicitudAnalisis().getIdSolicitud() ==  idSolicitudAnalisis) 
	        {
	            muestraRespuesta.add(muestras.get(i));
	        }
	    }
	    return muestraRespuesta;
	}
	@Override
	public <S extends Muestra> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Muestra> entities) {
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
	public Muestra getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Muestra getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Muestra getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Muestra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Muestra> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Muestra save(Muestra muestra) {
		
		return this.muestraRepository.save(muestra);
	}

	@Override
	public Optional<Muestra> findById(Long id) {
		Optional<Muestra> muestra = this.muestraRepository.findById(id);
		return muestra;
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
		muestraRepository.deleteById(id);
		
	}

	@Override
	public void delete(Muestra entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Muestra> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Muestra> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Muestra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Muestra> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Muestra> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Muestra> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Muestra, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public MuestraDto obtenerMuestrasDto(Muestra muestra) {
		return this.muestraMapper.muetraToDtoMuestra(muestra);
	}
	
	public List<Muestra> obtenerMuestrasByLoteId(Long loteId)
	{
		List<Muestra> muestrasByLote = new ArrayList<>();
		List<Muestra> muestras = this.muestraRepository.findAll();
		muestras.forEach((muestra)->{
				if(muestra.getIdLoteMuestra().getIdLoteMuestra() == loteId) {
					muestrasByLote.add(muestra);
				}
		});
		return muestrasByLote;
	}
	
	
}
