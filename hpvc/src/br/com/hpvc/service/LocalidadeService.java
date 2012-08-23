package br.com.hpvc.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.hpvc.dao.LocalidadeDAO;
import br.com.hpvc.entidade.Localidade;

@Component
public class LocalidadeService {
	
	private LocalidadeDAO localidadeDAO;

	public LocalidadeService() {
		localidadeDAO = new LocalidadeDAO();
	}
	
	public void cadastrarLocalidade(Localidade localidade) {		
		try {			
			localidadeDAO.cadastrarLocalidade(localidade);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<Localidade> listarTodasLocalidades() {
		return localidadeDAO.listarTodasLocalidades();
	}

}
