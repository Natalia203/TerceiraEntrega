<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt=br">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Editar Cliente </h1>
    <form name="" action="update">
        <table>
             <tr>
                <td><input type="text" name="idcli" id="caixa2" readonly value="<%out.print(request.getAttribute("idcli"));%>"></td>
            </tr>
            <tr>
                <td><input type="text" name="nome" class="caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
            </tr>
            <tr>
                <td><input type="text" name="cpf" class="caixa1" value="<%out.print(request.getAttribute("cpf"));%>"></td>
            </tr>
            <tr>
                <td><input type="text" name="email"  class="caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
            </tr>
        </table>
        <input type="submit" value="Salvar" class="botao1">
    </form>  
</body>
</html>