package com.walterfcarvalho.cursoumc.cursoumc.resources;


import org.springframework.web.bind.annotation.RestController;
import com.walterfcarvalho.cursoumc.cursoumc.services.EstadoService;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// anotation for a new controllers
@RestController
@RequestMapping(value="/estados")

public class EstadoResource {
    
    @Autowired
    private EstadoService estadoService;

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id ) {

        Estado obj = estadoService.buscar(id);
                            
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="",  method=RequestMethod.GET)
    public ResponseEntity<?> findAll1() {
        return this.findAll2();
    }
    @RequestMapping(value="/",  method=RequestMethod.GET)
    
    public ResponseEntity<?> findAll2() {

        List<Estado> obj = estadoService.buscarAll();
                            
        return ResponseEntity.ok().body(obj);
    }

}
