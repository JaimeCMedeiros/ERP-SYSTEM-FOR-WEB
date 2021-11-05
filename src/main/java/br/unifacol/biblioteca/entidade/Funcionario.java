package br.unifacol.biblioteca.entidade;
/*Jaime Costa Medeiros Junior
 * */
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	
	public Funcionario() {
		
	}
	public Funcionario(String nome, String sexo, String idade, String cnpj) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.cnpj = cnpj;
	}
	
}