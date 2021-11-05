package br.unifacol.biblioteca.interfaces.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;


import br.unifacol.biblioteca.exceptions.FuncionarioException;
import br.unifacol.biblioteca.entidade.Funcionario;

public interface IFuncionarioServi {
	
	public void cadastrarFuncionario(String nome, String sexo, String cnpj, String idade) throws FuncionarioException;
	public void alterarFuncionario(String nome, String sexo, String cnpj, String idade);
	public void alterarFuncionario(Funcionario funcionario);
	public void removerFuncionario(String cnpj, int codigo);
	public Funcionario listarFuncionarioPorCnpj(String cnpj);
	public ArrayList<Funcionario> listarFuncionarios();
	public Funcionario listarFuncionarioPorCodigo(long codigo);
}
