package br.unifacol.biblioteca.interfaces.repositorio;
/*Jaime Costa Medeiros Junior
 * */

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.LivroException;
import java.util.List;
import java.util.ArrayList;

public interface ILivroReposi {
	
	public void salvar(Livro livro);
	public void editar(Livro livro);
	public void excluir(Livro livro);
	public List<Livro> listar();
	public ArrayList<Livro> consultarPorNome(String nome) throws LivroException;
	public Livro consultarPorIdentificador(String identificador) throws LivroException;
	public ArrayList<Livro> consultarPorIdAutor(long idAutor) throws LivroException;
	public ArrayList<Livro> consultarPorCnpjAutor(String cnpjAutor) throws LivroException;

}
