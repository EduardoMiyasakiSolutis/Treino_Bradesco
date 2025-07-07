<%@ page import="java.util.List" %>
<%@ page import="model.Banco" %>
<%@ page import="bean.BancoBean" %>
<jsp:useBean id="bancoBean" class="bean.BancoBean" scope="application" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/atualizar.js"></script>
<%
    List<Banco> lista = bancoBean.listarTodos();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Bancos</title>
</head>
<body>
    <h2>Todos os Bancos</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Identificador</th>
            <th>Nome</th>
            <th>Data Nascimento</th>
        </tr>
        <%
            for (Banco b : lista) {
        %>
        <tr>
            <td><%= b.getIdBanco() %></td>
            <td><%= b.getIdentificador() %></td>
            <td><%= b.getNome() %></td>
            <td><%= b.getData_nascimento() %></td>
            <td>
            <button type="button"
							onclick="updateBank(<%=b.getIdBanco()%>)"
							class="btn-action btn-edit"'>Atualizar</button></td>
        </tr>
        <% } %>
    </table>
    <a href="cadastroBancos.jsp">Cadastrar novo banco</a>
</body>
</html>
