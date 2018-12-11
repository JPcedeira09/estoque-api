package br.com.motorize.estoqueapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motorize.estoqueapi.persistence.model.Funcionario;
import br.com.motorize.estoqueapi.persistence.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/funcionario/")
public class FuncionarioController {

	/// BLOCO DE SERVIÇOS DO FUNCIONARIO 
		@Autowired
		FuncionarioRepository funcionarioRepository;
		
		@PostMapping("add")
		public void addFuncionario(@RequestBody Funcionario lojaCarro) {
			log.info("Funcionario add: {}", lojaCarro);
			funcionarioRepository.create(lojaCarro);
		}

		@PostMapping("delete")
		public void deleteFuncionario(@RequestBody Funcionario lojaCarro) {
			log.info("Funcionario add: {}", lojaCarro);
			funcionarioRepository.delete(lojaCarro);
		}

		@PostMapping("deletebyId/{id}")
		public void deletebyIdFuncionario(@PathVariable("id") long id) {
			log.info("Funcionario deletebyId: {}", id);
			funcionarioRepository.deletebyId(id);
		}

		@PostMapping("update")
		public Funcionario updateFuncionario(@RequestBody Funcionario lojaCarro) {
			log.info("Funcionario update: {}", lojaCarro);
			return funcionarioRepository.update(lojaCarro);
		}

		@PostMapping("findAll")
		public List<Funcionario> findAllFuncionario() {
			log.info("Funcionario findAll");
			return funcionarioRepository.findAll();
		}

		@PostMapping("findOne/{id}")
		public Funcionario findOneFuncionario(@PathVariable("id") long id) {
			log.info("Funcionario find id: {}", id);
			return funcionarioRepository.findOne(id);
		}
}
