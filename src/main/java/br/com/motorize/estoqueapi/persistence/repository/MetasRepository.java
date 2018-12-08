package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import javax.transaction.Transactional;

import br.com.motorize.estoqueapi.persistence.model.Meta;

public class MetasRepository extends AbstractJpaDAO<Meta>{

	public MetasRepository() {
		setClazz(Meta.class);
	}

	@Transactional
	public List<Meta> findAll() {
		return super.findAll();
	}

	@Transactional
	public void create(Meta entity) {
		super.create(entity);
	}

	@Transactional
	public void deletebyId(long entityId) {
		super.deletebyId(entityId);
	}

	@Transactional
	public void delete(Meta entity) {
		super.delete(entity);
	}

	@Transactional
	public Meta update(Meta entity) {
		return super.update(entity);
	}
}