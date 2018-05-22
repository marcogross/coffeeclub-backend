package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ItemPedidoFuncionario;
import com.example.demo.repositories.ItemPedidoFuncionarioRepository;

@Service
public class ItemPedidoFuncionarioService {

	@Autowired
	private ItemPedidoFuncionarioRepository repo;
	
	public ItemPedidoFuncionario find(Integer id) {
		Optional<ItemPedidoFuncionario> obj = repo.findById(id);
		return obj.orElse(null);	
	}
	
	public ItemPedidoFuncionario insert(ItemPedidoFuncionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<ItemPedidoFuncionario> insertAll(List<ItemPedidoFuncionario> objects) {
		return repo.saveAll(objects);
	}
	
	public ItemPedidoFuncionario update(ItemPedidoFuncionario obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	/* USE ESSA FORMA DE DELETE EM ENTIDADES QUE POSSUEM OUTRAS ENTIDADES LIGADAS A ELA
	 * Ex: Uma categoria tem vários produtos atrelados a ela
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
			
		}
	}
	*/
	
	public List<ItemPedidoFuncionario> findAll(){
		return repo.findAll();
	}
}
