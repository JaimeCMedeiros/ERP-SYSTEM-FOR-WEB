package br.unifacol.biblioteca.interfaces.servico;
/*Jaime Costa Medeiros Junior
 * */

import java.util.List;
import java.util.ArrayList;
import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;

public interface ILivroServi {
	public void cadastrar(Autor autor, String genero, String titulo, String identificador);
	public void alterar(String genero, String titulo, String identificador, List<Livro> livros);
	public void remover(String cnpj, int codigo);
	public ArrayList<Livro> listarTodos();

}
