package br.unifacol.biblioteca.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.interfaces.repositorio.IAutorReposi;

public class AutorRepo extends GenericRepository<Autor> implements IAutorReposi {
	@Override																	
	public void salvar(Autor autor) {
	 EntityTransaction transacao = null;
	 EntityManagerFactory entityManagerFactory = null;
	 EntityManager entityManager=null;
		try {
				entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				entityManager = entityManagerFactory.createEntityManager();				  
				transacao = entityManager.getTransaction(); 
				transacao.begin();
				 
				entityManager.persist(autor); 
				System.out.println("autor ID=" + autor.getId());
				System.out.println("PASSANDO NO salvar -INICIO");	
					
				transacao.commit();				
					
				System.out.println("PASSANDO NO salvar-FIN");
				
			} catch (RuntimeException e) {
				System.out.println("GenericRepository.salvar"+e.toString());
				throw e;
			} finally { 
			 if(entityManager!=null) {
				entityManager.close();
				entityManagerFactory.close();
				}
			}
		}
	
	@Override
	public boolean alterar(Autor autor) {
	 EntityTransaction transacao = null;
	 EntityManagerFactory entityManagerFactory = null;
	 EntityManager entityManager=null;
		try {
			  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			  entityManager = entityManagerFactory.createEntityManager();
			  
			transacao = entityManager.getTransaction();
			transacao.begin();
			entityManager.merge(autor);
			System.out.println("autor ID=" + autor.getId());
			System.out.println("PASSANDO NO salvar EDITAR AUTOR");
			 
			transacao.commit();				
			
			System.out.println("PASSANDO NO salvar EDITAR AUTOR salvar-FIN");
			 
		} catch (RuntimeException e) {
			System.out.println("GenericRepository.salvar"+e.toString());
			throw e;
		} finally {
		 if(entityManager!=null) {
			entityManager.close();
			entityManagerFactory.close();
			}
		}
	return false;
}
	
	@Override
	public void remover(Autor autor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Autor> listarTodos() {
	 EntityTransaction transacao = null;
	 EntityManagerFactory entityManagerFactory = null;
	 EntityManager entityManager=null;
		try {
			  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			  entityManager = entityManagerFactory.createEntityManager();
			  
			    CriteriaBuilder cb = entityManager.getCriteriaBuilder(); 
		        CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
		        Root<Autor> rootEntry = cq.from(Autor.class); 
		        CriteriaQuery<Autor> all = cq.select(rootEntry);
		        TypedQuery<Autor> allQuery = entityManager.createQuery(all);
		        System.out.println("--------------");
		        return new ArrayList<Autor>( allQuery.getResultList()); 
			 
		} catch (RuntimeException e) {
			System.out.println("GenericRepository.salvar"+e.toString());
			throw e;
		} finally {
		 if(entityManager!=null) {
			entityManager.close();
			entityManagerFactory.close();
			}
		}
	}
	
	@Override
	public Autor consultarPorCnpj(String cnpj) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Autor> criteria = builder.createQuery(Autor.class);
			 Autor autor= (Autor) entityManager.createQuery("FROM br.unifacol.biblioteca.entidade.Autor c WHERE c.cpnj = :cnpj") 
					 .setParameter("cnpj", cnpj).getSingleResult();	
			return autor;   
			
		} catch (RuntimeException e) {
			System.out.println("AutorRepo.consultarPorCnpj" + e.toString());
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@Override
	public ArrayList<Autor> consultarPorNome(String nome) { 
		// TODO Auto-generated method stub
		return null;
	}
}