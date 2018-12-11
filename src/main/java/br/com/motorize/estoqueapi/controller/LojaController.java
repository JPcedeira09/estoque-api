package br.com.motorize.estoqueapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motorize.estoqueapi.persistence.model.LojaCarro;
import br.com.motorize.estoqueapi.persistence.repository.LojaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/loja/")
public class LojaController {

	@Autowired
	LojaRepository lojaRepository;

	@PostMapping("add")
	public void addLoja(@RequestBody LojaCarro lojaCarro) {
		lojaRepository.create(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@PostMapping("delete")
	public void deleteLoja(@RequestBody LojaCarro lojaCarro) {
		lojaRepository.delete(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@GetMapping("deletebyId/{id}")
	public void deletebyIdLoja(@PathVariable("id") long id) {
		lojaRepository.deletebyId(id);
		log.info("Loja deletebyId: {}", id);
	}

	@PostMapping("update")
	public LojaCarro updateLoja(@RequestBody LojaCarro lojaCarro) {
		log.info("Loja update: {}", lojaCarro);
		return lojaRepository.update(lojaCarro);
	}

	@GetMapping("findAll")
	public List<LojaCarro> findAllLoja() {
		log.info("Loja findAll");
		return lojaRepository.findAll();
	}

	@GetMapping("findOne/{id}")
	public LojaCarro findOneLoja(@PathVariable("id") long id) {
		log.info("Loja find id: {}", id);
		return lojaRepository.findOne(id);
	}
}
