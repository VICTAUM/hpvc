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
	<link rel="stylesheet" href="../layout/js/tabela/css/blue-theme.css" />
   
    <!-- BIBLIOTECA JQUERY -->
	<script type="text/javascript" src="../layout/js/jquery-1.7.2.min.js"></script>
    <!-- SCROLL MENU -->
    <script type="text/javascript" src="../layout/js/menu-scroll.js"></script>
    <script type="text/javascript" src="../layout/js/tabela/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="../layout/js/tabela/jquery.tablesorter.pager.js"></script>
    
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
            
            <h1 class="titulo"><img src="../layout/img/ico-cadastro.png" alt="Bem vindo ao hpvc" width="41" height="51" />Cadastrar Site</h1>
            
            <!-- INICIO MENU PRINCIPAL -->
            <jsp:include page="../menu-rolante.jsp" />
            <!-- FIM MENU PRINCIPAL -->
            
            <!-- INICIO FORMULARIO -->
            <form action="<c:url value="/site/realizar-cadastro" />" method="post" class="form-hpvc" style="margin:0 0 0 125px;">
                                         
              <label for="Nome">Nome:
              	<input type="text" name="site.nome" id="nome" style="width: 450px;" />              	
              </label>
              
              <label for="Localidades">Localidade
                  <select name="site.localidade.codigo" style="width:200px;">
              		<option value="" selected="selected">Selecione</option>              		
              		<c:forEach items="${localidades}" var="localidade">
              			<option value="${localidade.codigo}">${localidade.nome}</option>
              		</c:forEach>                      
                </select>
              </label>
        
              <input type="submit" class="botao fright" value="Cadastrar Site" />
            </form>
            <!-- FIM FORMULARIO -->
            
            <!-- INICIO DA TABELA -->
            <c:if test="${sites != null}">
            	<table cellspacing="2" class="tablesorter">
            	    <thead>
            	        <tr>
            	            <th>C&oacute;digo</th>
            	            <th>Site</th>
            	            <th>Localidade</th>
            	        </tr>
            	    </thead>	
            	    <tbody>
            	    	<c:forEach items="${sites}" var="site">
            	    		<tr>
            	            <td>${site.codigo}</td>
            	            <td>${site.nome}</td>
            	            <td>${site.localidade.nome}</td>
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
