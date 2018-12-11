package br.com.motorize.estoqueapi.controller;

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

	@GetMapping("login/{email}/{senha}")
	public Acesso login(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		log.info("Acesso LOGIN - email: {} com senha:", email, senha);
		return acessoRepository.login(email, senha);
	}
	
	@PostMapping("add")
	public void addLoja(@RequestBody Acesso lojaCarro) {
		log.info("Acesso add: {}", lojaCarro);
		acessoRepository.create(lojaCarro);
	}

	@GetMapping("deletebyId/{id}")
	public void deletebyIdLoja(@PathVariable("id") long id) {
		acessoRepository.deletebyId(id);
		log.info("Acesso deletebyId: {}", id);
	}

	@PostMapping("update")
	public Acesso updateLoja(@RequestBody Acesso acesso) {
		log.info("Acesso update: {}", acesso);
		return acessoRepository.update(acesso);
	}

	@GetMapping("findOne/{id}")
	public Acesso findOneLoja(@PathVariable("id") long id) {
		log.info("Acesso find id: {}", id);
		return acessoRepository.findOne(id);
	}
}
