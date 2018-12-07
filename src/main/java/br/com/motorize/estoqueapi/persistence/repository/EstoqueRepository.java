package br.com.motorize.estoqueapi.persistence.repository;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.motorize.estoqueapi.persistence.model.CarroEstoque;

@Repository
@ManagedBean
public class EstoqueRepository extends AbstractJpaDAO<CarroEstoque>{

	public EstoqueRepository() {
		setClazz(CarroEstoque.class);
	}

	public List<CarroEstoque> findMarca(String marca) {
		String query = "select c from CarroEstoque c where c.marca = :marca";
		TypedQuery<CarroEstoque> estoque = getEntityManager().createQuery(query, CarroEstoque.class);
		estoque.setParameter("marca", marca );
		List<CarroEstoque> resultado = estoque.getResultList();
		return resultado;
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
