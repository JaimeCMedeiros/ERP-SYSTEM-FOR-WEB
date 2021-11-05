package br.unifacol.biblioteca.interfaces.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.AutorException;

public interface IAutorServi { 

	public void cadastrarAutor(String nome, String sexo, String cnpj, String idade, List<Livro> livros) throws AutorException;
	public void alterarAutor(String nome, String sexo, String cnpj, String idade, List<Livro> livros);
	public void alterarAutor(Autor autor);
	public void removerAutor(String cnpj, int codigo);
	public Autor listarAutorPorCnpj(String cnpj);
	public ArrayList<Autor> listarAutores();
	public Autor listarAutorPorCodigo( long codigo );
		
}
