
<%@page import="com.mycompany.pi3.DAO"%>
<%@page import="com.mycompany.pi3.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String idTemp = request.getParameter("id");
            int id = Integer.parseInt(idTemp);
            
            String nome = request.getParameter("TxtNome");
            String cpf = request.getParameter("TxtCPF");
            String sexo = request.getParameter("Sexo");
            //Date dataNasc = new Date();
            
            String data = request.getParameter("DataNascimento");
            //Date dataNasc = dateFormat.parse(data);
            
            String estadoCivil = request.getParameter("EstadoCivil");
            String endereco = request.getParameter("TxtEndereco");
            String complemento = request.getParameter("TxtComplemento");
            String numero = request.getParameter("TxtNumeroEnd");
            String bairro = request.getParameter("TxtBairro");
            String cep = request.getParameter("TxtCep");
            String cidade = request.getParameter("TxtCidade");
            String estado = request.getParameter("Estados");
            
            Cliente cliente = new Cliente(nome,cpf,sexo,data,estadoCivil,endereco,complemento,numero,bairro,
            cep,cidade,estado);
            cliente.setId(id);
            
            DAO.atualizarCliente(cliente);
            
            response.sendRedirect("/pi3-1.0-SNAPSHOT/Listagem");
            
        %>
    </body>
</html>
