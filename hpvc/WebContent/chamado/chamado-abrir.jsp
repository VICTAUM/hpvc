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
    <link rel="shortcut icon" type="../layout/image/x-icon" href="" />
    <link rel="stylesheet" href="../layout/css/fonts.css" type="text/css" />
    <link rel="stylesheet" href="../layout/css/reset-minificado.css" />
    <link rel="stylesheet" href="../layout/css/formularios.css" />
	<link rel="stylesheet" href="../layout/css/estilo.css" type="text/css" />
    

    
    <!-- BIBLIOTECA JQUERY -->
	<script type="text/javascript" src="../layout/js/jquery-1.7.2.min.js"></script>
    <!-- SCROLL MENU -->
    <script type="text/javascript" src="../layout/js/menu-scroll.js"></script>
    
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
//             contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            beforeSend : function() {},
            error : function(a, b) {
                console.info(a, status, b);
            },
            success : function(data) {
               $(".ajax").html(data);
            }
        });
		
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
            
            <h1 class="titulo"><img src="../layout/img/ico-cadastro.png" alt="Bem vindo ao hpvc" width="41" height="51" />Abrir chamado</h1>
            
            <!-- INICIO MENU PRINCIPAL -->
            <jsp:include page="../menu-rolante.jsp" />
            <!-- FIM MENU PRINCIPAL -->
            
            <!-- INICIO FORMULARIO -->
            <form action="<c:url value="/chamado/cadastrar" />" method="post" class="form-hpvc" style="margin:0 0 0 125px;">
              <!-- INICIO LISTA RETORNO -->
              <ul class="lista-retorno">
            		<li>
                    	<h2>Identifica&ccedil;&atilde;o</h2>
                        <p>0000000000</p>
                    </li>
                    <li>
                    	<h2>Reaberturas</h2>
                        <p>0</p>
                    </li> 
                    <li>
                    	<h2>Data de cadastro</h2>
                        <p>${hoje}</p>
                    </li>
                    <li>
                    	<h2>Data de encerramento</h2>
                        <p></p>
                    </li>                    
              </ul>
               <!-- FIM LISTA RETORNO -->
                               
              <label for="Status">Status
                  <select name="chamado.statusChamado.codigo" style="width:300px;">
              		<option value="" selected="selected">Selecione</option>              		
              		<c:forEach items="${status}" var="status">
              			<option value="${status.codigo}">${status.descricao}</option>
              		</c:forEach>                      
                </select>
              </label>
                              	
              <label for="&Aacute;rea">&Aacute;rea
              	<select name="chamado.area.codigo" style="width:300px;" id="select-area">
              		<option value="" selected="selected">Selecione</option>              		
              		<c:forEach items="${areas}" var="area">
              			<option value="${area.codigo}">${area.descricao}</option>
              		</c:forEach>                      
                </select>
              </label>
                              	
              <label for="Categoria" class="ajax">CATEGORIA
                  <select style="width:300px;">
                      <option value="" selected="selected">Selecione</option>                      
                  </select>
              </label>
              
              <label for="Sub-Categoria" class="ajax-sub">SUB-CATEGORIA
                  <select style="width:300px;">
                      <option value="" selected="selected">Selecione</option>                      
                  </select>
              </label>
              
              <!-- INICIO LISTA RETORNO -->
              <ul class="lista-retorno">
            	<li>
                  <h2>Cadastrante</h2>
                  <p>${usuarioSessao.usuario.nome}</p>
                </li>
                <li>
                  <h2>Criador</h2>
                  <input type="text" name="cliente" id="cliente" style="width: 300px;"/>
                </li>
                <li>
                  <h2>Ramal para retorno</h2>
                  <p>${usuarioSessao.usuario.ramal}</p>
                </li>                                        
              </ul>
              <!-- FIM LISTA RETORNO -->
              <label for="Descrição">Descriç&atilde;o
                 <textarea name="chamado.descricao" id=""></textarea>
              </label>
              <input type="submit" class="botao fright" value="Cadastrar Item" />
            </form>
            <!-- FIM FORMULARIO -->
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
