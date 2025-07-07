<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Banco</title>
<link rel="stylesheet" href="css/cadastro.css">
</head>
<body>
	<div class="container">
		<form class="form-card" action="banco" method="post">
			<h2>Atualizar Banco</h2>

			<!-- Simulação do método PUT -->
			<input type="hidden" name="method" value="PUT">
			
			<!-- ID vindo pela URL -->
			<input type="hidden" name="id" value="<%= id %>">

			<label for="identificador">Identificador:</label>
			<input type="text" name="identificador" id="identificador" placeholder="0123" required>

			<label for="nome">Nome:</label>
			<input type="text" name="nome" id="nome" placeholder="Banco Itaú" required>

			<label>Data de Nascimento:</label>
			<input type="date" name="data_nascimento" id="data_nascimento" required>

			<button type="submit" class="btn-primary">Atualizar banco</button>
		</form>
	</div>
</body>
</html>
