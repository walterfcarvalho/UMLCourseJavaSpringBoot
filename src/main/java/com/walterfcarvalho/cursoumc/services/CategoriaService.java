package com.walterfcarvalho.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walterfcarvalho.cursoumc.domain.Categoria;
import com.walterfcarvalho.cursoumc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    // instancia automaticamente o objeto
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), obj));

    }

    public List<Categoria> buscarAll() {
    
        Optional<List<Categoria>> obj = Optional.ofNullable(repo.findAll());
        return obj.orElseThrow(
            () -> new ObjectNotFoundException(
                "Empty list", obj));

    }


    



}
// 56