package com.anda.muestras.repository;

import com.anda.muestras.model.EstadoRecolectorDeMuestra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRecolectorDeMuestrasRepository extends JpaRepository<EstadoRecolectorDeMuestra,Long> {

	EstadoRecolectorDeMuestra findByNombreEstadoRecoleccion(String nombre);

}
