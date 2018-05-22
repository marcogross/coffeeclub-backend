package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cafe;
import com.example.demo.repositories.CafeRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class CafeService {
	
	@Autowired
	private CafeRepository repo;
	
	public Cafe find(Integer id) {
		Optional<Cafe> obj = repo.findById(id);
		//return obj.orElse(null) ;
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cafe.class.getName()));
	}
	
	public Cafe insert(Cafe obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cafe update(Cafe obj) {
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
	
	public List<Cafe> findAll(){
		return repo.findAll();
	}
	
	
	
	//criar costrutor de cafe
	/*
    public Cafe cadastrarCafe(String nome, double preco, Integer intensidade, String perfilAromatico, String variedade) {
        Cafe cafe = new Cafe();
        cafe.setNome(nome);
        cafe.setIntensidade(intensidade);
        cafe.setPerfilAromatico(perfilAromatico);
        cafe.setPreco(preco);
        cafe.setVariedade(variedade);
        return getRepository().save(cafe);
    }
    */


}
