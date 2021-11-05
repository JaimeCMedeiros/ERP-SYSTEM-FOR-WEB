<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#48D1CC">

<h1> CADASTRO DE LIVRO DO AUTOR</h1>
 <form action="<%= request.getContextPath() %>/LivroSalvarServlet" method="get">
  CNPJ AUTOR: <input type="text" name="cnpj">
  <br> <br> 
  Titulo: <input id="titulo" name="titulo" required="required" type="text" placeholder="Sapuris" />
  <br> <br> 
  <input type='hidden' name='id' value='0'/>
  
  Genero: <input id="genero" name="genero" required="required" type="text" placeholder="terror" />
  <br> <br> 
 
  <input type="submit" value="SALVAR LIVRO">
 </form>
</body>
</html>