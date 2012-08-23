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
    <link rel="stylesheet" href="layout/css/reset-minificado.css" />
    
	<link rel="stylesheet" href="layout/css/estilo.css" type="text/css" />
    <!-- BIBLIOTECA JQUERY -->
	<script type="text/javascript" src="layout/js/jquery-1.7.2.min.js"></script>
    <!-- SCROLL MENU -->
    <script type="text/javascript" src="layout/js/menu-scroll.js"></script>
</head>
<body>

<!-- INICIO BG CORPO -->
<div class="bg-corpo">
	
	<!-- INICIO CORPO -->
    <div class="corpo">
        
        <!-- INICIO CONTEUDO -->
        <div class="conteudo centraliza">
            
            <!-- INICIO BARRA LOGIN -->
			<jsp:include page="apresentacao.jsp" />
            <!-- FIM BARRA LOGIN -->
            
            <!-- INICIO TITULO DA PÁGINA -->
            <h1 class="titulo">
            	<img src="layout/img/ico-pc-titutlo.png" alt="Bem vindo ao hpvc" width="75" height="64" />Bem vindo ao HPVC
            </h1>
            <!-- FIM TITULO DA PÁGINA -->
            
            <!-- INICIO MENU PRINCIPAL -->
			<jsp:include page="menu-rolante.jsp" />
            <!-- FIM MENU PRINCIPAL -->
           
            <!-- INICIO MENU -->
			<jsp:include page="menu-estatico.jsp" />
            <!-- FIM MENU -->
        </div>
        <!-- FIM CONTEUDO -->
    </div>
    <!-- FIM CORPO -->
</div>
<!-- FIM BG CORPO -->

<!-- INICIO RODAPE -->
<jsp:include page="rodape.jsp" />
<!-- FIM RODAPE -->

</body>
</html>
