package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.ItemPedidoFuncionario;
import com.example.demo.services.ItemPedidoFuncionarioService;

@RestController
@RequestMapping(value="/itensPedidoFuncionario")
public class ItemPedidoFuncionarioResource {
	
	@Autowired
	private ItemPedidoFuncionarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ItemPedidoFuncionario> find(@PathVariable Integer id) {
		
		ItemPedidoFuncionario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ItemPedidoFuncionario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ItemPedidoFuncionario obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Retorna uma lista de todos os objetos (ex: todos os cafes no endereço /cafes)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ItemPedidoFuncionario>> findAll() {
		
		List<ItemPedidoFuncionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}