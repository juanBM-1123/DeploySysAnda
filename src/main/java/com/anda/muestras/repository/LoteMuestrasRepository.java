package com.anda.muestras.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.SolicitudAnalisis;


public interface LoteMuestrasRepository extends JpaRepository<LoteMuestras,Long> {

	@Query("Select u from LoteMuestras u where u.idSolicitudAnalisis = :solicitudAnalisis")
	LoteMuestras findByIdSolicitudAnalisis(@Param("solicitudAnalisis")SolicitudAnalisis solicitudAnalisis);

	List<LoteMuestras> findByCustomUser(CustomUser customUser);
	
}
