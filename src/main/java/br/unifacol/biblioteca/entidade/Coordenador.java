package br.unifacol.biblioteca.entidade;
/*Jaime Costa Medeiros Junior
 * */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coordenador")
public class Coordenador extends Pessoa {
	
	
	@Column(length = 50, nullable = false)
	protected String codCord;
	
	public Coordenador() {
		
	}

	public Coordenador(String nome, String sexo, String idade, String cnpj, String codCord) {
		super();
		this.nome =nome;
		this.sexo = sexo;
		this.idade = idade;
		this.cnpj = cnpj;
		this.codCord = codCord;
	}

	public String getCodCord() {
		return codCord;
	}

	public void setCodCord(String codCord) {
		this.codCord = codCord;
	}
	
}
