<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem vindo</title>
<link rel="stylesheet" href="css/cadastro.css">

</head>
<body>
	<div class="container">
		<form class="form-card" action="banco" method='post'>
			<h2>Cadastrar Banco</h2>

			<label for='identificador'>Identificador:</label>
			 <input type="text" name="identificador" id="identificador" placeholder="0123" required>

			<label for='nome'>Nome:</label> 
			<input type="text" name="nome" id="nome" placeholder="Banco Itaú" required>
			
			 <label>Data de Nascimento:</label> 
			 <input type="date" name="data_nascimento" id="data_nascimento" required>

			<button type="submit" class="btn-primary">Cadastrar banco</button>
		</form>
		<br>
		<form class="form-card" action="banco" method='get'>
			<button type="submit" class="btn-primary">Listar Bancos</button>
		</form>
	</div>
</body>
</html>