package com.proyectoColegio.colegio.controller;

import com.proyectoColegio.colegio.modelos.MovimientoDinero;
import com.proyectoColegio.colegio.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoDineroController {

    @Autowired
    MovimientoDineroService movimientoDineroService;

    @GetMapping("/movements") //Consultar todos los movimientos
    public List<MovimientoDinero> verMovimientos() {
        return movimientoDineroService.getAllMovimientos();
    }


    @GetMapping("/enterprises/{id}/movements")
    //Consultar movimientos que pertenecen a una empresa por el id de la empresa
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id) {
        return movimientoDineroService.obtenerPorEmpresa(id);
    }



    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero guardarMovimiento(@PathVariable("id") Integer id,@RequestBody MovimientoDinero movimiento){
        return movimientoDineroService.saveOrUpdateMovimiento(movimiento);
    }

    @PatchMapping("/movements/{id}")//Editar o actualizar un movimiento
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov = movimientoDineroService.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientoDineroService.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/movements/{id}")
    public String deleteMovimiento(@PathVariable("id") Integer id){
        boolean respuesta= movimientoDineroService.deleteMovimiento(id);
        if (respuesta){
            return "Se elimino correctamente el movimiento con id " +id;
        }
        return "No se pudo eliminar el movimiento con id "+id;
    }
}
