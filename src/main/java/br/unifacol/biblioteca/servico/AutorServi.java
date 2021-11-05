package br.unifacol.biblioteca.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.interfaces.servico.IAutorServi;
import br.unifacol.biblioteca.repositorio.AutorRepo;

public class AutorServi implements IAutorServi {
	private AutorRepo autorReposMySQL;
	
	
	
	public AutorServi() {
		this.autorReposMySQL = new AutorRepo();
	}


	@Override
	public void cadastrarAutor(String nome, String sexo, String cnpj, String idade, List<Livro> livros) throws AutorException {
		
	try {	
		Autor novoAutor = new Autor(nome,sexo,cnpj,idade,livros);
		if(nome == "")
			throw new AutorException("Nome nulo");
		if(cnpj == "")
			throw new AutorException("CNPJ nulo");
		if(idade == "")
			throw new AutorException("idade nula");
		this.autorReposMySQL.salvar(novoAutor);
		System.out.println("Novo autor cadastrado com sucesso");
	  } catch(Exception e) {
		  System.out.println("Falha ao cadastrar novo autor"+" Erro: "+e.getMessage());
	  }
	}

	@Override
	public void alterarAutor(String nome, String sexo, String cnpj, String idade, List<Livro> livros) {
		try {
			boolean encontrado=false;	
			Autor novoAutor =new Autor(nome,sexo,cnpj,idade,livros);
			if(this.autorReposMySQL.alterar(novoAutor))
				System.out.println("AUTOR ALTERADO COM SUCESSO");
			else				
				System.out.println("AUTOR NAO ENCONTRADO");
	} catch (Exception e) {
		System.out.println("ERROR - AO ALTERAR DADOS DO AUTOR -"+e.getMessage());
	}
		
	}

	@Override
	public void alterarAutor(Autor autor) { 
		try {
			 if(autor.getNome().length()<2) 
				 throw new AutorException("Nome esta incorreto");
				 if(this.autorReposMySQL.alterar(autor))
					 System.out.println("Autor alterado com sucesso");
				 else
					 System.out.println("------------------");
			  }catch(Exception e) {
				 System.out.println("Falha ao alterar Autor"+"Error: "+e.getMessage());
		 }
	}

	@Override
	public void removerAutor(String cnpj, int codigo) { 
	try {	
		Autor novoAutor = this.autorReposMySQL.consultarPorCnpj(cnpj);
		if(novoAutor != null)
			this.autorReposMySQL.remover(novoAutor);
		else
			System.out.println("Autor invalido ou nao encontrado");
	}catch(Exception e) {
		 System.out.println("Falha ao remover"+"Error: "+e.getMessage());
  }
}

	@Override
	public Autor listarAutorPorCnpj(String cnpj) {
		Autor autor=this.autorReposMySQL.consultarPorCnpj(cnpj);
		if(autor !=null)
			 System.out.println("Nome:"+autor.getNome());
		return autor;
	}

	@Override
	public ArrayList<Autor> listarAutores() {
     ArrayList<Autor> autores = new ArrayList<Autor>(this.autorReposMySQL.listarTodos());
		return autores;
	}


	
	@Override
	public Autor listarAutorPorCodigo(long codigo) {
		return this.autorReposMySQL.buscar(codigo);
	}

}
