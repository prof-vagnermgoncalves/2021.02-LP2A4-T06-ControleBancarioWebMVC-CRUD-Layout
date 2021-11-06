<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form method="POST"
	  action="${pageContext.request.contextPath}/pessoafisica/cadastrar">
	<p>
		<label for="numCpf">CPF:</label>
		<input type="num" name="numCpf">
	</p>
	
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome">
	</p>
	
	<p>
		<label for="datNascto">Data de Nascimento:</label>
		<input type="date" name="datNascto">
	</p>
	
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco">
	</p>
	
	<p>
		<label for="numCep">CEP:</label>
		<input type="number" name="numCep">
	</p>
	
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone">
	</p>
	
	<p>
		<label for="numRenda">Renda (R$):</label>
		<input type="number" name="numRenda" step=".01">
	</p>
	
	<p>
		<label for="selSituacao">Situação</label>
		<select name="selSituacao">
			<option value="">- Selecione -</option>
			<option value="0">Inativo</option>
			<option value="1">Ativo</option>
		</select>
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>