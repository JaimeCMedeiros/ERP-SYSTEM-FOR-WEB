package br.unifacol.biblioteca.interfaces.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Coordenador;

public interface ICoordenadorReposi {
	
	public void salvar(Coordenador coordenador);
	public boolean alterar(Coordenador coordenador);
	public Coordenador consultarPorCnpj(String cnpj);
	public void remover(Coordenador coordenador);
	public ArrayList<Coordenador> listarTodos();
	public Coordenador buscar(long id);
	public ArrayList<Coordenador> consultarPorNome(String nome);

}
