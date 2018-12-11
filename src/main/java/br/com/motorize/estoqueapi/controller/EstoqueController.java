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
@RequestMapping("/api/carro/")
public class EstoqueController {

	@Autowired
	EstoqueRepository estoqueRepository;

	@GetMapping("/hello/{txt}")
	public String hello(@PathVariable("txt") String txt) {
		log.info("Nome do Hello: txt={}", txt);
		return txt;
	}

	@PostMapping("add")
	public void addCarroEstoque(@RequestBody CarroEstoque estoque) {
		estoqueRepository.create(estoque);
		log.info("Estoque add: {}", estoque);
	}

	@PostMapping("update")
	public void updateCarroEstoque(@RequestBody CarroEstoque estoque) {
		estoqueRepository.update(estoque);
		log.info("Estoque add: {}", estoque);
	}

	@PostMapping("deleteid")
	public void deleteByIdCarroEstoque(@RequestBody long id) {
		estoqueRepository.deletebyId(id);
		log.info("Estoque delete: {}", id);
	}

	@PostMapping("delete")
	public void deleteCarroEstoque(@RequestBody CarroEstoque carroEstoque) {
		estoqueRepository.delete(carroEstoque);
		log.info("Estoque delete: {}", carroEstoque);
	}

	@GetMapping("find{id}")
	public CarroEstoque findByIdCarroEstoque(@PathVariable("id") Long id) {
		log.info("Estoque find: id={}", id);
		return estoqueRepository.findOne(id);
	}

	@GetMapping("findAll")
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

}
