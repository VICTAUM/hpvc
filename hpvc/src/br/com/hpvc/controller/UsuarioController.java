package br.com.hpvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hpvc.dao.UsuarioDAO;
import br.com.hpvc.entidade.TipoUsuario;
import br.com.hpvc.entidade.Usuario;
import br.com.hpvc.service.SiteService;
import br.com.hpvc.service.UsuarioService;
import br.com.hpvc.session.UsuarioSessao;

@Resource
@Path("/usuario")
public class UsuarioController {
	
	private Result result;
	private UsuarioSessao usuarioSessao;
	private HttpSession session;
	private UsuarioDAO usuarioDAO;
	private HttpServletRequest request;
	private Usuario usuario;
	private UsuarioService usuarioService;
	private SiteService siteService;
	
	public UsuarioController(Result result, UsuarioSessao usuarioSessao, HttpSession session, HttpServletRequest request) {
		super();		
		this.result = result;
		this.usuarioSessao = usuarioSessao;
		this.session = session;
		this.request = request;
		usuarioDAO = new UsuarioDAO();
		usuarioService = new UsuarioService();
		siteService = new SiteService();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Get("/cadastrar-usuario")
	public void cadastrarUsuario() {
		session.setAttribute("tiposUsuarios", usuarioService.listarTiposUsuarios());
		session.setAttribute("sites", siteService.listarTodosSites());
		session.setAttribute("usuarios", usuarioService.listarTodosUsuarios());
		result.forwardTo("usuario-cadastrar.jsp");
	}
	
	@Post("/realizar-cadastro")
	public void realizarCadastro(Usuario usuario) {		
		try {
			usuarioService.cadastrarUsuario(usuario);
			session.setAttribute("tiposUsuarios", usuarioService.listarTiposUsuarios());
			session.setAttribute("sites", siteService.listarTodosSites());
			session.setAttribute("usuarios", usuarioService.listarTodosUsuarios());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.forwardTo("usuario-cadastrar.jsp");
	}
	
	
	
	
}
