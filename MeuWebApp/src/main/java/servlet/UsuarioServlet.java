package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Conexao;
import model.Usuario;

public class UsuarioServlet extends HttpServlet {

	UsuarioDAO dao = new UsuarioDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);

		dao.inserir(usuario);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Usuário cadastrado com sucesso!</h3>");
		out.println("<a href='cadastro.jsp'>Cadastrar outro</a>");
		out.println("</body></html>");

		out.println("<form action='usuarios' method='get'>");
		out.println("<input type='submit' value='Ver usuários cadastrados'/>");
		out.println("</form>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    List<Usuario> usuarioList = dao.getAllUsers();

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Lista de Usuários</title>");
	    out.println("<style>");
	    out.println("body { font-family: 'Segoe UI', sans-serif; background-color: #f4f6f8; margin: 0; padding: 20px; }");
	    out.println("h2 { text-align: center; color: #333; }");
	    out.println(".table-container { max-width: 900px; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }");
	    out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
	    out.println("th, td { padding: 12px 15px; text-align: left; }");
	    out.println("th { background-color: #7a5af8; color: white; font-weight: normal; }");
	    out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
	    out.println("tr:hover { background-color: #f1f1f1; }");
	    out.println("a { display: inline-block; margin-top: 20px; text-decoration: none; color: #fff; background: #7a5af8; padding: 10px 15px; border-radius: 6px; }");
	    out.println("a:hover { background: #674bd8; }");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<div class='table-container'>");
	    out.println("<h2>Lista de Usuários</h2>");
	    out.println("<table>");
	    out.println("<tr><th>ID</th><th>Nome</th><th>Email</th></tr>");

	    for (Usuario u : usuarioList) {
	        out.println("<tr>");
	        out.println("<td>" + u.getId() + "</td>");
	        out.println("<td>" + u.getNome() + "</td>");
	        out.println("<td>" + u.getEmail() + "</td>");
	        out.println("</tr>");
	    }

	    out.println("</table>");
	    out.println("<a href='cadastro.jsp'>Cadastrar novo usuário</a>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
	}


}
