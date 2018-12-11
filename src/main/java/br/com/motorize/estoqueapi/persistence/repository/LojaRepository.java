package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.motorize.estoqueapi.persistence.model.LojaCarro;


@Repository
@ManagedBean
public class LojaRepository extends AbstractJpaDAO<LojaCarro>{

	public LojaRepository() {
		setClazz(LojaCarro.class);
	}

	@Transactional
	public List<LojaCarro> findAll() {
		return super.findAll();
	}

	@Transactional
	public void create(LojaCarro entity) {
		super.create(entity);
	}

	@Transactional
	public void deletebyId(long entityId) {
		super.deletebyId(entityId);
	}

	@Transactional
	public void delete(LojaCarro entity) {
		super.delete(entity);
	}

	@Transactional
	public LojaCarro update(LojaCarro entity) {
		return super.update(entity);
	}
}
