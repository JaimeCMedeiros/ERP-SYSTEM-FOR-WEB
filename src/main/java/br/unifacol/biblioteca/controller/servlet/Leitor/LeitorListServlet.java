package br.unifacol.biblioteca.controller.servlet.Leitor;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.servico.LeitorServi;


@WebServlet("/LeitorListServlet")
public class LeitorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
		      response.setContentType("text/html");  
		      PrintWriter out=response.getWriter(); 
		      try {
			     LeitorServi leitorServi=new LeitorServi();
			     ArrayList<Leitor> leitores=new ArrayList<Leitor>();
			     leitores=leitorServi.listarLeitores();
			     out.println("<a href='http://localhost:8080/biblioteca/leitor/leitor_cadastrar.jsp'>Add Novo Leitor</a>");  
			     out.println("<h1>Lista de Leitor</h1>");  
			       
			     
			       
			     out.print("<table border='1' width='100%'");  
			     out.print("<tr><th>Id</th><th>NOME</th><th>IDADE</th><th>CNPJ</th><th>SEXO</th><th>Edit Leitor</th><th>Delete Leitor</th></tr>");  
			     System.out.println("nome :: " + leitores.size());
			     for(Leitor e:leitores){  
			      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getIdade()+"</td><td>"+e.getCnpj()+"</td><td>"+e.getSexo()+"<td><a href='LeitorEditarServlet?id="+e.getId()+
			    		  "'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></td></tr>");  
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
