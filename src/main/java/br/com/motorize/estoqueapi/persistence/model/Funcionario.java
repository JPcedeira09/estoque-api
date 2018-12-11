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
@Table(name = "funcionario")
@Data
@ToString
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -5727594560683215709L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_funcionario;
	
    @OneToOne(cascade=CascadeType.ALL)  
	private  LojaCarro loja;
    
	private String nome;
	
	private Double valor_comissao;
	
    @OneToOne(cascade=CascadeType.ALL)  
	private  Acesso acesso;
}
