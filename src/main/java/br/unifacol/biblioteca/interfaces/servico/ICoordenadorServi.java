package br.unifacol.biblioteca.interfaces.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.exceptions.CoordenadorException;

public interface ICoordenadorServi {
	
	public void cadastrarCoordenador(String nome, String sexo, String cnpj, String idade, String codCord) throws CoordenadorException;
	public void alterarCoordenador(String nome, String sexo, String cnpj, String idade, String codCord);
	public void alterarCoordenador(Coordenador coordenador);
	public void removerCoordenador(String cnpj, int codigo);
	public Coordenador listarCoordenadorPorCnpj(String cnpj);
	public ArrayList<Coordenador> listarCoordenadores();
	public Coordenador listarCoordenadorPorCodigo(long codigo);

}
