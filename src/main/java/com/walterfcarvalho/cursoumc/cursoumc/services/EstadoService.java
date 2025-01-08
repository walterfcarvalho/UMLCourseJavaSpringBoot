package com.walterfcarvalho.cursoumc.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walterfcarvalho.cursoumc.cursoumc.domain.Estado;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.EstadoRepository;

@Service
public class EstadoService {

    // instancia automaticamente o objeto
    @Autowired
    private EstadoRepository repo;

    public Estado buscar(Integer id) {
        Optional<Estado> obj = repo.findById(id);

        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName(), obj));

    }

    public List<Estado> buscarAll() {
    
        Optional<List<Estado>> obj = Optional.ofNullable(repo.findAll());
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Empty list", obj));

    }

}
