package br.unifacol.biblioteca.servico;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.LivroException;
import br.unifacol.biblioteca.interfaces.repositorio.ILivroReposi;
import br.unifacol.biblioteca.repositorio.LivroRepo;

public class LivroServi implements ILivroReposi {
	
	private LivroRepo livroReposMySQL;
	
	public LivroServi() {
		this.livroReposMySQL = new LivroRepo();
	}

	public void salvar(Livro livro) {
	String identificador=String.valueOf(new Random().nextInt());
	livro.setIdentificador(identificador);
	this.livroReposMySQL.salvar(livro);
	}

	public void editar(Livro livro) {
		this.livroReposMySQL.editar(livro);
		
	}

	
    public void excluir(Livro livro) {
		this.livroReposMySQL.excluir(livro);
		
	}

	
    public List<Livro> listar() {
		return this.livroReposMySQL.listar();
	}
    
    public Livro listarLivroPorCodigo(long codigo) {
		return this.livroReposMySQL.buscar(codigo);
	}
    

	public ArrayList<Livro> consultarPorNome(String nome) throws LivroException {
		return this.livroReposMySQL.consultarPorNome(nome);
	}

	@Override
	public Livro consultarPorIdentificador(String identificador) throws LivroException {
		return this.livroReposMySQL.consultarPorIdentificador(identificador);
	}

	@Override
	public ArrayList<Livro> consultarPorIdAutor(long idAutor) throws LivroException {
		return this.livroReposMySQL.consultarPorIdAutor(idAutor);
	}


	@Override
	public ArrayList<Livro> consultarPorCnpjAutor(String cnpjAutor) throws LivroException {
		return this.livroReposMySQL.consultarPorCnpjAutor(cnpjAutor);
	}

	

}