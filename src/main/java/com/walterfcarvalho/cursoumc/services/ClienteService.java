package com.walterfcarvalho.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walterfcarvalho.cursoumc.domain.Cliente;
import com.walterfcarvalho.cursoumc.repositories.ClienteRepository;

@Service
public class ClienteService {

    // instancia automaticamente o objeto
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), obj));

    }

    public List<Cliente> buscarAll() {
    
        Optional<List<Cliente>> obj = Optional.ofNullable(repo.findAll());
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Empty list", obj));

    }
}