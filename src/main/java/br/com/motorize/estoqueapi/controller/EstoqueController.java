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
import br.com.motorize.estoqueapi.persistence.model.Funcionario;
import br.com.motorize.estoqueapi.persistence.model.LojaCarro;
import br.com.motorize.estoqueapi.persistence.model.Meta;
import br.com.motorize.estoqueapi.persistence.repository.EstoqueRepository;
import br.com.motorize.estoqueapi.persistence.repository.FuncionarioRepository;
import br.com.motorize.estoqueapi.persistence.repository.LojaRepository;
import br.com.motorize.estoqueapi.persistence.repository.MetasRepository;
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

	/// BLOCO DE SERVIÇOS DO CARRO

	@PostMapping("/carro/add")
	public void addCarroEstoque(@RequestBody CarroEstoque estoque) {
		estoqueRepository.create(estoque);
		log.info("Estoque add: {}", estoque);
	}

	@PostMapping("/carro/update")
	public void updateCarroEstoque(@RequestBody CarroEstoque estoque) {
		estoqueRepository.update(estoque);
		log.info("Estoque add: {}", estoque);
	}

	@PostMapping("/carro/deleteid")
	public void deleteByIdCarroEstoque(@RequestBody long id) {
		estoqueRepository.deletebyId(id);
		log.info("Estoque delete: {}", id);
	}

	@PostMapping("/carro/delete")
	public void deleteCarroEstoque(@RequestBody CarroEstoque carroEstoque) {
		estoqueRepository.delete(carroEstoque);
		log.info("Estoque delete: {}", carroEstoque);
	}

	@GetMapping("/carro/find/carro/{id}")
	public CarroEstoque findByIdCarroEstoque(@PathVariable("id") Long id) {
		log.info("Estoque find: id={}", id);
		return estoqueRepository.findOne(id);
	}

	@GetMapping("/carro/findAll")
	public List<CarroEstoque> findAllCarroEstoque() {
		log.info("Estoque findAll");
		return estoqueRepository.findAll();
	}

	@GetMapping("/find/marca/{marca_carro}")
	public List<CarroEstoque> findByMarca(@PathVariable("marca_carro") String marca_carro) {
		log.info("Estoque find: Marca={}", marca_carro);
		return estoqueRepository.findMarca(marca_carro);
	}

	@GetMapping("/find/marca/{marca_carro}/{versao_carro}")
	public List<CarroEstoque> findByMarcaVersao(@PathVariable("marca_carro") String marca_carro, @PathVariable("versao_carro") String versao_carro) {
		log.info("Estoque find: Marca={} e Versao=", marca_carro, versao_carro);
		return estoqueRepository.findMarcaVersao(marca_carro, versao_carro);
	}

	@GetMapping("/find/ano/{marca_carro}/{versao_carro}/{ano1}/{ano2}")
	public List<CarroEstoque> findBetweenAnos(@PathVariable("marca_carro") String marca_carro,@PathVariable("versao_carro") String versao_carro,@PathVariable("ano1") int ano1, @PathVariable("ano2")int ano2 ) {
		log.info("Estoque find: carro entre os anos ={} e {}", ano1, ano2);
		return estoqueRepository.findBetweenAnos(marca_carro, versao_carro,ano1, ano2);
	}

	/// BLOCO DE SERVIÇOS DA LOJA 
	@Autowired
	LojaRepository lojaRepository;

	@PostMapping("/loja/add")
	public void addLoja(@RequestBody LojaCarro lojaCarro) {
		lojaRepository.create(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@PostMapping("/loja/delete")
	public void deleteLoja(@RequestBody LojaCarro lojaCarro) {
		lojaRepository.delete(lojaCarro);
		log.info("Loja add: {}", lojaCarro);
	}

	@PostMapping("/loja/deletebyId")
	public void deletebyIdLoja(@RequestBody long id) {
		lojaRepository.deletebyId(id);
		log.info("Loja deletebyId: {}", id);
	}

	@PostMapping("/loja/update")
	public void updateLoja(@RequestBody LojaCarro lojaCarro) {
		lojaRepository.update(lojaCarro);
		log.info("Loja update: {}", lojaCarro);
	}

	@PostMapping("/loja/findAll")
	public void findAllLoja() {
		log.info("Loja findAll");
		lojaRepository.findAll();
	}

	@PostMapping("/loja/findOne")
	public void findOneLoja(@RequestBody long id) {
		lojaRepository.findOne(id);
		log.info("Loja find id: {}", id);
	}
	
	/// BLOCO DE SERVIÇOS DO FUNCIONARIO 
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@PostMapping("/funcionario/add")
	public void addFuncionario(@RequestBody Funcionario lojaCarro) {
		log.info("Funcionario add: {}", lojaCarro);
		funcionarioRepository.create(lojaCarro);
	}

	@PostMapping("/funcionario/delete")
	public void deleteFuncionario(@RequestBody Funcionario lojaCarro) {
		log.info("Funcionario add: {}", lojaCarro);
		funcionarioRepository.delete(lojaCarro);
	}

	@PostMapping("/funcionario/deletebyId")
	public void deletebyIdFuncionario(@RequestBody long id) {
		log.info("Funcionario deletebyId: {}", id);
		funcionarioRepository.deletebyId(id);
	}

	@PostMapping("/funcionario/update")
	public void updateFuncionario(@RequestBody Funcionario lojaCarro) {
		log.info("Funcionario update: {}", lojaCarro);
		funcionarioRepository.update(lojaCarro);
	}

	@PostMapping("/funcionario/findAll")
	public void findAllFuncionario() {
		log.info("Funcionario findAll");
		funcionarioRepository.findAll();
	}

	@PostMapping("/funcionario/findOne")
	public void findOneFuncionario(@RequestBody long id) {
		log.info("Funcionario find id: {}", id);
		lojaRepository.findOne(id);
	}
	
	/// BLOCO DE SERVIÇOS DA META DO FUNCIONARIO 
		@Autowired
		MetasRepository metasRepository;
		
		@PostMapping("/meta/add")
		public void addMeta(@RequestBody Meta lojaCarro) {
			log.info("Meta add: {}", lojaCarro);
			metasRepository.create(lojaCarro);
		}

		@PostMapping("/meta/delete")
		public void deleteMeta(@RequestBody Meta lojaCarro) {
			log.info("Meta add: {}", lojaCarro);
			metasRepository.delete(lojaCarro);
		}

		@PostMapping("/meta/deletebyId")
		public void deletebyIdMeta(@RequestBody long id) {
			log.info("Meta deletebyId: {}", id);
			metasRepository.deletebyId(id);
		}

		@PostMapping("/meta/update")
		public void updateMeta(@RequestBody Meta lojaCarro) {
			log.info("Meta update: {}", lojaCarro);
			metasRepository.update(lojaCarro);
		}

		@PostMapping("/meta/findAll")
		public void findAllMeta() {
			log.info("Meta findAll");
			metasRepository.findAll();
		}

		@PostMapping("/meta/findOne")
		public void findOneMeta(@RequestBody long id) {
			log.info("Meta find id: {}", id);
			metasRepository.findOne(id);
		}
}
