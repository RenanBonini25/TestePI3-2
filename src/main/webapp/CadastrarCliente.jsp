<%-- 
    Document   : CadastrarCliente
    Created on : 27/04/2018, 20:20:09
    Author     : renan.bfsilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/estilo.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="corpo">
		<div id="dados">
			<form action="${pageContext.request.contextPath}/CadastrarCliente" method="post">
				<label>Nome</label>
				<input type="text" name="TxtNome"><br><br>
				<label>CPF</label>
				<input type="text" name="TxtCPF"><br><br>
				<label>Sexo</label>
				<select name="Sexo">
					<option value="null">Selecione</option>
					<option value="Feminino">Feminino</option>
					<option value="Masculino">Masculino</option>
				</select>
				<label>Data de Nascimento</label>
				<input type="date" name="DataNascimento"><br><br>
				<label>Estado Civil</label>
				<select name="EstadoCivil">
					<option value="null">Selecione</option>
					<option value="Solteiro">Solteiro(a)</option>
					<option value="Casado">Casado(a)</option>
					<option value="Viúvo">Viúvo(a)</option>
				</select><br><br>
				<label>Endereço</label>
				<input type="text" name="TxtEndereco"><br><br>
				<label>Complemento</label>
				<input type="text" name="TxtComplemento">
				<label>Número</label>
				<input type="text" name="TxtNumeroEnd"><br><br>
				<label>Bairro</label>
				<input type="text" name="TxtBairro">
				<label>CEP</label>
				<input type="text" name="TxtCep"><br><br>
				<label>Cidade</label>
				<input type="text" name="TxtCidade">
				<label>Estado</label>
				<select name="Estados">
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
				
                                <input type="submit" name="BotaoSalvar" onclick="" value="Salvar">
			</form>
		</div>		
	</div>
    </body>
</html>
