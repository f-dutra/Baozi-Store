package com.baozi.store.controller;

import com.baozi.store.model.Produto;
import com.baozi.store.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	public Produto criar(@RequestBody Produto produto) {
		return repository.save(produto);
	}

	@GetMapping
	public List<Produto> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Produto buscar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
