package com.walterfcarvalho.cursoumc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.walterfcarvalho.cursoumc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
 
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    List<Cliente> findByNome(String nome);

}
