package br.com.hpvc.service;

import java.util.List;

import br.com.hpvc.dao.UsuarioDAO;
import br.com.hpvc.entidade.TipoUsuario;
import br.com.hpvc.entidade.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		try {
			usuarioDAO.cadastrarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TipoUsuario> listarTiposUsuarios() {		
		return usuarioDAO.listarTiposUsuarios();
	}
	
	public List<Usuario> listarTodosUsuarios() {
		return usuarioDAO.listarTodosUsuarios();
	}

}
