package com.proyectoColegio.colegio.controller;

import com.proyectoColegio.colegio.modelos.Colegios;
import com.proyectoColegio.colegio.service.ColegiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContorllerColegios {


    @Autowired
    ColegiosService colegiosService;

    //EMPRESAS
    @GetMapping("/enterprises") //Ver json de todas las empresas
    public List<Colegios> verColegios(){
        return colegiosService.getAllColegios();
    }

    @PostMapping("/enterprises") //Guardar el json del body como una nueva empresa o registro en nuestra bd
    public Colegios guardarColegios(@RequestBody Colegios emp) {
        return this.colegiosService.saveOrUpdateColegios(emp);
    }


    @GetMapping(path = "enterprises/{id}")
    public Colegios empresaPorID(@PathVariable("id") Integer id){

        return this.colegiosService.getColegiosById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Colegios actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Colegios colegios){
        Colegios emp= colegiosService.getColegiosById(id);
        emp.setNombre(colegios.getNombre());
        emp.setDireccion(colegios.getDireccion());
        emp.setTelefono(colegios.getTelefono());
        emp.setNIT(colegios.getNIT());
        return colegiosService.saveOrUpdateColegios(emp);

    }


    @DeleteMapping (path= "enterprises/{id}") //Eliminar registro de la bd
    public String DeleteColegio(@PathVariable("id") Integer id){
        boolean respuesta= this.colegiosService.deleteColegio(id);
        if (respuesta){  //Si respuesta es true?
            return "Se elimino la empresa con id" +id;
        }
        else{
            return "No se pudo eliminar la empresa con id"+id;
        }
    }
}
