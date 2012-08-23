package br.com.hpvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hpvc.entidade.Localidade;
import br.com.hpvc.service.LocalidadeService;
import br.com.hpvc.session.UsuarioSessao;

@Resource
@Path("/localidade")
public class LocalidadeController {

	private Result result;
	private UsuarioSessao usuarioSessao;
	private HttpSession session;	
	private HttpServletRequest request;
	private LocalidadeService localidadeService;
	private Localidade localidade;
	
	public LocalidadeController(Result result, UsuarioSessao usuarioSessao, HttpSession session, HttpServletRequest request) {
		super();		
		this.result = result;
		this.usuarioSessao = usuarioSessao;
		this.session = session;
		this.request = request;
		localidadeService = new LocalidadeService();
	}
		
	@Get("cadastrar-localidade")
	public void cadastrarLocalidade(){
		session.setAttribute("localidades", localidadeService.listarTodasLocalidades());
		result.forwardTo("localidade-cadastrar.jsp");
	}
	
	@Post("/realizar-cadastro")
	public void realizarCadastro(Localidade localidade) {		
		localidadeService.cadastrarLocalidade(localidade);		
		session.setAttribute("localidades", localidadeService.listarTodasLocalidades());
		result.forwardTo("localidade-cadastrar.jsp");
	}


//	Getters and Setters

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

}
