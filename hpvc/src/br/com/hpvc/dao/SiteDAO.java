package br.com.hpvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.hpvc.entidade.Site;

public class SiteDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	public SiteDAO() {

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
	
	public void cadastrarSite(Site site) {
		
		this.inicio();
		System.out.println(">>> " + site.getNome());
		try {
			em.getTransaction().begin();
			em.persist(site);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>> " + e.getMessage());
			em.getTransaction().rollback();
			
		} finally {
			this.fim();
		}
		
	}
	
	public List<Site> listarTodosSites() {
		
		this.inicio();
		
		List<Site> todosSites = new ArrayList<Site>();
		
		try {
			
			Query query = em.createQuery("select s from Site s");
			todosSites = (List<Site>) query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return todosSites;
	}

}
