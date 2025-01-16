package com.walterfcarvalho.cursoumc.cursoumc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walterfcarvalho.cursoumc.cursoumc.domain.ItemPedido;
import com.walterfcarvalho.cursoumc.cursoumc.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
 
}
