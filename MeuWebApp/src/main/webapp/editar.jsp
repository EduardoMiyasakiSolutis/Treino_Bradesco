<%@ page import="model.Usuario, dao.UsuarioDAO" %>
<%
    String idParam = request.getParameter("id");
    int id = Integer.parseInt(idParam);

    UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = dao.findById(id);
%>

<html>
<head>
    <title>Editar Usuário</title>
</head>
<body>
    <h2>Editar Usuário</h2>
    <form action="usuarios" method="post">
        <input type="hidden" name="id" value="<%= usuario.getId() %>"/>
        Nome: <input type="text" name="nome" value="<%= usuario.getNome() %>"/><br><br>
        Email: <input type="text" name="email" value="<%= usuario.getEmail() %>"/><br><br>
        <input type="submit" value="Salvar"/>
    </form>
</body>
</html>
