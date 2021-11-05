package br.unifacol.biblioteca.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import javax.persistence.metamodel.EntityType;
//import javax.persistence.metamodel.Metamodel;

//import org.hibernate.jpa.QueryHints;

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.interfaces.repositorio.ILivroReposi;
import br.unifacol.biblioteca.exceptions.LivroException;

public class LivroRepo extends GenericRepository<Livro> implements ILivroReposi {

	@Override
	public ArrayList<Livro> consultarPorNome(String nome) throws LivroException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			// **creating CriteriaBuilder**
			CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
			Root<Livro> livroRoot = criteria.from(Livro.class);
			criteria.select(livroRoot);

			// **Adding where clause**
			criteria.where(builder.equal(livroRoot.get("nome"), nome));
			ArrayList<Livro> livros = (ArrayList<Livro>) ((EntityManager) entityManagerFactory).createQuery(criteria).getResultList();			 
			return livros;

		} catch (RuntimeException e) {
			System.out.println("LivroRepo.consultarPorNome" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@Override
	public Livro consultarPorIdentificador(String identificador) throws LivroException {
		 
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			// **creating CriteriaBuilder**
			CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
			Root<Livro> livroRoot = criteria.from(Livro.class);
			criteria.select(livroRoot);

			// **Adding where clause**
			criteria.where(builder.equal(livroRoot.get("identificador"), identificador));
			Livro livro = ((EntityManager) entityManagerFactory).createQuery(criteria).getSingleResult();			 
			return livro;

		} catch (RuntimeException e) {
			System.out.println("LivroRepo.consultarPorIdentificador" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}


	
	@Override
	public ArrayList<Livro> consultarPorIdAutor(long idAutor) throws LivroException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			// **creating CriteriaBuilder**
			 
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
			 ArrayList<Livro> livros=null;
			 
			livros = (ArrayList<Livro>) entityManager.createQuery("FROM br.unifacol.biblioteca.entidade.Livro c WHERE c.autor.id = :idAutor")
		            .setParameter("idAutor", idAutor).getResultList();
		            
		            
				 
			return livros;   
			
		 
		} catch (RuntimeException e) {
			System.out.println("LivroRepo.consultarPorIdAutor" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	
	@Override
	public ArrayList<Livro> consultarPorCnpjAutor(String cnpjAutor) throws LivroException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
			 ArrayList<Livro> livros=null;
			 
			livros = (ArrayList<Livro>) entityManager.createQuery(" FROM br.unifacol.biblioteca.entidade.Livro c WHERE c.autor.cnpjAutor = :cnpjAutor")
            .setParameter("cnpjAutor", cnpjAutor).getResultList();
		            
		            
				 
			return livros;   			 
 

		} catch (RuntimeException e) {
			System.out.println("LivroRepo.consultarPorCnpjAutor" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	
	
}