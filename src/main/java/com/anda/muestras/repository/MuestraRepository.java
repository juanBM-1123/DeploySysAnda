package com.anda.muestras.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.anda.muestras.model.Muestra;

public interface MuestraRepository extends JpaRepository<Muestra,Long> {

	public void deleteById(Long id);



}
