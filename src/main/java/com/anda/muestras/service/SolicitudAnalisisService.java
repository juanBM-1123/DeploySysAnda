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

import com.anda.muestras.dto.SolicitudAnalisisDetalleDtoMapper;
import com.anda.muestras.dto.SolicitudDetalleDto;
import com.anda.muestras.dto.SolicitudDtoDetalles;
import com.anda.muestras.dto.SolicitudMapper;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.SolicitudAnalisis;
import com.anda.muestras.repository.SolicitudAnalisisRepository;

import jakarta.transaction.Transactional;

@Service
public class SolicitudAnalisisService implements SolicitudAnalisisRepository {

	@Autowired
	private SolicitudAnalisisRepository solicitudAnalisisRepository;
	@Autowired
	private LoteMuestraService loteMuestraService;
	@Autowired
	private SolicitudMapper solicitudMapper;
	
	public SolicitudAnalisisService() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	
	public SolicitudAnalisis findById(long id) {
        return this.solicitudAnalisisRepository.findById(id).orElse(null);
    }

	@Override
	public <S extends SolicitudAnalisis> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<SolicitudAnalisis> entities) {
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
	public SolicitudAnalisis getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitudAnalisis getById(Long id) {
		Optional<SolicitudAnalisis> solicitudAnalisisOptional = this.solicitudAnalisisRepository.findById(id);
		if(solicitudAnalisisOptional.isPresent()) {
			return solicitudAnalisisOptional.get();
		}
		return null;
	}

	@Override
	public SolicitudAnalisis getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudAnalisis> findAll() {
		// TODO Auto-generated method stub
		return solicitudAnalisisRepository.findAll();
	}

	@Override
	public List<SolicitudAnalisis> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return solicitudAnalisisRepository.findAllById(ids);
	}

	@Override
	public SolicitudAnalisis save(SolicitudAnalisis solicitudAnalisis) {
		SolicitudAnalisis tempSolicitudAnalisis = this.solicitudAnalisisRepository.save(solicitudAnalisis);
		return tempSolicitudAnalisis;
	}

	@Override
	public Optional<SolicitudAnalisis> findById(Long id) {
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
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 SolicitudAnalisis solicitudAnalisis = this.solicitudAnalisisRepository.findById(id).orElse(null);
		    if (solicitudAnalisis != null) {
		        this.solicitudAnalisisRepository.delete(solicitudAnalisis);
		 }
		
	}

	@Override
	public void delete(SolicitudAnalisis entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends SolicitudAnalisis> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SolicitudAnalisis> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SolicitudAnalisis> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends SolicitudAnalisis> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SolicitudAnalisis> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends SolicitudAnalisis> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends SolicitudAnalisis, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Recupera una lista de todos las solicitudes de analisis
	 * con sus datos de detalle correspondiente:
	 * Nombre y apellidos del muestreador
	 * ubicacion exacta
	 * nombre de departamento
	 * nombre municipio
	 * id de solicitud
	 * */
	public List<SolicitudDtoDetalles> obtenerDetallesSolicitudesDeAnalisis(){
		List<SolicitudDtoDetalles> solicitudesDetalleDto = new ArrayList<>();
		List<SolicitudAnalisis> solicitudesDeAnalisis = this.solicitudAnalisisRepository.findAll();
		
		solicitudesDeAnalisis.forEach((solicitudAnalisis)->{
			solicitudesDetalleDto.add(solicitudMapper.solicitudAnalisisToSolicitudDtoDetalle(solicitudAnalisis));
		});
		
		return solicitudesDetalleDto;
	}
	
}
