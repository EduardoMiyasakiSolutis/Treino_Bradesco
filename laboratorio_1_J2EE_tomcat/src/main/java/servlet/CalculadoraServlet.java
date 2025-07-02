package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double n1 = Double.valueOf(req.getParameter("num1"));
		double n2 = Double.valueOf(req.getParameter("num2"));

		String operacao = req.getParameter("operacao");

		double resultado = 0;
		
		if(operacao == "#" || operacao == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		switch (operacao) {

		case "Soma": {
			resultado = somar(n1, n2);
			break;
		}

		case "Subtracao": {
			resultado = subtrair(n1, n2);
			break;
		}

		case "Multiplicacao": {
			resultado = multiplicar(n1, n2);
			break;
		}

		case "Divisao": {
			resultado = dividir(n1, n2);
			break;
		}

		default: {
			resultado = 0;
			break;
			}
		}
		
		req.setAttribute("resultado", resultado);
		req.setAttribute("operacao", operacao);
		req.setAttribute("n1", n1);
		req.setAttribute("n2", n2);
		
		req.getRequestDispatcher("/resultado.jsp").forward(req, resp);

	}

	public double somar(double n1, double n2) {
		return n1 + n2;
	}

	public double subtrair(double n1, double n2) {
		return n1 - n2;
	}

	public double multiplicar(double n1, double n2) {
		return n1 * n2;
	}

	public double dividir(double n1, double n2) {
		return n1 / n2;
	}

}
