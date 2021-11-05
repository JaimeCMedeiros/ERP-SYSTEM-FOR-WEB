package br.unifacol.biblioteca.interfaces.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.exceptions.LeitorException;

public interface ILeitorServi {
	
	public void cadastrarLeitor(String nome, String sexo, String cnpj, String idade) throws LeitorException;
	public void alterarLeitor(String nome, String sexo, String cnpj, String idade);
	public void alterarLeitor(Leitor leitor);
	public void removerLeitor(String cnpj, int codigo);
	public Leitor listarLeitorPorCnpj(String cnpj);
	public ArrayList<Leitor> listarLeitores();
	public Leitor listarLeitorPorCodigo(long codigo);

}
