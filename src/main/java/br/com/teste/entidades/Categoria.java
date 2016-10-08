package br.com.teste.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

	private static final long serialVersionUID = -6479757452889858133L;
	
	@Id
	@SequenceGenerator( name = "SEQ", sequenceName = "GEN_CATEGORIA", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ" ) 
	private Integer id;
	@NotBlank
	@Size(max = 30, message = "O tamanho do nome deve estar entre 1 e 30")	
	private String nome;
	@NotBlank
	@Size(max = 3, message = "O tamanho da digla deve estar entre 1 e 3")
	private String sigla;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	

}
