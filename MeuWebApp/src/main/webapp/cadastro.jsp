<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>   	
<body>
    <div class="container">
        <form class="form-card" action='usuarios' method="post">
            <h2>Criar conta</h2>

            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" placeholder="Eduardo Kendi" required>
 
            <label for="email">Email</label>
            <input type="email" name="email" id="email" placeholder="eduardo_kendi@gmail.com" required>
 
            <button type="submit" class="btn-primary">Criar conta</button>
 
        </form>
    </div>
</body>
</html>
 
 