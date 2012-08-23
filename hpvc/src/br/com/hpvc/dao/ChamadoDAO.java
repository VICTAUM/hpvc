package br.com.hpvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.hpvc.entidade.Area;
import br.com.hpvc.entidade.Categoria;
import br.com.hpvc.entidade.StatusChamado;
import br.com.hpvc.entidade.SubCategoria;

public class ChamadoDAO {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	public ChamadoDAO() {
		// TODO Auto-generated constructor stub
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
	
	public List<Area> findAllAreas() {
				
		List<Area> areas = new ArrayList<Area>();
		this.inicio();
		
		try {
			Query query = em.createQuery("select a from Area a ");
			
			areas = (List<Area>) query.getResultList();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return areas;
	}
	
	public List<Categoria> findAllCategoriasByArea(Long codigoArea) {
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		this.inicio();
		
		try {
			System.out.println("select c from Categoria c where c.area.codigo = " + codigoArea);
			Query query = em.createQuery("select c from Categoria c where c.area.codigo = :codigo");
			query.setParameter("codigo", codigoArea);
			
			categorias = (List<Categoria>) query.getResultList();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return categorias;
	}
	
	public List<SubCategoria> findAllSubCategoria(Long codigoCategoria) {
		
		List<SubCategoria> subCategorias = new ArrayList<SubCategoria>();
		this.inicio();
		
		try {
			Query query = em.createQuery("select c from SubCategoria c where c.categoria.codigo = :codigo");
			query.setParameter("codigo", codigoCategoria);
			
			subCategorias = (List<SubCategoria>) query.getResultList();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return subCategorias;
	}
	
	public List<StatusChamado> findAllStatusChamado() {
		
		List<StatusChamado> status = new ArrayList<StatusChamado>();
		this.inicio();
		
		try {
			
			Query query = em.createQuery("select s from StatusChamado s");
			status = (List<StatusChamado>) query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return status;
	}

	public static void main(String[] args) {
		
		ChamadoDAO dao = new ChamadoDAO();
		List<Area> lista = dao.findAllAreas();
		
		System.out.println(">>> " + lista.size());
	}
	
}
