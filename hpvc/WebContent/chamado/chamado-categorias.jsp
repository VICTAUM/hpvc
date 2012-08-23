<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
CATEGORIA
<select name="chamado.categoria.codigo" style="width:300px;" id="select-categoria">
    <option value="" selected="selected">Selecione</option>
    <c:forEach var="cat" items="${categorias}">
    	<option value="${cat.codigo}">${cat.descricao}</option>
    </c:forEach>
</select>

<script>

$(document).ready(function() {
	
	$('#select-categoria').change(function() {
	
	var codigo = $(this).val();
			
	$.ajax({
	    url : "../chamado/listarSubCategorias",
	    data : "codigo=" + codigo,
	    dataType : "html",
	    timeout : "60000",
	    type : "GET",
// 	    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
	    beforeSend : function() {},
	    error : function(a, b) {
	        console.info(a, status, b);            
	    },
	    success : function(data) {
	       $(".ajax-sub").html(data);
	    }
	});
	
	});
});

</script>