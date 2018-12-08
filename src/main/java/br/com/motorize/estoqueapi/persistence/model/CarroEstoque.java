package br.com.motorize.estoqueapi.persistence.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "carro_estoque")
@Data
@ToString
public class CarroEstoque implements Serializable{

	private static final long serialVersionUID = 3200213257418572774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_carro;
	
    @OneToOne(cascade=CascadeType.ALL)  
	private  LojaCarro loja;
	
	private String marca_carro; 
	
	private String nome_carro;
	
	private String versao_carro;
	
	private Double preco_carro;
	
	private Integer ano_carro;
	
	private Integer ano_versao;
	
	private long id_loja;
	
	private long nome_loja;
}
