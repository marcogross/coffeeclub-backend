package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ItemPedidoFuncionario;
import com.example.demo.domain.PedidoFuncionario;
import com.example.demo.repositories.PedidoFuncionarioRepository;

@Service
public class PedidoFuncionarioService {

	@Autowired
	private PedidoFuncionarioRepository repo;
	
	@Autowired
	private ItemPedidoFuncionarioService itemPedidoFuncionarioService;

	// Método find
	public PedidoFuncionario find(Integer id) {
		Optional<PedidoFuncionario> obj = repo.findById(id);
		return obj.orElse(null);
	}

	// Método insert
	public PedidoFuncionario insert(PedidoFuncionario obj) {
		//PedidoFuncionario pedidoFuncionario =  repo.save(obj);
		
		
		//itemPedidoFuncionarioService.insertAll(pedidoFuncionario.getItenspedidofuncionario());
		for (ItemPedidoFuncionario item : obj.getItenspedidofuncionario()) {
			item.setPedidofuncionario(obj);
			//itemPedidoFuncionarioService.insert(item);
		}
		
		return repo.save(obj);
	}

	// Método update
	public PedidoFuncionario update(PedidoFuncionario obj) {
		return repo.save(obj);
	}

	// Método delete
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	/*
	 * USE ESSA FORMA DE DELETE EM ENTIDADES QUE POSSUEM OUTRAS ENTIDADES LIGADAS A
	 * ELA Ex: Uma categoria tem vários produtos atrelados a ela public void
	 * delete(Integer id) { find(id); try { repo.deleteById(id); }
	 * catch(DataIntegrityViolationException e) { throw new
	 * DataIntegrityException("Não é possível excluir uma categoria que possui produtos"
	 * );
	 * 
	 * } }
	 */

	// Método findAll (retorna uma lista com os objetos da categoria)
	public List<PedidoFuncionario> findAll() {
		return repo.findAll();
	}
}
