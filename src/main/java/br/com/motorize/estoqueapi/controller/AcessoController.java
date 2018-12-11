package br.com.motorize.estoqueapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motorize.estoqueapi.persistence.model.Acesso;
import br.com.motorize.estoqueapi.persistence.repository.AcessoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/acesso/")
public class AcessoController {

	@Autowired
	AcessoRepository acessoRepository;

	@PostMapping("add")
	public void addLoja(@RequestBody Acesso lojaCarro) {
		acessoRepository.create(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@PostMapping("delete")
	public void deleteLoja(@RequestBody Acesso lojaCarro) {
		acessoRepository.delete(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@GetMapping("deletebyId/{id}")
	public void deletebyIdLoja(@PathVariable("id") long id) {
		acessoRepository.deletebyId(id);
		log.info("Loja deletebyId: {}", id);
	}

	@PostMapping("update")
	public Acesso updateLoja(@RequestBody Acesso acesso) {
		log.info("Loja update: {}", acesso);
		return acessoRepository.update(acesso);
	}

	@GetMapping("findAll")
	public List<Acesso> findAllLoja() {
		log.info("Loja findAll");
		return acessoRepository.findAll();
	}

	@GetMapping("findOne/{id}")
	public Acesso findOneLoja(@PathVariable("id") long id) {
		log.info("Loja find id: {}", id);
		return acessoRepository.findOne(id);
	}
}
