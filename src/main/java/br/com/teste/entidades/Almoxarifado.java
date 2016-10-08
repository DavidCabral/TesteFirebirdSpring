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
@Table(name = "ALMOXARIFADO")
public class Almoxarifado implements Serializable {
	private static final long serialVersionUID = -520425326013229896L;
	@Id
	@SequenceGenerator( name = "SEQ", sequenceName = "GEN_ALMOXARIFADO", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ" ) 
	private Integer id;
	@NotBlank
	@Size(max = 30, message = "O tamanho dO nome deve estar entre 1 e 30")
	private String nome;	
	@Size(max = 30, message = "O tamanho da localizacao deve estar entre 1 e 30")
	private String localizacao;
	private boolean ativo;
	
	@Size(max = 150, message = "O tamanho da descricao deve conter no máximo 150 caracters")
	private String descricao;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

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

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}
