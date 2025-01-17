package com.walterfcarvalho.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walterfcarvalho.cursoumc.domain.Cidade;
import com.walterfcarvalho.cursoumc.repositories.CidadeRepository;

@Service
public class CidadeService {

    // instancia automaticamente o objeto
    @Autowired
    private CidadeRepository repo;

    public Cidade buscar(Integer id) {
        Optional<Cidade> obj = repo.findById(id);

        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName(), obj));

    }

    public List<Cidade> buscarAll() {
    
        Optional<List<Cidade>> obj = Optional.ofNullable(repo.findAll());
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Empty list", obj));

    }

}
