
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../_css/estilo.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <c:forEach items="${obterCliente}" var="p">
            <div id="corpo">
                <div id="dados">
                    <form action="${pageContext.request.contextPath}/EditCliente" method="post">
                        <input type="hidden" value="${p.id}" name="id">
                        <label>Nome</label>
                        <input type="text" value="${p.nome}" name="TxtNome"><br><br>
                        <label>CPF</label>
                        <input type="text" value="${p.cpf}" name="TxtCPF"><br><br>
                        <label>Sexo</label>
                        <select name="Sexo">
                            <option value="${p.sexo}">${p.sexo}</option>
                            <option value="null">Selecione</option>
                            <option value="Feminino">Feminino</option>
                            <option value="Masculino">Masculino</option>
                        </select>
                        <label>Data de Nascimento</label>
                        <input type="date" value="${p.dtNascimento}" name="DataNascimento"><br><br>
                        <label>Estado Civil</label>
                        <select name="EstadoCivil">
                            <option value="${p.estadoCivil}">${p.estadoCivil}</option>
                            <option value="null">Selecione</option>
                            <option value="Solteiro">Solteiro(a)</option>
                            <option value="Casado">Casado(a)</option>
                            <option value="Viúvo">Viúvo(a)</option>
                        </select><br><br>
                        <label>Endereço</label>
                        <input type="text" value="${p.endereco}" name="TxtEndereco"><br><br>
                        <label>Complemento</label>
                        <input type="text" value="${p.complemento}" name="TxtComplemento">
                        <label>Número</label>
                        <input type="text" value="${p.numero}" name="TxtNumeroEnd"><br><br>
                        <label>Bairro</label>
                        <input type="text" value="${p.bairro}" name="TxtBairro">
                        <label>CEP</label>
                        <input type="text" value="${p.cep}" name="TxtCep"><br><br>
                        <label>Cidade</label>
                        <input type="text" value="${p.cidade}" name="TxtCidade">
                        <label>Estado</label>
                        <select name="Estados">
                            <option value="${p.estado}">${p.estado}</option>
                            <option value="null">Selecione</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select><br><br>

                        <input type="submit" name="BotaoSalvar" value="Salvar">
                    </form>
                </c:forEach>

            </div>		
        </div>

    </body>
</html>
