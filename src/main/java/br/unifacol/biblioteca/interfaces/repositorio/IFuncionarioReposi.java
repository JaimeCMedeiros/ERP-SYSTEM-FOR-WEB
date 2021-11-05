package br.unifacol.biblioteca.interfaces.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Funcionario;

public interface IFuncionarioReposi {
	
	public void salvar(Funcionario funcionario);
	public boolean alterar(Funcionario funcionario);
	public Funcionario consultarPorCnpj(String cnpj);
	public void remover(Funcionario funcionario);
	public ArrayList<Funcionario> listarTodos();
	public Funcionario buscar(long id);
	public ArrayList<Funcionario> consultarPorNome(String nome);

}
