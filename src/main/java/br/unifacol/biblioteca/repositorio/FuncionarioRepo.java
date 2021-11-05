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

import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.interfaces.repositorio.IFuncionarioReposi;

public class FuncionarioRepo extends GenericRepository<Funcionario> implements IFuncionarioReposi {

	@Override
	public void salvar(Funcionario funcionario) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
					entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
					entityManager = entityManagerFactory.createEntityManager();				  
					transacao = entityManager.getTransaction();
					transacao.begin();
			  
					entityManager.persist(funcionario);
					System.out.println("FUNCIONARIO ID=" + funcionario.getId());
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
	public Funcionario consultarPorCnpj(String cnpj) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
			 Funcionario funcionario= (Funcionario) entityManager.createQuery("FROM br.unifacol.biblioteca.entidade.Funcionario c WHERE c.cpnj = :cnpj")
					 .setParameter("cnpj", cnpj).getSingleResult();				 
			return funcionario;   
			
		} catch (RuntimeException e) {
			System.out.println("FuncionarioRepo.consultarPorCnpj" + e.toString());
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@Override
	public void remover(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Funcionario> listarTodos() {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				  entityManager = entityManagerFactory.createEntityManager();
				  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			        CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
			        Root<Funcionario> rootEntry = cq.from(Funcionario.class);
			        CriteriaQuery<Funcionario> all = cq.select(rootEntry);
			        TypedQuery<Funcionario> allQuery = entityManager.createQuery(all);
			        System.out.println("--------------");
			        return new ArrayList<Funcionario>( allQuery.getResultList());
				 
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
	public ArrayList<Funcionario> consultarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Funcionario funcionario) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				  entityManager = entityManagerFactory.createEntityManager();
				  
				transacao = entityManager.getTransaction();
				transacao.begin();
				entityManager.merge(funcionario);
				System.out.println("FUNCIONARIO ID=" + funcionario.getId());
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
}


