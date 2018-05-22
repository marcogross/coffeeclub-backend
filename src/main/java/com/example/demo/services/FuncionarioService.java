package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	//Método find
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElse(null) ;
		
	}
	//Método insert
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	//Método update
	public Funcionario update(Funcionario obj) {
		return repo.save(obj);
	}
	
	//Método delete
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
	
	//Método findAll (retorna uma lista com os objetos da categoria)
	public List<Funcionario> findAll(){
		return repo.findAll();
	}
	
}
