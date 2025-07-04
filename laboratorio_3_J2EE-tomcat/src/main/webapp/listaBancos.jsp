<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Banco"%>

<%
List<Banco> lista = (List<Banco>) request.getAttribute("banksList");
if (lista == null) {
	System.out.print("lista vazia");
}
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Lista de Bancos</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/resultado.css" />
<script>
	const contextPath = '${pageContext.request.contextPath}';
	
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/deletar.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/atualizar.js"></script>
	

</head>
<body>
	<div class="resultado-container">
		<h2>Lista de Bancos</h2>

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Identificador</th>
					<th>Nome</th>
					<th>Data de Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (lista != null && !lista.isEmpty()) {
					for (Banco b : lista) {
				%>
				<tr>
					<td><%=b.getId_banco()%></td>
					<td><%=b.getIdentificador()%></td>
					<td><%=b.getNome()%></td>
					<td><%=b.getData_nascimento()%></td>
					<td>
					<button type="button"
							onclick="updateBank(<%=b.getId_banco()%>)"
							class="btn-action btn-edit"'>Atualizar</button></td>
					<td>
						<button type="button" onclick="deletarBanco(<%=b.getId_banco()%>)"
							class="btn-action btn-delete"'>Deletar</button>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4">Nenhum banco encontrado.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<a href="cadastroBancos.jsp" class="botao-voltar">Cadastrar Novo</a>
	</div>
</body>
</html>
