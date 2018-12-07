package br.com.motorize.estoqueapi.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name ="marca")
	private String marca; 
	
	@Column(name ="nome_carro")
	private String nome_carro;
	
	@Column(name ="id_loja")
	private long id_loja;
	
	@Column(name ="nome_loja")
	private long nome_loja;
}
