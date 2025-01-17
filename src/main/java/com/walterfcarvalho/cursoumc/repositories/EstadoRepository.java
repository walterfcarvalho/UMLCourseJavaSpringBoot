package com.walterfcarvalho.cursoumc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walterfcarvalho.cursoumc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
 
}
