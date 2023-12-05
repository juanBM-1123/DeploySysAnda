package com.anda.muestras.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.Roles;


@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
		public abstract List<CustomUser> findByRol(Roles rol);

		Optional<CustomUser> findByUsername(String username);
}