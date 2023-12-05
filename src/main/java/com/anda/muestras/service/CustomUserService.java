package com.anda.muestras.service;


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

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.Roles;
import com.anda.muestras.repository.CustomUserRepository;


@Service
public class CustomUserService implements CustomUserRepository {
	
	@Autowired
	private CustomUserRepository customUserRepository;
	
	public CustomUserService() {
		
	}
	
	public List<CustomUser> getCustomUser (){
		return (List<CustomUser>) customUserRepository.findByRol(Roles.MUESTREADOR);
	}
	
	@Override
	public List<CustomUser> findByRol(Roles rol) {
		// TODO Auto-generated method stub
		return (List<CustomUser>) customUserRepository.findByRol(Roles.MUESTREADOR);
	}
		
	public CustomUser findById(long id) {
        return this.customUserRepository.findById(id).orElse(null);
    }

	@Override
	public void flush() {
		// TODO Auto-generated method stub
	}
	
	
	public <S extends CustomUser> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomUser> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<CustomUser> entities) {
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
	public CustomUser getOne(Long id) {
		Optional<CustomUser> customUser = this.customUserRepository.findById(id);
		if(customUser.isPresent()) {
			return customUser.get();
		}
		return null;
	}

	@Override
	public CustomUser getById(Long id) {
		CustomUser customUser = this.customUserRepository.findById(id).get();
		if(customUser==null) {
				return null;
		}
		return customUser;
	}

	@Override
	public CustomUser getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomUser> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public <S extends CustomUser> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomUser> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomUser> findAll() {
		// TODO Auto-generated method stub
		return this.customUserRepository.findAll();
		//return null;
	}


	@Override
	public List<CustomUser> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public <S extends CustomUser> S save(S entity) {
		// TODO Auto-generated method stub
		CustomUser customUser = this.customUserRepository.save(entity);
		if(customUser != null) {
			return (S)customUser;
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<CustomUser> findById(Long id) {
		CustomUser customUser = this.customUserRepository.getById(id);
		if(customUser== null) {
				return null;
		}
		
		return Optional.of(customUser);
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
		this.customUserRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CustomUser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends CustomUser> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomUser> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomUser> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomUser> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends CustomUser> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomUser> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends CustomUser> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends CustomUser, R> R findBy(Example<S> example,
		Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CustomUser> findByUsername(String username) {
		Optional<CustomUser> user = this.customUserRepository.findByUsername(username);
		return user;
	}
	
}