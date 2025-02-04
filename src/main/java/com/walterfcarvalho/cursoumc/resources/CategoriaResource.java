package com.walterfcarvalho.cursoumc.resources;


import org.springframework.web.bind.annotation.RestController;
import com.walterfcarvalho.cursoumc.domain.Categoria;
import com.walterfcarvalho.cursoumc.services.CategoriaService;

import io.micrometer.common.lang.Nullable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



// anotation for a new controllers
@RestController
@RequestMapping(value="/categorias")

public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Categoria obj = categoriaService.buscar(id);
                            
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="",  method=RequestMethod.GET)
    public ResponseEntity<?> findAll1(@RequestParam String catName) {
        return this.findAll2(catName);
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> findAll2(@RequestParam @Nullable String catName ) {

        List<Categoria> obj = categoriaService.buscarAll();
                            
        return ResponseEntity.ok().body(obj);
    }

}
