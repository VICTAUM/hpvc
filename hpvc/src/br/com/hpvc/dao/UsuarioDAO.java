package br.com.hpvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.hpvc.entidade.TipoUsuario;
import br.com.hpvc.entidade.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	public UsuarioDAO() {
		
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
	
	public Usuario autenticar(String login, String senha) {
		 
		this.inicio();
		
		try {
			
			Query query = em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		} finally {
			this.fim();
		}
				
	}
	
	public List<TipoUsuario> listarTiposUsuarios() {
		
		this.inicio();
		
		try {
			
			Query query = em.createQuery("select u from TipoUsuario u");
						
			return (List<TipoUsuario>) query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		} finally {
			this.fim();
		}
		
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		
		this.inicio();
		
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
	}
	
	public List<Usuario> listarTodosUsuarios() {
		
		this.inicio();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Query query = em.createQuery("select u from Usuario u order by u.nome");
			usuarios = (List<Usuario>)query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.fim();
		}
		
		return usuarios;
	}
	
	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = dao.autenticar("ADMIN", "ADMIN");
		
		System.out.println(">>> " + u.getLogin());
	}

}
