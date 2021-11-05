package br.unifacol.biblioteca.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.exceptions.FuncionarioException;
import br.unifacol.biblioteca.interfaces.servico.IFuncionarioServi;
import br.unifacol.biblioteca.repositorio.FuncionarioRepo;

public class FuncionarioServi implements IFuncionarioServi {
		private FuncionarioRepo funcionarioReposMySQL;
	
	public FuncionarioServi() {
		this.funcionarioReposMySQL = new FuncionarioRepo();
		}	

	@Override
	public void cadastrarFuncionario(String nome, String sexo, String cnpj, String idade) throws FuncionarioException {
		try {	
			Funcionario novoFuncionario = new Funcionario(nome,sexo,cnpj,idade);
			if(nome == "")
				throw new FuncionarioException("Nome nulo");
			if(cnpj == "")
				throw new FuncionarioException("CNPJ nulo");
			if(idade == "")
				throw new FuncionarioException("Idade nulo");
			this.funcionarioReposMySQL.salvar(novoFuncionario);
			System.out.println("Novo funcionario cadastrado com sucesso");
		  } catch(Exception e) {
			  System.out.println("Falha ao cadastrar novo funcionario"+" Erro: "+e.getMessage());
		  }
		}

	@Override
	public void alterarFuncionario(String nome, String sexo, String cnpj, String idade) {
		try {
			boolean encontrado=false;	
			Funcionario novoFuncionario =new Funcionario(nome,sexo,cnpj,idade);
			
			if(this.funcionarioReposMySQL.alterar(novoFuncionario))		 
				System.out.println("Funcionario ALTERADO COM SUCESSO");
			else				
				System.out.println("Funcionario NAO ENCONTRADO");
	} catch (Exception e) {
		System.out.println("ERROR - AO ALTERAR DADOS DO Funcionario -"+e.getMessage());
	}
		
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {
		try {
			 if(funcionario.getNome().length()<3) 
				 throw new FuncionarioException("Nome esta incorreto");
				 if(this.funcionarioReposMySQL.alterar(funcionario))
					 System.out.println("Funcionario alterado com sucesso");
				 else
					 System.out.println("------------------");
			  }catch(Exception e) {
				 System.out.println("Falha ao alterar Funcionario"+"Error: "+e.getMessage());
		 }
	}

	@Override
	public void removerFuncionario(String cnpj, int codigo) {
		try {	
			Funcionario novoFuncionario = this.funcionarioReposMySQL.consultarPorCnpj(cnpj);
			if(novoFuncionario != null)
				this.funcionarioReposMySQL.remover(novoFuncionario);
			else
				System.out.println("Funcionario invalido ou nao encontrado");
		}catch(Exception e) {
			 System.out.println("Falha ao remover"+"Error: "+e.getMessage());
	  }
	}

	@Override
	public Funcionario listarFuncionarioPorCnpj(String cnpj) {
		
		Funcionario funcionario=this.funcionarioReposMySQL.consultarPorCnpj(cnpj);
		
		if(funcionario !=null)
			 System.out.println("Nome:"+funcionario.getNome());
		return funcionario;
	}

	@Override
	public ArrayList<Funcionario> listarFuncionarios() {
	     ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>(this.funcionarioReposMySQL.listarTodos());
			return funcionarios;
		}

	@Override
	public Funcionario listarFuncionarioPorCodigo(long codigo) {
		return this.funcionarioReposMySQL.buscar(codigo);
	}

}
