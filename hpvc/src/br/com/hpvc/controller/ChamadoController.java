package br.com.hpvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hpvc.dao.ChamadoDAO;
import br.com.hpvc.entidade.Area;
import br.com.hpvc.entidade.Categoria;
import br.com.hpvc.entidade.Chamado;
import br.com.hpvc.entidade.StatusChamado;
import br.com.hpvc.entidade.SubCategoria;
import br.com.hpvc.session.UsuarioSessao;

@Resource
@Path("/chamado")
public class ChamadoController {
	
	private Result result;
	private UsuarioSessao usuarioSessao;
	private HttpSession session;
	private ChamadoDAO chamadoDAO;
	private HttpServletRequest request;	
	private Chamado chamado;

	public ChamadoController(Result result, UsuarioSessao usuarioSessao, HttpSession session) {
		super();		
		this.result = result;
		this.usuarioSessao = usuarioSessao;
		this.session = session;
		this.request = request;		
		chamadoDAO = new ChamadoDAO();
	}
	
	@Get("/abrir-chamado")
	public void abrirChamado() {	
		session.setAttribute("areas", listarArea());		
		session.setAttribute("status", listaStatusChamados());		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		session.setAttribute("hoje", sdf.format(new Date()));		
		result.forwardTo("chamado-abrir.jsp");
	}
	
	
	public List<Area> listarArea(){
		return chamadoDAO.findAllAreas(); 
	}
	
	public List<StatusChamado> listaStatusChamados() {
		return chamadoDAO.findAllStatusChamado();
	}
	
	@Get("/listarCategorias")
	public void listarCategorias(Long codigo) {		
		session.setAttribute("categorias", buscarCategoria(codigo));		
		result.forwardTo("chamado-categorias.jsp");
	}
	
	@Get("/listarSubCategorias")
	public void listarSubCategorias(Long codigo) {
		session.setAttribute("subCategorias", buscarSubCategorias(codigo));
		result.forwardTo("chamado-subCategorias.jsp");
	}
	
	public List<SubCategoria> buscarSubCategorias(Long codigo) {
		return chamadoDAO.findAllSubCategoria(codigo);
	}
	
	public List<Categoria> buscarCategoria(Long codigo) {
		return chamadoDAO.findAllCategoriasByArea(codigo);
	}
	
	@Post("/cadastrar")
	public void cadastrarChamado(Chamado chamado) {
		System.out.println("Funcionou");
		System.out.println("DESCRIÇÃO....: " + chamado.getDescricao());
		System.out.println("STATUS.......: " + chamado.getStatusChamado().getCodigo());
//		System.out.println("ARÉA.........: " + chamado.getArea().getCodigo());
//		System.out.println("CATEGORIA....: " + chamado.getCategoria().getCodigo());
		System.out.println("SUB-CATEGORIA: " + chamado.getSubCategoria().getCodigo());
		
	}


	public Chamado getChamado() {
		return chamado;
	}


	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

}
