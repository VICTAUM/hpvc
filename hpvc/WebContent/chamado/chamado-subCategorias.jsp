<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

SUB-CATEGORIA
<select name="chamado.subCategoria.codigo" style="width:300px;">
    <option value="" selected="selected">Selecione</option>
    <c:forEach var="sub" items="${subCategorias}">
    	<option value="${sub.codigo}">${sub.descricao}</option>
    </c:forEach>
</select>