package br.com.hpvc.session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.hpvc.entidade.Usuario;
import br.com.hpvc.util.Perfil;

@Component
@SessionScoped
public class UsuarioSessao {

	public UsuarioSessao() {
		// TODO Auto-generated constructor stub
	}
	
	private Usuario usuario;
	private Perfil perfil;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public boolean login() {
		return usuario != null && usuario.getLogin().length() > 0 ? true : false;
	}
	
	public void logout() {
		usuario = null;
	}

	
}
