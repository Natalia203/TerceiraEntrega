package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			clientes(request, response);
		} else if (action.equals("/insert")) {
			novoCliente(request, response);
		} else if (action.equals("/select")) {
			listarCliente(request, response);
		} else if (action.equals("/update")) {
			editarCliente(request, response);
		} else if (action.equals("/delete")) {
			removerCliente(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto
		ArrayList<JavaBeans> lista = dao.listarClientes();
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("cliente", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agencia.jsp");
		rd.forward(request, response);
	}

	// Novo Cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		// Invocar o método inserirCliente
		dao.inserirCliente(cliente);
		// redirecionar para agencia.jsp
		response.sendRedirect("main");
	}

	// Editar
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		// Setar a variável
		cliente.setIdcli(idcli);
		// executar o método
		dao.selecionarCliente(cliente);
		// Setar os atributos
		request.setAttribute("idcli", cliente.getIdcli());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("email", cliente.getEmail());
		// Encaminhar ao Documento
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar variáveis
		cliente.setIdcli(request.getParameter("idcli"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		// executar alterar cliente
		dao.alterarCliente(cliente);
		// redirecionar para o documento
		response.sendRedirect("main");
	}

	// Remover cliente
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento
		String idcli = request.getParameter("idcli");
		// Setar
		cliente.setIdcli(idcli);
		// Executar
		dao.deletarCliente(cliente);
		// redirecionar para o documento
		response.sendRedirect("main");
	}
}
