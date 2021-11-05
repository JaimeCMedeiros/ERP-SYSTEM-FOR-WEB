package br.unifacol.biblioteca.interfaces.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import br.unifacol.biblioteca.entidade.Leitor;

public interface ILeitorReposi {
	public void salvar(Leitor leitor);
	public boolean alterar(Leitor leitor);
	public Leitor consultarPorCnpj(String cnpj);
	public void remover(Leitor leitor);
	public ArrayList<Leitor> listarTodos();
	public Leitor buscar(long id);
	public ArrayList<Leitor> consultarPorNome(String nome);

}
