package com.walterfcarvalho.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walterfcarvalho.cursoumc.domain.Pedido;
import com.walterfcarvalho.cursoumc.repositories.PedidoRepository;

@Service
public class PedidoService {

    // instancia automaticamente o objeto
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName(), obj));

    }

    public List<Pedido> buscarAll() {
    
    

        Optional<List<Pedido>> obj = Optional.ofNullable(repo.findAll());
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Empty list", obj));

    }


    



}
// 56