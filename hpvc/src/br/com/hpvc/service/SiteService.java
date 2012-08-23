package br.com.hpvc.service;

import java.util.List;

import br.com.hpvc.dao.LocalidadeDAO;
import br.com.hpvc.dao.SiteDAO;
import br.com.hpvc.entidade.Site;

public class SiteService {

	private SiteDAO siteDAO;
	private LocalidadeDAO localidadeDAO;
	
	public SiteService() {
		siteDAO = new SiteDAO();
		localidadeDAO = new LocalidadeDAO();
	}
	
	public void cadastrarSite(Site site) {		
		try {
			siteDAO.cadastrarSite(site);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public List<Site> listarTodosSites() {
		return siteDAO.listarTodosSites();
	}
	
	
	
}
