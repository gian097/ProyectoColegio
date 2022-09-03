package com.proyectoColegio.colegio.service;

import antlr.ASTNULLType;
import com.proyectoColegio.colegio.modelos.Colegios;
import com.proyectoColegio.colegio.repo.ColegiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColegiosService {

    @Autowired //Conectamos esta clase con el repository de Empresa
    ColegiosRepository colegiosRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    public List<Colegios> getAllColegios(){
        List<Colegios> colegiosList = new ArrayList<>();
        colegiosRepository.findAll().forEach(colegios -> colegiosList.add(colegios));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return colegiosList;
    }
    //Metodo que me trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Colegios getColegiosById(Integer id){
        return colegiosRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public Colegios saveOrUpdateColegios(Colegios colegios){
        Colegios emp=colegiosRepository.save(colegios);
        return emp;
    }
    //Metodo para eliminar empresas registradas teniendo el id
    public boolean deleteColegio(Integer id){
        colegiosRepository.deleteById(id);  //Eliminar

        if (colegiosRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }







}
