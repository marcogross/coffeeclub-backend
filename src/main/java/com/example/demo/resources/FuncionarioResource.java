package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Funcionario;
import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.services.FuncionarioService;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	//Método GET
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
		
		Funcionario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	//Método POST
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Funcionario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	//Método PUT
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Funcionario obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	//Método DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Retorna uma lista de todos os objetos (ex: todos os cafes no endereço /cafes)
	//Obs: Nesta solicitação GET queremos ver só as informações basicas/nativas da nossa classe, por isso queremos receber um objeto DTO
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {
		
		List<Funcionario> list = service.findAll();
		List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

}
