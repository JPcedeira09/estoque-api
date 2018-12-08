package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import javax.transaction.Transactional;

import br.com.motorize.estoqueapi.persistence.model.Funcionario;

public class FuncionarioRepository extends AbstractJpaDAO<Funcionario>{

	public FuncionarioRepository() {
		setClazz(Funcionario.class);
	}

	@Transactional
	public List<Funcionario> findAll() {
		return super.findAll();
	}

	@Transactional
	public void create(Funcionario entity) {
		super.create(entity);
	}

	@Transactional
	public void deletebyId(long entityId) {
		super.deletebyId(entityId);
	}

	@Transactional
	public void delete(Funcionario entity) {
		super.delete(entity);
	}

	@Transactional
	public Funcionario update(Funcionario entity) {
		return super.update(entity);
	}

}
