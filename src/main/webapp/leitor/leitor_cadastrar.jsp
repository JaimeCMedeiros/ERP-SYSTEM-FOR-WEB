<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#48D1CC">

<h1> CADASTRO DE LEITOR</h1>
 <form action="<%= request.getContextPath() %>/LeitorAddServlet" method="get">
  Nome: <input id="nome" name="nome" required="required" type="text" placeholder="Thiago Silva" />
  <br> <br> 
  
  Sexo: <select   name="sexo" required>
  <option value="Masculino">MASCULINO</option>
  <option value="Feminino">FEMININO</option>
  <option value="Outros">OUTROS</option>
  </select>
  <br> <br>  
  
  Idade: <input id="idade" name="idade" required="required" type="text" placeholder="30" />
  <br> <br> 
  
  Cnpj: <input id="cnpj" name="cnpj" required="required" type="text" placeholder="12345678901" /><br>
  <br> <br> 
  
  <br> 
  <input type="submit" value="REGISTRAR">
 </form>
</body>
</html>