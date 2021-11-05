package br.unifacol.biblioteca.entidade;

/*Jaime Costa Medeiros Junior
 * */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity  
@Table(name = "autor") 
public class Autor extends Pessoa {
	
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	public List<Livro> livros;             
	public Autor(String nome, String sexo, String cnpj, String idade,List<Livro> livros) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.cnpj = cnpj;
	}
	public Autor() {
		
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}