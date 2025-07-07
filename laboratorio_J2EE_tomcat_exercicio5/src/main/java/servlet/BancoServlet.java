package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BancoDAO;
import model.Banco;
import service.BancoService;

public class BancoServlet extends HttpServlet {

	BancoService service = new BancoService();
	
	BancoDAO dao = new BancoDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String metodo = req.getParameter("method");

		if (metodo != null && metodo.equalsIgnoreCase("put")) {
			doPut(req, resp);
		} else {

			String identificador = req.getParameter("identificador");
			String nome = req.getParameter("nome");
			var dataNascimento = req.getParameter("data_nascimento");

			Banco banco = new Banco();
			banco.setData_nascimento(LocalDate.parse(dataNascimento));
			banco.setNome(nome);
			banco.setIdentificador(identificador);

			service.saveBank(banco);

			resp.sendRedirect("banco");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("servlet chamada");
		List<Banco> banksList = service.getAllBanks();

		req.setAttribute("banksList", banksList);

		req.getRequestDispatcher("/listaBancos.jsp").forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idParameter = req.getParameter("id");

		if (idParameter == null || idParameter.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			resp.getWriter().print("ID do banco não informado");
			return;
		}

		try {

			int id = Integer.parseInt(idParameter);

			boolean deletado = dao.deleteById(id);

			if (deletado) {
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.getWriter().println("Banco deletado com sucesso");
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				resp.getWriter().println("Usuário não encontrado!");
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().println("ID não encontrado");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String identificador = req.getParameter("identificador");
		String nome = req.getParameter("nome");
		var dataNascimento = req.getParameter("data_nascimento");

		System.out.print(dataNascimento);
		Banco banco = new Banco();
		banco.setData_nascimento(LocalDate.parse(dataNascimento));
		banco.setNome(nome);
		banco.setIdentificador(identificador);

		dao.updateById(id, banco);

		resp.sendRedirect("banco");
	}

}
