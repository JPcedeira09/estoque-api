package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.motorize.estoqueapi.persistence.model.Acesso;

@Repository
@ManagedBean
public class AcessoRepository extends AbstractJpaDAO<Acesso>{

	public AcessoRepository() {
		setClazz(Acesso.class);
	}

	@Transactional
	public List<Acesso> findAll() {
		return super.findAll();
	}

	@Transactional
	public void create(Acesso entity) {
		super.create(entity);
	}

	@Transactional
	public void deletebyId(long entityId) {
		super.deletebyId(entityId);
	}

	@Transactional
	public void delete(Acesso entity) {
		super.delete(entity);
	}

	@Transactional
	public Acesso update(Acesso entity) {
		return super.update(entity);
	}
}
