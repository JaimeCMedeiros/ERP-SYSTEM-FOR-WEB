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

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.interfaces.repositorio.ICoordenadorReposi;

public class CoordenadorRepo  extends GenericRepository<Coordenador> implements ICoordenadorReposi{
	
	@Override
	public void salvar(Coordenador coordenador) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
					entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
					entityManager = entityManagerFactory.createEntityManager();				  
					transacao = entityManager.getTransaction();
					transacao.begin();
			  
					entityManager.persist(coordenador);
					System.out.println("COORDENADOR ID=" + coordenador.getId());
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
	public Coordenador consultarPorCnpj(String cnpj) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			 CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			 CriteriaQuery<Coordenador> criteria = builder.createQuery(Coordenador.class);
			 Coordenador coordenador= (Coordenador) entityManager.createQuery("FROM br.unifacol.biblioteca.entidade.Coordenador c WHERE c.cpnj = :cnpj")
					 .setParameter("cnpj", cnpj).getSingleResult();				 
			return coordenador;   
			
		} catch (RuntimeException e) {
			System.out.println("FuncionarioRepo.consultarPorCnpj" + e.toString());
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@Override
	public void remover(Coordenador coordenador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Coordenador> listarTodos() {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				  entityManager = entityManagerFactory.createEntityManager();
				  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			        CriteriaQuery<Coordenador> cq = cb.createQuery(Coordenador.class);
			        Root<Coordenador> rootEntry = cq.from(Coordenador.class);
			        CriteriaQuery<Coordenador> all = cq.select(rootEntry);
			        TypedQuery<Coordenador> allQuery = entityManager.createQuery(all);
			        System.out.println("--------------");
			        return new ArrayList<Coordenador>( allQuery.getResultList());
				 
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
	public ArrayList<Coordenador> consultarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Coordenador coordenador) {
		 EntityTransaction transacao = null;
		 EntityManagerFactory entityManagerFactory = null;
		 EntityManager entityManager=null;
			try {
				  entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
				  entityManager = entityManagerFactory.createEntityManager();
				  
				transacao = entityManager.getTransaction();
				transacao.begin();
				entityManager.merge(coordenador);
				System.out.println("COORDENADOR ID=" + coordenador.getId());
				System.out.println("PASSANDO NO salvar EDITAR COORDENADOR");
				 
				transacao.commit();				
				
				System.out.println("PASSANDO NO salvar EDITAR COORDENADOR salvar-FIN");
				 
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
