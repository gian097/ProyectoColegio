package com.proyectoColegio.colegio.service;

import com.proyectoColegio.colegio.modelos.Empleado;
import com.proyectoColegio.colegio.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoSerivice {

    @Autowired
    EmpleadoRepository empleadoRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList= new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }


    //Metodo para buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Integer id){ //Existe optional y asi se podria usar

        return empleadoRepository.findById(id);
    }



    //Metodo para eliminar un registro de Empleado por Id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        if(this.empleadoRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }




}
