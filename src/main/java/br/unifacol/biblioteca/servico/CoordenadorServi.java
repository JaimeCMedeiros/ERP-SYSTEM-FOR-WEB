package br.unifacol.biblioteca.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.exceptions.CoordenadorException;
import br.unifacol.biblioteca.interfaces.servico.ICoordenadorServi;
import br.unifacol.biblioteca.repositorio.CoordenadorRepo;

public class CoordenadorServi implements ICoordenadorServi {
	
private CoordenadorRepo coordenadorReposMySQL;

	
	public CoordenadorServi() {
		this.coordenadorReposMySQL = new CoordenadorRepo();
		}	

	@Override
	public void cadastrarCoordenador(String nome, String sexo, String cnpj, String idade, String codCord) throws CoordenadorException {
		try {	
			Coordenador novoCoordenador = new Coordenador(nome,sexo,cnpj,idade,codCord);
			if(nome == "")
				throw new CoordenadorException("Nome nulo");
			if(cnpj == "")
				throw new CoordenadorException("CNPJ nulo");
			if(idade == "")
				throw new CoordenadorException("idade nulo");
			if(codCord == "")
				throw new CoordenadorException("Codigo do Coordenador nulo");
			this.coordenadorReposMySQL.salvar(novoCoordenador);
			System.out.println("Novo Coordenador cadastrado com sucesso");
		  } catch(Exception e) {
			  System.out.println("Falha ao cadastrar novo Coordenador"+" Erro: "+e.getMessage());
		  }
		} 

	@Override
	public void alterarCoordenador(String nome, String sexo, String cnpj, String idade, String codCord) {
		try {
			boolean encontrado=false;	
			Coordenador novoCoordenador =new Coordenador(nome,sexo,cnpj,idade,codCord);
			
			if(this.coordenadorReposMySQL.alterar(novoCoordenador))		 
				System.out.println("Coordenador ALTERADO COM SUCESSO");
			else				
				System.out.println("Coordenador NAO ENCONTRADO");
	} catch (Exception e) {
		System.out.println("ERROR - AO ALTERAR DADOS DO Coordenador -"+e.getMessage());
	}
		
	}

	@Override
	public void alterarCoordenador(Coordenador coordenador) {
		try {
			 if(coordenador.getNome().length()<3) 
				 throw new CoordenadorException("Nome esta incorreto");
				 if(this.coordenadorReposMySQL.alterar(coordenador))
					 System.out.println("Coordenador alterado com sucesso");
				 else
					 System.out.println("------------------");
			  }catch(Exception e) {
				 System.out.println("Falha ao alterar Coordenador"+"Error: "+e.getMessage());
		 }
	}

	@Override
	public void removerCoordenador(String cnpj, int codigo) {
		try {	
			Coordenador novoCoordenador = this.coordenadorReposMySQL.consultarPorCnpj(cnpj);
			if(novoCoordenador != null)
				this.coordenadorReposMySQL.remover(novoCoordenador);
			else
				System.out.println("Coordenador invalido ou nao encontrado");
		}catch(Exception e) {
			 System.out.println("Falha ao remover"+"Error: "+e.getMessage());
	  }
	}

	@Override
	public Coordenador listarCoordenadorPorCnpj(String cnpj) {
		
		Coordenador coordenador=this.coordenadorReposMySQL.consultarPorCnpj(cnpj);
		
		if(coordenador !=null)
			 System.out.println("Nome:"+coordenador.getNome());
		return coordenador;
	}

	@Override
	public ArrayList<Coordenador> listarCoordenadores() {
	     ArrayList<Coordenador> coordenadores = new ArrayList<Coordenador>(this.coordenadorReposMySQL.listarTodos());
			return coordenadores;
		}

	@Override
	public Coordenador listarCoordenadorPorCodigo(long codigo) {
		return this.coordenadorReposMySQL.buscar(codigo);
	}

}
