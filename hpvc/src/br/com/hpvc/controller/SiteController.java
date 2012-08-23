package br.com.hpvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hpvc.entidade.Site;
import br.com.hpvc.service.LocalidadeService;
import br.com.hpvc.service.SiteService;
import br.com.hpvc.session.UsuarioSessao;

@Resource
@Path("/site")
public class SiteController {

	private Result result;
	private UsuarioSessao usuarioSessao;
	private HttpSession session;	
	private HttpServletRequest request;
	private SiteService siteService;
	private LocalidadeService localidadeService;
	private Site site;
	
	public SiteController(Result result, UsuarioSessao usuarioSessao, HttpSession session, HttpServletRequest request) {
		super();		
		this.result = result;
		this.usuarioSessao = usuarioSessao;
		this.session = session;
		this.request = request;
		siteService = new SiteService();
		localidadeService = new LocalidadeService();
	}
	
	@Get("/cadastrar-site")
	public void cadastrarSite() {
		session.setAttribute("sites", siteService.listarTodosSites());
		session.setAttribute("localidades", localidadeService.listarTodasLocalidades());
		result.forwardTo("site-cadastrar.jsp");
	}

	@Post("/realizar-cadastro")
	public void realizarCadastro(Site site) {		
		siteService.cadastrarSite(site);
		session.setAttribute("sites", siteService.listarTodosSites());
		session.setAttribute("localidades", localidadeService.listarTodasLocalidades());
		
		result.forwardTo(SiteController.class).cadastrarSite();
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
}
