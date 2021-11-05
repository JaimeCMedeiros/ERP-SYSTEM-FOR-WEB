package br.unifacol.biblioteca.entidade;

/*Jaime Costa Medeiros Junior
 * */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
@MappedSuperclass 

public abstract class Pessoa  implements Serializable {
	@Id
	 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	 
	private Long id; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 50, nullable = false) 
	protected String nome;		 
	@Column(length = 50, nullable = false)
	protected String sexo;
	@Column(length = 50, nullable = false)
	protected String idade;
	@Column(length = 50, nullable = false)
	protected String cnpj;

	public String getCnpj() { 
		return cnpj;
	}
	public void setCnpj(String cnpj) { 
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
}
