package com.baozi.store.controller;

import com.baozi.store.model.Pedido;
import com.baozi.store.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository repository;

	@PostMapping
	public Pedido criar(@RequestBody Pedido pedido) {
		return repository.save(pedido);
	}

	@GetMapping
	public List<Pedido> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Pedido buscar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
