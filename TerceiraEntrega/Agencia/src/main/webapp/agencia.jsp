<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Clientes</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de Clientes</h1>
	<a href="novo.html" class="botao1">Novo Cliente</a>
    <table id="tabela">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>E-mail</th>
                <th>Opções</th>
            </tr>
        </thead>
        <tbody>
            <% for (int i= 0; i <lista.size(); i++){ %>
                <tr>
                    <td><%=lista.get(i).getIdcli()%></td>
                    <td><%=lista.get(i).getNome()%></td>
                    <td><%=lista.get(i).getCpf()%></td>
                    <td><%=lista.get(i).getEmail()%></td>
                    <td><a href="select?idcli=<%=lista.get(i).getIdcli()%>" class="botao1">Editar</a>
                    <a href="javascript: confirmar(<%=lista.get(i).getIdcli()%>)" class="botao2">Excluir</a>
                    </td>
                </tr>   
            <% } %>
        </tbody>
    </table>
      <script src="scripts/confirmador.js"></script>
</body>
</html>