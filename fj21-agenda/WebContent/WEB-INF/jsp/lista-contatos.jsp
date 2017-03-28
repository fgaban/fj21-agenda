<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	<!--  criava/instanciava o DAO - ex antes do MVC tb alterou o items do forEach ${dao.lista} -->
	<!-- jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />  -->
	
	<table border="1">
		<!-- percorre contatos montando as linhas da tabela -->
		<tr align="center" bgcolor="cccccc">
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereco</td>
			<td>Data Nascimento</td>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail nao informado
						</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco}</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<a href="grava-contato.jsp?id=${contato.id}&nome=${contato.nome}&email=${contato.email}
						&endereco=${contato.endereco}&dataNascimento=<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>">Alterar</a>
				</td>
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td>
				<a href="grava-contato.jsp?id=0">Incluir</a>
			</td>
		</tr>
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>