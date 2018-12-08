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

	public List<CarroEstoque> findMarca(String marca_carro) {
		String query = "select c from CarroEstoque c where c.marca_carro = :marca_carro";
		TypedQuery<CarroEstoque> estoque = getEntityManager().createQuery(query, CarroEstoque.class);
		estoque.setParameter("marca_carro", marca_carro );
		List<CarroEstoque> resultado = estoque.getResultList();
		return resultado;
	}

	public List<CarroEstoque> findMarcaVersao(String marca_carro, String versao_carro) {
		String query = "select c from CarroEstoque c where c.marca_carro = :marca_carro and c.versao_carro = :versao_carro";
		TypedQuery<CarroEstoque> estoque = getEntityManager().createQuery(query, CarroEstoque.class);
		estoque.setParameter("marca_carro", marca_carro );
		estoque.setParameter("versao_carro", versao_carro );
		List<CarroEstoque> resultado = estoque.getResultList();
		return resultado;
	}


	/*
	 * SELECT * FROM motorizeDB.carro_estoque;  
		select * from carro_estoque  
		where  ano_carro between 2015 and 2016  
 		and ano_versao between 2016 and 2017;
	 */
	
	public List<CarroEstoque> findBetweenAnos(String marca_carro, String versao_carro,int ano1, int ano2) {
		String query = "select c from CarroEstoque c where c.ano_versao between :ano1 and :ano2 and c.marca_carro = :marca_carro and c.versao_carro = :versao_carro";
		TypedQuery<CarroEstoque> estoque = getEntityManager().createQuery(query, CarroEstoque.class);
		estoque.setParameter("ano1", ano1 );
		estoque.setParameter("ano2", ano2 );
		estoque.setParameter("marca_carro", marca_carro );
		estoque.setParameter("versao_carro", versao_carro );
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
	
	@Transactional
	public void deletebyId(long entityId) {
		super.deletebyId(entityId);
	}
	
	@Transactional
	public void delete(CarroEstoque entity) {
		super.delete(entity);
	}
	
	@Transactional
	public CarroEstoque update(CarroEstoque entity) {
		return super.update(entity);
	}
}
