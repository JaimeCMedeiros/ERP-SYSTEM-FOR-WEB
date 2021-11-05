package br.unifacol.biblioteca.interfaces.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Autor;

public interface IAutorReposi {
	
	public void salvar(Autor autor);
	public boolean alterar(Autor autor);
	public Autor consultarPorCnpj(String cnpj);
	public void remover(Autor autor);
	public ArrayList<Autor> listarTodos();
	public Autor buscar(long id);
	public ArrayList<Autor> consultarPorNome(String nome);

}