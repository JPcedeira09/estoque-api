package br.com.motorize.estoqueapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motorize.estoqueapi.persistence.model.Meta;
import br.com.motorize.estoqueapi.persistence.repository.MetasRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/meta/")
public class MetaController {

			@Autowired
			MetasRepository metasRepository;
			
			@PostMapping("add")
			public void addMeta(@RequestBody Meta lojaCarro) {
				log.info("Meta add: {}", lojaCarro);
				metasRepository.create(lojaCarro);
			}

			@PostMapping("delete")
			public void deleteMeta(@RequestBody Meta lojaCarro) {
				log.info("Meta add: {}", lojaCarro);
				metasRepository.delete(lojaCarro);
			}

			@GetMapping("deletebyId/{id}")
			public void deletebyIdMeta(@PathVariable("id")  long id) {
				log.info("Meta deletebyId: {}", id);
				metasRepository.deletebyId(id);
			}

			@PostMapping("update")
			public Meta updateMeta(@RequestBody Meta meta) {
				log.info("Meta update: {}", meta);
				return metasRepository.update(meta);
			}

			@GetMapping("findAll")
			public List<Meta> findAllMeta() {
				log.info("Meta findAll");
				return metasRepository.findAll();
			}

			@GetMapping("findOne/{id}")
			public Meta findOneMeta(@PathVariable("id") long id) {
				log.info("Meta find id: {}", id);
				return metasRepository.findOne(id);
			}
}
