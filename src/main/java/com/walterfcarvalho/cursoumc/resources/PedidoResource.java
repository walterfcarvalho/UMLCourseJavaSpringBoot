package com.walterfcarvalho.cursoumc.resources;


import org.springframework.web.bind.annotation.RestController;
import com.walterfcarvalho.cursoumc.domain.Pedido;
import com.walterfcarvalho.cursoumc.services.PedidoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



// anotation for a new controllers
@RestController
@RequestMapping(value="/pedidos")

public class PedidoResource {

    @Autowired
    private PedidoService PedidoService;

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Pedido obj = PedidoService.buscar(id);
                            
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="",  method=RequestMethod.GET)
    public ResponseEntity<?> findAll1(@RequestParam String catName) {
        return this.findAll2(catName);
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> findAll2(@RequestParam String catName ) {

        List<Pedido> obj = PedidoService.buscarAll();
                            
        return ResponseEntity.ok().body(obj);
    }

}
