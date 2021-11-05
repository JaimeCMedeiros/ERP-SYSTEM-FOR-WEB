package br.unifacol.biblioteca.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.interfaces.repositorio.ILeitorReposi;

public class LeitorRepo extends GenericRepository<Leitor> implements ILeitorReposi {

	@Override
	public boolean alterar(Leitor leitor) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				  entityManager = entityManagerFactory.createEntityManager();
				  
				transacao = entityManager.getTransaction();
				transacao.begin();
				entityManager.merge(leitor);
				System.out.println("LEITOR ID=" + leitor.getId());
				System.out.println("PASSANDO NO salvar EDITAR LEITOR");
				 
				transacao.commit();				
				
				System.out.println("PASSANDO NO salvar EDITAR LEITOR salvar-FIN");
				 
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
	public void salvar(Leitor leitor) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
					entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
					entityManager = entityManagerFactory.createEntityManager();				  
					transacao = entityManager.getTransaction();
					transacao.begin();
			  
					entityManager.persist(leitor);
					System.out.println("LEITOR ID=" + leitor.getId());
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
	public Leitor consultarPorCnpj(String cnpj) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Leitor> criteria = builder.createQuery(Leitor.class);
			 Leitor leitor= (Leitor) entityManager.createQuery("FROM br.unifacol.biblioteca.entidade.Leitor c WHERE c.cpnj = :cnpj")
					 .setParameter("cnpj", cnpj).getSingleResult();				 
			return leitor;   
			
		} catch (RuntimeException e) {
			System.out.println("LeitorRepo.consultarPorCnpj" + e.toString());
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@Override
	public void remover(Leitor leitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Leitor> listarTodos() {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				   entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				   entityManager = entityManagerFactory.createEntityManager();
				   CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			       CriteriaQuery<Leitor> cq = cb.createQuery(Leitor.class);
			       Root<Leitor> rootEntry = cq.from(Leitor.class);
			       CriteriaQuery<Leitor> all = cq.select(rootEntry);
			       TypedQuery<Leitor> allQuery = entityManager.createQuery(all);
			       System.out.println("--------------");
			       return new ArrayList<Leitor>( allQuery.getResultList());
				 
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
	public ArrayList<Leitor> consultarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
