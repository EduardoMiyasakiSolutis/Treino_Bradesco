<%@ page import="model.Banco" %>
<%@ page import="bean.BancoBean" %>
<jsp:useBean id="bancoBean" class="bean.BancoBean" scope="page" />
<jsp:useBean id="novoBanco" class="model.Banco" scope="request" />

<html>
<head><title>Cadastro de Banco</title></head>
<body>
    <form action="salvarBanco.jsp" method="post">
        Nome: <input type="text" name="nome"><br>
        identificador: <input type="text" name="identificador"><br>
        Data Nascimento: <input type="date" name="data_nascimento"><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
