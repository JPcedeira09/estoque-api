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
@Table(name = "metas_funcionario")
@Data
@ToString
public class Meta implements Serializable{

	private static final long serialVersionUID = -2851021435177211302L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_meta;
	
	private Double valor_meta_funcionario;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Funcionario f;
	
}
