
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 1200px; margin-left: auto; margin-right: auto;">
            <table cellpadding="10">
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Sexo</th>
                    <th>Data Nascimento</th>
                    <th>Estado Civil</th>
                    <th>Endereço</th>
                    <th>Complemento</th>
                    <th>Número</th>
                    <th>Bairro</th>
                    <th>CEP</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                </tr>
                <c:forEach items="${Listagem}" var="p">
                    <tr>
                        <td>${p.nome}</td>
                        <td>${p.cpf}</td>
                        <td>${p.dtNascimento}</td>
                        <td>${p.estadoCivil}</td>
                        <td>${p.endereco}</td>
                        <td>${p.complemento}</td>
                        <td>${p.numero}</td>
                        <td>${p.bairro}</td>
                        <td>${p.cep}</td>
                        <td>${p.cidade}</td>
                        <td>${p.estado}</td>
                        <td>
                            <a href="Editar=${p.id}">Editar</a> 
                            <a href="Deletar=${p.id}">Deletar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
