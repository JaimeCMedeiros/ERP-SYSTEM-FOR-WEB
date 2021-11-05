<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#48D1CC">

<h1>CADASTRO DE COORDENADOR</h1>
 <form action="<%= request.getContextPath() %>/CoordenadorAddServlet" method="get">
  Nome: <input id="nome" name="nome" required="required" type="text" placeholder="Paulo Augusto" />
  <br> <br> 
  
  Sexo: <select   name="sexo" required>
  <option value="Masculino">MASCULINO</option>
  <option value="Feminino">FEMININO</option>
  <option value="Outros">OUTROS</option>
  </select>
  <br> <br>  
  
  Cnpj: <input id="cnpj" name="cnpj" required="required" type="text" placeholder="12345678901" />
  <br> <br> 
  
  Idade: <input id="idade" name="idade" required="required" type="text" placeholder="20" />
  <br> <br>
  
  Codigo Coordenador: <input id="codCord" name="codCord" required="required" type="text" placeholder="092" /><br>
  <br> <br>
  
  <br> 
  <input type="submit" value="REGISTRAR">
 </form>
</body>
</html>