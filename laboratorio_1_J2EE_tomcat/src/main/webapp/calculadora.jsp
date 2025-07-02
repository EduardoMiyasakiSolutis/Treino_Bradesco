	<!DOCTYPE html>
<html>
<head>
<title>Calculadora</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Calculadora Simples</h2>

	<form action='calc' method='post'>

		<label>Número 1:</label> 
		<input type='text' name='num1' required></input> <br><br> 
		
		<label>Número 2:</label>
		 <input type='text' name='num2'required></input> <br><br>
		 
		 <label>Operação:</label>
		  <select name='operacao'>
		  <option value='#' disabled selected>Selecione um valor</option>
		  <option value='Soma'>Soma</option>
		  <option value='Subtracao'>Subtração</option>
		  <option value='Multiplicacao'>Multiplicação</option>
		  <option value='Divisao'>Divisão</option>
		  
		</select><br><br>
		
		<input type='submit' value='Calcular'>
	</form>
</body>
</html>
