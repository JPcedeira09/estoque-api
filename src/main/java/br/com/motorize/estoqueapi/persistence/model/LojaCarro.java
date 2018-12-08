package br.com.motorize.estoqueapi.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "loja_carro")
@Data
@ToString
public class LojaCarro implements Serializable{

	private static final long serialVersionUID = 8234811056779099603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_loja;
	
	private String nome_loja;
	
	private String cnpj;

	private Double valor_meta;

}
