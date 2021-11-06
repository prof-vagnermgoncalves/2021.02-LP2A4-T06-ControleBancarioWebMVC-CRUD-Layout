<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.PessoaFisica"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
PessoaFisica pessoaFisica = (PessoaFisica) request.getAttribute("pessoaFisica");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/pessoafisica/editar">
	<p>
		<label for="numCpf">CPF:</label>
		<input type="num" name="numCpf" value="<%=pessoaFisica.getCpf()%>">
		<input type="hidden" name="numId" value="<%=pessoaFisica.getId()%>">
	</p>
	
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome" value="<%=pessoaFisica.getNome()%>">
	</p>
	
	<p>
		<%
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String datNasctoValue = "";
			
			if(pessoaFisica.getNascto() != null)
			{
				datNasctoValue = dateFormat.format(pessoaFisica.getNascto());
			}
		%>
		
		<label for="datNascto">Data de Nascimento:</label>
		<input type="date" name="datNascto" value="<%=datNasctoValue%>"> <!-- yyyy-MM-dd -->
	</p>
	
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco" value="<%=pessoaFisica.getEndereco()%>">
	</p>
	
	<p>
		<label for="numCep">CEP:</label>
		<input type="number" name="numCep" value="<%=pessoaFisica.getCep()%>">
	</p>
	
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone" value="<%=pessoaFisica.getTelefone()%>">
	</p>
	
	<p>
		<label for="numRenda">Renda (R$):</label>
		<input type="number" name="numRenda" step=".01" value="<%=pessoaFisica.getRenda()%>">
	</p>
	
	<p>
		<%
		String statusAtivo = "", statusInativo = "";
		
		if(pessoaFisica.getSituacao() == 1)
			statusAtivo = "selected";
		else
			statusInativo = "selected";
		%>
		
		<label for="selSituacao">Situação</label>
		<select name="selSituacao">
			<option value="">- Selecione -</option>
			<option value="0" <%=statusInativo%>>Inativo</option>
			<option value="1" <%=statusAtivo%>>Ativo</option>
		</select>
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>