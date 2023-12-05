package com.anda.muestras.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.anda.muestras.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
}
