package com.proyectoColegio.colegio.repo;

import com.proyectoColegio.colegio.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface MovimentoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {
    //Metodo para filtrar movimientos por empresa
    @Query(value="select * from movimientos where empleado_id in (select id from empleado where colegio_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);
}
