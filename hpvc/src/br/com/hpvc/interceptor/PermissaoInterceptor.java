package br.com.hpvc.interceptor;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.ws.api.model.MEP;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.hpvc.anotations.Permissao;
import br.com.hpvc.controller.IndexController;
import br.com.hpvc.session.UsuarioSessao;
import br.com.hpvc.util.Perfil;

@Intercepts
@RequestScoped
public class PermissaoInterceptor implements Interceptor {

	private final HttpServletRequest request;
	private Result result;
	private UsuarioSessao usuarioSessao;
	
	public PermissaoInterceptor(HttpServletRequest request, Result result, UsuarioSessao usuarioSessao) {System.out.println("Dentro do Interceptador");
		this.request = request;
		this.result  = result;
		this.usuarioSessao = usuarioSessao;
	}

	public boolean accepts(ResourceMethod method) {System.out.println("Método accepts");		
//		!method.getMethod().isAnnotationPresent(Permissao.class)		
		return  !method.containsAnnotation(Permissao.class);
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		
//		String uri = request.getRequestURI();
//		if (uri.contains("/teste") && (this.usuarioSessao == null || !this.usuarioSessao.login())) {
//			result.redirectTo(IndexController.class).teste();
//		} else {
//			System.out.println("Deu ruim");
//		}
//		stack.next(method, resourceInstance);
		
		Permissao methodPermissao = method.getMethod().getAnnotation(Permissao.class);
		Permissao controllerPermissao = method.getResource().getType().getAnnotation(Permissao.class);
		
		if (hasAccess(methodPermissao) && hasAccess(controllerPermissao)) {System.out.println("Dentro do If");
			stack.next(method, resourceInstance);
		} else { System.out.println("Dentro do Else");
			result.redirectTo(IndexController.class).acessoNegado();
		}			
	}
	
	public boolean hasAccess(Permissao permissao) {
		System.out.println("Dentro do HasAccess " + permissao + " <<<");		
		if (permissao == null) return true;		
		Collection<Perfil> perfis = Arrays.asList(permissao.value());
		
		return perfis.contains(usuarioSessao.getUsuario().getTipoUsuario().getDescricao());		
	}

}
