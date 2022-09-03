package com.proyectoColegio.colegio.repo;

import com.proyectoColegio.colegio.modelos.Colegios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//Anotacion que le dice a Spring que esta clase es un repositorio
public interface ColegiosRepository extends JpaRepository<Colegios, Integer> {

}
