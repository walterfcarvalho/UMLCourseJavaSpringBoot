package com.walterfcarvalho.cursoumc.cursoumc;


import org.springframework.web.bind.annotation.RestController;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Categoria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;


// anotation for a new controllers
@RestController
@RequestMapping(value="/categorias")

public class CategoriaResource {

    @RequestMapping(method=RequestMethod.GET)
    public ArrayList<Categoria> listar() {
        Categoria cat1 = new Categoria(1,"informatica");
        Categoria cat2 = new Categoria(2,"escritório ");
        Categoria cat3 = new Categoria(3,"papelaria");

        ArrayList<Categoria> lista = new ArrayList<>();

        
        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        
        lista.sort( (a, b) -> { return 1 * a.getNome().compareTo(b.getNome()); } );


        return lista;
    }



}
