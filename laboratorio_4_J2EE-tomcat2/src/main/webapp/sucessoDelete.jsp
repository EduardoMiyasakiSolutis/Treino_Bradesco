<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Conta Deletada</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sucesso.css">
</head>
<body>
    <div class="container">
        <h2>Conta deletada com sucesso ✅</h2>
        <div class="buttons">
            <a href="cadastroBancos.jsp" class="btn btn-cadastrar">Cadastrar Novo Banco</a>
            <a href="${pageContext.request.contextPath}/banco" class="btn btn-listar">Listar Bancos</a>
        </div>
    </div>
</body>
</html>
