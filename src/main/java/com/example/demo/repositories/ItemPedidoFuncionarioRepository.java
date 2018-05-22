package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ItemPedidoFuncionario;

@Repository
public interface ItemPedidoFuncionarioRepository extends JpaRepository<ItemPedidoFuncionario, Integer> {

}
