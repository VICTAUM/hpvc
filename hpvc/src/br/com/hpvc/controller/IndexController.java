/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.hpvc.controller;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hpvc.anotations.Permissao;
import br.com.hpvc.dao.UsuarioDAO;
import br.com.hpvc.entidade.Usuario;
import br.com.hpvc.session.UsuarioSessao;
import br.com.hpvc.util.Perfil;


@Resource
public class IndexController {

	private Result result;
	private UsuarioSessao usuarioSessao;
	private UsuarioDAO usuarioDAO;
	private HttpSession session;

	public IndexController(Result result, HttpSession session, UsuarioSessao usuarioSessao) { 
		super();
		System.out.println("CONSTRUTOR DO CONTROLLER");
		this.result = result;
		this.session = session;
		this.usuarioSessao = usuarioSessao;
		usuarioDAO = new UsuarioDAO();				
	}


	@Path("/")
	public void index() {
		result.forwardTo("index.jsp");
	}
	
	@Permissao({Perfil.CLIENTE})
	@Post("/autenticar")
	public void autenticar(Usuario usuario) {
		System.out.println("Funcionou");		
		Usuario user = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());
		
		if (user != null) {
			this.usuarioSessao.setUsuario(user);			
			result.forwardTo("tela-inicial.jsp");
		} else {
			result.include("erro", "Login ou senha inválidos").redirectTo(this).index();
		}			
	}
	
	
	@Post("/teste")
	public void teste() {
		result.forwardTo("teste.jsp");
	}
	
	@Post("/acessoNegado")
	public void acessoNegado() {
		result.include("mensagem", "Usuário ou Senha inválidos");
		result.redirectTo(IndexController.class).index();
	}

}
