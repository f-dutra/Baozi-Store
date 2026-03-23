package com.baozi.store.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.baozi.store.repository.ClienteRepository;
import com.baozi.store.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PostMapping
	public Cliente criar(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

	@GetMapping
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
