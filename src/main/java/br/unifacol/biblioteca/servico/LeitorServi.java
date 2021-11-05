package br.unifacol.biblioteca.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.exceptions.LeitorException;
import br.unifacol.biblioteca.interfaces.servico.ILeitorServi;
import br.unifacol.biblioteca.repositorio.LeitorRepo;

public class LeitorServi implements ILeitorServi {
	
	private LeitorRepo leitorReposMySQL;
	
	public LeitorServi() {
		this.leitorReposMySQL = new LeitorRepo();
		}	


	@Override
	public void cadastrarLeitor(String nome, String sexo, String cnpj, String idade) throws LeitorException {
		try {	
			Leitor novoLeitor = new Leitor(nome,sexo,cnpj,idade);
			if(nome == "")
				throw new LeitorException("Nome nulo");
			if(cnpj == "")
				throw new LeitorException("CNPJ nulo");
			if(idade == "")
				throw new LeitorException("Idade nulo");
			this.leitorReposMySQL.salvar(novoLeitor);
			System.out.println("Novo leitor cadastrado com sucesso");
		  } catch(Exception e) {
			  System.out.println("Falha ao cadastrar novo leitor"+" Erro: "+e.getMessage());
		  }
		}

	@Override
	public void alterarLeitor(String nome, String sexo, String cnpj, String idade) {
		try {
			boolean encontrado=false;	
			Leitor Leitor =new Leitor(nome,sexo,cnpj,idade);
			
			if(this.leitorReposMySQL.alterar(Leitor))		 
				System.out.println("Leitor ALTERADO COM SUCESSO");
			else				
				System.out.println("Leitor NAO ENCONTRADO");
	} catch (Exception e) {
		System.out.println("ERROR - AO ALTERAR DADOS DO Leitor -"+e.getMessage());
	}
		
	}


	@Override
	public void alterarLeitor(Leitor leitor) {
		try {
			 if(leitor.getNome().length()<3) 
				 throw new LeitorException("Nome esta incorreto");
				 if(this.leitorReposMySQL.alterar(leitor))
					 System.out.println("Leitor alterado com sucesso");
				 else
					 System.out.println("------------------");
			  }catch(Exception e) {
				 System.out.println("Falha ao alterar Leitor"+"Error: "+e.getMessage());
		 }
	}

	@Override
	public void removerLeitor(String cnpj, int codigo) {
		try {	
			Leitor novoLeitor = this.leitorReposMySQL.consultarPorCnpj(cnpj);
			if(novoLeitor != null)
				this.leitorReposMySQL.remover(novoLeitor);
			else
				System.out.println("Leitor invalido ou nao encontrado");
		}catch(Exception e) {
			 System.out.println("Falha ao remover"+"Error: "+e.getMessage());
	  }
	}
	

	@Override
	public Leitor listarLeitorPorCnpj(String cnpj) {
		
		Leitor leitor=this.leitorReposMySQL.consultarPorCnpj(cnpj);
		
		if(leitor !=null)
			 System.out.println("Nome:"+leitor.getNome());
		return leitor;
	}

	@Override
	public ArrayList<Leitor> listarLeitores() {
	     ArrayList<Leitor> leitores = new ArrayList<Leitor>(this.leitorReposMySQL.listarTodos());
			return leitores;
		}

	@Override
	public Leitor listarLeitorPorCodigo(long codigo) {
		return this.leitorReposMySQL.buscar(codigo);
	}

}
