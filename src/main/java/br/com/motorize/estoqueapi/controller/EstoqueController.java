package br.com.motorize.estoqueapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motorize.estoqueapi.persistence.model.CarroEstoque;
import br.com.motorize.estoqueapi.persistence.repository.EstoqueRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@GetMapping("/hello/{txt}")
	public String hello(@PathVariable("txt") String txt) {
		log.info("Nome do Hello: txt={}", txt);
		return txt;
	}
	
	@GetMapping("/feign")
	public String feign() {
		return "TESTE";
	}
	@PostMapping("/add")
	public void add(@RequestBody CarroEstoque estoque) {
		estoqueRepository.create(estoque);
		log.info("Estoque add: {}", estoque);
	}
	
	@GetMapping("/find/carro/{id}")
	public CarroEstoque findById(@PathVariable("id") Long id) {
		log.info("Estoque find: id={}", id);
		return estoqueRepository.findOne(id);
	}
	
	@GetMapping("/findAll")
	public List<CarroEstoque> findAll() {
		log.info("Estoque find");
		return estoqueRepository.findAll();
	}
	
	@GetMapping("/find/marca/{marca}")
	public List<CarroEstoque> findByDepartment(@PathVariable("marca") String marca) {
		log.info("Estoque find: departmentId={}", marca);
		return estoqueRepository.findMarca(marca);
	}

}
