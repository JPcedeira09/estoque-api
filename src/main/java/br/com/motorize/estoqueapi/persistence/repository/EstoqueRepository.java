package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.motorize.estoqueapi.persistence.model.CarroEstoque;

@Repository
public class EstoqueRepository extends AbstractJpaDAO<CarroEstoque>{

	public EstoqueRepository() {
		setClazz(CarroEstoque.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CarroEstoque> findMarca(String id) {
				return getEntityManager().createNamedQuery("").getResultList();
				
	}
	
	@Transactional(readOnly = true)
	public List<CarroEstoque> findAll() {
		return super.findAll();
	}
	
	@Transactional
	public void create(CarroEstoque entity) {
		super.create(entity);
	}
}
