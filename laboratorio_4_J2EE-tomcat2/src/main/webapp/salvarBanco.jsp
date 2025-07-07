<%@ page import="java.time.LocalDate" %>
<%@ page import="model.Banco" %>
<%@ page import="bean.BancoBean" %>
<jsp:useBean id="banco" class="model.Banco" scope="request" />
<jsp:useBean id="bancoBean" class="bean.BancoBean" scope="application" />

<%
    banco.setIdentificador(request.getParameter("identificador"));
    banco.setNome(request.getParameter("nome"));
    banco.setData_nascimento(LocalDate.parse(request.getParameter("data_nascimento")));
    bancoBean.inserir(banco);
%>

<h2>Banco cadastrado com sucesso!</h2>
<a href="cadastroBancos.jsp">Cadastrar outro</a>
<a href="listarBancos.jsp">Ver todos</a>
