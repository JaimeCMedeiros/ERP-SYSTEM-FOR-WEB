package br.unifacol.biblioteca.entidade;
/*Jaime Costa Medeiros Junior
 * */
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "leitor")
public class Leitor extends Pessoa {
	
	
	public Leitor() {
		
	}
	public Leitor(String nome, String sexo, String idade, String cnpj) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.cnpj = cnpj;
	}

}
