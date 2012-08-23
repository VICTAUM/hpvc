package br.com.hpvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.hpvc.entidade.Localidade;

@Component
public class LocalidadeDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	public LocalidadeDAO() {
		
	}
	
	public void inicio() {
		emf = Persistence.createEntityManagerFactory("hpvc");
		em = emf.createEntityManager();
	}
	
	public void fim() {
		try {
			em.clear();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void cadastrarLocalidade(Localidade localidade) {
		
		this.inicio();
		
		try {
			em.getTransaction().begin();
			em.persist(localidade);		
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			 e.printStackTrace();
		} finally {
			this.fim();
		}
		
	}
	
	public List<Localidade> listarTodasLocalidades() {
		
		this.inicio();
		List<Localidade> localidades = new ArrayList<Localidade>();
		
		try {
			
			Query query = em.createQuery("select l from Localidade l");
			localidades = (List<Localidade>) query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return localidades;
	}

}
