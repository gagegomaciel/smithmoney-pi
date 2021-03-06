package com.smithmoney.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smithmoney.model.Categoria;
import com.smithmoney.model.TipoLancamento;
import com.smithmoney.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
		
		private final CategoriaService categoriaService;

		public CategoriaController(CategoriaService categoriaService) {
			this.categoriaService = categoriaService;
		}
				
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> findById(@PathVariable Long id) {
			
			Categoria categoria = this.categoriaService.findById(id);
			
			return ResponseEntity.ok(categoria);
		}
		
		@GetMapping("/tipo/{tipo}")
		public ResponseEntity<List<Categoria>> findAllByType(@PathVariable TipoLancamento tipo) {			
			List<Categoria> categorias = this.categoriaService.findAllByType(tipo);			
			return ResponseEntity.ok(categorias);
		}
		
		@GetMapping
		public ResponseEntity<List<Categoria>> findAll() {
			
			List<Categoria> categoria = this.categoriaService.findAll();
			
			return ResponseEntity.ok(categoria);
		}
		
	}