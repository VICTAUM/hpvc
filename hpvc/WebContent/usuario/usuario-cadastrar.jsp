<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sistema HPVC</title>
	<meta name="robots" content="all" />
	<meta name="description" content="Sistema HPVC" />	
	<meta name="author" content="Luciano Bara�na" />
	<meta name="google-site-verification" content="" />	
	<meta name="Revisit-after" content="10 days" />	
	<meta http-equiv="imagetoolbar" content="no" />	
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="content-language" content="pt-br" />
    <link rel="shortcut icon" type="../layout/image/x-icon" href="" />
    <link rel="stylesheet" href="../layout/css/fonts.css" type="text/css" />
    <link rel="stylesheet" href="../layout/css/reset-minificado.css" />
    <link rel="stylesheet" href="../layout/css/formularios.css" />
	<link rel="stylesheet" href="../layout/css/estilo.css" type="text/css" />
	<link rel="stylesheet" href="../layout/js/tabela/css/blue-theme.css" />
   
    <!-- BIBLIOTECA JQUERY -->
	<script type="text/javascript" src="../layout/js/jquery-1.7.2.min.js"></script>
    <!-- SCROLL MENU -->
    <script type="text/javascript" src="../layout/js/menu-scroll.js"></script>
    <script type="text/javascript" src="../layout/js/tabela/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="../layout/js/tabela/jquery.tablesorter.pager.js"></script>
    <script type="text/javascript" src="../layout/js/jquery.validate.js"></script>
    
    <script type="text/javascript">
	  $(function() {
		  $("table")
			  .tablesorter({widthFixed: true, widgets: ['zebra']})
			  .tablesorterPager({container: $("#pager")});
	  });
	</script>
    
<script type="text/javascript">
    
$(document).ready(function() {
    		
	$('#select-area').change(function() {
		
		var codigo = $(this).val();
				
		$.ajax({
            url : "../chamado/listarCategorias",
            data : "codigo=" + codigo,
            dataType : "html",
            timeout : "60000",
            type : "GET",
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            beforeSend : function() {},
            error : function(a, b) {
                console.info(a, status, b);alert("Erro " + status);
            },
            success : function(data) {
               $(".ajax").html(data);
            }
        });
		
	}); 
	
	$('#form-usuario').validate({
		rules : {
			"usuario.nome" : {required : true},
			"usuario.login" : {required : true},
			"usuario.email" : {required : true, email : true}
		}, 
		messages : {
			"usuario.nome" : {required : "Campo localidade n�o pode ser vazio"},
			"usuario.login" : {required : "Campo login n�o deve ser vazio"},
			"usuario.email" : {required : "Campo email n�o deve ser vazio", email : "Esse email n�o � v�lido"}
		},
		errorLabelContainer: "#error",
		errorElement: "li"
	});
	
});
    
    
    </script>    
    
</head>
<body>
<!-- INICIO BG CORPO -->
<div class="bg-corpo">
	<!-- INICIO CORPO -->
    <div class="corpo">
        
        <!-- INICIO CONTEUDO -->
        <div class="conteudo centraliza">
            
            <!-- INICIO BARRA LOGIN -->
            <jsp:include page="../apresentacao.jsp" />
            <!-- FIM BARRA LOGIN -->            
            
            <h1 class="titulo"><img src="../layout/img/ico-cadastro.png" alt="Bem vindo ao hpvc" width="41" height="51" />Cadastrar Usu&aacute;rio</h1>
            
            <!-- INICIO MENU PRINCIPAL -->
            <jsp:include page="../menu-rolante.jsp" />
            <!-- FIM MENU PRINCIPAL -->
            
            <!-- INICIO FORMULARIO -->
            <form action="<c:url value="/usuario/realizar-cadastro" />" method="post" class="form-hpvc" id="form-usuario" style="margin:0 0 0 125px;">
              
              <ul id="error">
              	<li></li>
              </ul>
              
              <label for="Nome Completo">Nome Completo
              	<input type="text" name="usuario.nome" id="nome" style="width: 450px;" />              	
              </label>
                            
              <label for="Login">Usu�rio
              	<input type="text" name="usuario.login" id="login" style="width: 214px;"/>
              </label>
                            
              <label for="Tipo Usu&aacute;rio">Tipo do Usu&aacute;rio
                  <select name="usuario.tipoUsuario.codigo" style="width:200px;">
              		<option value="" selected="selected">Selecione</option>              		
              		<c:forEach items="${tiposUsuarios}" var="tipo">
              			<option value="${tipo.codigo}">${tipo.descricao}</option>
              		</c:forEach>                      
                </select>
              </label>
                                             
              <label for="Site">Site
                  <select name="usuario.site.codigo" style="width:200px;">
              		<option value="" selected="selected">Selecione</option>              		
              		<c:forEach items="${sites}" var="site">
              			<option value="${site.codigo}">${site.nome}</option>
              		</c:forEach>                      
                </select>
              </label>
                          
              <label for="Email">Email
			  	<input type="text" name="usuario.email" id="email" style="width: 450px;"/>
              </label>
              
              <label for="Ramal">Ramal
			  	<input type="text" name="usuario.ramal" id="ramal" style="width: 214px;"/>
              </label>
              
              <input type="submit" class="botao fright" value="Cadastrar Usu&aacute;rio" />
            </form>
            <!-- FIM FORMULARIO -->
            
            <!-- INICIO DA TABELA -->
            <c:if test="${usuarios != null}">
            	<table cellspacing="2" class="tablesorter">
            	    <thead>
            	        <tr>
            	            <th>C&oacute;digo</th>
            	            <th>Nome</th>
            	            <th>Usu&aacute;rio</th>
            	            <th>Perfil</th>
            	            <th>Email</th>
            	            <th>Ramal</th>
            	            <th>Site</th>            	            
            	        </tr>
            	    </thead>	
            	    <tbody>
            	    	<c:forEach items="${usuarios}" var="usuario">
            	    		<tr>
            	            <td>${usuario.codigo}</td>
            	            <td>${usuario.nome}</td>
            	            <td>${usuario.login}</td>
            	            <td>${usuario.tipoUsuario.descricao}</td>
            	            <td>${usuario.email}</td>
            	            <td>${usuario.ramal}</td>
            	            <td>${usuario.site.nome}</td>
            	        </tr>
            	    	</c:forEach>            	                    	        
            	   </tbody>
            	</table>
            
            	<div id="pager" class="pager">
            	  <form>
            	      <a href="" class="first">Primeiro</a>
            	      <a href="" class="prev">Previa</a>
            	        <input type="text" class="pagedisplay"/>
            	      <a href="" class="next">Proximo</a>
            	      <a href="" class="last">Ultimo</a>        
            	      <select class="pagesize">
            	          <option selected="selected"  value="10">10</option>
            	          <option value="20">20</option>
            	          <option value="30">30</option>
            	          <option  value="40">40</option>
            	      </select>
            	  </form>
            	</div>
            </c:if>            
            <!-- FIM DA TABELA -->            
            
            <input type="button" value="Voltar" class="botao fright" onClick="history.go(-1)">
            
        </div>
        <!-- FIM CONTEUDO -->
    </div>
    <!-- FIM CORPO -->
</div>
<!-- FIM BG CORPO -->

<!-- INICIO RODAPE -->
<jsp:include page="../rodape.jsp" />
<!-- FIM RODAPE -->
</body>
</html>
