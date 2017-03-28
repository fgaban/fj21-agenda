<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="minhasTags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grava Contato</title>
	<link href="css/jquery.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>

	<h1>Grava Contato</h1>
	<hr />
	<form action="mvc?logica=GravaContatoLogic" method="POST">
		<input type="hidden" name="id" value="${param.id}" />	
		Nome: <input type="text" name="nome" value="${param.nome}" /><br /> 
		E-mail: <input type="text" name="email" value="${param.email}" /><br /> 
		Endereco: <input type="text" name="endereco" value="${param.endereco}" /><br />
		Data Nascimento: <minhasTags:campoData id="dataNascimento" valor="${param.dataNascimento}" /><br /> 
		
		<input type="submit" value="Gravar">
	</form>
	
	<c:import url="/WEB-INF/jsp/rodape.jsp"/>
</body>
</html>