package com.proyectoColegio.colegio.service;

import com.proyectoColegio.colegio.modelos.MovimientoDinero;
import com.proyectoColegio.colegio.repo.MovimentoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService {
    @Autowired
    MovimentoDineroRepository movimentoDineroRepository;

    public List<MovimientoDinero> getAllMovimientos(){ //Metodo que me muestra todos los movimientos sin ningn filtro
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimentoDineroRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return movimientosList;
    }
/*
    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) { //Obterner teniendo en cuenta el id del empleado
        return movimentoDineroRepository.findByEmpresa(id);
    }

 */

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return movimentoDineroRepository.findByEmpresa(id);
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){ //Guardar o actualizar elementos
        MovimientoDinero mov=movimentoDineroRepository.save(movimientoDinero);
        return mov;
    }

    public MovimientoDinero getMovimientoById(Integer id){ //Ver movimientos por id
        return movimentoDineroRepository.findById(id).get();
    }

    public boolean deleteMovimiento(Integer id){ //Eliminar movimiento por id
        movimentoDineroRepository.deleteById(id); //Eliminar usando el metodo que nos ofrece el repositorio
        if(this.movimentoDineroRepository.findById(id).isPresent()){ //Si al buscar el movimiento lo encontramos, no se eliminó (false)
            return false;
        }
        return true; //Si al buscar el movimiento no lo encontramos, si lo eliminò (true)
    }

}
