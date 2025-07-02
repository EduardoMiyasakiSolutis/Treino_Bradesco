<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado da Operação</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resultado.css">
</head>
<body>
    <div class="resultado-container">
        <h2>Resultado da Operação</h2>

        <p>
            O resultado da operação de <strong><%= request.getAttribute("operacao") %></strong> entre 
            <strong><%= request.getAttribute("n1") %></strong> e 
            <strong><%= request.getAttribute("n2") %></strong> é:
        </p>

        <div class="resultado">
            <%= request.getAttribute("resultado") %>
        </div>

        <a href="index.jsp" class="botao-voltar">Voltar</a>
    </div>
</body>
</html>
