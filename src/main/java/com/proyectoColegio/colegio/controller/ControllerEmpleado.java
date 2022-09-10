package com.proyectoColegio.colegio.controller;

import com.proyectoColegio.colegio.modelos.Empleado;
import com.proyectoColegio.colegio.service.ColegiosService;
import com.proyectoColegio.colegio.service.EmpleadoSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerEmpleado {

    @Autowired
    EmpleadoSerivice empleadoService;

    @Autowired
    ColegiosService colegiosService;


    @GetMapping("/users") //Ver json de todas los empleados
    public List<Empleado> verEmpleados(){
        return empleadoService.getAllEmpleado();
    }


    @PostMapping("/users") //Guardar un empleado nuevo
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
        return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }


    @GetMapping(path = "user/{id}")//Consultar empleado por ID
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @PatchMapping("/user/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado empl=empleadoService.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setColegios(empleado.getColegios());
        empl.setRol(empleado.getRol());
        return empleadoService.saveOrUpdateEmpleado(empl);
    }

    @DeleteMapping("/user/{id}") //Metodo para eliminar empleados por id
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta=empleadoService.deleteEmpleado(id); //eliminamos usando el servicio de nuestro service
        if (respuesta){ //si la respuesta booleana es true, si se eliminò
            return "Se pudo eliminar correctamente el empleado con id "+id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar correctamente el empleado con id "+id;
    }



}
