package br.unifacol.biblioteca.repositorio;
/*Jaime Costa Medeiros Junior
 * */
import java.lang.reflect.ParameterizedType;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericRepository<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericRepository() {
		System.out.println("CLASSS" + getClass().getGenericSuperclass().toString());
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		EntityTransaction transacao = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			transacao = entityManager.getTransaction();
			transacao.begin();
			entityManager.persist(entidade);
			transacao.commit();			 

		} catch (RuntimeException e) {
			System.out.println("GenericRepository.salvar" + e.toString());
			// TODO: handle exception
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			// sessao.close();
			if (entityManager != null) {
				entityManager.close();
				entityManagerFactory.close();
			}
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		EntityTransaction transacao = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Entidade> cq = cb.createQuery(classe);
			Root<Entidade> rootEntry = cq.from(classe);
			CriteriaQuery<Entidade> all = cq.select(rootEntry);

			TypedQuery<Entidade> allQuery = entityManager.createQuery(all);
			return allQuery.getResultList();

		} catch (RuntimeException e) {
			System.out.println("GenericRepository.buscar" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(long id) {
		EntityTransaction transacao = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			
			System.out.println("ID :: " + id);
			Entidade resultado = (Entidade) entityManager.find(classe, id);
			return resultado;

		} catch (RuntimeException e) {
			System.out.println("GenericRepository.buscar("+classe.toString()+"):" + e.toString());
			// TODO: handle exception
			throw e;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	public void excluir(Entidade entidade) {
		EntityTransaction transacao = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			transacao = entityManager.getTransaction();
			transacao.begin();
			entityManager.remove(entidade);
			transacao.commit();

		} catch (RuntimeException e) {
			System.out.println("GenericRepository.excluir" + e.toString());
			// TODO: handle exception
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			// sessao.close();
			if (entityManager != null) {
				entityManager.close();
				entityManagerFactory.close();
			}
		}

	}

	public void editar(Entidade entidade) {
		EntityTransaction transacao = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecapersistencia");
			entityManager = entityManagerFactory.createEntityManager();
			transacao = entityManager.getTransaction();
			transacao.begin();
			entityManager.merge(entidade);
			transacao.commit();

		} catch (RuntimeException e) {
			System.out.println("GenericRepository.editar" + e.toString());
			// TODO: handle exception
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			// sessao.close();
			if (entityManager != null) {
				entityManager.close();
				entityManagerFactory.close();
			}
		}

	}

}