<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sistema HPVC</title>
	<meta name="robots" content="all" />
	<meta name="description" content="Sistema HPVC" />	
	<meta name="author" content="Luciano Baraúna" />
	<meta name="google-site-verification" content="" />	
	<meta name="Revisit-after" content="10 days" />	
	<meta http-equiv="imagetoolbar" content="no" />	
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="content-language" content="pt-br" />
    <link rel="shortcut icon" type="layout/image/x-icon" href="" />
    <link rel="stylesheet" href="layout/css/fonts.css" type="text/css" />
	<link rel="stylesheet" href="layout/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="layout/css/login.css" type="text/css" />
</head>
<body>
<!-- INICIO CORPO LOGIN -->
<div class="corpo-login">
	<!-- INICIO FORM LOGIN -->
    <form action="/hpvc/autenticar" class="form-login" method="post">
	    <fieldset>
	    	<label for="Usuário">Usu&aacute;rio</label>
	    	<input type="text" name="usuario.login" />
	    	<label for="Senha">Senha</label>
	    	<input type="password" name="usuario.senha" />
	    	<input type="submit" value="entrar" />
            <a href="#" title="Lembrar">esqueceu a senha?</a>	    
        </fieldset>
        
	</form>
	<p>${mensagem}</p>
    <!-- FIM FORM LOGIN -->
</div>
<br clear="all" />
<!-- FIM CORPO LOGIN -->

<!-- INICIO BG RODAPE LOGIN -->
<jsp:include page="rodape.jsp" />
<!-- FIM BG RODAPE LOGIN -->

</body>
</html>
