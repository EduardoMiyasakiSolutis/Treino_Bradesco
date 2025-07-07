<%@ page import="java.util.*, model.Banco, service.BancoService" %>
<jsp:useBean id="service" class="service.BancoService" scope="page" />
<%
    List<Banco> lista = service.getAllBanks();
%>

<html>
<body>
    <h2>Lista de Bancos</h2>
    <ul>
        <% for (Banco b : lista) { %>
            <li><%= b.getIdentificador()%> - <%= b.getNome() %></li>
        <% } %>
    </ul>
</body>
</html>
