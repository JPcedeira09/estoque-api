package br.com.motorize.estoqueapi.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "carro_estoque")
public class CarroEstoque implements Serializable{

	private static final long serialVersionUID = 3200213257418572774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_carro;
	
	private String marca; 
	
	private String nome_carro;
}
