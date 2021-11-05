package br.unifacol.biblioteca.controller.servlet.autor;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.AutorServi;


@WebServlet("/AutorListServlet")
public class AutorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	   @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
		     response.setContentType("text/html");  
		     PrintWriter out=response.getWriter(); 
		     try {
			     AutorServi autorServi=new AutorServi();
			     ArrayList<Autor> autores=new ArrayList<Autor>();
			     autores=autorServi.listarAutores(); 
			     out.println("<a href='http://localhost:8080/biblioteca/autor/autor_cadastrar.jsp'>Add Novo Autor</a>");  
			     out.println("<h1>Lista de Autor</h1>");  
			       
			     
			       
			     out.print("<table border='1' width='100%'");  
			     out.print("<tr><th>Id</th><th>NOME</th><th>CNPJ</th><th>IDADE</th><th>SEXO</th><th>Edit Autor</th><th>Delete Autor</th><th>LIVRO</th></tr>");  
			     System.out.println("nome :: " + autores.size());
			     for(Autor e:autores){  
			      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getCnpj()+"</td><td>"+e.getIdade()+"</td><td>"+e.getSexo()+"<td><a href='AutorEditarServlet?id="+e.getId()+
			    		  "'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td><td><a href='LivroAddServlet?id="+e.getId()+"'>ADD</a></td></tr>");  
			     }  
			     out.print("</table>");  
			       
			     out.close(); 
		     } catch (Exception e) {
					System.out.println("Error - Conversao indisponivel:"+e.getMessage());
			}
			finally {
			      System.out.println("OPERACAO FINALIZADA");
		    }
	 } 


}
